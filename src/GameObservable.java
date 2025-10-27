public class GameObservable implements Observable
{
    private List<GameObservateur>   obs = new ArrayList<>();
    private List<Voiture>           car = new ArrayList<>();

    public void add_obs(GameObservateur o)
    {
        obs.add(o);
    }
    public void remove_obs(GameObservateur o)
    {
        obs.remove(o);
    }
    public void notify_obs()
    {
        for (GameObservateur obs : observateurs)
        {
            obs.update(); // On notifie les Views pour les mettre a jour
        }
    }

    public ArrayList<Voiture> get_voitures()
    {
        return car;
    }

    public ArrayList<GameObservateur> get_obs()
    {
        return obs;
    }
}
