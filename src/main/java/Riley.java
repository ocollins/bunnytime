import org.apache.log4j.Logger;

/**
 * Created by student on 3/30/17.
 */
class Riley implements Runnable
{
    private final Logger logger = Logger.getLogger(this.getClass());
    House house;

    public Riley(House house)
    {

        this.house = house;
    }
    public void run()
    {
        try
        {
            logger.info("Riley is watching TV and waiting for bunnies");
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        while(true)
        {
            house.receiveEggs();
        }
    }
}
