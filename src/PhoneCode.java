import java.util.Scanner;
//=============================================================================
public class PhoneCode {
//-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    public static final int AREA_CODE = 305;

//-----------------------------------------------------------------------------
    public static void main(String[] args) {
        int inputNumber;

        do {
            System.out.println("Please enter your 305 phone number: " + AREA_CODE);
            inputNumber = keyboard.nextInt();
        } while (inputNumber <= 999999 || inputNumber > 9999999);

        System.out.println("The phone number " + AREA_CODE + inputNumber + " can be encoded as " + encodeNumber(AREA_CODE) + encodeNumber(inputNumber));

    }
//-----------------------------------------------------------------------------
    public static String encodeNumber(int inputNumber) {
        char[] lettersForEncoding = {'0', '1', 'A', 'D', 'G', 'J', 'M', 'P', 'T', 'W'};
        int[] numLettersForEncoding = {0, 1, 3, 3, 3, 3, 3, 4, 3, 4};

        int digit, numLetters, placeOfLetterUsed;
        char startingLetter, letterUsed;
        String result = "";

        while (inputNumber > 0) {
            digit = inputNumber % 10;

            inputNumber /= 10;

            numLetters = numLettersForEncoding[digit];
            startingLetter = lettersForEncoding[digit];

            placeOfLetterUsed = (int) Math.floor(Math.random() + (numLetters));
            letterUsed = (char) ((int) startingLetter + placeOfLetterUsed);

            result = "" + letterUsed + result;
        }
        return (result);
    }
//-----------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------

