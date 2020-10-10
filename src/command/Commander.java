package command;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Commander {
	public static Command order(Map<String,Proxy> pxy) {
		Command cmd = null;
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE:
			cmd = new Command(pxy);
			break;
		case REGISTER: case SIGNUP:
			cmd = new CreateCommand(pxy);
			break;
		case ACCESS: case SIGNIN:
			cmd = new ExistCommand(pxy);
			break;
		case CUST_LIST:
			cmd = new ListCommand(pxy);
			break;
		case CUST_RETRIEVE:
			cmd = new RetrieveCommand(pxy);
			break;
		case CUST_UPDATE:
			cmd = new UpdateCommand(pxy);
			break;
		case CUST_FILE_UPLOAD:
			cmd = new FileCommand(pxy);
			break;
		case CUST_REMOVE:
			cmd = new RemoveCommand(pxy);
			break;
		case CATE_LIST:
			cmd = new ListCommand(pxy);
			break;
		default:
			break;
		}
		return cmd;
	}
}
