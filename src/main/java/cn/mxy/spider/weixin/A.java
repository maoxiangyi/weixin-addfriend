package cn.mxy.spider.weixin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;

import cn.mxy.spider.weixin.domain.BaseResponse;
import cn.mxy.spider.weixin.domain.Member;
import cn.mxy.spider.weixin.domain.Response;

public class A {

	public static void main(String[] args) throws Exception {
		JSONReader jsonReader = new JSONReader(new FileReader("c:/wxfriend.txt"));
		Response response = new Response();
		jsonReader.startObject();
		while (jsonReader.hasNext()) {
			String key = jsonReader.readString();
			if (key.contains("BaseResponse")) {
				BaseResponse baseResponse = new BaseResponse();
				jsonReader.startObject();
				while (jsonReader.hasNext()) {
					String obj = jsonReader.readString();
					String val = jsonReader.readObject().toString();
					baseResponse.setvalue(obj,val);
				}
				jsonReader.endObject();
				response.setBaseResponse(baseResponse);
			} else if (key.contains("MemberCount")) {
				Object obj = jsonReader.readObject();//
				String val = obj.toString();
				response.setMemberCount(Integer.parseInt(val));
			} else if (key.contains("MemberList")) {
				ArrayList<Member> memberList = new ArrayList<Member>();
				jsonReader.startArray();// ---> [ 开启读List对象
				while (jsonReader.hasNext()) {
					Member member = new Member();
					jsonReader.startObject();
					while (jsonReader.hasNext()) {
						String obj = jsonReader.readString();
						String val = jsonReader.readObject().toString();
						member.setvalue(obj,val);
					}
					jsonReader.endObject();
					memberList.add(member);
				}
				jsonReader.endArray();// ---> [ 结束读List对象
				response.setMemberList(memberList);
			} else if (key.contains("Seq")) {
				Object obj = jsonReader.readObject();
				String val = obj.toString();
				response.setSeq(Integer.parseInt(val));
			}
		}
		jsonReader.endObject();
		System.out.println(response);
		File file = new File("c:/wxfriend_parser_result.txt");
		BufferedWriter bwBufferedWriter = new BufferedWriter(new FileWriter(file));
		bwBufferedWriter.write(response.toString());
		bwBufferedWriter.flush();
		bwBufferedWriter.close();
	}

	@Test
	public void testSmallData() throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(new File("c:/wxfriend_small.txt"));
		BufferedReader br = new BufferedReader(fileReader);
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String json = sb.toString();
		Response res = JSON.parseObject(json, Response.class);
		System.out.println(res);
	}
	
	@Test
	public void testEclipseConsolePrint() throws FileNotFoundException, IOException {
		long startTime = System.currentTimeMillis();
		ArrayList<Member> arrayList = new ArrayList<Member>();
		for(int i=1;i<1300;i++){
			Member member = new Member();
			arrayList.add(member);
		}
		System.out.println(arrayList);
		System.out.println(System.currentTimeMillis()-startTime);
	}
	
}
