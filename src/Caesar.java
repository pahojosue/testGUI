
//A Java Program to illustrate Caesar Cipher Technique
class Caesar
{
    // Encrypts text using a shift of s
    public static String encrypt(String text, int s)
    {
        String result = "";

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                result = result.concat(""+ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                result = result.concat(""+ch);
            }
        }
        return result;
    }
}
