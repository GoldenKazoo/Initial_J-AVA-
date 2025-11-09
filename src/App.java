import javax.swing.JOptionPane;

public class App
{
    public static void main(String[] args)
    {
        int nbVoitures = 0;

        while (nbVoitures < 1 || nbVoitures > 3) //loop de demande, l'user doit entrer dans ce scope de nb
        {
            String input = JOptionPane.showInputDialog(
                null, 
                "Entrez le nombre de voitures (1 à 3) :", 
                "Configuration du jeu", 
                JOptionPane.QUESTION_MESSAGE
            );
            if (input == null)
            {
                return; // si l'utilisateur cancel, fin du programme
            }
            nbVoitures = Integer.parseInt(input);
        }

        GameObservable game = new GameObservable(nbVoitures);
        new GameView(game);
        new Classement(game);
        
        for (Voiture v : game.get_voitures())
        {
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
            }
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
