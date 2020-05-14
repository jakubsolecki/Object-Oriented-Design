package pl.edu.agh.to.lab4.agents;

import pl.edu.agh.to.lab4.people.Person;

import java.util.Iterator;

public interface PersonAggregate {
    public Iterator<Person> iterator();
}
