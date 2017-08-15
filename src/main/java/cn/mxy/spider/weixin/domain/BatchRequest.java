package cn.mxy.spider.weixin.domain;

public class BatchRequest {
	private BaseRequest BaseRequest;
	private int Count;
	private java.util.List<SimpleUser> List;
	public BaseRequest getBaseRequest() {
		return BaseRequest;
	}
	public void setBaseRequest(BaseRequest baseRequest) {
		BaseRequest = baseRequest;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public java.util.List<SimpleUser> getList() {
		return List;
	}
	public void setList(java.util.List<SimpleUser> list) {
		List = list;
	}
	
}
