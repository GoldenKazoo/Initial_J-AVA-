public interface State

{
    void moove(IVoiture car);
    void show_state(IVoiture car);
    public void accelerate(IVoiture car);
    public void decelerate(IVoiture car);
    public String get_name ();
}
