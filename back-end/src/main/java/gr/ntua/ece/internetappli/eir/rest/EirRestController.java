package gr.ntua.ece.internetappli.eir.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import gr.ntua.ece.internetappli.eir.entity.*;
import gr.ntua.ece.internetappli.eir.repository.*;
import gr.ntua.ece.internetappli.eir.repository.exception.*;

import java.util.List;
import java.io.*;

@RestController
public class EirRestController {

	@Autowired
	MyMongoCollectionRepository myMongoCollectionRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/clinicalStudies")
	public List<MyMongoCollection> getAllStudies() {
		return myMongoCollectionRepository.findAll();
	}

	@GetMapping("/clinicalStudies/{id}")
	public MyMongoCollection getStudy(@PathVariable("id") String id) throws ClinicalStudyNotFoundException {
		MyMongoCollection collection = myMongoCollectionRepository.findClinicalStudyById(id);
		if (collection == null) throw new ClinicalStudyNotFoundException(id);
		return collection;
	}

}
