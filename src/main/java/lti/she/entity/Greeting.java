package lti.she.entity;

import java.util.Calendar;

public class Greeting {
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting() {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        if(timeOfDay >= 0 && timeOfDay < 12) greeting = "Good Morning";
        else if(timeOfDay >= 12 && timeOfDay < 16) greeting = "Good Afternoon";
        else if(timeOfDay >= 16 && timeOfDay < 24) greeting = "Good Evening";
    }
        
}
