package webservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webservice.dto.Client;
import webservice.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Client> getAll() {
        return service.getAllClients();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Client getId(@PathVariable("id") int id) {
        return service.getClient(id);
    }


}