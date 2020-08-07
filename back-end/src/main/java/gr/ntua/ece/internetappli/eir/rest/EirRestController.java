package gr.ntua.ece.internetappli.eir.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;

import gr.ntua.ece.internetappli.eir.entity.*;
import gr.ntua.ece.internetappli.eir.repository.*;
import gr.ntua.ece.internetappli.eir.repository.exception.*;

import java.util.List;
import java.io.*;

@RestController
@RequestMapping("/rest")
public class EirRestController {

	@Autowired
	MyMongoCollectionRepository myMongoCollectionRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot Restfull App!";
	}

	@GetMapping("/clinicalStudies")
	public List<MyMongoCollection> getAllStudies() {
		List<MyMongoCollection> result = myMongoCollectionRepository.findAll();
		// Link selflink = ControllerLinkBuilder.linkTo(EirRestController.class)
		// 									.slash("clinicalStudies")
		// 									.withSelfRel();
		// result.add(selflink);
		return result;
	}

	@GetMapping(value = "/clinicalStudies/{id}",produces = MediaTypes.HAL_JSON_VALUE)
	public MyMongoCollection getStudy(@PathVariable("id") String id) throws ClinicalStudyNotFoundException {
		MyMongoCollection collection = myMongoCollectionRepository.findClinicalStudyById(id);
		if (collection == null) throw new ClinicalStudyNotFoundException(id);
		Link selflink = ControllerLinkBuilder.linkTo(EirRestController.class)
											.slash("clinicalStudies")
											.slash(collection.getId())
											.withSelfRel();
		Link linkToAll = ControllerLinkBuilder.linkTo(EirRestController.class)
											.slash("clinicalStudies")
											.withRel("allStudies");
		collection.add(selflink);
		collection.add(linkToAll);
		return collection;
	}

}
