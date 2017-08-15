package cn.mxy.spider.weixin.domain;

public class BaseResponse {
	public int ret;
	public String errMsg;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "BaseResponse [ret=" + ret + ", errMsg=" + errMsg + "]";
	}

	public void setvalue(String obj, String val) {
		if (obj.contains("Ret")) {
			this.ret = Integer.parseInt(val);
		}
		if (obj.contains("ErrMsg")) {
			this.errMsg = val;
		}
	}

}
