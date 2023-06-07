import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Collections.sort(intList, Collections.reverseOrder());

        ArrayList<Integer> answerList = new ArrayList<>();
        for(int v:intList) {
            if (v > 0) {
                if (v % 2 == 0) {
                    answerList.add(v);
                }
            } else {
                break;
            }
        }

        Collections.reverse(answerList);
        System.out.println("Решено без StreamAPI " + answerList);

        StreamMain.streamMain();

    }
}