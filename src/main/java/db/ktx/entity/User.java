package db.ktx.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
	@Id
  private int userId;
	private String username;
	private String password;
	private String name;
	private int age;
	private String phone;
	private String email;
	private String img_url;
	private String reset_password;
	private Date create_at;
	private Date update_at;

public String getName() {
	return name;
}

public Date getCreate_at() {
	return create_at;
}

public Date getUpdate_at() {
	return update_at;
}

public int getAge() {
	return age;
}

public int getUserId() {
	return userId;
}



public String getEmail() {
	return email;
}

public String getImg_url() {
	return img_url;
}

public String getPassword() {
	return password;
}

public String getReset_password() {
	return reset_password;
}

public String getUsername() {
	return username;
}

public void setAge(int age) {
	this.age = age;
}

public void setName(String name) {
	this.name = name;
}

public void setCreate_at(Date create_at) {
	this.create_at = create_at;
}

public void setEmail(String email) {
	this.email = email;
}

public void setImg_url(String img_url) {
	this.img_url = img_url;
}

public void setPassword(String password) {
	this.password = password;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPhone() {
	return phone;
}

public void setReset_password(String reset_password) {
	this.reset_password = reset_password;
}

public void setUpdate_at(Date update_at) {
	this.update_at = update_at;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public void setUsername(String username) {
	this.username = username;
}
}
