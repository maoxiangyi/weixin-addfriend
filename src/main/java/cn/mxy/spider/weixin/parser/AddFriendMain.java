package cn.mxy.spider.weixin.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import cn.mxy.spider.weixin.domain.AddFriendRequest;
import cn.mxy.spider.weixin.domain.BaseRequest;
import cn.mxy.spider.weixin.domain.BatchRequest;
import cn.mxy.spider.weixin.domain.Group;
import cn.mxy.spider.weixin.domain.GroupMemberResponse;
import cn.mxy.spider.weixin.domain.Member;
import cn.mxy.spider.weixin.domain.Response;
import cn.mxy.spider.weixin.domain.SimpleUser;
import cn.mxy.spider.weixin.domain.VerifyUser;
import cn.mxy.spider.weixin.util.FileUtil;

public class AddFriendMain {
	public static void main(String[] args) throws Exception {
		System.out.println("启动微信机器人……");
		String api = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxgetcontact?r=1502459493994&seq=0&skey=@crypt_e80a62f_8006d79";
		HashMap<String, String> headerInfoMap = headerInfoMap();
		String json = getHtml(api, headerInfoMap);
		System.out.println("……获取用户的所有好友信息");
		FileUtil.saveStringToFile(json, "c:/用户的所有好友信息.txt");
		// 解析Json串
		Response response = parseJson(json);
		System.out.println(response.getMemberList());
		// 找出那些是微信群
		ArrayList<Member> groupList = findWXGroup(response);
		System.out.println("……提取用户的微信群");
		FileUtil.saveStringToFile(groupList.toString(), "c:/用户的群信息");
		// 每个群的群成员及关系
		getGroupContact(groupList);

	}

	private static void getGroupContact(ArrayList<Member> groupList) throws Exception {
		// 获取微信群的好友列表
		String api = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxbatchgetcontact?type=ex&r=1502525127909";
		// 准备参数
		BatchRequest initRequestParam = initRequestParam(groupList);
		// 将参数转化成json串
		Gson gson = new Gson();
		String json = gson.toJson(initRequestParam);
		// 发起HTTP请求 一次获取微信群中所有好友的列表信息
		System.out.println("……获取微信群中所有群成员信息");
		String html = postHtml(api, headerInfoMap(), json);
		// 根据
		GroupMemberResponse groupInfo = JSON.parseObject(html, GroupMemberResponse.class);
		List<Group> contactList = groupInfo.getContactList();
		System.out.println("……保存每个群的详细信息");
		for (Group group : contactList) {
			// 保存群和群的成员
			FileUtil.saveStringToFile(group.getMemberList().toString(), "c:/群【" + group.getNickName() + "】的成员列表.txt");
		}
		for (Group group : contactList) {
			System.out.println("……当前群名称：" + group.getNickName());
			List<Member> memberList = group.getMemberList();
			for (Member member : memberList) {
				System.out.println("…………识别用户" + member.getNickName() + "是否已经是好友关系");
				addFriend(member);
				System.out.println("…………自动添加" + member.getNickName());
				System.out.println("…………休息5s,然后在开始");
				Thread.sleep(5 * 1000);
			}
		}

	}

	private static void addFriend(Member member) throws Exception, Exception {
		String api = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxverifyuser?r=1502528004153";
		// 准备请求参数
		AddFriendRequest addFriendRequest = new AddFriendRequest();
		// 基础信息
		addFriendRequest.setBaseRequest(getBaseRequest());
		// 要添加的人
		ArrayList<VerifyUser> arrayList = new ArrayList<VerifyUser>();
		VerifyUser verifyUser = new VerifyUser();
		verifyUser.setValue(member.getUserName());
		arrayList.add(verifyUser);
		addFriendRequest.setVerifyUserList(arrayList);
		// 验证信息
		addFriendRequest.setVerifyContent("我是毛祥溢，正在开发微信机器人，这个一个测试。");

		Gson gson = new Gson();
		String json = gson.toJson(addFriendRequest);
		String html = postHtml(api, headerInfoMap(), json);
		// System.out.println(html);
		System.out.println(html);
	}

	private static BatchRequest initRequestParam(ArrayList<Member> groupList) {
		BatchRequest batchRequest = new BatchRequest();

		// 设置BaseRequest
		batchRequest.setBaseRequest(getBaseRequest());

		// 设置List
		ArrayList<SimpleUser> simpleUserList = new ArrayList<SimpleUser>();
		for (Member member : groupList) {
			SimpleUser simpleUser = new SimpleUser();
			simpleUser.setUserName(member.getUserName());
			simpleUser.setEncryChatRoomId(member.getEncryChatRoomId());
			simpleUserList.add(simpleUser);
		}
		batchRequest.setList(simpleUserList);

		// 设置Count
		batchRequest.setCount(simpleUserList.size());

		return batchRequest;
	}

	private static BaseRequest getBaseRequest() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setSid("h1IbMklk02KQ8dvF");
		baseRequest.setSkey("@crypt_e80a62f_e84047ff64025605149b9cfb65bcd879");
		baseRequest.setUin(457245275);
		baseRequest.setDeviceID("e660400080556092");
		return baseRequest;
	}

	private static String readLocalFile() throws Exception {
		FileReader fileReader = new FileReader(new File("c:/wxfriend.txt"));
		BufferedReader br = new BufferedReader(fileReader);
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	private static ArrayList<Member> findWXGroup(Response response) {
		List<Member> memberList = response.getMemberList();
		ArrayList<Member> groupList = new ArrayList<Member>();
		for (Member member : memberList) {
			// getStatues == 1 表示微信群
			// if (member.getStatues() == 1) {
			// groupList.add(member);
			// }
			// getContactFlag == 3 表示最近联系的人
			// if (member.getContactFlag() == 3) {
			// groupList.add(member);
			// }
			if (member.getStatues() == 1 && member.getContactFlag() == 3) {
				groupList.add(member);
			}
		}
		return groupList;
	}

	/**
	 * 不能打印 打印对象。
	 * 
	 * @param json
	 * @return
	 */
	private static Response parseJson(String json) {
		Response response = JSON.parseObject(json, Response.class);
		// Gson gson = new Gson();
		// Response response = gson.fromJson(json, Response.class);
		return response;
	}

	private static String getHtml(String api, HashMap<String, String> headerInfoMap)
			throws IOException, ClientProtocolException {
		CloseableHttpClient hc = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(api);
		for (Map.Entry kv : headerInfoMap.entrySet()) {
			httpGet.addHeader((String) kv.getKey(), (String) kv.getValue());
		}
		CloseableHttpResponse response = hc.execute(httpGet);
		String html = null;
		if (200 == response.getStatusLine().getStatusCode()) {
			html = EntityUtils.toString(response.getEntity(), Charset.forName("utf-8"));
		} else {
			System.out.println("网络请求失败" + api);
		}
		return html;
	}

	private static String postHtml(String api, HashMap<String, String> headerInfoMap, String param)
			throws IOException, ClientProtocolException {
		CloseableHttpClient hc = HttpClients.createDefault();
		// 创建post请求方式
		HttpPost httpPost = new HttpPost(api);
		// 添加请求头
		for (Map.Entry kv : headerInfoMap.entrySet()) {
			httpPost.addHeader((String) kv.getKey(), (String) kv.getValue());
		}
		// 添加post参数 注意 微信是stringentity
		HttpEntity paramEntity = new StringEntity(param);
		httpPost.setEntity(paramEntity);

		CloseableHttpResponse response = hc.execute(httpPost);
		String html = null;
		if (200 == response.getStatusLine().getStatusCode()) {
			html = EntityUtils.toString(response.getEntity(), Charset.forName("utf-8"));
		} else {
			System.out.println("网络请求失败" + api);
		}
		return html;
	}

	private static HashMap<String, String> headerInfoMap() {
		HashMap<String, String> headerInfoMap = new HashMap<String, String>();
		headerInfoMap.put("Accept", "application/json, text/plain, */*");
		headerInfoMap.put("Accept-Encoding", "gzip, deflate");
		headerInfoMap.put("Content-Type", "application/json;charset=UTF-8");
		headerInfoMap.put("Referer", "https://wx.qq.com/");
		headerInfoMap.put("Accept-Encoding", "gzip, deflate, sdch");
		headerInfoMap.put("Accept-Language", "zh-CN,zh;q=0.8");
		headerInfoMap.put("Cache-Control", "max-age=0");
		headerInfoMap.put("Connection", "keep-alive");
		headerInfoMap.put("Cookie",
				"pgv_pvi=1855142912; pgv_si=s4165670912; MM_WX_NOTIFY_STATE=1; MM_WX_SOUND_STATE=1; mm_lang=zh_CN; webwxuvid=9de99e77a3eec08376d31e03398ef309ddf32bd00c3f56319b3d743fe83d32bb8b8ec91df10d6ecebe4a2dbf0f191e2c; webwx_auth_ticket=CIsBEISDjYYGGoABAnycEatzaa+39LW05lF5eOVUsyd00nckw1gjh7NzHrE2Q/J7ivIOGqQWOXgAonP7sOvKtoVBQnfHy6L3CmEmXtqbuQCxbLUHRlWhC5oIC+tM2xsYJNH7rsQuYIKw1Kl9kfkrwANLe+B1PNDT1vf/7Jg6cDMdpDyYYzWlbMYAJAI=; login_frequency=1; last_wxuin=457245275; wxloadtime=1502705141_expired; wxpluginkey=1502705370; wxuin=457245275; wxsid=JX+wIgGNxkOgpJ/l; webwx_data_ticket=gSfVlxzTfRVecv0VSijUxQVk");
		headerInfoMap.put("Host", "wx.qq.com");
		headerInfoMap.put("Upgrade-Insecure-headerInfoMaps", "1");
		headerInfoMap.put("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
		return headerInfoMap;
	}

}
