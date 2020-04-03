package pl.edu.agh.dronka.shop.model;

public enum MusicGenres {

    ROCK("Rock"), METAL("Metal"), POP("Pop"), RAP("Rap"), INDIE("Indie"),
    UNKNOWN("Nieznany");

    private String displayName;

    MusicGenres(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static MusicGenres parseGenre(String genre){
        switch(genre){
            case "Rock":
                return ROCK;
            case "Pop":
                return POP;
            case "Rap":
                return RAP;
            case "Metal":
                return METAL;
            case "Indie":
                return INDIE;
            default:
                return UNKNOWN;
        }
    }

}
