package SharedCodeBase;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Stamp {

    public long start_time;

    public Stamp() {
        this(0);
    }

    public Stamp(long start_time_input) {
        if(start_time_input == -1) start_time = new Date().getTime();
        else start_time = start_time_input;
    }

    public static String getFormattedTimeNow() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
    }

    public static String getDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public static String getDateAndTimeFileNames() {
        return new SimpleDateFormat("yy-MM-dd").format(new Date()) + LocalTime.now().format(DateTimeFormatter.ofPattern("-HH-mm-ss-SSS"));
    }

    public String getFormattedTime() {
        return String.format("[%02d:%02d:%02d.%03d] ",
                (TimeUnit.MILLISECONDS.toHours(new Date().getTime() - start_time)) % 24,
                (TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - start_time)) % 60,
                (TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - start_time)) % 60,
                (new Date().getTime() - start_time) % 1000
        );
    }

    public Integer getHours() {
        return LocalTime.now().getHour();
    }

    public Integer getMinutes() {
        return LocalTime.now().getMinute();
    }

    public Integer getSeconds() {
        return LocalTime.now().getSecond();
    }

    public Integer getMilliseconds() {
        return LocalTime.now().getNano();
    }

    public void reset() {
        start_time = new Date().getTime();
    }
}