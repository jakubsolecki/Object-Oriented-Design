package pl.edu.agh.to.lab4.agents;

import pl.edu.agh.to.lab4.agents.PersonAggregate;
import pl.edu.agh.to.lab4.people.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CompositeAggregate implements PersonAggregate {
    Collection<PersonAggregate> dataSources;

    public CompositeAggregate() {
        this.dataSources = new ArrayList<>();
    }

    public CompositeAggregate(Collection<PersonAggregate> dataSources) {
        this.dataSources = dataSources;
    }

    public void addDataSource(PersonAggregate dataSource) {
        this.dataSources.add(dataSource);
    }

    @Override
    public Iterator<Person> iterator() {
        Collection<Person> combinedCollection = new ArrayList<>();
        for(PersonAggregate i : dataSources){
            Iterator<Person> it = i.iterator();
            while(it.hasNext())
                combinedCollection.add(it.next());
        }

        return combinedCollection.iterator();
    }
}
