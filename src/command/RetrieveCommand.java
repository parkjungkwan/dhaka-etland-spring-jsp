package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ImageDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ImageServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		String customerID = request.getParameter("customer_id");
		CustomerDTO cust = new CustomerDTO();
		ImageDTO img = new ImageDTO();
		cust.setCustomerID(customerID);
		cust = CustomerServiceImpl.getInstance()
					.retrieveCustomer(cust);
		img.setImgSeq(cust.getPhoto());
		img = ImageServiceImpl.getInstance()
				.findImage(img);
		request.setAttribute("cust", cust);
		request.setAttribute("image", img);
	}
}
