package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.agents.PrisonerDatabaseDecorator;
import pl.edu.agh.to.lab4.dataProviders.CitizenDatabase;
import pl.edu.agh.to.lab4.agents.CitizenDatabaseDecorator;
import pl.edu.agh.to.lab4.dataProviders.PrisonerDatabase;
import pl.edu.agh.to.lab4.filters.AgeSearchStrategy;
import pl.edu.agh.to.lab4.filters.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.filters.JailedSearchStrategy;
import pl.edu.agh.to.lab4.filters.NameSearchStrategy;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Finder finder = new Finder(Arrays.asList(new CitizenDatabaseDecorator(new CitizenDatabase()),
                new PrisonerDatabaseDecorator(new PrisonerDatabase())));
        CompositeSearchStrategy compositeSearchStrategy= new CompositeSearchStrategy();
        compositeSearchStrategy.addStrategy(new AgeSearchStrategy(18));
        compositeSearchStrategy.addStrategy(new JailedSearchStrategy());
        compositeSearchStrategy.addStrategy(new NameSearchStrategy("Janusz"));

        finder.displaySuspectsWithName(compositeSearchStrategy);
    }
}

