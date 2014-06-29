package us.pollapp.inturik.DTO;

import java.util.Date;

public class PollaDTO {

	private Integer id;
	private String name;
	private Date createdDate;
	private int idUserAdmin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdUserAdmin() {
		return idUserAdmin;
	}

	public void setIdUserAdmin(int idUserAdmin) {
		this.idUserAdmin = idUserAdmin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
