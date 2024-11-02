import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JPanel MainForm;
    private JButton encryptButton;
    private JTextField cipherText;
    private JLabel headerLabel;
    private JLabel plainTextLabel;
    private JTextField plainTextField;
    private JRadioButton caesarRadioButton;
    private JRadioButton onetimePadRadioButton;
    private JRadioButton playfairRadioButton;
    private JRadioButton polybiusRadioButton;
    private JRadioButton vigenereRadioButton;
    private JTextField keyField;
    private JButton decipherButton;
    private JLabel keyLabel;
    private JLabel cipherTextLabel;
    private JButton resetButton;
    private String optionSelect = "";

    public Main()
    {
        setContentPane(MainForm);
        setTitle("Encryption and Decryption");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 350);
        setLocationRelativeTo(null);
        setVisible(true);

        keyField.setEnabled(false);
        keyField.setToolTipText("Enter the key if needed");
        keyField.setBackground(new Color(92, 91, 91));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(caesarRadioButton);
        buttonGroup.add(onetimePadRadioButton);
        buttonGroup.add(playfairRadioButton);
        buttonGroup.add(polybiusRadioButton);
        buttonGroup.add(vigenereRadioButton);

        encryptButton.addActionListener(new ActionListener() {
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
                keyField.setEnabled(false);
                checkEnabled();
            }
        });
        onetimePadRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionSelect = "oneTimePad";
                keyField.setEnabled(true);
                checkEnabled();
            }
        });
        playfairRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionSelect = "playfair";
                keyField.setEnabled(true);
                checkEnabled();
            }
        });
        vigenereRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionSelect = "Vigenere";
                keyField.setEnabled(true);
                checkEnabled();
            }
        });
        polybiusRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionSelect = "Polybius";
                keyField.setEnabled(false);
                checkEnabled();
            }
        });
        decipherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrypt();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plainTextField.setText("");
                keyField.setText("");
                cipherText.setText("");
            }
        });
    }

    public void checkEnabled()
    {
        if(!keyField.isEnabled())
        {
            keyField.setBackground(new Color(92, 91, 91));
        }
        else
        {
            keyField.setBackground(new Color(255, 255, 255));
        }
    }

    public void cleanScreen()
    {
        cipherText.setText("");
    }

    public void encrypt()
    {
        if(optionSelect.equalsIgnoreCase("caesar"))
        {
            cipherText.setText(Caesar.encrypt(plainTextField.getText().toUpperCase(), 3));
        }
        else if (optionSelect.equalsIgnoreCase("oneTimePad"))
        {
            cipherText.setText(OneTimePad.stringEncryption(plainTextField.getText().toUpperCase(), keyField.getText().toUpperCase()));
        }
        else if(optionSelect.equalsIgnoreCase("playfair"))
        {
            String plaintext = plainTextField.getText();
            String key = keyField.getText();
            String preparedKey = Playfair.prepareText(key, true);
            Playfair.createTable(preparedKey);
            String preparedText = Playfair.prepareText(plaintext, false);
            String encryptedText = Playfair.encode(preparedText);
            cipherText.setText(encryptedText);
        }
        else if(optionSelect.equalsIgnoreCase("Vigenere"))
        {
            String Str = plainTextField.getText();
            String Keyword = keyField.getText();

            String str = Vigenere.LowerToUpper(Str);
            String keyword = Vigenere.LowerToUpper(Keyword);

            String key = Vigenere.generateKey(str, keyword);
            String cipherText = Vigenere.cipherText(str, key);
            this.cipherText.setText(cipherText);
        }
        else if(optionSelect.equalsIgnoreCase("Polybius"))
        {
            cipherText.setText(Polybious.polybiusCipher(plainTextField.getText()));
        }
    }

    public void decrypt()
    {
        if(optionSelect.equalsIgnoreCase("caesar"))
        {
            plainTextField.setText(Caesar.encrypt(cipherText.getText().toUpperCase(), -3));
        }
        else if (optionSelect.equalsIgnoreCase("oneTimePad"))
        {
            plainTextField.setText(OneTimePad.stringDecryption(cipherText.getText().toUpperCase(), keyField.getText().toUpperCase()));
        }
        else if(optionSelect.equalsIgnoreCase("playfair"))
        {
            String cipherText = this.cipherText.getText();
            String key = keyField.getText();
            String preparedKey = Playfair.prepareText(key, true);
            Playfair.createTable(preparedKey);
            String preparedText = Playfair.prepareText(cipherText, false);
            String decryptedText = Playfair.decode(preparedText);
            this.cipherText.setText(decryptedText);
        }
        else if(optionSelect.equalsIgnoreCase("Vigenere"))
        {
            String Str = cipherText.getText();
            String Keyword = keyField.getText();

            String str = Vigenere.LowerToUpper(Str);
            String keyword = Vigenere.LowerToUpper(Keyword);

            String key = Vigenere.generateKey(str, keyword);
            String plainText = Vigenere.originalText(str, key);
            this.plainTextField.setText(plainText);
        }
        else if(optionSelect.equalsIgnoreCase("Polybius"))
        {
            cipherText.setText(Polybious.polybiusCipher(plainTextField.getText()));
        }
    }
}
