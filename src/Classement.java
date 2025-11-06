import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Classement extends JComponent implements Observateur {
    private GameObservable observable;
    private JLabel labels[];
    private JFrame frame;
    private JPanel classementPanel;

    public Classement(GameObservable observable){
        this.observable = observable;
        observable.add_obs(this);
        this.labels = new JLabel[this.observable.getRanking().length];

        this.frame = new JFrame("Panneau d'affichage");
        frame.setSize(250, 300);
        frame.setLocation(1300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.classementPanel = new JPanel();
        for(int i = 0; i < this.labels.length; i++){
            labels[i] = new JLabel();
            classementPanel.add(labels[i]);
        }
        
        drawRanking();
        frame.add(classementPanel);
        frame.setVisible(true);
    }


    private void drawRanking(){
        for(int i = 0; i < this.labels.length; i++){
            labels[i].setText("Numéro " + String.valueOf(i+1) + " : " + this.observable.getRanking()[i].who() + " | Position : " + this.observable.getRanking()[i].getPosition());
        }
    }

    @Override
    public void update(GameObservable observable){
        //repaint();
        drawRanking();
    }
}