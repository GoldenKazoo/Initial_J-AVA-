import java.util.Random;

public class StateBoost implements State
{
    @Override
    public void moove(Voiture context) {
        Random rdm = new Random();
        int position = context.getPosition();
    
        if (context.getGasLeft() >= 5) {
            
            int step = rdm.nextInt(5,11);
            position += step;
            context.decreaseGas(5);
        }
    
        context.setPosition(position);
    }
    @Override
    public void accelerate(Voiture context)
    {
        System.out.println("Can't get faster ! Do some drifts to be faster");
    }
    @Override
    public void decelerate(Voiture context)
    {
        context.set_state(new StateNormal());
    }

    @Override
    public String get_action_message() {
        return "Voiture boostee : impossible d'accélerer plus";
    }
}
