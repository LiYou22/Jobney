package model.application;

import java.time.ZonedDateTime;

public class CalendarActivity {
	
    private ZonedDateTime date;
    private String clientName;
    private Integer serviceNo;

    public CalendarActivity(ZonedDateTime date) {
        this.date = date;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CalenderActivity{" +
                "date=" + date;
    }
}
