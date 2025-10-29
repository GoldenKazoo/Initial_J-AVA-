import javax.swing.JComponent;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JFrame;

public class GameView extends JComponent /*implements GameObservateur*/{
    private int cellSize = 50;
    final int NB_CASES_X = 20;
    final int NB_CASES_Y = 10;
    //private GameObservable gameObservable;
    

    public GameView(/*GameObservable gameObservable*/){
        //gameObservable.addObserver(this); // Je m'ajoute
        //this.gameObservable = gameObservable;
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
        ArrayList<Coordonnee> piste = new ArrayList<>();
        for(int i = 18; i > 2; i--){
            piste.add(new Coordonnee(i, 9, false));
        }
        piste.add(new Coordonnee(2, 9, true));
        for(int i = 8; i > 3; i--){
            piste.add(new Coordonnee(2, i, false));
        }
        piste.add(new Coordonnee(2,3, true));
        for(int i = 3; i < 13; i++){
            piste.add(new Coordonnee(i, 3, false));
        }
        piste.add(new Coordonnee(13, 3, true));
        piste.add(new Coordonnee(13, 4, false));
        piste.add(new Coordonnee(13, 5, false));
        piste.add(new Coordonnee(13, 6, true));
        piste.add(new Coordonnee(14, 6, false));
        piste.add(new Coordonnee(15, 6, false));
        piste.add(new Coordonnee(16, 6, true));
        for(int i = 5; i > 2; i--){
            piste.add(new Coordonnee(16, i, false));
        }
        piste.add(new Coordonnee(16, 2, true));
        piste.add(new Coordonnee(17, 2, false));
        piste.add(new Coordonnee(18, 2, false));
        piste.add(new Coordonnee(19, 2, true));
        for(int i = 3; i < 10; i++){
            piste.add(new Coordonnee(19, i, false));
        }
        
        super.paintComponent(g);
        g.setColor(new Color(0,113,0,255));
        g.fillRect(0, 0, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);  
        drawPiste(piste, g);
        //drawPiste(this.gameObservable.getPiste(), g);
        g.setColor(Color.BLACK);
        drawGrid(g, cellSize * NB_CASES_X, cellSize * NB_CASES_Y);
        //drawCars(this.gameObservable.getCars(), g);
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
                //g.drawString("3", c.getX() * cellSize, c.getY() * cellSize);
            }
        }
    }

    private void drawCars(ArrayList<Voiture> voitures, Graphics g){
        for (Voiture voiture : voitures) {
            g.setColor(voiture.getColor());
            //g.fillRect((X + 5 , Y + 5, cellSize - 10, cellSize - 10);
            // Que contient la voiture ? Coordonnées ? Numéro de case sur la piste ?
        }
    }

    // Override update()
    // @Override
    // public void update(){
    //     repaint();
    // }
}