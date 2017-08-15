package cn.mxy.spider.weixin.domain;

import java.util.List;

public class GroupMemberResponse {

	private BaseResponse BaseResponse;
	private int Count;
	private List<Group> ContactList;
	public BaseResponse getBaseResponse() {
		return BaseResponse;
	}
	public void setBaseResponse(BaseResponse baseResponse) {
		BaseResponse = baseResponse;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public List<Group> getContactList() {
		return ContactList;
	}
	public void setContactList(List<Group> contactList) {
		ContactList = contactList;
	}
	@Override
	public String toString() {
		return "GroupMemberResponse [BaseResponse=" + BaseResponse + ", Count=" + Count + ", ContactList=" + ContactList
				+ "]";
	}

}
