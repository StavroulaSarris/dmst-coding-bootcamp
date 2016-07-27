package stavroulasarri;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;



	@Controller
	public class WebController extends WebMvcConfigurerAdapter {

	  	@Autowired
	  	private PersonRepository repository;

			 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/result").setViewName("result");
	    }

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
	        return "redirect:/result";
	    }
			


}
