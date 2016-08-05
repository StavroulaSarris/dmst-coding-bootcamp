package stavroulasarri;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
public class Person
{
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;

  	@Size(min=2, max=30)
    private String name, surname;

	 @Email
	 private String email;

  	@Size(min=5, max=20)
  	private String address;

    @NotNull
    @Min(18)
    private Integer age;

    protected Person () {}

    public Person (String name, String surname,Integer age,String email,String address) {
      this.name = name;
       this.surname = surname;
       this.age = age;
        this.email = email;
        this.address = address;
      }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
   public String getSurname() {
       return this.surname;
    }

   public void setSurname(String surname) {
        this.surname = surname;
   }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {

      return String.format(
                   "Person[id=%d, name='%s', surname='%s',age ='%d',email = '%s',address = '%s']",
                   id, name, surname,age,email,address);

    }

}
