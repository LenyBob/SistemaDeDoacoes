package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    public MainScreen() {
        setTitle("Sistema de Doadores - Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Bem-vindo ao Sistema de Doadores!");
        welcomeLabel.setBounds(80, 20, 250, 25);
        panel.add(welcomeLabel);

        JButton cadastrarButton = new JButton("Cadastrar Doador");
        cadastrarButton.setBounds(100, 70, 180, 25);
        panel.add(cadastrarButton);

        JButton listarButton = new JButton("Listar Doadores");
        listarButton.setBounds(100, 110, 180, 25);
        panel.add(listarButton);

        JButton sairButton = new JButton("Sair");
        sairButton.setBounds(100, 150, 180, 25);
        panel.add(sairButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoadorForm();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoadorTableView();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
