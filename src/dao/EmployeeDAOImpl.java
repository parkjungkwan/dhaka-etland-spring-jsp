package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class EmployeeDAOImpl implements EmployeeDAO{
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertEmployee(EmployeeDTO emp) {
		try {
			String sql = EmployeeSQL.REGISTER.toString();
			Connection conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getManager());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthDate());
			pstmt.setString(4, emp.getPhoto());
			pstmt.setString(5, emp.getNotes());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1) ? "입력 성공":"입력 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<EmployeeDTO> selectEmployeeList(Proxy pxy) {
		return null;
	}

	@Override
	public List<EmployeeDTO> selectEmployees(Proxy pxy) {
		List<EmployeeDTO> list = new ArrayList<>();
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public EmployeeDTO selectEmployee(Proxy pxy) {
		return null;
	}

	@Override
	public int countEmployees(Proxy pxy) {
		int res = 0;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean ok = false;
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(EmployeeSQL.ACCESS.toString());
			ps.setString(1, emp.getEmployeeID());
			ps.setString(2, emp.getName());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){ok = true; }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		
	}

}
