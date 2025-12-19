import java.awt.Color;

public class Voiture implements IVoiture
{
    private String name;
    private int position = 0;
    private int gas_left = 60;
    private Color color;
    private int laps = 0;
    public State state;

    public Voiture(String name, Color color)
    {
        this.name = name;
        this.color = color;
        this.state = new StateNormal();
    }

    public String who()
    {
        return this.name;
    }

    public Color getColor()
    {
        return color;
    }

    public int getGasLeft()
    {
        return gas_left;
    }

    public void decreaseGas(int nb)
    {
        gas_left -= nb;
        System.out.println(name + " a encore " + gas_left);
    }

    public int getPositionIndex()
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

    @Override
    public State get_state() {
        return state;
    }
    
    public String getStateMessage() {
        return state.get_action_message();
    }
    
}
