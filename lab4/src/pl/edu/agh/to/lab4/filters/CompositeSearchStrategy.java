package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.people.Person;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy {
    Collection<SearchStrategy> searchStrategies = new ArrayList<>();
    public void addStrategy(SearchStrategy searchStrategy){
        searchStrategies.add(searchStrategy);
    }

    @Override
    public boolean filter(Person person) {
        for (SearchStrategy searchStrategy : searchStrategies){
            if (!searchStrategy.filter(person)){
                return false;
            }
        }
        return true;
    }
}
