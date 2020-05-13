package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Finder {
    private final Collection<Citizen> allCitzens;

    private final Map<String, Collection<Prisoner>> allPrisoners;

    public Finder(Collection<Citizen> allCitzens, Map<String, Collection<Prisoner>> allPrisoners) {
        this.allCitzens = allCitzens;
        this.allPrisoners = allPrisoners;
    }

    public Finder(CitizenDatabase citizenDatabase, PrisonersDatabase prisonersDatabase) {
        this(citizenDatabase.getCitizens(), prisonersDatabase.getPrisoners());
    }

    public void displaySuspectsWithName(String name) {
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<Prisoner>();
        ArrayList<Citizen> suspectedPeople = new ArrayList<Citizen>();

        for (Collection<Prisoner> prisonerCollection : allPrisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (!prisoner.isJailed() && prisoner.getFirstname().equals(name)) {
                    suspectedPrisoners.add(prisoner);
                }
                if (suspectedPrisoners.size() >= 10) {
                    break;
                }
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        if (suspectedPrisoners.size() < 10) {
            for (Citizen citizen : allCitzens) {
                if (citizen.getAge() > 18 && citizen.getFirstname().equals(name)) {
                    suspectedPeople.add(citizen);
                }
                if (suspectedPrisoners.size() + suspectedPeople.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspectedPrisoners.size() + suspectedPeople.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner n : suspectedPrisoners) {
            System.out.println(n.toString());
        }

        for (Citizen p : suspectedPeople) {
            System.out.println(p.toString());
        }
    }
}
