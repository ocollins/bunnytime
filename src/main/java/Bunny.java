import java.util.Date;

/**
 * Created by student on 3/28/17.
 */
public class Bunny implements Runnable{
    String name;
    Date inTime;

    House house;

    public Customer(House house)
    {
        this.house = house;
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
        goForHairCut();
    }
    private synchronized void goForHairCut()
    {
        house.add(this);
    }
    
}
