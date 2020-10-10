package service;

import java.util.List;

import domain.EmployeeDTO;
import proxy.Proxy;

public interface EmployeeService {
	public void registEmployee(EmployeeDTO emp);
	public List<EmployeeDTO> bringEmployeeList(Proxy pxy);
	public List<EmployeeDTO> retrieveEmployees(Proxy pxy);
	public EmployeeDTO retrieveEmployee(Proxy pxy);
	public int countEmployees(Proxy pxy);
	public boolean existsEmployee(EmployeeDTO emp);
	public void modifyEmployee(EmployeeDTO emp);
	public void removeEmployee(EmployeeDTO emp);
}
