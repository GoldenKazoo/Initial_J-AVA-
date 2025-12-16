public class StateDamaged implements State
{
    int turns = 0;

    public void moove(IVoiture context)
    {
        if (turns < 5)
        {
            turns++;
        }
        else
        {
            turns = 0;
            context.set_state(new StateLow());
        }
    }


    public void show_state(IVoiture context)
    {

    }
    public void accelerate(IVoiture context)
    {
        System.out.println("You are broken, skill issue !");
    }
    public void decelerate(IVoiture context)
    {
        System.out.println("You are broken, skill issue !");
    }

    public String get_name()
    {
        return "DAMAGED";
    }
}
