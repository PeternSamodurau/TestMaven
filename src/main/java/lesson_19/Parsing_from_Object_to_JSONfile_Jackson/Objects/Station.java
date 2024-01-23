package lesson_19.Parsing_from_Object_to_JSONfile_Jackson.Objects;

public class Station {
    private final int numberStation;
    private final String nameStation;


    public Station(int numberStation, String nameStation) {
        this.numberStation = numberStation;
        this.nameStation = nameStation;

    }

    public Integer getNumberStation() {
        return numberStation;
    }

    public String getNameStation() {
        return nameStation;
    }

    @Override
    public String toString() {
        return numberStation + " " + nameStation;
    }

}
