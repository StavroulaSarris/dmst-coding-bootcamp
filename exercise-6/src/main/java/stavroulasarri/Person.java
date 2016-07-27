package stavroulasarri;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  private String name,surname,email,address;
  private int age;

  protected Person () {}

  public Person (String name, String surname,int age,String email,String address) {
      this.name = name;
      this.surname = surname;
      this.age = age;
      this.email = email;
      this.address = address;
}
public void setName(String name) {
  this.name = name;
}

public String getName() {
  return this.name;
}

public void setSurname(String surname) {
  this.surname = surname;
}

public String getSurname() {
  return this.surname;
}

public void setAge(int age) {
  this.age = age;
}
public int getAge () {
  return this.age;
}
public void setEmail(String email) {
  this.email = email;
}
public String getEmail() {
  return this.email;
}
public void setAddress() {
  this.address = address;
}
public String getAddress() {
   return this.address;
}
@Override
public String toString() {

  return String.format(
               "Customer[id=%d, name='%s', surname='%s',age ='%d',email = '%s',address = '%s']",
               id, name, surname,age,email,address);

}

}
