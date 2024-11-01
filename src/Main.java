import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JPanel MainForm;
    private JButton clickMeButton;
    private JTextField caesarText;
    private JLabel Label1;
    private JLabel Label2;
    private JTextField textField1;
    private JRadioButton caesarRadioButton;
    private JRadioButton onetimePadRadioButton;
    private JRadioButton playfairRadioButton;
    private String optionSelect = "";

    public Main()
    {
        setContentPane(MainForm);
        setTitle("Simple GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(caesarRadioButton);
        buttonGroup.add(onetimePadRadioButton);
        buttonGroup.add(playfairRadioButton);

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cleanScreen();
                    if(!optionSelect.isEmpty())
                    {
                        encrypt();
                    }
            }
        });

        caesarRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionSelect = "caesar";
            }
        });
        onetimePadRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionSelect = "oneTimePad";
            }
        });
        playfairRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionSelect = "playfair";
            }
        });
    }

    public void cleanScreen()
    {
        caesarText.setText("");
    }

    public void encrypt()
    {
        if(optionSelect.equalsIgnoreCase("caesar"))
        {
            caesarText.setText(Caesar.encrypt(textField1.getText().toUpperCase(), 3));
        }
        else if (optionSelect.equalsIgnoreCase("oneTimePad"))
        {
            caesarText.setText(OneTimePad.stringEncryption(textField1.getText().toUpperCase(), "MONEY"));
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
