package pl.edu.agh.to.lab4.agents;

import pl.edu.agh.to.lab4.agents.PersonAggregate;
import pl.edu.agh.to.lab4.dataProviders.PrisonerDatabase;
import pl.edu.agh.to.lab4.people.Person;

import java.util.Iterator;
import java.util.stream.Collectors;

public class PrisonerDatabaseDecorator implements PersonAggregate {
    private final PrisonerDatabase prisonerDatabase;

    public PrisonerDatabaseDecorator(PrisonerDatabase prisonerDatabase) {
        this.prisonerDatabase = prisonerDatabase;
    }

    @Override
    public Iterator<Person> iterator() {
        return prisonerDatabase
                .getPrisoners()
                .entrySet()
                .stream()
                .flatMap(collection -> collection.getValue().stream())
                .map(prisoner -> (Person) prisoner)
                .collect(Collectors.toSet())
                .iterator();
    }
}
