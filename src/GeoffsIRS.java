import java.util.Scanner;
//=============================================================================
public class GeoffsIRS {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);

    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;

    private static final double HIGH_RATE = 0.25;
    private static final double MEDIUM_RATE = 0.1;
    private static final double LOW_RATE = 0.03;
    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        double amount,income,deductions;
        double taxableIncome,taxOwed;
        char taxGroup;

//----1. Input income and deduction
        income = 0.0;
        deductions = 0.0;
//----   1.1 Repeatedly until 0.0 is entered
        do {
//----       1.1.1 Prompt user
            System.out.print("Enter next amount : ");
//----       1.1.2 Input value
            amount = keyboard.nextDouble();
//----       1.1.3 If positive
            if (amount > 0.0) {
//----           1.1.3.1 Add to income
                income += amount;
            } else {
//----       1.1.4 If negative
//----           1.1.4.1 Add (absolute) to deduction
                deductions -= amount;
            }
        } while (amount != 0.0);

//----2. Compute taxable income
        taxableIncome = computeTaxableIncome(income,deductions);
//----3. Compute tax group
        taxGroup = chooseTaxGroup(taxableIncome);
//----4. Compute tax
        taxOwed = computeTax(taxableIncome,taxGroup);

//----5. Display tax information
        displayTaxInformation(income,deductions,taxableIncome,taxGroup,
                taxOwed);
    }
    //-----------------------------------------------------------------------------
    private static double computeTaxableIncome(double income,
                                               double deductions) {

//----   2.1 If income >= deduction taxable is income - deduction, else
        if (income >= deductions) {
            return(income - deductions);
        } else {
//----   2.2 Taxable is 0.0
            return(0.0);
        }
    }
    //-----------------------------------------------------------------------------
    private static char chooseTaxGroup(double income) {

//----   3.1 If taxable >= 500000
        if (income >= STINKING_RICH) {
//----       3.1.1 Group is S, else
            return('S');
//----   3.2 If taxable >= 200000
        } else if (income >= QUITE_RICH) {
//----       3.2.1 Group is Q, else
            return('Q');
//----   3.3 If taxable >= 100000
        } else if (income >= MIAMI_POOR) {
//----       3.3.1 Group is M, else
            return('M');
//----   3.4 If taxable >= 50000
        } else if (income >= AVERAGE) {
//----       3.4.1 Group is A, else
            return('A');
//----   3.5 If taxable >= 20000
        } else if (income >= REALISTIC) {
//----       3.5.1 Group is R, else
            return('R');
        } else {
//----   3.6 Group is P
            return('P');
        }
    }
    //-----------------------------------------------------------------------------
    private static double computeTax(double taxable,char group) {

        double tax;

//----   4.1 Depending on the group
        switch (group) {
//----       4.1.1 For S and Q
            case 'S':
            case 'Q':
//----           4.1.1.1 Tax is 25% of taxable
                tax = HIGH_RATE * taxable;
                break;
//----       4.1.2 For M
            case 'M':
//----           4.1.2.1 Tax is 10% of taxable
                tax = MEDIUM_RATE * taxable;
                break;
//----       4.1.3 For A and R
            case 'A':
            case 'R':
//----           4.1.3.1 Tax is 10% of taxable
                tax = LOW_RATE * taxable;
                break;
//----       4.1.4 For P
            case 'P':
//----           4.1.4.1 Tax is 0.0
                tax = 0.0;
                break;
//----       4.1.5 For other groups
            default:
//----           4.1.5.1 Error!
                System.out.println("ERROR: Illegal tax group");
                tax = 0.0;
                break;
        }

        return(tax);
    }
    //-----------------------------------------------------------------------------
    private static void displayTaxInformation(double income,double deductions,
                                              double taxableIncome,char taxGroup,double taxOwed) {

        System.out.println();
//----   5.1 Display income
        System.out.println("Income         = $" + income);
//----   5.2 Display deduction
        System.out.println("Deductions     = $" + deductions);
//----   5.3 Display taxable
        System.out.println("Taxable income = $" + taxableIncome);
//----   5.4 Display group
        System.out.println("Tax group      = " + taxGroup);
//----   5.5 Display tax
        System.out.println("Tax owed       = $" + taxOwed);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================

//  private static void displayTax(double income,double deductions ) {
//       double taxableIncome = computeTaxableIncome(income, deductions) ;
//     char taxGroup = chooseTaxGroup(taxableIncome);
//     double taxOwed = computeTax(taxableIncome);



//       System.out.println();
//----  Display income
//    System.out.println("Income         = $" + income);
//----  Display deduction
//    System.out.println("Deductions     = $" + deductions);
//----  Display taxable
//   System.out.println("Taxable income = $" + taxableIncome);
//----  Display group
//    System.out.println("Tax group      = " + taxGroup);
//----  Display tax
//   System.out.println("Tax owed       = $" + taxOwed);
//   }

//}//end  of the class