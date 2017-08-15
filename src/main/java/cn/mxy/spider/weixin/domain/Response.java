package cn.mxy.spider.weixin.domain;

import java.util.List;

public class Response {
	public BaseResponse baseResponse;
	public int memberCount;
	public List<Member> memberList;
	public int seq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public BaseResponse getBaseResponse() {
		return baseResponse;
	}
	public void setBaseResponse(BaseResponse baseResponse) {
		this.baseResponse = baseResponse;
	}
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	@Override
	public String toString() {
		return "Response [baseResponse=" + baseResponse + ", memberCount=" + memberCount + ", memberList=" + memberList
				+ ", seq=" + seq + "]";
	}
	
}
