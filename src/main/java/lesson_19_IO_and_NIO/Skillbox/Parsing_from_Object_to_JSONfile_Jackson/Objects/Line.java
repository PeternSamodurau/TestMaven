package lesson_19_IO_and_NIO.Skillbox.Parsing_from_Object_to_JSONfile_Jackson.Objects;

public class Line {
    private final String numberLine;
    private final String nameLine;


    public Line(String numberLine, String nameLine) {
        this.numberLine = numberLine;
        this.nameLine = nameLine;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    @Override
    public String toString() {
        return numberLine + " " + nameLine;
    }
}
