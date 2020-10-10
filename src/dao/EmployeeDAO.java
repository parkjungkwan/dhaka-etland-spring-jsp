package dao;

import java.util.List;

import domain.EmployeeDTO;
import proxy.Proxy;

public interface EmployeeDAO {
	public void insertEmployee(EmployeeDTO emp);
	public List<EmployeeDTO> selectEmployeeList(Proxy pxy);
	public List<EmployeeDTO> selectEmployees(Proxy pxy);
	public EmployeeDTO selectEmployee(Proxy pxy);
	public int countEmployees(Proxy pxy);
	public boolean existsEmployee(EmployeeDTO emp);
	public void updateEmployee(EmployeeDTO emp);
	public void deleteEmployee(EmployeeDTO emp);
}
