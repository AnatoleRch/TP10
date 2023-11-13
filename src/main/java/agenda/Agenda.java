package agenda;
import java.time.LocalDate;
import java.util.*;


/**
 * Description : An agenda that stores events
 */
public class Agenda {

private ArrayList<Event> eventList;

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        this.eventList = new ArrayList<Event>();
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> list = new ArrayList<Event>();
        for(Event e : eventList){
            if (e.isInDay(day)){
                list.add(e);
            }
        }
        return list;
    }
}
