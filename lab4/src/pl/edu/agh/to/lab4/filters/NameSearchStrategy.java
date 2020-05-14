package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.people.Person;

public class NameSearchStrategy implements SearchStrategy {
    private String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }
    @Override
    public boolean filter(Person person) {
        return person.getFirstname().equals(name);
    }
}
