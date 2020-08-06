package gr.ntua.ece.internetappli.eir;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.io.*;

@RestController
public class HelloController {

	@Autowired
	MyMongoCollectionRepository myMongoCollectionRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	// @GetMapping("/clinicalStudies")
	// public List<ClinicalStudy> getAllStudies() {
	// 	return clinicalStudyRepository.findAll();
	// }

	@GetMapping("/clinicalStudies/{id}")
	public MyMongoCollection getStudy(@PathVariable("id") String id) {
		return myMongoCollectionRepository.findClinicalStudyById(id);
	}

}
