package com.viettel.demo.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "staff")
public class Staff implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "Staff_Name")
	private String name;
	
	@Column(name = "Staff_Address")
	private String Address;
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@JoinTable(name = "care",
//				joinColumns = @JoinColumn(name = "staff_id"),
//				inverseJoinColumns  = @JoinColumn(name = "client_id"))
//	private Collection<Client> clients;

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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

//	public Collection<Client> getClients() {
//		return clients;
//	}
//
//	public void setClients(Collection<Client> clients) {
//		this.clients = clients;
//	}
//
//	public Staff(long id, String name, String address, Collection<Client> clients) {
//		super();
//		this.id = id;
//		this.name = name;
//		Address = address;
//		this.clients = clients;
//	}

	public Staff() {
		super();
	}
	
	
	
	
	
	
	
	
}
