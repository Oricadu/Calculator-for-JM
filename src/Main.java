import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = null;
        try {
            calculator = new Calculator(scanner.nextLine());
            System.out.println(calculator.getInput() + " = " +
                    calculator.getResult());
        } catch (UserInputException e) {
            e.printStackTrace();
        }


    }
}
