package service;

import java.util.List;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import domain.CategoryDTO;
import proxy.PageProxy;

public class CategoryServiceImpl implements CategoryService{
	public static CategoryServiceImpl getInstance() {
		return new CategoryServiceImpl();
	}
	CategoryDAO dao;
	private CategoryServiceImpl() {
		dao = CategoryDAOImpl.getInstance();
	}
	public List<CategoryDTO> bringCategoryList(PageProxy pagePxy) {
		return dao.selectCategoryList(pagePxy);
	}

}
