package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.agents.PersonAggregate;
import pl.edu.agh.to.lab4.agents.CompositeAggregate;
import pl.edu.agh.to.lab4.filters.SearchStrategy;
import pl.edu.agh.to.lab4.people.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Finder {
    private final PersonAggregate personAggregate;

    public Finder(Collection<PersonAggregate> dataSources) {
        this.personAggregate = new CompositeAggregate(dataSources);
    }

    public void displaySuspectsWithName(SearchStrategy searchStrategy) {
        List<Person> suspectedPeople = new ArrayList<>();
        Iterator<Person> it = personAggregate.iterator();
        while(it.hasNext()){
            Person person = it.next();
            if (searchStrategy.filter(person)){
                suspectedPeople.add(person);
            }
        }

        System.out.println("Znalazłem " + suspectedPeople.size() + " pasujacych podejrzanych!");
        for (Person person : suspectedPeople){
            System.out.println(person);
        }
    }
}
