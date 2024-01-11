package lesson_15.Instanse_15_14;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat("HH:mm");
    private String code;
    private Type type;
    private Date date;
    private Aircraft aircraft;

    public Flight(String code, Type type, Date date, Aircraft aircraft) {
        this.code = code;
        this.type = type;
        this.date = date;
        this.aircraft = aircraft;
    }

    public String getCode() {
        return this.code;
    }

    public Type getType() {
        return this.type;
    }

    public Date getDate() {
        return this.date;
    }

    public Aircraft getAircraft() {
        return this.aircraft;
    }

    public String toString() {
        String var10000 = HOUR_FORMAT.format(this.date);
        return var10000 + " / " + this.code + " / " + this.type + " / " + aircraft;
    }

    public static enum Type {
        ARRIVAL,
        DEPARTURE;

        private Type() {
        }
    }

}
