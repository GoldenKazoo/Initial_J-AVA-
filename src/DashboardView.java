import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardView extends JFrame implements Observateur {
    private Voiture voiture;
    private GameObservable game;
    private JLabel fuelLabel;
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

        fuelLabel = new JLabel("Carburant restant : " + v.getGasLeft());
        lapLabel = new JLabel("Tours réalisés : " + v.get_laps());
        pauseButton = new JButton("Pause | Reprendre");

        fuelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lapLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(fuelLabel);
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
        fuelLabel.setText("Carburant restant : " + voiture.getGasLeft());
        lapLabel.setText("Tours réalisés : " + voiture.get_laps());
    }
}
