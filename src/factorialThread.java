import java.io.IOException;
import java.math.BigInteger;

public class factorialThread implements Runnable{
    private int numForFactorial;

    public factorialThread(int numForFactorial) {
        this.numForFactorial = numForFactorial;
    }

    @Override
    public void run() {
        try {
            System.out.println("Факториал числа " + this.numForFactorial + " равен " + factorial2(this.numForFactorial));
        } catch (ArithmeticException e) {
            System.out.println(this.numForFactorial + " - значение меньше или равно 0");
        } catch (IOException e) {
            System.out.println("Ой, ошибка!");
        }
    }

    private long factorial (int num) throws IOException {
        if (num <= 0)
            throw new ArithmeticException("Значение меньше или равно 0");
        if (num == 1) return 1;
        return num * factorial(num - 1);
    }

    private BigInteger factorial2 (int num) throws IOException {
        if (num <= 0)
            throw new ArithmeticException("Значение меньше или равно 0");
        BigInteger result = BigInteger.ONE;
        for (int i = num; i > 1; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
