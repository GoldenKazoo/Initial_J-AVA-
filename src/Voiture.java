public class Voiture
{
    private String  name;
    private int     total_distance = 0;
    private int     gas_left = 60;

    public Voiture (String name)
    {
        this.name = name;
    }

    public void moove (int random_nb)
    {
        this.total_distance += random_nb;
        gas_left -= 2;
    }
}