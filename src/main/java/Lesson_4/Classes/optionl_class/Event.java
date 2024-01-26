package Lesson_4.Classes.optionl_class;

import javax.xml.crypto.Data;
import java.util.Date;

public class Event {
    private String id;
    private Date date;
    private float hour;

    public Event(String id, Date date, float hour) {
        this.id = id;
        this.date = date;
        this.hour = hour;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public float getHour() {
        return hour;
    }
}
