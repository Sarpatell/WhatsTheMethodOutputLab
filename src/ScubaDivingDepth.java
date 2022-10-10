import java.util.Scanner;
//=============================================================================
public class ScubaDivingDepth {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);

    private static final byte FEET_PER_ATM = 33;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold input values
        int depthInFeet;
        int percentageO2InGas;
        double ambientPressure,o2Pressure;
        char o2Group;
        boolean exceedsMaxO2Pressure,exceedsContingencyO2Pressure;

//---- Input data
        System.out.print("Enter depth and percentage O2   : ");
//----   Input depth
        depthInFeet = keyboard.nextInt();
//----   Input percentage O2
        percentageO2InGas = keyboard.nextInt();

//---- Compute dive data
//----   Compute ambient pressure = (depth / 33) + 1
        ambientPressure = 1 + (double) depthInFeet / FEET_PER_ATM;
//----   Compute PPO2 = ambient * (percentage O2 / 100)
        o2Pressure = (double)percentageO2InGas/100 * ambientPressure;
//----   Compute OPG
//----       N = integer part of PPO2 * 10
//----       Take Nth letter after 'A'
        o2Group = (char)((int)(o2Pressure * 10)  + (int)'A');
//----       Exceed maximal = PPO2 > 1.4
        exceedsMaxO2Pressure = o2Pressure > MAX_O2_PRESSURE;
//----       Exceed contingency = PPO2 > 1.6
        exceedsContingencyO2Pressure = o2Pressure > CONTINGENCY_O2_PRESSURE;

//---- Display dive data
        System.out.println();
//----   Display ambient pressure, PPO2, OPG
        System.out.println("Ambient pressure                : " + ambientPressure);
        System.out.println("O2 pressure                     : " + o2Pressure);
        System.out.println("O2 group                        : " + o2Group);
//----   Display exceed status values
        System.out.println();
//---- Print those Boolean values
        System.out.println("Exceeds maximal O2 pressure     : " +
                exceedsMaxO2Pressure);
        System.out.println("Exceeds contingency O2 pressure : " +
                exceedsContingencyO2Pressure);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================
