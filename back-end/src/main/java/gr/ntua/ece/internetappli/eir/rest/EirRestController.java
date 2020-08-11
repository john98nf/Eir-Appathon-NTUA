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
import java.util.stream.Collectors;
import java.util.regex.PatternSyntaxException;
import java.lang.IllegalArgumentException;
import java.io.*;

@RestController
@RequestMapping("/rest")
public class EirRestController {

	@Autowired
	MyMongoCollectionRepository myMongoCollectionRepository;

	@RequestMapping(value = {"/",""},produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<String> index() {
		return new EntityModel<>("Greetings from Eir Restfull Web Service!",
								ControllerLinkBuilder.linkTo(EirRestController.class)
								.withSelfRel());
	}

	@GetMapping(value = "/clinicalStudies",produces = MediaTypes.HAL_JSON_VALUE)
	public CollectionModel<EntityModel<MyMongoCollection>> getAllStudies() {
		List<EntityModel<MyMongoCollection>> result = myMongoCollectionRepository.findAll().stream()
													    .map(collection -> new EntityModel<>(collection,
														ControllerLinkBuilder.linkTo(EirRestController.class)
															.slash("clinicalStudies")
															.slash(collection.getId())
															.withSelfRel(),
														ControllerLinkBuilder.linkTo(EirRestController.class)
															.slash("clinicalStudies")
															.withRel("allStudies")))
													    .collect(Collectors.toList());

		return new CollectionModel<>(result, ControllerLinkBuilder.linkTo(EirRestController.class)
														.slash("clinicalStudies")
														.withSelfRel());
	}

	@GetMapping(value = "/clinicalStudies/{id}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<MyMongoCollection> getStudy(@PathVariable("id") String id) {

		if (!id.matches("[A-Fa-f0-9]+")) throw new InvalidQueryException();

		MyMongoCollection collection;
		try {
			collection = myMongoCollectionRepository.findClinicalStudyById(id);
		}
		catch (IllegalArgumentException e) {
			throw new InvalidQueryException();
		}

		if (collection == null) throw new ClinicalStudyNotFoundException();

		return new EntityModel<>(collection,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("clinicalStudies")
												.slash(collection.getId())
												.withSelfRel(),
											ControllerLinkBuilder.linkTo(EirRestController.class)
													.slash("clinicalStudies")
													.withRel("allStudies"));
	}

	@GetMapping(value = "/actualNumberOfVolunteers/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<ActualNumberOfVolunteers> getActualNumberOfVolunteers(@PathVariable("condition") String condition) {

		condition = condition.replace('+',' ');
		if (!condition.matches("[a-zA-Z]+(?:'[a-zA-Z0-9\\s]+)*")) throw new InvalidQueryException();

		// Drop '+' character and replace it with actual spaces
		ActualNumberOfVolunteers result = myMongoCollectionRepository.sumOfVolunteers(condition);

		if (result == null) throw new ActualNoVNotFoundException();

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("actualNumberOfVolunteers")
												.slash(condition)
												.withSelfRel());
	}

	@GetMapping(value = "/anticipatedNumberOfVolunteers/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<AnticipatedNumberOfVolunteers> getAnticipatedNumberOfVolunteers(@PathVariable("condition") String condition) {

		// Drop '+' character and replace it with actual spaces
		condition = condition.replace('+',' ');
		if (!condition.matches("[a-zA-Z]+(?:'[a-zA-Z0-9\\s]+)*")) throw new InvalidQueryException();

		AnticipatedNumberOfVolunteers result = myMongoCollectionRepository.sumOfAnticipatedVolunteers(condition);

		if (result == null) throw new AnticipatedNoVNotFoundException();

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("anticipatedNumberOfVolunteers")
												.slash(condition)
												.withSelfRel());
	}

	@GetMapping(value = "/averageTimeForRequitment/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<AverageTimeForRequitment> getAverageTimeForRequitment(@PathVariable("condition") String condition) {

		// Drop '+' character and replace it with actual spaces
		condition = condition.replace('+',' ');
		if (!condition.matches("[a-zA-Z]+(?:'[a-zA-Z0-9\\s]+)*")) throw new InvalidQueryException();

		AverageTimeForRequitment result = myMongoCollectionRepository.averageTimeForRequitmentInDays(condition);

		if (result == null) throw new AnticipatedNoVNotFoundException();

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("averageTimeForRequitment")
												.slash(condition)
												.withSelfRel());
	}

}
