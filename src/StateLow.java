import java.util.Random;

public class StateLow implements State
{
    public void moove(Voiture context)
    {
        Random rdm;
        int position;

        position = context.getPosition();
        rdm = new Random();
        if (context.getGasLeft() >= 1)
        {
            position += rdm.nextInt(1, 4); // 3 inclus 
            context.decreaseGas(1);
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
        context.set_state(new StateNormal());
    }
    public void decelerate(Voiture context)
    {
        context.set_state(new StateStoped());
    }
}
