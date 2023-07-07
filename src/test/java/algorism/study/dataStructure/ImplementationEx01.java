package algorism.study.dataStructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ImplementationEx01 {


    @Test
    @DisplayName("각 문자열을 배열에 담기")
    void stringToArray(){
        String test = "안녕하세요";
        char[] charArray = test.toCharArray();

        charArray.toString();
    }

    @Test
    @DisplayName("성적 조작하기")
    void averageChange(){
        int num = 3;
        int [] arr = {40,80,60};
        Arrays.sort(arr);
        int max = arr[num-1];
        double sum = 0;

        for(int i=0; i<num; i++) {
            sum += (arr[i]/(double)max)*100;
        }
        Assertions.assertThat(sum/num).isEqualTo(75);
    }
}
