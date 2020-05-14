package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.people.Person;
import pl.edu.agh.to.lab4.people.Prisoner;

public class JailedSearchStrategy implements SearchStrategy {
    @Override
    public boolean filter(Person person) {
        if (!(person instanceof Prisoner)){
            return true;
        }
        return !((Prisoner) person).isJailed();
    }

}
