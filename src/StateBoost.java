import java.util.Random;

public class StateBoost implements State
{
    public void moove(Voiture context)
    {
        Random rdm;
        int position;

        position = context.getPosition();
        rdm = new Random();
        if (context.getGasLeft() > 0)
        {
            position += rdm.nextInt(5,10);
            context.setGas(10);
        }
        context.setPosition(position);
    }

    public void change_state(Voiture context)
    {

    }

    public void show_state(Voiture context)
    {

    }
    public void accelerate(Voiture context)
    {
        System.out.println("Can't get faster ! Do some drifts to be faster");
    }
    public void decelerate(Voiture context)
    {
        context.set_state(new StateNormal());
    }
}
