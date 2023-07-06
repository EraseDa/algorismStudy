package algorism.study.dataStructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImplementationEx01 {


    @Test
    @DisplayName("각 문자열을 배열에 담기")
    void stringToArray(){
        String test = "안녕하세요";
        char[] charArray = test.toCharArray();

        charArray.toString();
    }


}
