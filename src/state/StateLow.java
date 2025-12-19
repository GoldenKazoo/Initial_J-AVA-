package state;
import java.util.Random;

import model.Voiture;

public class StateLow implements State
{
    @Override
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

    @Override
    public void accelerate(Voiture context)
    {
        context.set_state(new StateNormal());
    }
    
    @Override
    public void decelerate(Voiture context)
    {
        context.set_state(new StateStoped());
    }
}
