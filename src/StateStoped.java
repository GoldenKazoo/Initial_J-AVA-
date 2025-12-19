public class StateStoped implements State
{
    @Override
    public void moove(Voiture context)
    {

    }

    @Override
    public void accelerate(Voiture context)
    {
        context.set_state(new StateLow());
    }
    @Override
    public void decelerate(Voiture context)
    {
    }
    @Override
    public String get_action_message() {
        return "Voiture arretee : impossible de ralentir plus";
    }
}
