import java.util.Scanner;
//=============================================================================
public class DentalRecords2 {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int ARRAY_ROWS = 2;
    private static final int ARRAY_COLUMNS = 10;
    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        // Print the introduction
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        // Getting input for number of family members
        int numPeople;
        String uppers;
        String lowers;
        int upperFinals = 0;
        int lowerFinals = 0;

        System.out.print("Please enter number of people in the family : ");
        numPeople = keyboard.nextInt();

        while (numPeople < 1 || numPeople > 5) {
            System.out.print("Invalid number of people, try again         : ");
            numPeople = keyboard.nextInt();
        }

        //Getting input for the upper and lower teeth
        String[] nameArray = new String[numPeople];
        char[][][] teethArray = new char[numPeople][ARRAY_ROWS][ARRAY_COLUMNS];
        for (int i = 0; i < numPeople; i++) {
            System.out.print("Please enter the name for family member " + (i + 1) + "   : ");
            nameArray[i] = keyboard.next();

            System.out.print("Please enter the uppers for " + nameArray[i] + "       : ");
            boolean x = true;
            while (x) {
                uppers = keyboard.next();

                if (uppers.length() > 10) {
                    System.out.print("Too many teeth, try again                   : ");
                } else {
                    for (int k = 0; k < uppers.length(); k++) {
                        teethArray[i][0][k] = uppers.charAt(k);
                        switch (teethArray[i][0][k]) {
                            case 'I':
                            case 'i':
                            case 'B':
                            case 'b':
                            case 'M':
                            case 'm':
                                x = false;
                                break;

                            default:
                                System.out.print("Invalid teeth types, try again              : ");
                                k = uppers.length() + 1;
                                x = true;
                                break;
                        }
                        upperFinals++;
                    }
                }
            }


            System.out.print("Please enter the lowers for " + nameArray[i] + "       : ");
            x = true;
            while (x) {
                lowers = keyboard.next();

                if (lowers.length() > 10) {
                    System.out.print("Too many teeth, try again                   :");
                } else {
                    for (int k = 0; k < lowers.length(); k++) {
                        teethArray[i][1][k] = lowers.charAt(k);
                        switch (teethArray[i][1][k]) {
                            case 'I':
                            case 'i':
                            case 'B':
                            case 'b':
                            case 'M':
                            case 'm':
                                x = false;
                                break;

                            default:
                                System.out.print("Invalid teeth types, try again              :");
                                k = lowers.length()+1;
                                x = true;
                                break;
                        }
                        lowerFinals++;
                    }
                }
            }
        }


        //menu
        int counterB = 0;
        int counterI = 0;
        int counterM = 0;
        double root1, root2;
        String familyMember;
        char toothLayer;
        int toothNumber;
        int x = 0;
        int j;
        int q = 0;

        char menuOption = 0;
        while (menuOption != 'X' && menuOption != 'x') {
            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            menuOption = keyboard.next().charAt(0);
            while (menuOption != 'P' && menuOption != 'p' && menuOption != 'E' && menuOption != 'e' &&
                    menuOption != 'R' && menuOption != 'r' && menuOption != 'X' && menuOption != 'x') {
                System.out.print("Invalid menu option, try again              : ");
                menuOption = keyboard.next().charAt(0);
            }
            switch (menuOption) {
                case 'P':
                case 'p':
                    for (int i = 0; i < numPeople; i++) {
                        System.out.println();
                        System.out.println(nameArray[i]);

                        System.out.print("  Uppers:  ");
                        int k = 0;
                        while (k < 10 && (teethArray[i][0][k] == 'B' || teethArray[i][0][k] == 'b' || teethArray[i][0][k] == 'I'
                                || teethArray[i][0][k] == 'i' || teethArray[i][0][k] == 'M' || teethArray[i][0][k] == 'm')) {
                            System.out.print("  " + (k + 1) + ":");
                            System.out.print(teethArray[i][0][k] + "\t");
                            k++;
                        }

                        System.out.println();
                        System.out.print("  Lowers:  ");
                        j = 0;
                        while (j < 10 && (teethArray[i][1][j] == 'B' || teethArray[i][1][j] == 'b' || teethArray[i][1][j] == 'I'
                                || teethArray[i][1][j] == 'i' || teethArray[i][1][j] == 'M' || teethArray[i][1][j] == 'm')) {
                            System.out.print("  " + (j + 1) + ":");
                            System.out.print(teethArray[i][1][j] + "\t");
                            j++;
                        }
                        System.out.println();
                    }
                    break;
                case 'R':
                case 'r':
                    for (int m = 0; m < numPeople; m++) {
                        for (int n = 0; n < 10; n++) {
                            if (teethArray[m][0][n] == 'B' || teethArray[m][0][n] == 'b') {
                                counterB++;
                            }
                            if (teethArray[m][0][n] == 'I' || teethArray[m][0][n] == 'i') {
                                counterI++;
                            }
                            if (teethArray[m][0][n] == 'M' || teethArray[m][0][n] == 'm') {
                                counterM++;
                            }
                        }
                    }

                    root1 = (-counterI + Math.sqrt((counterI * counterI) + (4 * counterB * counterM))) / (2 * counterB);
                    root2 = (-counterI - Math.sqrt((counterI * counterI) + (4 * counterB * counterM))) / (2 * counterB);
                    System.out.print("One root canal at     ");
                    System.out.printf("%.2f", root1);
                    System.out.println();
                    System.out.print("Another root canal at ");
                    System.out.printf("%.2f", root2);
                    System.out.println();
                    break;

                case 'E':
                case 'e':
                    System.out.print("Which family member                         : ");
                    familyMember = keyboard.next();
                    boolean b;
                    for (int i = 0; i < numPeople; i++) {
                        b = nameArray[i].equalsIgnoreCase(familyMember);
                        while (!b) {
                            System.out.print("Invalid family member, try again            : ");
                            familyMember = keyboard.next();
                            b = true;
                        }
                    }


                        /*if (!nameArray[1].equalsIgnoreCase(familyMember) && !nameArray[2].equalsIgnoreCase(familyMember)
                                && !nameArray[3].equalsIgnoreCase(familyMember) && !nameArray[4].equalsIgnoreCase(familyMember)) {
                            System.out.print("Invalid family member, try again            :");
                            familyMember = keyboard.next();
                        } else {
                            break;
                        }*/


                    System.out.print("Which tooth layer (U)pper or (L)ower        : ");
                    toothLayer = keyboard.next().charAt(0);
                    while (toothLayer != 'U' && toothLayer != 'u' && toothLayer != 'L'&& toothLayer != 'l') {
                        System.out.print("Invalid layer, try again                    : ");
                        toothLayer = keyboard.next().charAt(0);
                    }
                    System.out.print("Which tooth number                          : ");
                    toothNumber = keyboard.nextInt();
                    if (toothLayer == 'u' || toothLayer == 'U') {
                        while (toothNumber > upperFinals) {
                            System.out.print("Invalid tooth number, try again             : ");
                            toothNumber = keyboard.nextInt();
                            for (int p = 0; p < toothNumber; p++) {
                                q++;
                            }
                        }
                        j = 0;
                        System.out.print(q);
                        while (teethArray[x][j][2] == 'M') {
                            System.out.println("Missing tooth, try again                    : ");
                            q = keyboard.nextInt();
                        }
                        teethArray[x][j][2] = 'M';

                    }else {
                        while (toothNumber > lowerFinals) {
                            System.out.print("Invalid tooth number, try again             : ");
                            toothNumber = keyboard.nextInt();
                            for (int p = 0; p < toothNumber; p++) {
                                q++;
                            }
                        }
                        j = 1;
                    }

                    break;
                default:
                    break;
            }



        }
        System.out.print("\nExiting the Floridian Tooth Records :-)");

    }
}


//-----------------------------------------------------------------------------

//=============================================================================
