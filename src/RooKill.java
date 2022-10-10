import java.util.Scanner;
//=============================================================================
public class RooKill {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----The roo kill constant
    private static final double ROO_KILL_PROBABILITY = 1.47;
    private static final double ROAD_WIDTH = 0.01;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

//---- Variables to hold input values
        double squareSide,roadLength,numberOfRoos;
        double rooDensity,squareArea,roadArea;
        double rooKills;

//---- Input of the data
//----   Input length of square
        System.out.print("Enter side of square in km  : ");
        squareSide = keyboard.nextDouble();
//----   Input length of roads
        System.out.print("Enter roads length in km    : ");
        roadLength = keyboard.nextDouble();
//----   Input number of kangaroos
        System.out.print("Enter number of 'roos       : ");
        numberOfRoos = keyboard.nextDouble();

//---- Solving the amount of kangaroos killed
//----   Compute kangaroos density
//----       Evaluate square area = side * side
        squareArea = squareSide * squareSide;
//----       Evaluate density = number of kangaroos / square area
        rooDensity = numberOfRoos / squareArea;
//----   Compute road area = 0.01km * roads length
        roadArea = roadLength * ROAD_WIDTH;
//----   Compute kills = kangaroos density * road area * 1.47
        rooKills = rooDensity * roadArea * ROO_KILL_PROBABILITY;

//---- Display amount of kangaroos killed
        System.out.println("Expected number of kills is : " + rooKills);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================