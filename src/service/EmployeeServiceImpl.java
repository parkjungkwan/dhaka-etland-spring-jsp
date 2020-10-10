package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;
import proxy.Proxy;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();
	private EmployeeServiceImpl() {dao = EmployeeDAOImpl.getInstance();}
	public static EmployeeServiceImpl getInstance() {
		return instance;
	}
	EmployeeDAO dao;
	@Override
	public void registEmployee(EmployeeDTO emp) {
		dao.insertEmployee(emp);
	}

	@Override
	public List<EmployeeDTO> bringEmployeeList(Proxy pxy) {
		return dao.selectEmployeeList(pxy);
	}

	@Override
	public List<EmployeeDTO> retrieveEmployees(Proxy pxy) {
		return dao.selectEmployees(pxy);
	}

	@Override
	public EmployeeDTO retrieveEmployee(Proxy pxy) {
		return dao.selectEmployee(pxy);
	}

	@Override
	public int countEmployees(Proxy pxy) {
		return dao.countEmployees(pxy);
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		return dao.existsEmployee(emp);
	}

	@Override
	public void modifyEmployee(EmployeeDTO emp) {
		dao.updateEmployee(emp);
	}

	@Override
	public void removeEmployee(EmployeeDTO emp) {
		dao.deleteEmployee(emp);
	}
	
}
