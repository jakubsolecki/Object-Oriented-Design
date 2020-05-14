package pl.edu.agh.to.lab4.dataProviders;

import pl.edu.agh.to.lab4.people.Citizen;

import java.util.ArrayList;
import java.util.Collection;

public class CitizenDatabase {

    private final Collection<Citizen> cracowCitizens = new ArrayList<Citizen>();

    public CitizenDatabase() {
        cracowCitizens.add(new Citizen("Jan", "Kowalski", 30));
        cracowCitizens.add(new Citizen("Janusz", "Krakowski", 30));
        cracowCitizens.add(new Citizen("Janusz", "Mlodociany", 10));
        cracowCitizens.add(new Citizen("Kasia", "Kosinska", 19));
        cracowCitizens.add(new Citizen("Piotr", "Zgredek", 29));
        cracowCitizens.add(new Citizen("Tomek", "Gimbus", 14));
        cracowCitizens.add(new Citizen("Janusz", "Gimbus", 15));
        cracowCitizens.add(new Citizen("Alicja", "Zaczarowana", 22));
        cracowCitizens.add(new Citizen("Janusz", "Programista", 77));
        cracowCitizens.add(new Citizen("Pawel", "Pawlowicz", 32));
        cracowCitizens.add(new Citizen("Krzysztof", "Mendel", 30));
    }

    public Collection<Citizen> getCitizens() {
        return cracowCitizens;
    }
}
