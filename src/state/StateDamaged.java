package state;

import model.*;


public class StateDamaged implements State {

    int turns = 0;

    @Override
    public void moove(Voiture context) {
        if (turns < 5) {
            turns++;
        } else {
            turns = 0;
            context.set_state(new StateLow());
        }
    }

    @Override
    public void accelerate(Voiture context) {
    }

    @Override
    public void decelerate(Voiture context) {
    }

    @Override
    public String get_action_message() {
        return "Voiture endommagee : impossible d'accélerer ou de ralentir";
    }
}
