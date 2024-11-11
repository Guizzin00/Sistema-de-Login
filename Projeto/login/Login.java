package Projeto.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Login {

    private static HashMap<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        usuarios.put("admin", "senha123");

        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(60, 60, 255), 0, getHeight(), new Color(75, 0, 130));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("Bem-vindo!");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(Color.black);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setForeground(Color.black);
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField userField = new JTextField(15);
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        userField.setPreferredSize(new Dimension(160, 25));
        userField.setBackground(new Color(255, 255, 255));
        userField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 2));
        userField.setCaretColor(Color.BLACK);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordField.setPreferredSize(new Dimension(160, 25));
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 2));
        passwordField.setCaretColor(Color.BLACK);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setBackground(new Color(140, 140, 140));
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(120, 40));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registerButton.setBackground(new Color(140, 140, 140));
        registerButton.setForeground(Color.WHITE);
        registerButton.setPreferredSize(new Dimension(120, 40));
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder());
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(105, 105, 105));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(140, 140, 140));
            }
        });

        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButton.setBackground(new Color(105, 105, 105));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButton.setBackground(new Color(140, 140, 140));
            }
        });

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        panel.add(userLabel);
        panel.add(userField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(buttonPanel);

        frame.add(panel);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String senha = new String(passwordField.getPassword());

                if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
                    JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
                    abrirTelaPrincipal();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String senha = new String(passwordField.getPassword());

                if (usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                } else {
                    if (usuarios.containsKey(usuario)) {
                        JOptionPane.showMessageDialog(frame, "Usuário já existe!");
                    } else {
                        usuarios.put(usuario, senha);
                        JOptionPane.showMessageDialog(frame, "Usuário registrado com sucesso!");
                    }
                }
            }
        });
    }

    private static void abrirTelaPrincipal() {
        Projeto.acesso.AcessoTela.main(new String[]{}); 
    }
}
