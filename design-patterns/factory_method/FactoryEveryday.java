package factory_method;

import java.util.Calendar;

public class FactoryEveryday {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();// we don’t know the concrete implementation until we print it java.util.GregorianCalendar[time=1616686987388
        System.out.println(cal);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    }
}
