/**
 * 
 */
package com.application.aled.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "residents")
public class Residents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resident", nullable = false)
	private int id;

	@OneToOne(cascade = CascadeType.PERSIST, optional = true)
	@JoinColumn(unique = true)
	private Rooms room;


	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(unique = true)
	private User user;

	public Residents() {
	}

	public Residents(Rooms room, User user){
		this.room = room;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Residents{" +
				"id=" + id +
				", room=" + room +
				", user=" + user +
				'}';
	}
}
