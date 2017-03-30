import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 3/30/17.
 */
class BunnyGenerator implements Runnable
{
    House house;
    private final Logger logger = Logger.getLogger(this.getClass());

    public BunnyGenerator(House house)
    {
        this.house = house;
        this.house = house;
    }

    public void run()
    {
        while(true)
        {
            Bunny Bunny = new Bunny(house);

            Bunny.setInTime(new Date());
            Thread thBunny = new Thread(Bunny);
            Bunny.setName("Bunny "+ thBunny.getId());
            thBunny.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }

}
