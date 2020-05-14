package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.people.Citizen;
import pl.edu.agh.to.lab4.people.Person;

public class AgeSearchStrategy implements SearchStrategy {
    private int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    @Override
    public boolean filter(Person person) {
        if (!(person instanceof Citizen)){
            return true;
        }
        return ((Citizen) person).getAge() > age;
    }
}
