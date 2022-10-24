import java.util.Scanner;
//=============================================================================
public class DentalRecords {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int ARRAY_COLUMNS = 10;
    private static final int ARRAY_ROWS = 2;

//-----------------------------------------------------------------------------
    public static void main(String[] args) {

        int FamilyNum;
        String[] nameRecord;
        char[][][] teethLayer;
        int[][] numTeeth;
        char menuOption;

//----Print Welcome Message
        System.out.println("Welcome to the Floridian Tooth Records\n" + "--------------------------------------");

//----Enter num of people in family
        FamilyNum = getFamilyNum();
        numTeeth = new int[2][FamilyNum];
        teethLayer = new char[FamilyNum][ARRAY_ROWS][ARRAY_COLUMNS];

//----Enter name, upper 10 teeth, and lower teeth
        nameRecord = new String[FamilyNum];
        getFamData(FamilyNum, nameRecord, teethLayer, numTeeth);

//----Print Main menu
        System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
        menuOption = keyboard.next().charAt(0);

//----Check if menu option is valid
        while (menuOption != 'X' && menuOption != 'x') {
            switch (menuOption) {
                case 'P':
                case 'p':
                    printFullRecords(FamilyNum, nameRecord, teethLayer, numTeeth);
                    System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
                    break;

                case 'E':
                case 'e':
                    extractTooth(FamilyNum, nameRecord, teethLayer, numTeeth);
                    System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
                    break;

                case 'R':
                case 'r':
                    calcRoot(FamilyNum, teethLayer, numTeeth);
                    System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
                    break;

                default:
                    System.out.print("Invalid menu option, try again              : ");

            }
            menuOption = keyboard.next().charAt(0);
        }

        System.out.print("\nExiting the Floridian Tooth Records :-)");
    }

//-----------------------------------------------------------------------------
    public static int getFamilyNum() {
        int numFam;

//----Prompt user for number of family members
        System.out.print("Please enter number of people in the family : ");
        numFam = keyboard.nextInt();

        while (numFam < 0 || numFam > 5) {
            System.out.print("Invalid number of people, try again         : ");
            numFam = keyboard.nextInt();
        }
        return (numFam);
    }
//-----------------------------------------------------------------------------
    public static void getFamData(int FamilyNum, String[] famNames, char[][][] teethInfo, int[][] numTeeth) {
        int showNum = 0;
        String uppers;
        String lowers;

//----Prompt for name, record in string array
        for (int famList = 0; famList  < FamilyNum; famList++) {
            showNum = famList + 1;
            System.out.print("Please enter the name for family member " + showNum + "   : ");
            famNames[famList] = keyboard.next();

//----Get uppers for specific family member
            uppers = getUppersLowers(famList, famNames[famList], "uppers");
            // Store get uppers for each member
            numTeeth[0][famList] = uppers.length();
            for (int i = 0; i < uppers.length(); i++) {
                teethInfo[famList][0][i] = uppers.charAt(i);
            }

//----Get lowers
            lowers = getUppersLowers(famList, famNames[famList], "lowers");

//----Store get lowers for each member
            numTeeth[1][famList] = lowers.length();
            for (int i = 0; i < lowers.length(); i++) {
                teethInfo[famList][1][i] = lowers.charAt(i);
            }
        }
    }
//-----------------------------------------------------------------------------
    public static String getUppersLowers(int famList, String famName, String teethLoc) {
        String teethUporLow;
        int teethLength = 0;
        boolean validity = true;

        System.out.printf("Please enter the %s for %-10s      : ", teethLoc, famName);
        teethUporLow = keyboard.next();

//----Check for all characters must be IBM (lowercase and upper case)
        validity = checkTeethValidity(teethUporLow);
        teethLength = teethUporLow.length();

//----Check for length <= 10
        while (!validity || teethLength > 10) {
            if (!validity) {
                System.out.print("Invalid teeth types, try again              : ");
            } else {
                System.out.print("Too many teeth, try again                   : ");
            }
            teethUporLow = keyboard.next();
            teethLength = teethUporLow.length();
            validity = checkTeethValidity(teethUporLow);
        }
        teethUporLow = teethUporLow.toUpperCase();
        return teethUporLow;
    }
//-----------------------------------------------------------------------------
    public static boolean checkTeethValidity(String teeth) {
        boolean teethValidity = false;

//----Make sure teeth are either I, B or M, upper or lowercase
        for (int index = 0; index < teeth.length(); index++) {
            switch (teeth.charAt(index)) {
                case 'I':
                case 'i':
                case 'B':
                case 'b':
                case 'M':
                case 'm':
                    teethValidity = true;
                    break;
                default:
                    //Anything else is not valid
                    teethValidity = false;
            }
        }
        return teethValidity;
    }
//-----------------------------------------------------------------------------
    public static void printFullRecords(int FamilyNum, String[] famNames, char[][][] teethInfo, int[][] numTeeth) {

//----Print names in string array
        for (int famList= 0; famList < FamilyNum; famList++) {
            System.out.println();
            System.out.println(famNames[famList]);
            System.out.print("  Uppers:  ");
            for (int toothList = 0; toothList < numTeeth[0][famList]; toothList++) {
                System.out.printf("%3d:%S", toothList + 1, teethInfo[famList][0][toothList]);
            }
            System.out.println();
            System.out.print("  Lowers:  ");
            for (int toothList = 0; toothList < numTeeth[1][famList]; toothList++) {
                System.out.printf("%3d:%S", toothList + 1, teethInfo[famList][1][toothList]);
            }
            System.out.println();
        }
    }
//-----------------------------------------------------------------------------
    public static void extractTooth(int totalFamilyNum, String[] famNames, char[][][] teethInfo, int[][] numTeeth) {
        String famMember;
        boolean found = false;
        boolean correctUL = false;
        char toothLayer;
        int saveMemberID = 0;
        int toothNum;
        int toothRow = 0;

//----Get family member name
        System.out.print("Which family member                         : ");
        famMember = keyboard.next();

//----Check if family member is valid
        do {
            for (int famList = 0; famList < totalFamilyNum; famList++) {
                if (famMember.equalsIgnoreCase(famNames[famList])) {
                    found = true;
                    saveMemberID = famList;
                }
            }
            if (!found) {
                System.out.print("Invalid family member, try again            : ");
                famMember = keyboard.next();
            }
        } while (!found);

//----Get tooth layer
        System.out.print("Which tooth layer (U)pper or (L)ower        : ");
        toothLayer = keyboard.next().charAt(0);

//----Get tooth layer whether upper or lower
        do {
            switch (toothLayer) {
                case 'U':
                case 'u':
                    correctUL = true;
                    toothRow = 0;
                    break;
                case 'L':
                case 'l':
                    correctUL = true;
                    toothRow = 1;
                    break;
                default:
                    System.out.print("Invalid layer, try again                    : ");
                    toothLayer = keyboard.next().charAt(0);
            }
        } while (!correctUL);

//----Get tooth number
        System.out.print("Which tooth number                          : ");
        toothNum = keyboard.nextInt();

//----Check if missing
//----Replace with M if valid
        while (toothNum > numTeeth[toothRow][saveMemberID] || toothNum <= 0 || teethInfo[saveMemberID][toothRow][toothNum - 1] == 'M') {
            if (toothNum > numTeeth[toothRow][saveMemberID] || toothNum <= 0) {
                System.out.print("Invalid tooth number, try again             : ");
            } else if (teethInfo[saveMemberID][toothRow][toothNum - 1] == 'M') {
                System.out.print("Missing tooth, try again                    : ");
            }
            toothNum = keyboard.nextInt();
        }
        teethInfo[saveMemberID][toothRow][toothNum - 1] = 'M';
    }
//-----------------------------------------------------------------------------
    public static void calcRoot(int totalFamilyNum, char[][][] teethInfo, int[][] numTeeth) {
        double I;
        double B;
        double M;
        double root1;
        double root2;
        double discriminant;
        double sumI = 0.0;
        double sumB = 0.0;
        double sumM = 0.0;

//----For loop to add up all I, B and M
        for (int famList = 0; famList < totalFamilyNum; famList++) {
            for (int rowList = 0; rowList < ARRAY_ROWS; rowList++) {
                for (int toothList = 0; toothList < numTeeth[rowList][famList]; toothList++) {
                    switch (teethInfo[famList][rowList][toothList]) {
                        case 'I':
                            sumI += 1;
                            break;
                        case 'B':
                            sumB += 1;
                            break;
                        case 'M':
                            sumM += 1;
                            break;
                        default:
                            System.out.print("Error in reading teeth information          :");
                    }
                }
            }
        }
//----Ix2+Bx-M
        B = sumB;
        I = sumI;
        M = -1 * sumM;

//----Calculate discriminant to find real root canals
        discriminant = Math.pow(B, 2) - 4 * I * M;
        if (discriminant == 0.0) {
            root1 = (-B + Math.pow(discriminant, 0.5)) / (2 * I);
            System.out.printf("One root canal at %.2f\n", root1);
            System.out.println();
        }else if (discriminant > 0.0) {
            root1 = (-B + Math.pow(discriminant, 0.5)) / (2 * I);
            root2 = (-B - Math.pow(discriminant, 0.5)) / (2 * I);
            System.out.printf("One root canal at %.2f\nAnother root canal at %.2f", root1, root2);
            System.out.println();
        }
    }
}
