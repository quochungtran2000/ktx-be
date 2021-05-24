package db.ktx.entity;


import javax.persistence.*;

@Entity
@Table(name = "banner")
public class Banner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String image_url;
	private String link;
	private String description;

	public Banner(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
