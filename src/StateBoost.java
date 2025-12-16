import java.util.Random;

public class StateBoost implements State
{
    public void moove(IVoiture context)
    {
        Random rdm;
        int position;

        position = context.getPosition();
        rdm = new Random();
        if (context.getGasLeft() > 0)
        {
            position += rdm.nextInt(5,10); // 10 inclus
            context.decreaseGas(5);
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
        System.out.println("Can't get faster ! Do some drifts to be faster");
    }
    public void decelerate(IVoiture context)
    {
        context.set_state(new StateNormal());
    }

    public String get_name()
    {
        return "BOOST";
    }
}
