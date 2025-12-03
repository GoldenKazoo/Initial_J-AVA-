public interface State

{
    void moove(Voiture car);
    void show_state(Voiture car);
    public void accelerate(Voiture car);
    public void decelerate(Voiture car);
}
