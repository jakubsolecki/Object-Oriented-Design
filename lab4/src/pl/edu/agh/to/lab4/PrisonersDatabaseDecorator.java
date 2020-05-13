package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PrisonersDatabaseDecorator implements PersonAggregate {
    private PrisonersDatabase prisonersDatabase;

    public PrisonersDatabaseDecorator(PrisonersDatabase prisonersDatabase) {
        this.prisonersDatabase = prisonersDatabase;
    }

    @Override
    public Iterator<Person> iterator() {
        return prisonersDatabase
                .getPrisoners()
                .entrySet()
                .stream()
                .flatMap(collection -> collection.getValue().stream())
                .map(prisoner -> (Person) prisoner)
                .collect(Collectors.toSet())
                .iterator();
    }

}
