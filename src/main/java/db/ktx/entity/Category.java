package db.ktx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
	@Id
	private int category_id;
	private String name;
	private String classes;

//	@JsonIgnore
//	@OneToMany(mappedBy = "category")
//	Set<Post> listPost;
//
//	public Set<Post> getListPost() {
//		return listPost;
//	}
//
//	public void setListPost(Set<Post> listPost) {
//		this.listPost = listPost;
//	}

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
