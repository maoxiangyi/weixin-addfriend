package cn.mxy.spider.weixin.domain;

public class VerifyUser {
	private String Value;
	private String VerifyUserTicket;
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getVerifyUserTicket() {
		return VerifyUserTicket;
	}
	public void setVerifyUserTicket(String verifyUserTicket) {
		VerifyUserTicket = verifyUserTicket;
	}
	@Override
	public String toString() {
		return "VerifyUser [Value=" + Value + ", VerifyUserTicket=" + VerifyUserTicket + "]";
	}
	
}
