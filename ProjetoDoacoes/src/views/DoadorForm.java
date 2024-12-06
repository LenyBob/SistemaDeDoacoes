package views;

import controllers.DoadorController;
import models.Doador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoadorForm extends JFrame {
    private final DoadorController controller;

    public DoadorForm() {
        controller = new DoadorController();

        setTitle("Cadastrar Doador");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 250, 25);
        panel.add(nameText);

        JLabel tipoLabel = new JLabel("Tipo Sanguíneo:");
        tipoLabel.setBounds(10, 60, 120, 25);
        panel.add(tipoLabel);

        JTextField tipoText = new JTextField(5);
        tipoText.setBounds(130, 60, 100, 25);
        panel.add(tipoText);

        JLabel dataLabel = new JLabel("Data de Nascimento:");
        dataLabel.setBounds(10, 100, 150, 25);
        panel.add(dataLabel);

        JTextField dataText = new JTextField(10);
        dataText.setBounds(160, 100, 120, 25);
        panel.add(dataText);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 140, 80, 25);
        panel.add(telefoneLabel);

        JTextField telefoneText = new JTextField(15);
        telefoneText.setBounds(100, 140, 250, 25);
        panel.add(telefoneText);

        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(10, 180, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 180, 250, 25);
        panel.add(emailText);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.setBounds(100, 230, 80, 25);
        panel.add(salvarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doador doador = new Doador();
                doador.setNome(nameText.getText());
                doador.setTipoSanguineo(tipoText.getText());
                doador.setDataNascimento(dataText.getText());
                doador.setTelefone(telefoneText.getText());
                doador.setEmail(emailText.getText());

                controller.cadastrarDoador(doador);
                JOptionPane.showMessageDialog(null, "Doador cadastrado com sucesso!");
                dispose();
            }
        });
    }
}
