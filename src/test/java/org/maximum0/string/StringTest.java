package org.maximum0.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열")
public class StringTest {

    @DisplayName("2744번 - 대소문자 바꾸기")
    @Test
    void test_2744_() {
        String input = "WrongAnswer";
        String result = "wRONGaNSWER";
        assertEquals(result, _2744_.solve(input));
    }

}
