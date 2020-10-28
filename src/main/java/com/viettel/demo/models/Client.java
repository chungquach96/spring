package com.viettel.demo.models;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viettel.demo.repository.AddressRepository;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Set<Address> addresses = new HashSet<>();


    public Long getId() {
        return id;
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
