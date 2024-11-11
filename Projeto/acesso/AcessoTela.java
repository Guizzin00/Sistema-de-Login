package Projeto.acesso;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AcessoTela {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AcessoTela().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame telaPrincipal = new JFrame("Tela Principal");
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaPrincipal.setSize(500, 400);
        telaPrincipal.setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    URL url = new URL("https://gizmodo.uol.com.br/wp-content/blogs.dir/8/files/2021/02/nyan-cat.gif");
                    ImageIcon icon = new ImageIcon(url);
                    g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        panel.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Bem-vindo!", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);

        JTextArea area = new JTextArea("NÃO TEM NADA AQUI SÓ TESTE MESMO :}.");
        area.setEditable(false);
        area.setBackground(new Color(0, 0, 0, 150));
        area.setForeground(Color.WHITE);
        area.setFont(new Font("Arial", Font.PLAIN, 18));
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setCaretPosition(0);

        JButton logoutButton = new JButton("Sair");
        logoutButton.setBackground(new Color(191, 194, 199));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(telaPrincipal,
                    "Você tem certeza que quer sair?", 
                    "Confirmar saída", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(telaPrincipal, "DEVELOPED BY Guizzin00.");
                telaPrincipal.dispose();
                Projeto.login.Login.main(new String[]{});
            }
        });

        panel.add(headerLabel, BorderLayout.NORTH);
        panel.add(area, BorderLayout.CENTER);
        panel.add(logoutButton, BorderLayout.SOUTH);

        telaPrincipal.add(panel);
        telaPrincipal.setVisible(true);
    }
}
