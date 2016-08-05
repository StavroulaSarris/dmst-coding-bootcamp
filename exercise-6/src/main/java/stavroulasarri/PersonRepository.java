package stavroulasarri;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @ModelAttribute("persons")
    List<Person> findBysurname(String surname);
}
