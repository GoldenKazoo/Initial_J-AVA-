import java.util.Random;

public class StateNormal implements State
{
    public void moove(Voiture context)
    {
        Random rdm;
        int position;

        position = context.getPosition();
        rdm = new Random();
        if (context.getGasLeft() > 0)
        {
            position += rdm.nextInt(6);
            context.setGas(2);
        }
        context.setPosition(position);
    }

    public void show_state(Voiture context)
    {

    }
    public void accelerate(Voiture context)
    {
        context.set_state(new StateBoost());
    }
    public void decelerate(Voiture context)
    {
        context.set_state(new StateLow());
    }
}
