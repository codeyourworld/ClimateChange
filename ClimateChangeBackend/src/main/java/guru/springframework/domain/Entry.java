package guru.springframework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//(name="Entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
    private Long id;

//    @Column(name="phone")
    private String phone;
//    @Column(name="address")
	private String address;
//    @Column(name="url")
	private String url;
//    @Column(name="email")
	private String email;
//    @Column(name="name")
	private String name;
//    @Column(name="openingHours")
	private String openingHours;
//    @Column(name="type")
	private String type;
//    @Column(name="info")
	private String info;
//    @Column(name="imageUrl")
	private String imageUrl;
//    @Column(name="imageID")
	private int imageID;
	//TODO coordinates 
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openinghours) {
		this.openingHours = openinghours;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the imageID
	 */
	public int getImageID() {
		return imageID;
	}

	/**
	 * @param imageID the imageID to set
	 */
	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Entry [id=" + id + ", phone=" + phone + ", address=" + address + ", url=" + url + ", name=" + name
				+ ", openingHours=" + openingHours + ", type=" + type + ", info=" + info + ", imageUrl=" + imageUrl
				+ ", imageID=" + imageID + "]";
	}


	
}
