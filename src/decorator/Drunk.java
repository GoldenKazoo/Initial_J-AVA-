package decorator;
import model.IVoiture;
import state.State;

public class Drunk extends VoitureDecorator
{
    boolean forward = true;

    public Drunk (IVoiture voiture)
    {
        super(voiture);
    }

    @Override
    public void moove() {
        int posAvant = voiture.getPosition();

        voiture.moove();

        int deplacement = voiture.getPosition() - posAvant;

        if (this.forward == false)
        {
            int newPos = posAvant - deplacement;
            voiture.setPosition(newPos);
            // System.out.println("POSITION BRUTE DE LA VOITURE : " + voiture.getPosition());
            // System.out.println("POSITION INDEXE DE LA VOITURE : " + voiture.getPositionIndex());
            // System.out.println("LE pilote est completement ivre, 1 verre d'alcool, 1 verre d'eau !");
            this.forward = true;
        }
        else
        {
            this.forward = false;
        }
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