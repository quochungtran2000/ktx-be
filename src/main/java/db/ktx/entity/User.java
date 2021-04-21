package db.ktx.entity;


import javax.persistence.*;
import java.awt.geom.GeneralPath;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user" , uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
@UniqueConstraint(columnNames = "email")})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String username;
	private String password;
	private String email;
	//  private String name;
	//  private int age;
	//	private String phone;
	//	private String img_url;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name="user_id")
			, inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(){

	}
    public User(String username, String password, String email) {
    	this.username = username;
    	this.password = password;
    	this.email = email;
    }

    public Set<Role> getRoles(){
		return roles;
	}
	public void setRoles(Set<Role> roles){
		this.roles = roles;
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
