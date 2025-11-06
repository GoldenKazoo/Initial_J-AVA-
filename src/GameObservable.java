import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;

public class GameObservable implements Observable
{
    private List<Observateur> obs = new ArrayList<>();
    private List<Voiture> car = new ArrayList<>();
    private Random random_nb = new Random();
    private ArrayList<Coordonnee> piste = new ArrayList<>();

    public GameObservable()
    {
        creerPiste();
        car.add(new Voiture("Rouge", Color.RED));
        car.add(new Voiture("Bleu", Color.BLUE));
        car.add(new Voiture("Vert", Color.GREEN));
    }

    public ArrayList<Coordonnee> getPiste()
    {
        return piste;
    }

    public void add_obs(Observateur x)
    {
        obs.add(x);
    }

    public void remove_obs(Observateur x)
    {
        obs.remove(x);
    }

    @Override
    public void notify_obs()
    {
        for (Observateur x : obs)
        {
            o.update(this);
        }
    }

    public List<Voiture> get_voitures()
    {
        return car;
    }

    public List<Observateur> get_obs()
    {
        return obs;
    }

    public void moove_car()
    {
        for (Voiture v : car)
        {
            if (v.getGasLeft() > 0)
            {
                int step = random_nb.nextInt(6) + 1; // avance de 1 à 6 cases
                v.moove(step, piste.size());
            }
        }
        notify_obs();
    }

    private void creerPiste() {
        for(int i = 18; i > 2; i--){
            piste.add(new Coordonnee(i, 9, false));
        }
        piste.add(new Coordonnee(2, 9, true));
        for(int i = 8; i > 3; i--){
            piste.add(new Coordonnee(2, i, false));
        }
        piste.add(new Coordonnee(2,3, true));
        for(int i = 3; i < 13; i++){
            piste.add(new Coordonnee(i, 3, false));
        }
        piste.add(new Coordonnee(13, 3, true));
        piste.add(new Coordonnee(13, 4, false));
        piste.add(new Coordonnee(13, 5, false));
        piste.add(new Coordonnee(13, 6, true));
        piste.add(new Coordonnee(14, 6, false));
        piste.add(new Coordonnee(15, 6, false));
        piste.add(new Coordonnee(16, 6, true));
        for(int i = 5; i > 2; i--)
        {
            piste.add(new Coordonnee(16, i, false));
        }
        piste.add(new Coordonnee(16, 2, true));
        piste.add(new Coordonnee(17, 2, false));
        piste.add(new Coordonnee(18, 2, false));
        piste.add(new Coordonnee(19, 2, true));
        for(int i = 3; i < 10; i++){
            piste.add(new Coordonnee(19, i, false));
        }
    }
}
