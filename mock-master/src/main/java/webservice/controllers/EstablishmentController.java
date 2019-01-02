package webservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webservice.dto.Establishment;
import webservice.services.EstablishmentService;

import java.util.List;

@RestController
@RequestMapping("establishment")
public class EstablishmentController {

	@Autowired
	private EstablishmentService service;

	@GetMapping(value = "/all", produces = "application/json")
	public List<Establishment> getAll() {
		return service.getAllEstablishments();
	}

	@GetMapping(value = "/similar/{id}", produces = "application/json")
	public Establishment getSimilar(@PathVariable("id") int id) {
		return service.getSimilarEstablishment(id);
	}

	@GetMapping(value = "/similarList/{id}", produces = "application/json")
	public List<Establishment> getSimilarList(@PathVariable("id") int id) {
		return service.getSimilarListEstablishment(id);
	}

}