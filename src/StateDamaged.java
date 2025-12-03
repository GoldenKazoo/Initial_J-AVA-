import java.util.Random;

public class StateDamaged implements State
{
    int turns = 0;

    public void moove(Voiture context)
    {
        if (turns < 5)
        {
            turns++;
        }
        else
        {
            turns = 0;
            context.set_state(new StateLow());
        }
    }


    public void show_state(Voiture context)
    {

    }
    public void accelerate(Voiture context)
    {
        System.out.println("You are broken, skill issue !");
    }
    public void decelerate(Voiture context)
    {
        System.out.println("You are broken, skill issue !");
    }
}
