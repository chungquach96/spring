package com.viettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "City", length = 20,nullable = true)
    private String city;

    @Column(name = "Province", length = 20,nullable = true)
    private String province;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = true)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Address(){
        super();
    }

}
