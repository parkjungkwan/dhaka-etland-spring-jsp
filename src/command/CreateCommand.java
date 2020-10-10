package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case REGISTER:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setManager(request.getParameter("manager"));
			emp.setPhoto(request.getParameter("photo"));
			emp.setName(request.getParameter("name"));
			emp.setBirthDate(request.getParameter("birthday"));
			emp.setNotes(request.getParameter("desc"));
			EmployeeServiceImpl.getInstance()
				.registEmployee(emp); 
			break;
		case SIGNUP:
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerID(request.getParameter("customer_id"));
			cust.setPassword(request.getParameter("password"));
			cust.setCustomerName(request.getParameter("customer_name"));
			cust.setCity(request.getParameter("city"));
			cust.setAddress(request.getParameter("address"));
			cust.setSsn(request.getParameter("ssn"));
			cust.setPhone(request.getParameter("phone"));
			cust.setPostalCode(request.getParameter("postal_code"));
			CustomerServiceImpl.getInstance()
				.registCustomer(cust);
			break;
		default:
			break;
		
		}
		
	
		   
		
	}
}
