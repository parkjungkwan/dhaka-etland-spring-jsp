package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class RequestProxy implements Proxy{
	private HttpServletRequest request;
	@Override
	public void carryOut(Object o) {
		if((HttpServletRequest) o != null) {
			setRequest((HttpServletRequest) o);
		}else {
			System.out.println("o 가 널");
		}
	}
}
