package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		String customerID = request.getParameter("customer_id");
		CustomerDTO cust = new CustomerDTO();
		cust.setCustomerID(customerID);
		cust = CustomerServiceImpl.getInstance()
					.retrieveCustomer(cust);
		if(!request.getParameter("city").equals(""))
			cust.setCity(request.getParameter("city"));
		if(!request.getParameter("address").equals(""))
			cust.setAddress(request.getParameter("address"));
		if(!request.getParameter("postal_code").equals(""))
			cust.setPostalCode(request.getParameter("postal_code"));
		if(!request.getParameter("password").equals(""))
			cust.setPassword(request.getParameter("password"));
		if(!request.getParameter("phone").equals(""))
			cust.setPhone(request.getParameter("phone"));
		CustomerServiceImpl.getInstance()
			.modifyCustomer(cust);
		
		cust = new CustomerDTO();
		cust.setCustomerID(customerID);
		cust = CustomerServiceImpl.getInstance().retrieveCustomer(cust);
		request.setAttribute("cust", cust);
	}
}





