package MyApp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
public class Person
{
  	@Size(min=2, max=30)
    private String name, surname;

	 @Email
	 private String email;

  	@Size(min=5, max=20)
  	private String address;

    @NotNull
    @Min(18)
    private Integer age;

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
    public String toString() {
        return "Person(Name: " + this.name + ",Surname " +this.surname +", Age: " + this.age +",Email: " +this.email + ",Address: " + this.address + ")";
    }

}
