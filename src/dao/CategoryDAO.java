package dao;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryDAO {
	public void insertCategory(CategoryDTO cate);
	public List<CategoryDTO> selectCategoryList(Proxy pxy);
	public List<CategoryDTO> selectCategorys(Proxy pxy);
	public CategoryDTO selectCategory(Proxy pxy);
	public int countCategorys(Proxy pxy);
	public boolean existsCategory(CategoryDTO cate);
	public void updateCategory(CategoryDTO cate);
	public void deleteCategory(CategoryDTO cate);
}
