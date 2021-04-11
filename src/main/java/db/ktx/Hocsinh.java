package db.ktx;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hocsinh {
	@Id
	String id;
	String name;
	Number age;


public void setAge(Number age) {
	this.age = age;
}

public Number getAge() {
	return age;
}

public void setId(String id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public String getId() {
	return id;
}

public String getName() {
	return name;
}
}
