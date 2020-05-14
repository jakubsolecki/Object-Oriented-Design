package pl.edu.agh.to.lab4.people;

public abstract class Person {
    private final String firstname;

    private final String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}