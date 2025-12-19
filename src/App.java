import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int nbVoitures = 0;
        ArrayList<Integer> data = new ArrayList<>();

        while (nbVoitures < 1 || nbVoitures > 3) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Entrez le nombre de voitures (1 à 3) :",
                    "Configuration du jeu",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                return;
            }
            nbVoitures = Integer.parseInt(input);
        }

        for (int i = 0; i < nbVoitures; i++) {
            String in = null;
            while (in == null || Integer.parseInt(in) < 1 || Integer.parseInt(in) > 4) {
                in = JOptionPane.showInputDialog(
                        null,
                        "1. BoostSound  2. Drunk  3. Hybride  4. Nothing ",
                        "Choisir un Decorator",
                        JOptionPane.QUESTION_MESSAGE);
            }
            data.add(Integer.parseInt(in));
        }

        GameObservable game = new GameObservable(nbVoitures, data);
        new GameView(game);
        new Classement(game);

        for (IVoiture v : game.get_voitures()) {
            new DashboardView(game, v);
        }

        while (!game.is_finished()) {
            if (!game.is_paused()) {
                game.moove_car();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
