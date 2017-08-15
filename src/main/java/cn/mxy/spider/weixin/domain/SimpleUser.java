package cn.mxy.spider.weixin.domain;

public class SimpleUser {
	
	//[{"UserName":
//	"@@6e940ca99493c567e7aa6896cf8d3e4fb6847336419aa520f81f6412ab1623ce",
//	"EncryChatRoomId":""}
	private String UserName;
	private String EncryChatRoomId;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEncryChatRoomId() {
		return EncryChatRoomId;
	}
	public void setEncryChatRoomId(String encryChatRoomId) {
		EncryChatRoomId = encryChatRoomId;
	}
	@Override
	public String toString() {
		return "SimpleUser [UserName=" + UserName + ", EncryChatRoomId=" + EncryChatRoomId + "]";
	}

}
