package db.ktx.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.geom.GeneralPath;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user" )
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String username;
	private String password;
	private String email;
	private String role;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	 Set<Post> listPost;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Comment> listComment;

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public Set<Post> getListPost() {
		return listPost;
	}

	public void setListPost(Set<Post> listPost) {
		this.listPost = listPost;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//  private String name;
	//  private int age;
	//	private String phone;
	//	private String img_url;
	public User(){

	}
	public User(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public String getImg_url() {
//		return img_url;
//	}
//
//	public void setImg_url(String img_url) {
//		this.img_url = img_url;
//	}
}
