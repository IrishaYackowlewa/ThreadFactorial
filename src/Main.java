import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //String nameFile = "D:\\Java_task\\Multithreading\\factorial.txt";
        String nameFile = "factorial.txt";
        try {
            for (int num: getValuesFromFile(nameFile)) {
                Thread factorialNumber = new Thread( new factorialThread(num));
                factorialNumber.start();
            }
        } catch (IOException e) {
            System.out.println("Ой, ошибка!");
            e.printStackTrace();
        } catch (Throwable e) {
            System.out.println("Ой, ошибка!");
        }
    }

    public static List<Integer> getValuesFromFile (String nameFile ) throws IOException{
            return Files.lines(Paths.get(nameFile))
                    .map(s -> s.split(" "))
                    .flatMap(Arrays::stream)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

}
