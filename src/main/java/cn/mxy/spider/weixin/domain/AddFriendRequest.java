package cn.mxy.spider.weixin.domain;

import java.util.ArrayList;
import java.util.List;

public class AddFriendRequest {

	private BaseRequest BaseRequest;
	private int VerifyUserListSize = 1;
	private int Opcode = 2;
	private List<VerifyUser> VerifyUserList;
	private String VerifyContent;
	private int SceneListCount = 1;
//	private List<Integer> SceneList = new ArrayList<Integer>();
	
	private  ArrayList<Integer> SceneList = new ArrayList<Integer>(){{add(33);}};  
	
	
	private String skey;
	public BaseRequest getBaseRequest() {
		return BaseRequest;
	}
	public void setBaseRequest(BaseRequest baseRequest) {
		BaseRequest = baseRequest;
	}
	public int getOpcode() {
		return Opcode;
	}
	public void setOpcode(int opcode) {
		Opcode = opcode;
	}
	public int getVerifyUserListSize() {
		return VerifyUserListSize;
	}
	public void setVerifyUserListSize(int verifyUserListSize) {
		VerifyUserListSize = verifyUserListSize;
	}
	public List<VerifyUser> getVerifyUserList() {
		return VerifyUserList;
	}
	public void setVerifyUserList(List<VerifyUser> verifyUserList) {
		VerifyUserList = verifyUserList;
	}
	public String getVerifyContent() {
		return VerifyContent;
	}
	public void setVerifyContent(String verifyContent) {
		VerifyContent = verifyContent;
	}
	public int getSceneListCount() {
		return SceneListCount;
	}
	public void setSceneListCount(int sceneListCount) {
		SceneListCount = sceneListCount;
	}
	
	
	
	
	public ArrayList<Integer> getSceneList() {
		return SceneList;
	}
	public void setSceneList(ArrayList<Integer> sceneList) {
		SceneList = sceneList;
	}
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	@Override
	public String toString() {
		return "AddFriendRequest [BaseRequest=" + BaseRequest + ", VerifyUserListSize=" + VerifyUserListSize
				+ ", Opcode=" + Opcode + ", VerifyUserList=" + VerifyUserList + ", VerifyContent=" + VerifyContent
				+ ", SceneListCount=" + SceneListCount + ", SceneList=" + SceneList + ", skey=" + skey + "]";
	}
	

}
