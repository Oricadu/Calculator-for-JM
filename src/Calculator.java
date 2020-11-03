import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private int firstNum = 0;
    private int secondNum = 0;
    private char sign;
    private String result = "";
    private String input;

    public String calculate(int firstNum, int secondNum, char sign) {
        switch (sign) {
            case '+':
                return result = "" + (firstNum + secondNum);
            case '*':
                return result = "" + (firstNum * secondNum);
            case '/':
                return result = "" + (firstNum / secondNum);
            case '-':
                return result = "" + (firstNum - secondNum);


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

    public String getInput() {
        return input;
    }

    public String getResult() {
        return result;
    }

    Calculator(String str) throws UserInputException {
        this.input = str.toUpperCase();
        if (checkString(str) == 'a'){
            calculate(firstNum, secondNum, sign);

        }else {
            result = convertToRoman(Integer.parseInt(calculate(firstNum, secondNum, sign)));
        }
    }

    private char checkString(String str) throws UserInputException{
        String sq = "";
        char flag = 0;
        str = str.replaceAll(" ", "");
        str = str.toUpperCase();
        String regex = "([1-9]|10)[-+/*]([1-9]|10)";
        boolean matches = Pattern.matches(regex, str);
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
            flag = 'a';

        }else{
            regex = "(([I]{0,3})|(I?V)|(V(I){1,3})|(I?X))[-+/*](([I]{0,3})|(I?V)|(V(I){1,3})|(I?X))";
            matches = Pattern.matches(regex, str);
            if (matches){
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++){
                    if ((chars[i] != '+') &&
                            (chars[i] != '-') &&
                            (chars[i] != '/') &&
                            (chars[i] != '*')){
                        sq += chars[i];
                    }else{
                        sign = chars[i];
                        this.firstNum = convertToArabic(sq);
                        sq = "";
                    }

                }
                this.secondNum = convertToArabic(sq);
                flag = 'r';

            }else{
                throw new UserInputException("input is incorrect");
            }

        }
        return flag;

    }

    private int convertToArabic(String str){
        char[] str1 = str.toCharArray();
        int[] arr = new int[str1.length];
        for (int i = 0; i < str1.length; i++){
            switch (str1[i]){
                case 'I':
                    arr[i] = 1;
                    break;
                case 'V':
                    arr[i] = 5;
                    break;
                case 'X':
                    arr[i] = 10;
                    break;


            }
        }
        int result;
        if (arr.length == 1){
            result = arr[0];

        }else{
            result = 0;
            for (int i = 1; i < arr.length; i++){
                if(arr[i] > arr[i-1]){
                    result += arr[i] - arr[i-1];
                }else{
                    result += arr[i-1];
                    if (i == arr.length-1){
                        result += arr[i];
                    }

                }
            }


        }

        return result;
    }

    private String convertToRoman(int number){
        String result = "";
        int i = 0;
        List<RomanNumbers> romanNumbersList = RomanNumbers.getReverseSortedValues();
        while ((number > 0) && (i < romanNumbersList.size())){
            RomanNumbers cur = romanNumbersList.get(i);
            if(cur.getNum() <= number){
                result += cur.name();
                number -= cur.getNum();
            }else{
                i++;
            }
        }

        return result;
    }


}


