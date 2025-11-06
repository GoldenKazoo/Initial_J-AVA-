public class App {
    public static void main(String[] args) {
        GameObservable game = new GameObservable();
        new GameView(game);

        // loop du jeu
        for (int i = 0; i < 30; i++) { // 30 tours de jeu pour test
            game.moove_car();
            game.notify_obs();

            try {
                Thread.sleep(500); // une pause pour voir le mouvement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

