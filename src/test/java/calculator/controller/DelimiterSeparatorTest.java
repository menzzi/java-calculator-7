package calculator.controller;

import org.junit.jupiter.api.Test;

import static calculator.controller.DelimiterSeparator.registerDelimiter;
import static calculator.controller.DelimiterSeparator.specifyingDelimiter;
import static org.junit.jupiter.api.Assertions.*;

public class DelimiterSeparatorTest {

    @Test
    void 숫자_시작_구분자_등록_안함(){
        String userInput = "123";
        int index = registerDelimiter(userInput);
        assertEquals(0,index);
    }

    @Test
    void 문자_시작_구분자_등록_성공(){
        String userInput = "//;\n123";
        int index = registerDelimiter(userInput);
        assertEquals(4,index);
    }

    @Test
    public void 구분자_등록_형식_에러() {
        String userInput = ";123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            specifyingDelimiter(userInput);
        });
        assertEquals("잘못된 형식입니다.", exception.getMessage());
    }

    @Test
    public void 구분자_등록_형식_에러2() {
        String userInput = "//;123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            specifyingDelimiter(userInput);
        });
        assertEquals("잘못된 형식입니다.", exception.getMessage());
    }

    @Test
    public void 구분자_등록_성공() {
        String userInput = "//;\n123";
        int result = specifyingDelimiter(userInput);
        assertEquals(4, result);
    }

}
