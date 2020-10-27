package com.viettel.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString.Exclude;
 
@Entity
@Table(name = "Client")
public class Client {
 
    @Id
    @GeneratedValue
    private Long id;
 
    @Column(name = "Client_No", length = 30, nullable = true)
    private String cliNo;
 
    @Column(name = "Full_Name", length = 128, nullable = true)
    private String fullName;
 
    @Column(name = "Birth_Day", nullable = true)
    private String birthDay;
    
    @Column(name = "Address", nullable=true)
    private String address;

    @JsonIgnore
    @ManyToMany(mappedBy = "clients")
    @EqualsAndHashCode.Exclude
    @Exclude
    private Collection<Staff> staffs;
    
 
    public Long getId() {
        return id;
    }
 
    public Collection<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Collection<Staff> staffs) {
		this.staffs = staffs;
	}

	public void setId(Long id) {
        this.id = id;
    }
 
    public String getCliNo() {
        return cliNo;
    }
 
    public void setCliNo(String cliNo) {
        this.cliNo = cliNo;
    }
 
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 
    public String getBirthDay() {
        return birthDay;
    }
 
    public void setBirthDay(String string) {
        this.birthDay = string;
    }
 
    public Client() {
		super();
	}

	@Override
    public String toString() {
        return this.getCliNo() + ", " + this.getFullName();
    }
 
}
