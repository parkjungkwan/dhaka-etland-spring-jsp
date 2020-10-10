package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class CategoryDAOImpl implements CategoryDAO{
	private Connection conn;
	public static CategoryDAO getInstance() {
		return new CategoryDAOImpl();
	}
	private CategoryDAOImpl() {
		conn = DatabaseFactory.createDatabase(Vendor.ORACLE)
				.getConnection();
	}
	@Override
	public void insertCategory(CategoryDTO cate) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<CategoryDTO> selectCategoryList(Proxy pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		CategoryDTO cate = null;
		try {
			String sql = CategorySQL.CATE_LIST.toString();
			System.out.println(">>>>>" + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("진입 >>>");
				cate = new CategoryDTO();
				cate.setCategoryID(rs.getString("CATEGORY_ID"));
				cate.setCategoryName(rs.getString("CATEGORY_NAME"));
				cate.setDescription(rs.getString("DESCRIPTION"));
				list.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("리스트 내부: "+list);
		return list;
	}
	@Override
	public List<CategoryDTO> selectCategorys(Proxy pxy) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public CategoryDTO selectCategory(Proxy pxy) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int countCategorys(Proxy pxy) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public boolean existsCategory(CategoryDTO cate) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void updateCategory(CategoryDTO cate) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteCategory(CategoryDTO cate) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
