package cn.mxy.spider.weixin.domain;

import java.util.Arrays;
import java.util.List;

public class AddFriendRequest {

	private BaseRequest BaseRequest;
	private int Opcode = 2;
	private int VerifyUserListSize = 1;
	private List<VerifyUser> VerifyUserList;
	private String VerifyContent;
	private int SceneListCount = 33;
	private int[] SceneList = new int[1];
	private String skey;
	public BaseRequest getBaseRequest() {
		return BaseRequest;
	}
	public void setBaseRequest(BaseRequest baseRequest) {
		BaseRequest = baseRequest;
		skey = baseRequest.getSkey();
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
	public int[] getSceneList() {
		return SceneList;
	}
	public void setSceneList(int[] sceneList) {
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
		return "AddFriendRequest [BaseRequest=" + BaseRequest + ", Opcode=" + Opcode + ", VerifyUserListSize="
				+ VerifyUserListSize + ", VerifyUserList=" + VerifyUserList + ", VerifyContent=" + VerifyContent
				+ ", SceneListCount=" + SceneListCount + ", SceneList=" + Arrays.toString(SceneList) + ", skey=" + skey
				+ "]";
	}
	
	
	

}
