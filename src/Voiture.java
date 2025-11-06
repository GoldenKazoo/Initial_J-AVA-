import java.awt.Color;

public class Voiture
{
    private String name;
    private int position = 0;
    private int gas_left = 60;
    private Color color;

    public Voiture(String name, Color color)
    {
        this.name = name;
        this.color = color;
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

    public int getPositionIndex()
    {
        return position % 54;
    }

    public void moove(int random_nb, int pisteSize)
    {
        if (gas_left > 0)
        {
            position += random_nb;
            gas_left -= 2;
        }
    }
}
