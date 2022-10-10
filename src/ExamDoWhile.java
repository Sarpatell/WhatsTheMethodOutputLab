import java.util.Scanner;

public class ExamDoWhile {

    private static final int QUARTER_WAY = 2;
    private static final int HALF_WAY = 5;
    private static final int ALL_THE_WAY = 8;

    public static void main(String[] args) {
        int numberOfValues = 0;
        int total = 0;
        boolean madeIt;

        do {
            numberOfValues++;
            while (numberOfValues < HALF_WAY) {
                total += numberOfValues;
                numberOfValues++;
            }
            madeIt = (total - numberOfValues) % 3 == 0;
            numberOfValues -= QUARTER_WAY;
            System.out.println(total + " " + numberOfValues + " " + madeIt);
        }while ((total - HALF_WAY) < ALL_THE_WAY);
        }
    }