package Lesson_4.Classes.optionl_class;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DataBase {

    public Event getNewTodayEvent(){                      // методу не нужен Optional, т к он не вернет null
        return new Event(UUID.randomUUID().toString(), new Date(), 0);
    }
    public List<Event> getEventsByDays(Date day){         //тоже не нужен Optional
        List<Event> result = new ArrayList<>();
        return result;
    }
    public Event findEventById(){
        Event result = null;
       // код
        return result;
    }

}
