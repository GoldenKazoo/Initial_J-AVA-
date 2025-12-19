public interface State
{
    void moove(Voiture car);
    void accelerate(Voiture car);
    void decelerate(Voiture car);

    default String get_action_message()
    {
        return null;
    }
}
