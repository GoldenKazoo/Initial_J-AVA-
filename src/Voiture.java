public class Voiture
{
    private String  name;
    private int     total_distance = 0;
    private int     gas_left = 60;

    public Voiture (String name)
    {
        this.name = name;
    }

    public String who ()
    {
        return (this.name);
    }
    public void moove (int random_nb)
    {
        this.total_distance = this.total_distance + random_nb;
        gas_left = this.gas_left - 2;
    }
}