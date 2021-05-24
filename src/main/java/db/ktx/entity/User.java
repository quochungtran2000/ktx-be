package db.ktx.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@Entity
@Table(name = "user" )
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
	private String username;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String email;
	private String name;
	private int age;
	private String phone;
	private String img_url;
	private String address;
	private Date create_at;
	private Date update_at;

	//role
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "userid"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Post> listPost = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Comment> listComment = new ArrayList<>();
	public User(){}

	public User(String username, String password, String email, String name, int age, String phone, String img_Url){
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.img_url = img_Url;

	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public List<Post> getListPost() {
		return listPost;
	}

	public void setListPost(List<Post> listPost) {
		this.listPost = listPost;
	}
	@JsonCreator
	public User(@JsonProperty("userid") Long userid, @JsonProperty("username") String username,
				@JsonProperty("password") String password, @JsonProperty("name") String name,
				@JsonProperty("age") int age, @JsonProperty("email") String email, @JsonProperty("address") String address,
				@JsonProperty("phone") String phone){
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.address = address;
		this.age = age;
		this.phone = phone;

	}
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}
