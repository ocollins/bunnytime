/**
 * Created by student on 3/30/17.
 */

import org.apache.log4j.Logger;

import java.time.LocalTime;

public class RunBunnies {
    private final Logger logger = Logger.getLogger(this.getClass());

    public static void main(String a[])
    {
        House house = new House();
        LocalTime localTime = LocalTime.now();

        RunBunnies rb = new RunBunnies();
        rb.logger.info("Early morning on Easter Sunday " + localTime);

        Riley riley = new Riley(house);
        BunnyGenerator bunnyGenerator = new BunnyGenerator(house);
        Thread thRiley = new Thread(riley);
        Thread thBunny = new Thread(bunnyGenerator);

        thBunny.start();
        thRiley.start();
    }
}