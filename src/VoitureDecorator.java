import java.awt.Color;

public abstract class VoitureDecorator implements IVoiture{

    protected IVoiture voiture;

    public VoitureDecorator(IVoiture v){
        this.voiture = v;
    }

    @Override
    public void moove() {
        voiture.moove();
    }

    @Override
    public void setPosition(int position) {
        voiture.setPosition(position);
    }

    @Override
    public void accelerate() {
        voiture.accelerate();
    }

    @Override
    public void decelerate() {
        voiture.decelerate();
    }

    @Override
    public int getGasLeft() {
        return voiture.getGasLeft();
    }

    @Override
    public int getPositionIndex() {
        return voiture.getPositionIndex();
    }

    @Override
    public int getPosition() {
        return voiture.getPosition();
    }

    @Override
    public Color getColor() {
        return voiture.getColor();
    }

    @Override
    public String who() {
        return voiture.who();
    }

    @Override
    public int get_laps() {
        return voiture.get_laps();
    }

}
