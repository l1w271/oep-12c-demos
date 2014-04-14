package com.oracle.oep.util ;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

import java.util.TimeZone;
import java.util.TreeSet;

import org.quartz.impl.calendar.HolidayCalendar;

/**
 * DellSimpleCalendar uses a HolidayCalendar to exclude dates from a given range;
 * 
 * Step 1 Construct and initialize instance
 * To Use the default Dates simply call init()on the instance;
 * To use the dates you want, use the  setExcludeDays(SortedSet<Date> dates) method;
 * 
 * Step 2
 * Invoke getTwoBusinessDayInterval(Date currentDate) or overriden method getTwoBusinessDayInterval(String dispatchDate)
 * epending on your input
 * 
 * Return value is a long measured in milliseconds from Epoch date of 1970
 */
public class SimpleCalendar  implements Serializable {
    
private HolidayCalendar dellHC;
private SimpleCalendar dscal;

private static final long serialVersionUID = 1;

public static final String VALENTINES_DAY = "February 14, 2014";
public static final String INDEPENDENCE_DAY = "July 4, 2014";
public static final String MEETING_DAY = "February 15, 2014";
public static final String NORMAL_TEST_DATE ="February 8, 2014";
public static final String EXTENDED_TEST_DATE ="February 13, 2014"; 
public static final String OUTSIDE_HOLIDAY_DATE ="February 16, 2014"; 
public static final String NEW_DSIPATCH_START ="February 18, 2014";


    public SimpleCalendar() {
        super();
        dscal = this;
    }

    /**
     * @param currentDate
     * @return
     */
    public long getTwoBusinessDayInterval(Date currentDate) {   
        long durationEnd = this.processExclusions(currentDate, this.calculateSLAEndDate(currentDate)).getTime();
        long durationStart = currentDate.getTime();
        long durationTotal = durationEnd - durationStart;
     System.out.println("================================= long value between start and end "+ durationTotal);
     return  durationTotal;
    }

    public static int getRandomLowInterval(String dispatchId) {   
        int interval = 0 ;
        
        Random r = new Random();
        interval = r.nextInt(10) + 5 ;
        
        //System.out.println("[" + Calendar.getInstance().getTime().toString() + "] {" + dispatchId + "} interval is: " + interval);
        
     return  interval;
    }

    /**
     * @param dispatchDate
     * @return
     */
    public long getTwoBusinessDayInterval(String dispatchDate){
     Date formatdispatchDate = new Date();
        try {             
            formatdispatchDate = DateFormat.getDateInstance().parse(dispatchDate); 
             formatdispatchDate = new Date(getTwoBusinessDayInterval(formatdispatchDate));
        } catch(ParseException pe) {
          System.err.println(pe.getLocalizedMessage());
        }
     return formatdispatchDate.getTime();
     }
 
    public HolidayCalendar getHolidayCalendar() {
     return dellHC;
    }

    /**
     * @param holidays
     */
    public void setExcludeDays(HolidayCalendar holidays) {
      try {
         holidays.addExcludedDate(DateFormat.getDateInstance().parse(SimpleCalendar.INDEPENDENCE_DAY));
         holidays.addExcludedDate(DateFormat.getDateInstance().parse(SimpleCalendar.VALENTINES_DAY));
         holidays.addExcludedDate(DateFormat.getDateInstance().parse(SimpleCalendar.MEETING_DAY));
     } catch(ParseException pe) {
         System.err.println(pe.getLocalizedMessage());
     }
      }

    /**
     * @param SortedSet dates
     */
    public void setExcludeDays(SortedSet<Date> dates) {

          dscal.dellHC = new HolidayCalendar();
          dscal.getHolidayCalendar().setTimeZone(TimeZone.getDefault());
          
          for(Iterator<Date> it = dates.iterator(); it.hasNext();) {  
          dellHC.addExcludedDate(it.next());
          }
      }

    /**
     * @param HolidayCalendar holcal
     */
    public void setHolidayCalendar(HolidayCalendar holcal) {
    this.dellHC = holcal;
 }

    /**
     */
    public void init() {
    dscal.setHolidayCalendar(new HolidayCalendar());
    dscal.getHolidayCalendar().setTimeZone(TimeZone.getDefault());
    dscal.setExcludeDays(dscal.getHolidayCalendar());
}

    /**
     * @param String dateformat
     * @return Date
     */
    public Date getStringDate(String dateformat) {
     Date formatdispatchDate = new Date();
      try {  
          formatdispatchDate = DateFormat.getDateInstance().parse(dateformat); 
     } catch(ParseException pe) {
          System.err.println(pe.getLocalizedMessage());
     }
     
     return formatdispatchDate;
     
 }

    /**
     * @param Date dispatchStart
     * @return Date
     */
    public Date calculateSLAEndDate(Date dispatchStart) {
     Calendar calendarOuter = Calendar.getInstance();
     calendarOuter.setTime(dispatchStart);
     calendarOuter.add(Calendar.HOUR,48);
     return calendarOuter.getTime();
 }
 
 public Date processExclusions(Date startDate, Date endDate)  {
     System.out.println("=========== INSIDE PROCESS EXCLUSIONS BETWEEN " +startDate + " and "+ endDate );
   
     SortedSet<Date> excludeDates = this.getHolidayCalendar().getExcludedDates();
     
     for(Iterator<Date> it = excludeDates.iterator(); it.hasNext();) {
        Date holidayDate = it.next();
            System.out.println("*********  EVALUATING HOLIDAY:  " + holidayDate + "**********" );
         if ( startDate.before(holidayDate) && (endDate.after(holidayDate))) {
             System.out.println("=========== DATE IN RANGE CONDITION for Holiday Date " + holidayDate );
             Calendar recalculatedEndDate = Calendar.getInstance();
             recalculatedEndDate.setTime(endDate);
             recalculatedEndDate.add(Calendar.HOUR, 24);
             endDate = recalculatedEndDate.getTime();
         }     
        }
     System.out.println("=========== COMPLETED PROCESS EXCLUSIONS BETWEEN " + startDate + " and "+ endDate );
     return endDate;
 }
 
 public static void main(String args[]) {
        
    // SimpleCalendar dscal = new SimpleCalendar();
        System.out.println("Low Interval: " + SimpleCalendar.getRandomLowInterval("Dispatch1"));
     /*
     dscal.init();
        System.out.println("===================== START NORMAL_TEST_DATE TEST: " + SimpleCalendar.NORMAL_TEST_DATE);  
     Date startDate = dscal.getStringDate(SimpleCalendar.NORMAL_TEST_DATE);
        System.out.println("PROCESSED NORMAL TEST DATE END DATE = "+ dscal.processExclusions(startDate,dscal.calculateSLAEndDate(startDate) ));
        System.out.println("===================== END NORMAL_TEST_DATE TEST : " + SimpleCalendar.NORMAL_TEST_DATE);  
      
        System.out.println("===================== START EXTENDED_TEST_DATE TEST: " + SimpleCalendar.EXTENDED_TEST_DATE);  
      startDate = dscal.getStringDate(SimpleCalendar.EXTENDED_TEST_DATE);
        System.out.println("EXTENDED END DATE is " + dscal.processExclusions(startDate,dscal.calculateSLAEndDate(startDate) ) );
        System.out.println("===================== END EXTENDED_TEST_DATE TEST =================== ");
        
        System.out.println("===================== START NEW HOLIDAYS TEST: " + SimpleCalendar.OUTSIDE_HOLIDAY_DATE);
        SortedSet<Date> newHolidays = new TreeSet<Date>();
        newHolidays.add( dscal.getStringDate(SimpleCalendar.OUTSIDE_HOLIDAY_DATE));
        dscal.setExcludeDays(newHolidays);
        startDate = dscal.getStringDate(SimpleCalendar.NEW_DSIPATCH_START);
        System.out.println("TESTING LONG DURATION is " + dscal.getTwoBusinessDayInterval(SimpleCalendar.NEW_DSIPATCH_START) );
        System.out.println("EXTENDED END DATE is " + dscal.processExclusions(startDate,dscal.calculateSLAEndDate(startDate) ) );
        System.out.println("===================== END NEW HOLIDAYS TEST: " + SimpleCalendar.NEW_DSIPATCH_START );
     */
     
     System.exit(0);
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SimpleCalendar)) {
            return false;
        }
        final SimpleCalendar other = (SimpleCalendar)object;
        if (!(dscal == null ? other.dscal == null : dscal.equals(other.dscal))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((dscal == null) ? 0 : dscal.hashCode());
        return result;
    }
}
