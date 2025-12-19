package decorator;
import model.IVoiture;
import state.State;

public class SoundBooster extends VoitureDecorator {
    
    public SoundBooster(IVoiture v){
        super(v);
    }

    @Override
    public void accelerate()
    {
        super.accelerate();
        System.out.println("VROOUUUUM !");
    }

    @Override
    public void decreaseGas(int nb) {
        this.decreaseGas(nb);
    }

    @Override
    public void set_state(State new_state) {
        voiture.set_state(new_state);
    }
    
    @Override
    public State get_state() {
        return voiture.get_state();
    }
    
    public String getStateMessage()
    {
        return voiture.getStateMessage();
    }
}
