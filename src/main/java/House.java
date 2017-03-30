import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * Created by student on 3/28/17.
 */
public class House {
    int maxBunnies;
    List<Bunny> listBunny;
    private final Logger logger = Logger.getLogger(this.getClass());

    public House()
    {
        maxBunnies = 10;
        listBunny = new LinkedList<Bunny>();
        //listBunny = Collections.synchronizedList(new LinkedList<Bunny>());
    }

    public void receiveEggs()
    {
        Bunny Bunny;
        logger.info("Riley is waiting for bunnies.");
        synchronized (listBunny)
        {

            while(listBunny.size()==0)
            {
                logger.info("Riley is waiting for Bunny.");
                try
                {
                    listBunny.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            logger.info("Riley found a Bunny by the door.");
            Bunny = (Bunny)((LinkedList<?>)listBunny).poll();
        }
        long duration=0;
        try
        {
            logger.info("Getting an egg from Bunny : " + Bunny.getName());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        logger.info("Done getting an egg from Bunny : "+Bunny.getName() + " in "+duration+ " seconds.");
    }

    public void add(Bunny Bunny)
    {
        logger.info("Bunny : "+Bunny.getName()+ " getting to Riley's door at "+Bunny.getInTime());

        synchronized (listBunny)
        {
            if(listBunny.size() == maxBunnies)
            {
                logger.info("Too many bunnies at the door. Bunny "+Bunny.getName() + " will have to come back");
                logger.info("Bunny "+Bunny.getName()+"Exists...");
                return ;
            }

            ((LinkedList<Bunny>)listBunny).offer(Bunny);
            logger.info("Bunny : "+Bunny.getName()+ " is waiting for other bunnies.");

            if(listBunny.size()==1)
                listBunny.notify();
        }
    }
}
