package state;
import java.util.Random;

import model.Voiture;

public class StateNormal implements State
{
    @Override
    public void moove(Voiture context)
    {
        Random rdm;
        int position;

        position = context.getPosition();
        rdm = new Random();
        if (context.getGasLeft() >= 2)
        {
            position += rdm.nextInt(1, 7); // 6 inclus

            context.decreaseGas(2);
        }
        context.setPosition(position);
    }
    @Override
    public void accelerate(Voiture context)
    {
        context.set_state(new StateBoost());
    }
    @Override
    public void decelerate(Voiture context)
    {
        context.set_state(new StateLow());
    }
}
