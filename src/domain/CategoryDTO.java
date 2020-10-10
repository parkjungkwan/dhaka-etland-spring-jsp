package domain;

import lombok.Data;

public class CategoryDTO {
	private String categoryID,
	   				categoryName,
	   				description;
// categoryID, categoryName, description

	public String getCategoryID() {
		return categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
