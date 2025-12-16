public class StateStoped implements State
{
    public void moove(IVoiture context)
    {

    }

    public void change_state(IVoiture context)
    {

    }

    public void show_state(IVoiture context)
    {

    }
    public void accelerate(IVoiture context)
    {
        context.set_state(new StateLow());
    }
    public void decelerate(IVoiture context)
    {
        System.out.println("Can't get slowe ! Planing to be a turtle ?");
    }

    public String get_name()
    {
        return "STOPED";
    }
}
