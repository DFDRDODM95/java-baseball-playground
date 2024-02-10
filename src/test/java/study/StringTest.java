package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void request1() {
        String [] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
        String [] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    void request2() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("test about charAt method")
    void request3() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char actual2 = "abc".charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
