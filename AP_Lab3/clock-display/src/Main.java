import java.time.LocalTime;



public class Main {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        ClockDisplay clock = new ClockDisplay(currentTime.getHour()
                                             ,currentTime.getMinute()
                                             ,currentTime.getSecond());

        for(int i=0;i<3600;i++){
            System.out.println(clock.getTime());
            clock.timeTick();
        }

    }
}
