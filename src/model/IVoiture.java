package model;
import java.awt.Color;

import state.State;

public interface IVoiture {

    String who();

    Color getColor();

    int getGasLeft();

    void decreaseGas(int nb);

    int getPositionIndex();

    int getPosition();

    void setPosition(int position);

    void moove();

    int get_laps();

    void set_state(State new_state);

    State get_state();

    void accelerate();

    void decelerate();

    public String getStateMessage();
}