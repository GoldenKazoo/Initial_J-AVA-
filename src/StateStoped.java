public class StateStoped implements State
{
    public void moove(Voiture context)
    {

    }

    public void change_state(Voiture context)
    {

    }

    public void show_state(Voiture context)
    {

    }
    public void accelerate(Voiture context)
    {
        context.set_state(new StateLow());
    }
    public void decelerate(Voiture context)
    {
        System.out.println("Can't get slowe ! Planing to be a turtle ?");
    }
}
