/***********************************
 * 
 *      Person.java
 *      Class includes constructors,
 *      setters, and getters used to
 *      create and obtain the information
 *      of a Person object
 * 
 ***********************************/



public class Person {
    private String firstName;
    private String lastName;
    private int age;
    

    
    /* DEFAULT CONSTRUCTOR 
    Requires that name and age are specified */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /* Setters and getters */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public int getAge() {
        return age;
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName + " Age: " + age;
    }
}
