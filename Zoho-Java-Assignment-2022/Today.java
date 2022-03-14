import java.text.SimpleDateFormat;
import java.util.Date;

public class Today {

    // todays date in the format Day MMM DD hr.min.sec TIMEZONE YYYY
    // Fri Aug 01 16:16:27 IST 2008
    public static void main(String[] args) {
        SimpleDateFormat formates = new SimpleDateFormat("EEE MMM dd HH:mm:ss");
        Date d = new Date();
        System.out.println(formates.format(d));
        // System.out.println("Today's Date: "+d);
    }
    
}
