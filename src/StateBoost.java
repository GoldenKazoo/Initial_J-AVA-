import java.util.Random;

public class StateBoost implements State
{
    public void moove(Voiture context) {
        Random rdm = new Random();
        int position = context.getPosition();
    
        if (context.getGasLeft() > 0) {
            
            int step = rdm.nextInt(5,11);
            position += step;
            context.decreaseGas(10);
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

    @Override
    public String get_action_message() {
        return "Voiture boostee : impossible d'accélerer plus";
    }
}
