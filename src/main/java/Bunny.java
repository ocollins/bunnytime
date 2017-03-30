import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by student on 3/28/17.
 */
public class Bunny implements Runnable{
    String name;
    Date inTime;

    House house;
    private final Logger logger = Logger.getLogger(this.getClass());

    public Bunny(House house)
    {
        this.house = house;
    }

    public Bunny() {
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {

        goToRileysHouse();
    }

    private synchronized void goToRileysHouse()
    {
        house.add(this);
    }
    
}
