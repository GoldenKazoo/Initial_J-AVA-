import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class GameObservable implements Observable
{
    private List<Observateur> obs = new ArrayList<>();
    private List<Voiture> car = new ArrayList<>();
    private Random random_nb = new Random();

    public void add_obs(Observateur o) {
        obs.add(o);
    }

    public void remove_obs(Observateur o) {
        obs.remove(o);
    }

    @Override
    public void notify_obs() {
        for (Observateur o : obs) {
            o.update(this); // On notifie les Views pour les mettre à jour
        }
    }

    public List<Voiture> get_voitures() {
        return car;
    }

    public List<Observateur> get_obs() {
        return obs;
    }

    public void moove_car() {
        for (Voiture v : car)
        {
            v.moove(random_nb.nextInt(6));
        }
        notify_obs(); // pas de paramètre
    }
}
