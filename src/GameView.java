import javax.swing.JComponent;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
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
        repaint(); // redessine la vue quand on update
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

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
        g.setColor(Color.BLACK);

        drawPiste(g, observable.getPiste());

        drawCars(g, observable.get_voitures(), observable.getPiste());

        g.setColor(Color.BLACK);
        drawGrid(g, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
    }


    private void drawPiste(Graphics g, ArrayList<Coordonnee> piste){
        // Dessiner la piste
        for (Coordonnee c : piste)
        {
            g.setColor(Color.GRAY);
            g.fillRect((c.getX()-1) * cellSize, (c.getY()-1) * cellSize, cellSize, cellSize);
            if (c.getVirage())
            {
                g.setColor(Color.YELLOW);
                g.fillRect((c.getX()-1) * cellSize + 5, (c.getY()-1) * cellSize + 5, cellSize - 10, cellSize - 10);
            }
        }
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

    private void drawCars(Graphics g, List<Voiture> voitures, List<Coordonnee> piste){
        //Dessier voitures
        int decalage = 10;
        for (Voiture v : voitures)
        {
            int index = v.getPositionIndex();
            if (index < piste.size())
            {
                Coordonnee c = piste.get(index);
                g.setColor(v.getColor());
                g.fillOval((c.getX()-1) * cellSize + decalage, (c.getY()-1) * cellSize + decalage, 
                        cellSize - 20, cellSize - 20);
                decalage += 5; // pour eviter la superpo
            }
        }
    }

}