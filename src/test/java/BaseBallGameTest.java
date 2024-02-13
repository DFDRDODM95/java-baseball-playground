import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseBallGameTest {

    static Scanner scanner = new Scanner(System.in);

    String ans = "123";
    @ParameterizedTest
    @CsvSource(value = {"123:false", "132:true", "1234:true"}, delimiter = ':')
    void count(String input, boolean expected) {
        boolean actual = true;
        boolean sw = false;
        if (input.length() != 3 || !isNum(input)) sw = true;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (sw) i = 3;
            if (sw) continue;
            int flag = 0;
            if (ans.contains(input.substring(i, i + 1))) flag++;
            if (ans.charAt(i) == input.charAt(i)) flag++;
            if (flag == 2) strike++;
        }
        if (strike == 3) actual = false;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false", "ㅁ:true"}, delimiter = ':')
    void gameEnd(String input, boolean expected) {
        boolean actual = true;
        if (Objects.equals(input, "2")) actual = false;
        if (Objects.equals(input, "1")) actual = true;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "ㅁ:false"}, delimiter = ':')
    void isNum(String input, boolean expected) {
        ArrayList<String> numbs = new ArrayList<>();
        for (int i = 1; i < 10; i++) numbs.add(String.valueOf(i));
        boolean actual = true;
        for (String s : input.split("")) if (!numbs.contains(s)) actual = false;
        assertEquals(expected, actual);
    }

    static boolean isNum(String text) {
        ArrayList<String> numbs = new ArrayList<>();
        for (int i = 1; i < 10; i++) numbs.add(String.valueOf(i));
        for (String s : text.split("")) if (!numbs.contains(s)) return false;
        return true;
    }
}