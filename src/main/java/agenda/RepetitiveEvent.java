package agenda;

import java.util.*;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

private ChronoUnit frequency;
private ArrayList<LocalDate> exeption;


    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event 
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency=frequency;
        this.exeption = new ArrayList<LocalDate>();
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        exeption.add(date);
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        for(LocalDate i : exeption){
            if (i.equals(aDay)){
                return false; 
            }
        }
        if (super.isInDay(aDay)) {
            return true;
        }
        int compt = 0;
        LocalDate date = (LocalDate) ChronoLocalDate.from(this.getStart());
        boolean a=false;
        while ( ChronoLocalDate.from(this.getStart().plus(compt, frequency)).isBefore(aDay)) {
            a = super.isInDay(aDay);
            compt=compt+1;
        }
        return a;
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return this.frequency;  
    }

}
