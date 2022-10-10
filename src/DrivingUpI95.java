import java.util.Scanner;
//=============================================================================
public class DrivingUpI95 {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----The speed limit
    private static final double SPEED_LIMIT = 65;
//----Constants for stops
    private static final double TIME_PER_STOP = 5.0/60.0;
    private static final double STOP_DISTANCE = 100;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold input values
        double distance,time,speed;

//----1. User messages
        userMessages();

//----2. Input distance and time
        System.out.print("Enter distance to travel : ");
        distance = keyboard.nextDouble();
        System.out.print("Enter time available     : ");
        time = keyboard.nextDouble();

//----3. Compute travel speed
        speed = computeTravelSpeed(distance,time);

//----4. Display output
        displayOutput(speed);
    }
//-----------------------------------------------------------------------------
    private static void userMessages() {

//----   1.1 Welcome message
        System.out.println();
        System.out.println("Welcome to Geoff's I95 Speed Machine");
//----   1.2 Instructions for use
        System.out.println();
        System.out.println("You will have to supply:");
        System.out.println("+ The distance you want to travel, in miles");
        System.out.println("+ The time you have available, in hours");
        System.out.println();
    }
//-----------------------------------------------------------------------------
    private static double computeTravelSpeed(double distanceToGo,
                                             double timeAvailable) {

        double timeForStops;

//----   3.1 Compute time for stops (remember to round up)
        timeForStops = TIME_PER_STOP * Math.ceil(distanceToGo/STOP_DISTANCE);
//----   3.2 Compute time for travel = time - stops
        timeAvailable -= timeForStops;
//----   3.3 Compute speed = distance / time for travel
        return(distanceToGo / timeAvailable);
    }
//-----------------------------------------------------------------------------
    private static void displayOutput(double speed) {

        System.out.println();
//----   4.1 Display speed
        System.out.println("You will have to travel at " + speed + "mph");
//----   4.2 Display true/false for over speed limit 
        System.out.println("Over the speed limit     : " +
                (speed > SPEED_LIMIT));
        System.out.println();
    }
//-----------------------------------------------------------------------------
}
//=============================================================================