package com.viettel.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.swing.event.ListSelectionEvent;

import com.viettel.demo.dto.AddressDto;
import com.viettel.demo.dto.StaffDto;
import com.viettel.demo.models.Address;
import com.viettel.demo.repository.AddressRepository;
import com.viettel.demo.repository.ClientRepository;
import com.viettel.demo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.viettel.demo.models.Client;
import com.viettel.demo.models.Staff;


@RestController
public class MainController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private AddressRepository addressRepository;

    //model mapper
    //Modelmapper

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "asd";
    }

    @PostMapping("/addAddressToClient")
    public ResponseEntity addAddressToClient() {

        return new ResponseEntity(1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress")
    public ResponseEntity deleteAddress(@Param("id") Long id) {
        addressRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/deleteClient")
    public ResponseEntity deleteClient(@Param("id") Long id) {
        clientRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addAddress")
    public ResponseEntity addAddress(@RequestBody AddressDto dto) {
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setProvince(dto.getProvince());

        Address resp = addressRepository.save(address);
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity addRelationShip() {
        List clients = new ArrayList<>();
        Optional<Client> c = clientRepository.findById(8L);

        Optional<Staff> s = staffRepository.findById(4L);
        clients.add(c.get());
        if (s.isPresent()) {
            s.get().setClients(clients);
        }
        Staff resp = staffRepository.save(s.get());

        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @PostMapping("/addStaff")
    public ResponseEntity addStaff(@RequestBody StaffDto dto) {
        Staff staff = new Staff();
        staff.setName(dto.getName());
        staff.setAddress(dto.getAddress());

        //mapstruct
        //modelmapper

        Staff resp = staffRepository.save(staff);
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }

    @GetMapping("/showAllClient")
    public ResponseEntity showAllClient() {
        Iterable<Client> clients = this.clientRepository.findAll();
        return new ResponseEntity(clients, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("/deleteAllClient")
    public ResponseEntity deleteAllClient() {
        this.clientRepository.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getAllStaff")
    public ResponseEntity getAllStaff() {
        Iterable<Client> staffs = this.clientRepository.findAll();

        return new ResponseEntity(staffs, HttpStatus.OK);
    }

    //CRUD
    //1-to-1
    //1-to-Many
    //Many-to-Many

}
