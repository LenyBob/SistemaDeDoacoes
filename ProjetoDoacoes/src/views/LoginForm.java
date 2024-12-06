package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    
    // Construtor do formulário de login
    public LoginForm() {
        setTitle("Login - Sistema de Doadores");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    // Adiciona os componentes ao painel
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Label para o nome de usuário
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Campo de texto para o nome de usuário
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Label para a senha
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // Campo de senha (oculta os caracteres digitados)
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Ação ao clicar no botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém o texto do campo de usuário e a senha digitada
                String user = userText.getText();
                String password = new String(passwordText.getPassword());

                // Verifica as credenciais
                if ("admin".equals(user) && "1234".equals(password)) {
                    // Se as credenciais forem corretas, abre a tela principal
                    new MainScreen();  // Aqui você pode chamar a sua tela principal
                    dispose(); // Fecha a tela de login
                } else {
                    // Se as credenciais forem incorretas, exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas!");
                }
            }
        });
    }

    // Método main para rodar o login
    public static void main(String[] args) {
        new LoginForm(); // Cria uma instância da tela de login
    }
}
