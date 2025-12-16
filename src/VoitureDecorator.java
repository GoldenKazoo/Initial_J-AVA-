import java.awt.Color;

public abstract class VoitureDecorator implements IVoiture {

    protected IVoiture voiture;

    public VoitureDecorator(IVoiture voiture) {
        this.voiture = voiture;
    }

    @Override
    public void moove(int random_nb, int pisteSize) {
        voiture.moove(random_nb, pisteSize);
    }

    @Override
    public int getPosition() { return voiture.getPosition(); }

    @Override
    public void setPosition(int position) { voiture.setPosition(position); }

    @Override
    public int getPositionIndex() { return voiture.getPositionIndex(); }

    @Override
    public State get_state() { return voiture.get_state(); }

    @Override
    public void set_state(State new_state) { voiture.set_state(new_state); }

    @Override
    public String who() { return voiture.who(); }

    @Override
    public Color getColor() { return voiture.getColor(); }

    @Override
    public int getGasLeft() { return voiture.getGasLeft(); }

    @Override
    public void decreaseGas(int nb) { voiture.decreaseGas(nb); }

    @Override
    public int get_laps() { return voiture.get_laps(); }
}
