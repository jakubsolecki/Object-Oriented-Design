package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.people.Person;

public interface SearchStrategy {
    public boolean filter(Person suspect);
}
