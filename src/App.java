public class App {
    public static void main(String[] args) {
        GameObservable game = new GameObservable();
        new GameView(game);
        new Classement(game);

        // loop du jeu
                for (Voiture v : game.get_voitures()) {
            new DashboardView(game, v);
        }
        
        // loop du jeu
        for (int i = 0; i < 30; i++)
    {
        if (!game.is_paused())
        {
            game.moove_car();
        }

        try
        {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    }
}