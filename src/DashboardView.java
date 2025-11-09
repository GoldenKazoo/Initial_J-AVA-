import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardView extends JFrame implements Observateur {
    private Voiture voiture;
    private GameObservable game;
    private JLabel gasLabel;
    private JLabel lapLabel;
    private JButton pauseButton;

    public DashboardView(GameObservable game, Voiture v)
    {
        this.game = game;
        this.voiture = v;

        game.add_obs(this);

        setTitle("Tableau de bord - " + v.who());
        setSize(250, 150);
        getContentPane().setBackground(v.getColor());
        setLayout(new GridLayout(3, 1));
        if (this.voiture.getColor() == Color.RED)
        {
            setLocation(1100, 100);
        }
        else if (this.voiture.getColor() == Color.BLUE)
        {
            setLocation(1100, 500);
        }
        else
        {
            setLocation(1100, 900);
        }
        gasLabel = new JLabel("Carburant restant : " + v.getGasLeft());
        lapLabel = new JLabel("Tours réalisés : " + v.get_laps());
        pauseButton = new JButton("Pause | Reprendre");

        gasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lapLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(gasLabel);
        add(lapLabel);
        add(pauseButton);

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                game.toggle_pause();
            }
        });

        setVisible(true);
    }

    @Override
    public void update(GameObservable observable)
    {
        gasLabel.setText("Carburant restant : " + voiture.getGasLeft());
        lapLabel.setText("Tours réalisés : " + voiture.get_laps());
    }
}
