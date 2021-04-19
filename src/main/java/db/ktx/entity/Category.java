package db.ktx.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	private int category_id;
	private String name;
	private String classes;

	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClasses() {
		return classes;
	}
	
	public void setClasses(String classes) {
		this.classes = classes;
	}
}
