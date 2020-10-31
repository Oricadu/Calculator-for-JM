import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");

        Scanner scanner = new Scanner(System.in);
        /*Calculator calculator = new Calculator(scanner.nextLine());
        System.out.println(calculator.getFirstNum() + " " +
                calculator.getSign() + " " +
                calculator.getSecondNum() + " = " +
                calculator.getResult());*/
        String str;
        String regex = "([I]{0,3})|(I?V)|(V(I){1,3})|(I?X)";
        do {

            str = scanner.nextLine();
            boolean matches = Pattern.matches(regex, str);
            System.out.println(str + " " + matches);
        }while (!str.equals(""));
    }
}
