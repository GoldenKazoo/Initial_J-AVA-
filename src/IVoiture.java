import java.awt.Color;

public interface IVoiture {

    String who();

    Color getColor();

    int getGasLeft();

    void decreaseGas(int nb);

    int getPositionIndex();

    int getPosition();

    void setPosition(int position);

    void moove(int random_nb, int pisteSize);

    int get_laps();

    void set_state(State new_state);

    State get_state();

}