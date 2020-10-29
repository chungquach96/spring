package com.viettel.demo.service.impl;

import com.viettel.demo.models.Client;
import com.viettel.demo.repository.ClientRepository;
import com.viettel.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAllClient() {
        return (List<Client>) clientRepository.findAll();
    }
}
