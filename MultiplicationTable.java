import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int multiplicand,multiplier;

        do {
            System.out.print("Enter a number to multiplicand:");
            multiplicand = input.nextInt();
            if (multiplicand<1){
                System.out.println("The number can't be negative!");
            }
        }while (multiplicand<1);

        for (multiplier=1; multiplier<=10; multiplier++) {
                System.out.println(multiplicand+"x"+multiplier+"="+(multiplicand*multiplier));
            if (multiplier==10){
                System.out.println("END");
            }

        }
    }
}
