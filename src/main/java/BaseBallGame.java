import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {
//            Random random = new Random();
//            int randomNumber = random.nextInt(889) + 111;
            int randomNumber = 123;
            String com = String.valueOf(randomNumber);
            guess(com);
        } while(gameEnd());

    }
    static void guess(String ans) {
        String input;
        do {
            System.out.println("숫자를 입력해 주세요.");
            input = scanner.nextLine();
        } while (count(ans, input));
    }

    static boolean count(String ans, String input) {
        String rst = "입력이 잘못되었습니다.";
        boolean sw = false;
        if (input.length() != 3 || !isNum(input)) sw = true;
        if (sw) System.out.println(rst);
        if (sw) return true;
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int flag = 0;
            if (ans.contains(input.substring(i, i + 1))) flag++;
            if (ans.charAt(i) == input.charAt(i)) flag++;
            if (flag == 2) strike++;
            if (flag == 1) ball++;
        }
        if (strike == 3) return false;
        if (ball > 0) rst = ball + "볼";
        if (strike > 0) rst = ball + "볼 " + strike + "스트라이크";
        System.out.println(rst);
        return true;
    }

    static boolean gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = scanner.nextLine();
            if (Objects.equals(input, "2")) return false;
            if (Objects.equals(input, "1")) return true;
            System.out.println("입력이 잘못되었습니다.");
        }
    }

    static boolean isNum(String text) {
        ArrayList<String> numbs = new ArrayList<>();
        for (int i = 1; i < 10; i++) numbs.add(String.valueOf(i));
        for (String s : text.split("")) if (!numbs.contains(s)) return false;
        return true;
    }
}
