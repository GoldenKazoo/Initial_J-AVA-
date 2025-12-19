import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class GameObservable implements Observable {
    private List<Observateur> obs = new ArrayList<>();
    private List<IVoiture> car = new ArrayList<>();
    private ArrayList<Coordonnee> piste = new ArrayList<>();
    private IVoiture[] ranking;
    private boolean paused = false;
    private boolean finished = false;

    public GameObservable(int nb_voitures, ArrayList<Integer> data)
    {
        creerPiste();
        switch (nb_voitures) {
            case 1:
                car.add(decoratorSet(data.get(0), new Voiture("Rouge", Color.RED)));
                break;
            case 2:
                car.add(decoratorSet(data.get(0), new Voiture("Rouge", Color.RED)));
                car.add(decoratorSet(data.get(1), new Voiture("Bleu", Color.BLUE)));
                break;
            case 3:
                car.add(decoratorSet(data.get(0), new Voiture("Rouge", Color.RED)));
                car.add(decoratorSet(data.get(1), new Voiture("Bleu", Color.BLUE)));
                car.add(decoratorSet(data.get(2), new Voiture("Orange", Color.ORANGE)));
                break;
        }
        createRanking();
    }

    private void createRanking() {
        this.ranking = new IVoiture[car.size()];
        for (int i = 0; i < this.ranking.length; i++) {
            this.ranking[i] = car.get(i);
        }
    }

    public ArrayList<Coordonnee> getPiste() {
        return piste;
    }

    public void add_obs(Observateur x) {
        obs.add(x);
    }

    public void remove_obs(Observateur x) {
        obs.remove(x);
    }

    @Override
    public void notify_obs() {
        for (Observateur x : obs) {
            x.update(this);
        }
    }

    public List<IVoiture> get_voitures() {
        return car;
    }

    public List<Observateur> get_obs() {
        return obs;
    }

    public IVoiture[] getRanking() {
        return ranking;
    }

    public void moove_car() {
        for (IVoiture v : car) {
            if (v.getGasLeft() > 0) {
                int posAvant = v.getPosition();

                v.moove();

                int deplacementReel = v.getPosition() - posAvant;

                checkDerapage(v, deplacementReel);

                updateRanking();
            }
        }
        notify_obs();
        setEnd();
    }

    private void updateRanking() {
        int n = this.ranking.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (this.ranking[j].getPosition() < this.ranking[j + 1].getPosition()) {

                    IVoiture temp = this.ranking[j];
                    this.ranking[j] = this.ranking[j + 1];
                    this.ranking[j + 1] = temp;
                }
    }

    public boolean is_paused() {
        return paused;
    }

    public boolean is_finished()
    {
        return finished;
    }
    public void toggle_pause() {
        paused = !paused;
    }

    private void creerPiste() {
        for (int i = 18; i > 2; i--) {
            piste.add(new Coordonnee(i, 9, false, 0));
        }
        piste.add(new Coordonnee(2, 9, true, 5));
        for (int i = 8; i > 3; i--) {
            piste.add(new Coordonnee(2, i, false, 0));
        }
        piste.add(new Coordonnee(2, 3, true, 3));
        for (int i = 3; i < 13; i++) {
            piste.add(new Coordonnee(i, 3, false, 0));
        }
        piste.add(new Coordonnee(13, 3, true, 2));
        piste.add(new Coordonnee(13, 4, false, 0));
        piste.add(new Coordonnee(13, 5, false, 0));
        piste.add(new Coordonnee(13, 6, true, 2));
        piste.add(new Coordonnee(14, 6, false, 0));
        piste.add(new Coordonnee(15, 6, false, 0));
        piste.add(new Coordonnee(16, 6, true, 2));
        for (int i = 5; i > 2; i--) {
            piste.add(new Coordonnee(16, i, false, 0));
        }
        piste.add(new Coordonnee(16, 2, true, 2));
        piste.add(new Coordonnee(17, 2, false, 0));
        piste.add(new Coordonnee(18, 2, false, 0));
        piste.add(new Coordonnee(19, 2, true, 5));
        for (int i = 3; i < 10; i++) {
            piste.add(new Coordonnee(19, i, false, 0));
        }
    }

    private boolean checkDerapage(IVoiture v, int step) {
        int circuitSize = piste.size();
        int posAvant = (v.getPosition() - step + circuitSize) % circuitSize;
    
        int direction = step >= 0 ? 1 : -1;
    
        int traversed = Math.abs(step);
    
        for (int k = 1; k <= traversed; k++) {
            int i = (posAvant + k * direction + circuitSize) % circuitSize;
            Coordonnee c = piste.get(i);
    
            if (c.getVirage()) {
                if (traversed >= c.getId()) {
                    v.set_state(new StateDamaged());
                    System.out.println(v.who() + " a derape au virage à l'indice " + i + " !" + "virage a " + c.getId() + " contre " + traversed);
                    return true;
                }
            }
        }
    
        return false;
    }
    
    

    public IVoiture decoratorSet(int i, Voiture v){
        if(i == 1){
            return new SoundBooster(v);
        }else if(i == 2){
            return new Drunk(v);
        }else if(i == 3){
            return new HybrideVoiture(v);
        }else{
            return v;
        }
    }

    public boolean setEnd()
    {
        for (IVoiture v : car) {
            if (v.get_laps() >= 3) {
                System.out.println("Finished ! Gagnant : " + v.who());
                finished = true;
                notify_obs();
                return true;
            }
        }
        return false;
    }
    
}
