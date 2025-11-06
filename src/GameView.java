import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class GameView extends JComponent implements Observateur
{
    private int cellSize = 50;
    final int NB_CASES_X = 20;
    final int NB_CASES_Y = 10;
    private GameObservable observable;

    public GameView(GameObservable observable)
    {
        this.observable = observable;
        observable.add_obs(this);
        launchGame();
    }

    @Override
    public void update(GameObservable observable)
    {
        repaint(); // redessine la vue quand on updatwe
    }

    public void launchGame()
    {
        JFrame frame = new JFrame("GameView");
        frame.setSize(cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(this);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // fod vert + grille
    g.setColor(Color.GREEN);
    g.fillRect(0, 0, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
    g.setColor(Color.BLACK);

    // Dessiner la piste
    for (Coordonnee c : observable.getPiste())
    {
        if (c.getVirage())
        {
            g.setColor(Color.YELLOW); // virage = jaune
        }
        else
        {
            g.setColor(Color.GRAY); // route normale
        }
        g.fillRect(c.getX() * cellSize, c.getY() * cellSize, cellSize, cellSize);
    }

    //Dessier voitures
    int decalage = 10;
    for (Voiture v : observable.get_voitures())
    {
        int index = v.getPositionIndex();
        if (index < observable.getPiste().size())
        {
            Coordonnee c = observable.getPiste().get(index);
            g.setColor(v.getColor());
            g.fillOval(c.getX() * cellSize + decalage, c.getY() * cellSize + decalage, 
                       cellSize - 20, cellSize - 20);
            decalage += 10; // pour eviter la superpo
        }
    }
    g.setColor(Color.BLACK);
    drawGrid(g, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
    }


    private void drawGrid(Graphics g, int x, int y)
    {
        for(int i = 0; i < (x / cellSize); i++)
        {
            g.drawLine(i*cellSize , 0, i*cellSize, y);
        }
        for(int i = 0; i < (y / cellSize); i++)
        {
            g.drawLine(0, i * cellSize, x, i * cellSize);
        }
    }

}