package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.CustomerSQL;
import enums.ImageSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.ImageProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerDAOImpl implements CustomerDAO {
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	Connection conn;
	private CustomerDAOImpl() {
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
	}

	public static CustomerDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertCustomer(CustomerDTO cust) {
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.SIGNUP.toString());
			ps.setString(1, cust.getCustomerID());
			ps.setString(2, cust.getCustomerName());
			ps.setString(3, cust.getPassword());
			ps.setString(4, cust.getSsn());
			ps.setString(5, cust.getPhone());
			ps.setString(6, cust.getPostalCode());
			ps.setString(7, cust.getCity());
			ps.setString(8, cust.getAddress());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerDTO> selectCustomerList(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy) pxy).getPage();
			PreparedStatement stmt = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.LIST.toString());
			String startRow = String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			stmt.setString(1, startRow);
			stmt.setString(2, endRow);
			ResultSet rs = stmt.executeQuery();
			CustomerDTO cust = null;
			while (rs.next()) {
				cust = new CustomerDTO();
				cust.setRnum(rs.getString("RNUM"));
				cust.setPassword(rs.getString("RNUM"));
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setSsn(rs.getString("SSN"));
				cust.setPhone(rs.getString("PHONE"));
				cust.setCity(rs.getString("CITY"));
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setPostalCode(rs.getString("POSTALCODE"));
				list.add(cust);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement stmt = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(sql);
			stmt.setString(1, "");
			ResultSet rs = stmt.executeQuery();
			CustomerDTO cust = null;
			while (rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cust) {
		CustomerDTO temp = null;
		try {
			String sql = (cust.getPassword() == null) ?
				 CustomerSQL.RETRIEVE.toString() :
				 CustomerSQL.SIGNIN.toString() 
			;	
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(sql);
			ps.setString(1, cust.getCustomerID());
			if(cust.getPassword() != null) {
				ps.setString(2, cust.getPassword());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				temp = new CustomerDTO();
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setCity(rs.getString("CITY"));
				temp.setPhone(rs.getString("PHONE"));
				temp.setCustomerID(rs.getString("CUSTOMER_ID"));
				temp.setCustomerName(rs.getString("CUSTOMER_NAME"));
				temp.setPassword(rs.getString("PASSWORD"));
				temp.setPostalCode(rs.getString("POSTALCODE"));
				temp.setSsn(rs.getString("SSN"));
				temp.setPhoto(rs.getString("PHOTO"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int countCustomers(Proxy pxy) {
		int count = 0;
		try {
			String sql = CustomerSQL.ROW_COUNT.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cust) {
		boolean b = false;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public void updateCustomer(CustomerDTO cust) {
		try {
			String sql = CustomerSQL.UPDATE.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, cust.getPassword());
			ps.setString(2, cust.getPhone());
			ps.setString(3, cust.getCity());
			ps.setString(4, cust.getAddress());
			ps.setString(5, cust.getPostalCode());
			ps.setString(6, cust.getCustomerID());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(CustomerDTO cust) {
		try {
			String sql = CustomerSQL.REMOVE.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, cust.getCustomerID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, PHONE FROM CUSTOMERS";
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			CustomerDTO cust = null;

			while (rs.next()) {
				cust = new CustomerDTO();
				String entry = rs.getString("CUSTOMER_ID");
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setPhone(rs.getString("PHONE"));
				map.put(entry, cust);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> selectProfile(Proxy pxy) {
		Map<String, Object> map = new HashMap<>();
		CustomerDTO cust = new CustomerDTO();
		ImageDTO img = new ImageDTO();
		try {
			String sql = "";
			ImageProxy ipxy = (ImageProxy)pxy;
			ImageDAOImpl.getInstance()
					.insertImage(ipxy.getImg());
			String lastSeq = ImageDAOImpl
					.getInstance()
					.lastImageSeq();
			String customerID = ipxy.getImg().getOwner();
			sql = CustomerSQL.UPDATE_PROFILE_IMG.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lastSeq);
			ps.setString(2, customerID);
			ps.executeUpdate();
			img.setImgSeq(lastSeq);
			img = ImageDAOImpl.getInstance()
					.selectImage(img);
			cust.setCustomerID(customerID);
			cust = selectCustomer(cust);
			map.put("cust", cust);
			map.put("img", img);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
}
