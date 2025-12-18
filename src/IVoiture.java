import java.awt.Color;

public interface IVoiture {
    
    public void moove();

    void accelerate();
    void decelerate();

    int getGasLeft();

    int getPositionIndex();
    int getPosition();

    int get_laps();

    Color getColor();
    String who();


    //public int getPosition();
    public void setPosition(int position);
}
