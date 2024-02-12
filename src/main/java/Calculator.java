import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String input = scanner.nextLine();
        String input = "2 + 3 * 4 / 2 - 1";

        Map<String, BinaryOperator<Integer>> op = new HashMap<>();
        op.put("+", (a, b) -> a + b);
        op.put("-", (a, b) -> a - b);
        op.put("*", (a, b) -> a * b);
        op.put("/", (a, b) -> a / b);

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> letters = new ArrayList<>();

        for (String item : input.split("")) {
            if (isNumeric(item)) {
                numbers.add(parseInt(item));
            }
            else {
                if(!item.equals(" ")) {
                    letters.add(item);
                }
            }
        }

        int result = numbers.get(0);
        for (int i = 0; i < letters.size(); i++) {
            result = op.get(letters.get(i)).apply(result, numbers.get(i + 1));
        }

        System.out.println("Result: " + result);

    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
