public class App {
    
    public static void main(String[] args) {
        GameObservable game_observable = new GameObservable();
        new GameView(game_observable);

    }
}
