import java.awt.Color;

public class Voiture implements IVoiture
{
    private String name;
    private int position = 0;
    private int gas_left = 60;
    private Color color;
    private int laps = 0;
    private State state;
    private final int pisteSize = 53;

    public Voiture(String name, Color color) {
        this.name = name;
        this.color = color;
        this.state = new StateNormal();
    }

    @Override
    public void moove(int random_nb, int pisteSize) {
        state.moove(this);
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
        laps = this.position / pisteSize;
    }

    @Override
    public int getPositionIndex() {
        return ((position % pisteSize) + pisteSize) % pisteSize;
    }

    @Override
    public void set_state(State new_state) {
        this.state = new_state;
    }

    @Override
    public State get_state() {
        return state;
    }

    @Override
    public String who() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getGasLeft() {
        return gas_left;
    }

    @Override
    public void decreaseGas(int nb) {
        gas_left -= nb;
        System.out.println(name + " a encore " + gas_left);
    }

    public int getPositionIndex() // Modulo positif
    {
        if(position < 0){
            return position + 53;
        }else{
            return position % 53;
        }
    }

    public int getPosition()
    {
        return(position);
    }

    public void setPosition(int position)
    {
      this.position = position;
    }
    
    public void moove()
    {
        state.moove(this);
    }

    public int get_laps()
    {
        laps = position / 53;
        return laps;
    }

    public void set_state(State new_state)
    {
        this.state = new_state;
    }

    @Override
    public void accelerate() {
        state.accelerate(this);
    }

    @Override
    public void decelerate() {
        state.decelerate(this);
    }
}
