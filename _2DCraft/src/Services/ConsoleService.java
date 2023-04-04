package Services;

import java.util.Scanner;

public class ConsoleService {
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressAnyKeyToContinue(){
        System.out.println("Press any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }
}
