import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumbers {
    I(1), IV(4), V(5), IX(9), X(10), L(50), C(100);
    private int num;
    RomanNumbers(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    public static List<RomanNumbers> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumbers e) -> e.num).reversed())
                .collect(Collectors.toList());
    }
}
