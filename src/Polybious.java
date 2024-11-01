
// Java Program to implement polybius cipher

class Polybious
{
    // Function to display polybius
    // cipher text
    public static String polybiusCipher(String s)
    {
        String result = "";
        int row, col;

        // convert each character
        // to its encrypted code
        for (int i = 0;i < s.length(); i++)
        {

            // finding row of the table
            row = (int)Math.ceil((s.charAt(i) - 'a') / 5) + 1;

            // finding column of the table
            col = ((s.charAt(i) - 'a') % 5) + 1;

            // if character is 'k'
            if (s.charAt(i) == 'k')
            {
                row = row - 1;
                col = 5 - col + 1;
            }

            // if character is greater than 'j'
            else if (s.charAt(i) >= 'j')
            {
                if (col == 1)
                {
                    col = 6;
                    row = row - 1;
                }
                col = col - 1;
            }
            result = result.concat(row + "" + col + " ");
        }

        return result;
    }
}

// This code is contributed by Anant Agarwal.
