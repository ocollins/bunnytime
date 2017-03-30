import org.apache.log4j.Logger;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 * Created by student on 3/30/17.
 */
public class BunnyTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void run() throws Exception {
        LocalTime localTime = LocalTime.now();
        House house = new House();
        logger.info("Easter early morning " + localTime);

        Riley riley = new Riley(house);
        BunnyGenerator bunnyGenerator = new BunnyGenerator(house);

        Thread thRiley = new Thread(riley);
        Thread thBunny = new Thread(bunnyGenerator);

        thBunny.start();
        thRiley.start();

    }

}