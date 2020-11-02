import java.util.regex.Pattern;

public class Calculator {
    private int firstNum = 0;
    private int secondNum = 0;
    private char sign;
    private int result = 0;

    public int calculate(int firstNum, int secondNum, char sign) {
        switch (sign) {
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

    Calculator(String str) throws UserInputException {
        checkString(str);
        calculate(firstNum, secondNum, sign);
    }

    private void checkString(String str) throws UserInputException{
        String sq = "";
        char flag = 0;
        str = str.replaceAll(" ", "");
        str = str.toUpperCase();
        String regex = "([0-9]|10)[-+/*]([0-9]|10)";
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
            regex = "(([I]{0,3})|(I?V)|(V(I){1,3})|(I?X))[-+/*](([I]{0,3})|(I?V)|(V(I){1,3})|(I?X))";
            matches = Pattern.matches(regex, str);
            System.out.println(matches);
            System.out.println(str);
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

            }else{
                throw new UserInputException("input is incorrect");
            }

        }

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
            //System.out.print(arr[i]);
        }
        //System.out.println();
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


        //System.out.println(result);

        return result;
    }

    private String convertToRoman(int number){
        String result = "";

        return result;
    }


}


