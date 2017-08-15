package cn.mxy.spider.weixin.domain;

import org.apache.commons.lang3.StringUtils;

public class Member {
	private int uin;
	private String userName;
	private String nickName;
	private String headImgUrl;
	private int contactFlag;
	private int memberCount;
	private String remarkName;
	private String hideInputBarFlag;
	private int sex;
	private String signature;
	private int verifyFlag;
	private int ownerUin;
	private String pYInitial;
	private String pYQuanPin;
	private String remarkPYInitial;
	private String remarkPYQuanPin;
	private int starFriend;
	private int appAccountFlag;
	private int statues;
	private String province;
	private String city;
	private String alias;
	private int snsFlag;
	private int uniFriend;
	private String displayName;
	private int chatRoomId;
	private String keyWord;
	private String encryChatRoomId;
	private int isOwner;

	public int getUin() {
		return uin;
	}

	public void setUin(int uin) {
		this.uin = uin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public int getContactFlag() {
		return contactFlag;
	}

	public void setContactFlag(int contactFlag) {
		this.contactFlag = contactFlag;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public String getRemarkName() {
		return remarkName;
	}

	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}

	public String getHideInputBarFlag() {
		return hideInputBarFlag;
	}

	public void setHideInputBarFlag(String hideInputBarFlag) {
		this.hideInputBarFlag = hideInputBarFlag;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getVerifyFlag() {
		return verifyFlag;
	}

	public void setVerifyFlag(int verifyFlag) {
		this.verifyFlag = verifyFlag;
	}

	public int getOwnerUin() {
		return ownerUin;
	}

	public void setOwnerUin(int ownerUin) {
		this.ownerUin = ownerUin;
	}

	public String getpYInitial() {
		return pYInitial;
	}

	public void setpYInitial(String pYInitial) {
		this.pYInitial = pYInitial;
	}

	public String getpYQuanPin() {
		return pYQuanPin;
	}

	public void setpYQuanPin(String pYQuanPin) {
		this.pYQuanPin = pYQuanPin;
	}

	public String getRemarkPYInitial() {
		return remarkPYInitial;
	}

	public void setRemarkPYInitial(String remarkPYInitial) {
		this.remarkPYInitial = remarkPYInitial;
	}

	public String getRemarkPYQuanPin() {
		return remarkPYQuanPin;
	}

	public void setRemarkPYQuanPin(String remarkPYQuanPin) {
		this.remarkPYQuanPin = remarkPYQuanPin;
	}

	public int getStarFriend() {
		return starFriend;
	}

	public void setStarFriend(int starFriend) {
		this.starFriend = starFriend;
	}

	public int getAppAccountFlag() {
		return appAccountFlag;
	}

	public void setAppAccountFlag(int appAccountFlag) {
		this.appAccountFlag = appAccountFlag;
	}

	public int getStatues() {
		return statues;
	}

	public void setStatues(int statues) {
		this.statues = statues;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getSnsFlag() {
		return snsFlag;
	}

	public void setSnsFlag(int snsFlag) {
		this.snsFlag = snsFlag;
	}

	public int getUniFriend() {
		return uniFriend;
	}

	public void setUniFriend(int uniFriend) {
		this.uniFriend = uniFriend;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getEncryChatRoomId() {
		return encryChatRoomId;
	}

	public void setEncryChatRoomId(String encryChatRoomId) {
		this.encryChatRoomId = encryChatRoomId;
	}

	public int getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(int isOwner) {
		this.isOwner = isOwner;
	}

	@Override
	public String toString() {
		return "Member [uin=" + uin + ", userName=" + userName + ", nickName=" + nickName + ", headImgUrl=" + headImgUrl
				+ ", contactFlag=" + contactFlag + ", memberCount=" + memberCount + ", remarkName=" + remarkName
				+ ", hideInputBarFlag=" + hideInputBarFlag + ", sex=" + sex + ", signature=" + signature
				+ ", verifyFlag=" + verifyFlag + ", ownerUin=" + ownerUin + ", pYInitial=" + pYInitial + ", pYQuanPin="
				+ pYQuanPin + ", remarkPYInitial=" + remarkPYInitial + ", remarkPYQuanPin=" + remarkPYQuanPin
				+ ", starFriend=" + starFriend + ", appAccountFlag=" + appAccountFlag + ", statues=" + statues
				+ ", province=" + province + ", city=" + city + ", alias=" + alias + ", snsFlag=" + snsFlag
				+ ", uniFriend=" + uniFriend + ", displayName=" + displayName + ", chatRoomId=" + chatRoomId
				+ ", keyWord=" + keyWord + ", encryChatRoomId=" + encryChatRoomId + ", isOwner=" + isOwner + "]";
	}

	public void setvalue(String obj, String val) {
		if (obj.contains("Uin")) {
			
			this.uin = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("UserName ")) {
			this.userName = val;
		}
		if (obj.contains("NickName ")) {
			this.nickName = val;
		}
		if (obj.contains("HeadImgUrl ")) {
			this.headImgUrl = val;
		}
		if (obj.contains("ContactFlag")) {
			this.contactFlag = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("MemberCount")) {
			this.memberCount = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("RemarkName")) {
			this.remarkName = val;
		}
		if (obj.contains("Sex")) {
			this.sex = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("Signature")) {
			this.signature = val;
		}
		if (obj.contains("VerifyFlag")) {
			this.verifyFlag = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("OwnerUin")) {
			this.ownerUin = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("PYInitial")) {
			this.pYInitial = val;
		}
		if (obj.contains("PYQuanPin")) {
			this.pYQuanPin = val;
		}
		if (obj.contains("RemarkPYInitial")) {
			this.remarkPYInitial = val;
		}
		if (obj.contains("RemarkPYQuanPin")) {
			this.remarkPYQuanPin = val;
		}
		if (obj.contains("StarFriend")) {
			this.starFriend = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("AppAccountFlag")) {
			this.appAccountFlag = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("Statues")) {
			this.statues = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("Province")) {
			this.province = val;
		}
		if (obj.contains("City")) {
			this.city = val;
		}
		if (obj.contains("Alias ")) {
			this.alias = val;
		}
		if (obj.contains("SnsFlag ")) {
			this.snsFlag = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("UniFriend ")) {
			this.uniFriend = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("DisplayName")) {
			this.displayName = val;
		}
		if (obj.contains("ChatRoomId")) {
			this.chatRoomId = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}
		if (obj.contains("KeyWord")) {
			this.keyWord = val;
		}
		if (obj.contains("EncryChatRoomId")) {
			this.encryChatRoomId = val;
		}
		if (obj.contains("IsOwner")) {
			this.isOwner = StringUtils.isBlank(val)?0:Integer.parseInt(val);
		}

	}

}
