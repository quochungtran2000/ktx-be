package db.ktx.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	private int location_id;
	private String name;
	private String address;

	public int getLocation_id() {
		return location_id;
	}
	
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
