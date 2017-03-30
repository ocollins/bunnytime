/**
 * Created by student on 3/30/17.
 */
class Riley implements Runnable
{
    House house;

    public Riley(House house)
    {
        this.house = house;
    }
    public void run()
    {
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley is ready for bunnies");
        while(true)
        {
            house.receiveEggs();
        }
    }
}
