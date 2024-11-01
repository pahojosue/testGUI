import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First extends JFrame{
    private JPanel panel1;
    private JButton clickButton;

    public First() {
        setContentPane(panel1);
        setTitle("Welcome Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new First());
    }
}
