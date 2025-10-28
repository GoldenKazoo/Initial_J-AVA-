import javax.swing.JComponent;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JFrame;

public class GameView extends JComponent /*implements GameObservateur*/{
    private int cellSize = 50;
    final int NB_CASES_X = 20;
    final int NB_CASES_Y = 10;
    private GameObservable gameObservable;

    public GameView(GameObservable gameObservable){
        gameObservable.addObserver(this); // Je m'ajoute
        this.gameObservable = gameObservable;
        launchGame();
    }

    public void launchGame(){
        JFrame frame = new JFrame("GameView");
        frame.setSize(cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(this);
        
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);        
        drawPiste(this.gameObservable.getPiste(), g);
        g.setColor(Color.BLACK);
        drawGrid(g, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
    }


    private void drawGrid(Graphics g, int x, int y){
        for(int i = 0; i < (x / cellSize); i++){
            g.drawLine(i*cellSize , 0, i*cellSize, y);
        }
        for(int i = 0; i < (y / cellSize); i++){
            g.drawLine(0, i * cellSize, x, i * cellSize);
        }
    }


    //Fonction drawPiste(). Je récupère via GameObservable la piste.
    private void drawPiste(ArrayList<Coordonnee> piste, Graphics g){
        for (Coordonnee c : piste) {
            g.setColor(Color.GRAY);
            g.fillRect((c.getX()-1) * cellSize, (c.getY()-1) * cellSize, cellSize, cellSize);
            // -1 parce qu'on commence à compter à 1, pas 0
            if(c.getVirage()){
                g.setColor(Color.YELLOW);
                g.fillRect((c.getX()-1) * cellSize + 5, (c.getY()-1) * cellSize + 5, cellSize - 10, cellSize - 10);
                //g.drawString("3", c.getX() * cellSize , c.getY() * cellSize);
            }
        }
    }
}