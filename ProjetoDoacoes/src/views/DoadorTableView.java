package views;

import controllers.DoadorController;
import models.Doador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DoadorTableView extends JFrame {
    private final DoadorController controller;

    public DoadorTableView() {
        controller = new DoadorController();

        setTitle("Listar Doadores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nome", "Tipo Sanguíneo", "Data de Nascimento", "Telefone", "E-mail"}, 0);
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 560, 300);
        panel.add(scrollPane);

        JButton atualizarButton = new JButton("Atualizar");
        atualizarButton.setBounds(250, 320, 100, 25);
        panel.add(atualizarButton);

        atualizarButton.addActionListener(e -> atualizarTabela(model));
    }

    private void atualizarTabela(DefaultTableModel model) {
        model.setRowCount(0); // Limpar tabela
        List<Doador> doadores = controller.listarDoadores();
        for (Doador doador : doadores) {
            model.addRow(new Object[]{
                    doador.getId(),
                    doador.getNome(),
                    doador.getTipoSanguineo(),
                    doador.getDataNascimento(),
                    doador.getTelefone(),
                    doador.getEmail()
            });
        }
    }
}
