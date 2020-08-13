package gr.ntua.ece.internetappli.eir.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.dao.DataAccessException;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import gr.ntua.ece.internetappli.eir.entity.*;
import gr.ntua.ece.internetappli.eir.repository.*;
import gr.ntua.ece.internetappli.eir.repository.exception.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.PatternSyntaxException;
import java.lang.IllegalArgumentException;
import java.io.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
		List<EntityModel<MyMongoCollection>> result;
		try {
			result = myMongoCollectionRepository.findAll().stream()
											    .map(collection -> new EntityModel<>(collection,
													ControllerLinkBuilder.linkTo(EirRestController.class)
														.slash("clinicalStudies")
														.slash(collection.getId())
														.withSelfRel(),
													ControllerLinkBuilder.linkTo(EirRestController.class)
														.slash("clinicalStudies")
														.withRel("allStudies")))
											    .collect(Collectors.toList());
		}
		catch (DataAccessException e) {
			throw new InvalidQueryException();
		}

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
		catch (DataAccessException e) {
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

	@GetMapping(value = "/randomClinicalStudyByCondition/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<MyMongoCollection> findOneClinicalStudy(@PathVariable("condition") String condition) {

		// Decode url params
		MyMongoCollection result;
		try {
			condition = URLDecoder.decode(condition, StandardCharsets.UTF_8.toString());
			result = myMongoCollectionRepository.randomClinicalStudyByCondition(condition);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Hello1");
			throw new InvalidQueryException();
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Hello2");
			throw new InvalidQueryException();
		}
		catch (DataAccessException e) {
			System.out.println("Hello3");
			throw new InvalidQueryException();
		}

		if (result == null) throw new ClinicalStudyNotFoundException();

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("randomClinicalStudyByCondition")
												.slash(result.getClinicalStudy().getCondition())
												.withSelfRel(),
											ControllerLinkBuilder.linkTo(EirRestController.class)
													.slash("clinicalStudies")
													.withRel("allStudies"));
	}

	@GetMapping(value = "/actualNumberOfVolunteers/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<ActualNumberOfVolunteers> getActualNumberOfVolunteers(@PathVariable("condition") String condition) {

		// Decode url params
		ActualNumberOfVolunteers result;
		try {
			condition = URLDecoder.decode(condition, StandardCharsets.UTF_8.toString());
			result = myMongoCollectionRepository.sumOfVolunteers(condition);
		}
		catch (IllegalArgumentException e) {
			throw new InvalidQueryException();
		}
		catch (UnsupportedEncodingException e) {
			throw new InvalidQueryException();
		}
		catch (DataAccessException e) {
			throw new InvalidQueryException();
		}

		if (result == null) result = new ActualNumberOfVolunteers(new Long(0));

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("actualNumberOfVolunteers")
												.slash(condition)
												.withSelfRel());
	}

	@GetMapping(value = "/anticipatedNumberOfVolunteers/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<AnticipatedNumberOfVolunteers> getAnticipatedNumberOfVolunteers(@PathVariable("condition") String condition) {

		// Decode url params
		AnticipatedNumberOfVolunteers result;
		try {
			condition = URLDecoder.decode(condition, StandardCharsets.UTF_8.toString());
			result = myMongoCollectionRepository.sumOfAnticipatedVolunteers(condition);
		}
		catch (IllegalArgumentException e) {
			throw new InvalidQueryException();
		}
		catch (UnsupportedEncodingException e) {
			throw new InvalidQueryException();
		}
		catch (DataAccessException e) {
			throw new InvalidQueryException();
		}

		if (result == null) result = new AnticipatedNumberOfVolunteers(new Long(0));

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("anticipatedNumberOfVolunteers")
												.slash(condition)
												.withSelfRel());
	}

	@GetMapping(value = "/averageTimeForRequitment/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<AverageTimeForRequitment> getAverageTimeForRequitment(@PathVariable("condition") String condition) {

		// Decode url params
		AverageTimeForRequitment result;
		try {
			condition = URLDecoder.decode(condition, StandardCharsets.UTF_8.toString());
			result = myMongoCollectionRepository.averageTimeForRequitmentInDays(condition);
		}
		catch (IllegalArgumentException e) {
			throw new InvalidQueryException();
		}
		catch (UnsupportedEncodingException e) {
			throw new InvalidQueryException();
		}
		catch (DataAccessException e) {
			throw new InvalidQueryException();
		}

		if (result == null) result = new AverageTimeForRequitment(new Float(0));

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("averageTimeForRequitment")
												.slash(condition)
												.withSelfRel());
	}

	@GetMapping(value = "/numberOfStudies/{condition}",produces = MediaTypes.HAL_JSON_VALUE)
	public EntityModel<NumberOfStudies> getNumberOfStudies(@PathVariable("condition") String condition) {

		// Decode url params
		NumberOfStudies result;
		try {
			condition = URLDecoder.decode(condition, StandardCharsets.UTF_8.toString());
			result = myMongoCollectionRepository.numberOfStudies(condition);
		}
		catch (IllegalArgumentException e) {
			throw new InvalidQueryException();
		}
		catch (UnsupportedEncodingException e) {
			throw new InvalidQueryException();
		}
		catch (DataAccessException e) {
			throw new InvalidQueryException();
		}

		if (result == null) result = new NumberOfStudies(new Long(0));

		return new EntityModel<>(result,ControllerLinkBuilder.linkTo(EirRestController.class)
												.slash("numberOfStudies")
												.slash(condition)
												.withSelfRel());
	}

}
