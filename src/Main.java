import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JPanel MainForm;
    private JTextArea textArea1;
    private JButton clickMeButton;
    private int count = 0;

    public Main()
    {
        setContentPane(MainForm);
        setTitle("Simple GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hello = 2;
                textArea1.setText(Main.toString(hello + count));
                count += 1;
            }
        });
    }

    public static String toString(int a)
    {
        return Integer.toString(a);
    }

    public static void main(String[] args) {
        new Main();
    }
}
