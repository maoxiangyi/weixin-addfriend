package cn.mxy.spider.weixin.domain;

import java.util.List;

public class Group {
	private int Uin;
	private String UserName;
	private String NickName;
	private String HeadImgUrl;
	private int ContactFlag;
	private int MemberCount;
	private List<Member> MemberList;
	public int getUin() {
		return Uin;
	}
	public void setUin(int uin) {
		Uin = uin;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getHeadImgUrl() {
		return HeadImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		HeadImgUrl = headImgUrl;
	}
	public int getContactFlag() {
		return ContactFlag;
	}
	public void setContactFlag(int contactFlag) {
		ContactFlag = contactFlag;
	}
	public int getMemberCount() {
		return MemberCount;
	}
	public void setMemberCount(int memberCount) {
		MemberCount = memberCount;
	}
	public List<Member> getMemberList() {
		return MemberList;
	}
	public void setMemberList(List<Member> memberList) {
		MemberList = memberList;
	}
	@Override
	public String toString() {
		return "Group [Uin=" + Uin + ", UserName=" + UserName + ", NickName=" + NickName + ", HeadImgUrl=" + HeadImgUrl
				+ ", ContactFlag=" + ContactFlag + ", MemberCount=" + MemberCount + "]";
	}

}
