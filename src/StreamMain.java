import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public static void streamMain(){
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> streamAnswerList = new ArrayList<>();

        Stream<Integer> stream = intList.stream();
        stream.filter(x -> x>0).filter(x -> x % 2 == 0).sorted(Comparator.naturalOrder()).forEach(w->streamAnswerList.add(w));

        System.out.println("Сортировка c использованием StreamAPI " + streamAnswerList);
    }
}
