package stavroulasarri;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;



	@Controller
	public class WebController extends WebMvcConfigurerAdapter {
			private static final Logger log = LoggerFactory.getLogger(Application.class);

			@Autowired
	  	private PersonRepository repository;

	    @RequestMapping(value="/", method=RequestMethod.GET)
	    public String showForm(Person person) {
	        return "forms";
	    }

	    @RequestMapping(value="/", method=RequestMethod.POST)
	    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {

	        if (bindingResult.hasErrors()) {
	            return "forms";
	        }
					repository.save(person);
					log.info("People found with findAll():");
					log.info("-------------------------------");
					for (Person person1 : repository.findAll()) {
						log.info(person1.toString());
					}

	        return "result";
	    }

		 	@RequestMapping(value = "/result", method = RequestMethod.GET)
     	public String showResults(Model model) {
 			 	Iterable<Person> person2 = repository.findAll();
 			 	model.addAttribute("person2", person2);
 			 	return "result";

			}



}
