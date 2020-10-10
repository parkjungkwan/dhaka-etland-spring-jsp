package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.ImageDTO;
import enums.ImageSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAOImpl instance = new ImageDAOImpl();
	Connection conn;
	private ImageDAOImpl() {
		try {
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ImageDAOImpl getInstance() {
		return instance;
	}
	
	@Override
	public void insertImage(ImageDTO img) {
		String sql = ImageSQL.IMG_ADD.toString();
		try {
			PreparedStatement ps = 
						conn.prepareStatement(sql);
			ps.setString(1, img.getImgName());
			ps.setString(2, img.getImgExtention());
			ps.setString(3, img.getOwner());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<ImageDTO> selectImageList(Proxy pxy) {
		return null;
	}

	@Override
	public List<ImageDTO> selectImages(Proxy pxy) {
		return null;
	}

	@Override
	public ImageDTO selectImage(ImageDTO img) {
		ImageDTO image = new ImageDTO();
		
		String sql = ImageSQL.SELECT_ONE_IMG.toString();
		try {
			PreparedStatement ps = 
						conn.prepareStatement(sql);
			ps.setString(1, img.getImgSeq());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				image.setImgExtention(rs.getString("IMG_EXTENTION"));
				image.setImgName(rs.getString("IMG_NAME"));
				image.setImgSeq(rs.getString("IMG_SEQ"));
				image.setOwner(rs.getString("OWNER"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return image;
	}

	@Override
	public int countImages(Proxy pxy) {
		return 0;
	}

	@Override
	public void updateImage(ImageDTO img) {
		
	}

	@Override
	public void deleteImage(ImageDTO img) {
		
	}
	@Override
	public String lastImageSeq() {
		String seq = "";
		String sql = ImageSQL.IMG_LAST_SEQ.toString();
		try {
			PreparedStatement ps = 
						conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				seq = rs.getString("SEQ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seq;
	}

}
