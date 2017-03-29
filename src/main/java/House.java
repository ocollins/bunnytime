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
    }

    public void cutHair()
    {
        Bunny Bunny;
        System.out.println("Riley is waiting for bunnies.");
        synchronized (listBunny)
        {

            while(listBunny.size()==0)
            {
                System.out.println("Riley is waiting for Bunny.");
                try
                {
                    listBunny.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("Riley found a Bunny in the queue.");
            Bunny = (Bunny)((LinkedList<?>)listBunny).poll();
        }
        long duration=0;
        try
        {
            System.out.println("Cuting hair of Bunny : "+Bunny.getName());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Completed Cuting hair of Bunny : "+Bunny.getName() + " in "+duration+ " seconds.");
    }

    public void add(Bunny Bunny)
    {
        System.out.println("Bunny : "+Bunny.getName()+ " entering the shop at "+Bunny.getInTime());

        synchronized (listBunny)
        {
            if(listBunny.size() == maxBunnies)
            {
                System.out.println("No chair available for Bunny "+Bunny.getName());
                System.out.println("Bunny "+Bunny.getName()+"Exists...");
                return ;
            }

            ((LinkedList<Bunny>)listBunny).offer(Bunny);
            System.out.println("Bunny : "+Bunny.getName()+ " got the chair.");

            if(listBunny.size()==1)
                listBunny.notify();
        }
    }
}
