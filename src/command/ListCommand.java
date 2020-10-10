package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CategoryDTO;
import domain.CustomerDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;

public class ListCommand extends Command{
	
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		PageProxy  pagePxy = new PageProxy();
		Pagination page = new Pagination();
		page.carryOut(request);
		pagePxy.carryOut(page);
		String flag = request.getParameter("cmd").toUpperCase();
		List<?> list = new ArrayList<>();
		
		switch (Action.valueOf(flag)) {
		case CUST_LIST:
			list = CustomerServiceImpl
			.getInstance()
			.bringCustomerList(pagePxy);
			break;
		case CATE_LIST:
			list = CategoryServiceImpl
				.getInstance()
				.bringCategoryList(pagePxy);
			break;
		default:
			break;
		}
		request.setAttribute("list", list);
		request.setAttribute("pagination", page);
		
	}
}
