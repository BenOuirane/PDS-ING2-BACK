package com.application.aled.entity;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.entity.RoleType;

/*
 * The class 'user' has three attributes 
 * will become the table 'users' with three columns :
 * - Id --> This will automaticaly be a sequence on our database
 * - Firstname
 * - Lastname
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	public User() {

	}

	public User(String firstname, String lastname, String username, String password, String role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the password to set
	 */
	public void setRole(String role) {
		for (RoleType roleType : RoleType.values()) {
			if(role.equals(roleType.name())){
				this.role = role;
				return;
			}

		
		}
		throw new CustomHandler("RoleType not respected");
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\''
				+ ", username='" + username + '\'' + ", password='" + password + '\'' + ", role='" + role + '\'' + '}';
	}
}
