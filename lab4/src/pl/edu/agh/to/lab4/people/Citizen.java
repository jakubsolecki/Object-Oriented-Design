package pl.edu.agh.to.lab4.people;

import pl.edu.agh.to.lab4.people.Person;

public class Citizen extends Person {
    private int age;

    public Citizen(String firstname, String lastname, int age) {
        super(firstname, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
