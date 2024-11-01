
public class OneTimePad {

    public static String stringEncryption(String text, String key)
    {
        String cipherText = "";
        int[] cipher= new int[key.length()];

        for(int i = 0; i < key.length(); i++)
        {
            cipher[i] = text.charAt(i) - 'A' + key.charAt(i) - 'A';
        }

        //if the sum is greater than 25 subtract 26 from it and store that resulting value
        for(int i = 0; i < key.length(); i++)
        {
            if(cipher[i] > 25)
                cipher[i] = cipher[i] - 26;
        }

        //converting the numbers into integers
        //convert these integers to corresponding ciphertext
        for(int i = 0; i < key.length(); i++)
        {
            int x = cipher[i] + 'A';
            cipherText += (char)x;
        }

        return cipherText;
    }

    public static String stringDecryption(String s, String key)
    {
        //Initializing the plaintext
        String plainText = "";

        //Initializing integer array of key length which stores difference in corresponding numbers of each character ciphertext and key
        int[] plain = new int[key.length()];

        //Running for loop or each character, subtracting and storing in the array
        for(int i = 0; i < key.length(); i++)
        {
            plain[i] = s.charAt(i) - 'A' - (key.charAt(i) - 'A');
        }

        for(int i = 0; i < key.length(); i++)
        {
            if(plain[i] < 0)
                plain[i] = plain[i] + 26;
        }

        //Converting int to corresponding char, add them up to plaintext
        for(int i = 0; i < key.length(); i++)
        {
            int x = plain[i] + 'A';
            plainText += (char)x;
        }

        return plainText;
    }
}
