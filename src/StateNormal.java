import java.util.Random;

public class StateNormal implements State
{
    public void moove(IVoiture context)
    {
        Random rdm;
        int position;

        position = context.getPosition();
        rdm = new Random();
        if (context.getGasLeft() > 0)
        {
            position += rdm.nextInt(1, 7); // 6 inclus
            context.decreaseGas(2);
        }
        context.setPosition(position);
    }

    public void show_state(IVoiture context)
    {

    }
    public void accelerate(IVoiture context)
    {
        context.set_state(new StateBoost());
    }
    public void decelerate(IVoiture context)
    {
        context.set_state(new StateLow());
    }

    public String get_name()
    {
        return "NORMAL";
    }
}
