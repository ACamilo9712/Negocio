import java.math.BigDecimal;

public class principal {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("7");

//Equivalent to result = MAX(a,b)
        BigDecimal result = a.max(b);
        System.out.println(result);
    }
}
