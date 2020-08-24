import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please input radius:");
        Scanner scanner = new Scanner(System.in);
        String radius = scanner.nextLine();

        System.out.println("Please input dividing part:");
        String part = scanner.nextLine();

        System.out.println("Please input precision:");
        String precision = scanner.nextLine();

        DividedRound round = new DividedRound(new BigDecimal(radius), Integer.parseInt(part), BigDecimal.valueOf(Double.parseDouble(precision)));
        System.out.println("Please wait for the calculation. (It should finish in 1 minute!)");

        round.start();

        while (true) ;
    }
}