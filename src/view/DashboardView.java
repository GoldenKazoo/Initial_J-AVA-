package view;
import javax.swing.*;

import core.GameObservable;
import model.IVoiture;

import java.awt.*;
import java.awt.event.*;

public class DashboardView extends JFrame implements Observateur {
    private IVoiture voiture;
    private GameObservable game;
    private JLabel gasLabel;
    private JLabel lapLabel;
    private JLabel stateLabel;
    private JButton pauseButton;
    private JButton slowdown;
    private JButton speedup;

    public DashboardView(GameObservable game, IVoiture v)
    {
        this.game = game;
        this.voiture = v;

        game.add_obs(this);

        setTitle("Tableau de bord - " + v.who());
        setSize(250, 150);
        getContentPane().setBackground(v.getColor());
        setLayout(new GridLayout(6, 1));
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
        slowdown = new JButton("Ralentir");
        speedup = new JButton("Accelerer");

        gasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lapLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(gasLabel);
        add(lapLabel);
        add(pauseButton);
        add(slowdown);
        add(speedup);

        stateLabel = new JLabel("");
        stateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(stateLabel);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                game.toggle_pause();
            }
        });

        speedup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = voiture.getStateMessage();
                if (msg != null) {
                    stateLabel.setText(msg);
                } else {
                    stateLabel.setText("");
                }
                voiture.accelerate();
            }
        });
        
        slowdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = voiture.getStateMessage();
                if (msg != null)
                {
                    stateLabel.setText(msg);
                } else {
                    stateLabel.setText("");
                }
                voiture.decelerate();
            }
        });
        
        setVisible(true);
    }

    @Override
    public void update(GameObservable observable)
    {
        gasLabel.setText("Carburant restant : " + voiture.getGasLeft());
        lapLabel.setText("Tours réalisés : " + voiture.get_laps());
    
        if (voiture.getStateMessage() == null) {
            stateLabel.setText("");
        }
    }
}
