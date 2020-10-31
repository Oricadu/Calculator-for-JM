import java.util.regex.Pattern;

public class Calculator {
    private int firstNum = 0;
    private int secondNum = 0;
    private char sign;
    private int result = 0;

    public int calculate(int firstNum, int secondNum, char sign){
        switch (sign){
            case '+':
                return result = firstNum + secondNum;
            case '*':
                return result = firstNum * secondNum;
            case '/':
                return result = firstNum / secondNum;
            case '-':
                return result = firstNum - secondNum;


        }
        return result;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public char getSign() {
        return sign;
    }

    public int getResult() {
        return result;
    }

    Calculator(String str){
        String sq = "";
        String regex = "([0-9]|10)[-+/*]([0-9]|10)";
        str = str.replaceAll(" ", "");
        boolean matches = Pattern.matches(regex, str);
        System.out.println(matches);
        System.out.println(str);
        if (matches){
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++){
                if (Character.isDigit(chars[i])){
                    sq += chars[i];
                }else{
                    sign = chars[i];
                    this.firstNum = Integer.parseInt(sq);
                    sq = "";
                }

            }
            this.secondNum = Integer.parseInt(sq);

        }else{
            System.out.println("exception");
        }
        calculate(firstNum, secondNum, sign);
    }


}
