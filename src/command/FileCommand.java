package command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import enums.Action;
import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

class FileCommand extends Command {
	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_FILE_UPLOAD:
			ImageProxy ipxy = new ImageProxy();
			ipxy.carryOut(request);
			Map<String,Object> map = CustomerServiceImpl
					.getInstance()
					.fileUpload(ipxy);
			request.setAttribute("image", map.get("img"));
			request.setAttribute("cust", map.get("cust"));
			break;
		default:
			break;
		}
	}
}
