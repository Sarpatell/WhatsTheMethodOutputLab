import java.util.Scanner;
//=============================================================================
public class StreetPeople {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        int[] houseNumbers;
        int[][] houseAges;

        houseNumbers = inputHouseNumbers();
        System.out.println();
        houseAges = inputHouseAges(houseNumbers);
        System.out.println();
        analyseData(houseNumbers,houseAges);
    }
    //-----------------------------------------------------------------------------
    private static int[] inputHouseNumbers() {

        int[] houseNumbers;
        int numberOfHouses;
        int houseIndex;

        System.out.print("How many houses in the street?   : ");
        numberOfHouses = keyboard.nextInt();
        houseNumbers = new int[numberOfHouses];
        System.out.println();

        for (houseIndex = 0; houseIndex < houseNumbers.length; houseIndex++) {
            System.out.print("What is the next house number?   : ");
            houseNumbers[houseIndex] = keyboard.nextInt();
        }

        return(houseNumbers);
    }
    //-----------------------------------------------------------------------------
    private static int[][] inputHouseAges(int[] houseNumbers) {

        int[][] houseAges;
        int houseIndex;
        int numberOfPeople;
        int personIndex;

        houseAges = new int[houseNumbers.length][];

        for (houseIndex = 0; houseIndex < houseNumbers.length; houseIndex++) {
            System.out.print("How many people live in number " + houseNumbers[houseIndex] + " : ");
            numberOfPeople = keyboard.nextInt();
            houseAges[houseIndex] = new int[numberOfPeople];
            for (personIndex = 0; personIndex < houseAges[houseIndex].length; personIndex++) {
                System.out.print("What is the age of person " + (personIndex+1) + "      : ");
                houseAges[houseIndex][personIndex] = keyboard.nextInt();
            }
            System.out.println();
        }

        return(houseAges);
    }
    //-----------------------------------------------------------------------------
    private static void analyseData(int[] houseNumbers,int[][] houseAges) {

        int houseIndex,personIndex;
        int totalStreetAge,totalHouseAge;

        totalStreetAge = 0;
        for (houseIndex = 0; houseIndex < houseNumbers.length; houseIndex++) {
            totalHouseAge = 0;
            for (personIndex = 0; personIndex < houseAges[houseIndex].length; personIndex++) {
                totalHouseAge += houseAges[houseIndex][personIndex];
            }
            System.out.println("House " + houseNumbers[houseIndex] + " has a total age of " + totalHouseAge);
            totalStreetAge += totalHouseAge;
        }
        System.out.println();
        System.out.println("The street has a total age of " + totalStreetAge);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================