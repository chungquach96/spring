package com.viettel.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.swing.event.ListSelectionEvent;

import com.viettel.demo.dto.StaffDto;
import com.viettel.demo.repository.ClientRepository;
import com.viettel.demo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.viettel.demo.models.Client;
import com.viettel.demo.models.Staff;


 
@Controller
public class MainController {
 
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private StaffRepository staffRepository;
    
    private static final String[] NAMES = new String[] { "Tom", "Jerry", "Donald" };
 
//    @GetMapping("/getClientByStaffId")
//    public ResponseEntity getClientByStaffId(@RequestParam(name = "staff_id") long staff_id ) {
//    	Iterable<Client> clients = this.clientRepository.findClientByStaffId(staff_id);
//    	return new ResponseEntity(clients, HttpStatus.OK);
//    }
//    
//    @PostMapping("/addStaffClientRelationShip")
//    public ResponseEntity addRelationShip(@RequestParam(name = "staff_id") long staff_id, @RequestParam(name = "client_id") long client_id) {
//    	System.out.println(""+staff_id+"--"+client_id);
//    	
//		return new ResponseEntity(HttpStatus.OK);
//    }
    
	  @PostMapping("/add")
	  public ResponseEntity addRelationShip() {
		List clients = new ArrayList<>();
	  	Optional<Client> c = clientRepository.findById(8L);
	  	
	  	Optional<Staff> s = staffRepository.findById(4L);
	  	clients.add(c.get());
	  	if (s.isPresent()) {
	  		s.get().setClients(clients);
		}
	  	


	  	
//	  	List clients = new ArrayList<>();
//	  	clients.add(c);
//	  	clients.add(c2);
//	  	
//	  	s.setClients(clients);
	  	Staff resp = staffRepository.save(s.get());
	  	
		return new ResponseEntity(resp, HttpStatus.OK);
	  }
    
    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/testInsert'>Insert</a></li>";
        html += " <li><a href='/showAllClient'>Show All Client</a></li>";
        html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/deleteAllClient'>Delete All Client</a></li>";
        html += " <li><a href='/showAllCustomer'>Show All customer</a></li>";
        html += "</ul>";
        return html;
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
    @RequestMapping("/showFullNameLikeTom")
    public String showFullNameLikeTom() {
 
        List<Client> clients = this.clientRepository.findByFullNameLike("Tom");
 
        String html = "";
        for (Client cli : clients) {
            html += cli + "<br>";
        }
 
        return html;
    }
 
    @ResponseBody
    @RequestMapping("/deleteAllClient")
    public String deleteAllClient() {
 
        this.clientRepository.deleteAll();
        return "Deleted!";
    }
    
    @GetMapping("/a")
    public ResponseEntity getAllStaff() {
    	Iterable<Client> staffs = this.clientRepository.findAll();
    	
    	return new ResponseEntity(staffs,HttpStatus.OK);
    }

    //CRUD
    //1-to-1
    //1-to-Many
    //Many-to-Many
 
}
