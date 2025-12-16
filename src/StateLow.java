import java.util.Random;

public class StateLow implements State
{
    public void moove(IVoiture context)
    {
        Random rdm;
        int position;

        position = context.getPosition();
        rdm = new Random();
        if (context.getGasLeft() > 0)
        {
            position += rdm.nextInt(1, 4); // 3 inclus 
            context.decreaseGas(1);
        }
        context.setPosition(position);
    }

    public void change_state(IVoiture context)
    {

    }

    public void show_state(IVoiture context)
    {

    }
    public void accelerate(IVoiture context)
    {
        context.set_state(new StateNormal());
    }
    public void decelerate(IVoiture context)
    {
        context.set_state(new StateStoped());
    }

    public String get_name()
    {
        return "LOW";
    }
}
