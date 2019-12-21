/**
 * 
 */
package com.application.aled.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */



/* 
	This entity will be the table of Referential Bracelet
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/

@Entity
@Table(name = "residents")
public class Residents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resident", nullable = false)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Rooms room;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private User user;

}
