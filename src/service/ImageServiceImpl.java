package service;

import java.util.List;

import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService{
	private static ImageServiceImpl instance = new ImageServiceImpl();
	ImageDAOImpl dao;
	private ImageServiceImpl() {
		dao = ImageDAOImpl.getInstance();
	}
	public static ImageServiceImpl getInstance() {
		return instance;
	}
	@Override
	public void createImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ImageDTO> imageList(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDTO> searchImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDTO findImage(ImageDTO img) {
		
		return dao.selectImage(img);
	}

	@Override
	public int countImages(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

}
