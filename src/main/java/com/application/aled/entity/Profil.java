
package com.application.aled.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profil {

	@Id
	private long id;
	/**


	@Column(name = "firstname")
	private String name;

	private TypeProfil typeProfil;
	
	@Column(name = "profil")
	private List<TypeProfil> listTypeProfil;

	
	public Profil(long id, String name, TypeProfil typeProfil, List<TypeProfil> listTypeProfil) {
		super();
		this.id = id;
		this.name = name;
		this.typeProfil = typeProfil;
		this.listTypeProfil = listTypeProfil;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeProfil getTypeProfil() {
		return typeProfil;
	}

	public void setTypeProfil(TypeProfil typeProfil) {
		this.typeProfil = typeProfil;
	}

	public List<TypeProfil> getListTypeProfil() {
		return listTypeProfil;
	}

	public void setListTypeProfil(List<TypeProfil> listTypeProfil) {
		this.listTypeProfil = listTypeProfil;
	}
	*/
}
