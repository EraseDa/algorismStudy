package algorism.study.dataStructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ImplementationEx02 {

/*문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
*/
    @Test
    @DisplayName("최소값과 최대값 출력")
    void returnMaxMin(){
        String s = "1 2 3 4";
        String[] sNum = s.split("\\s+");
        int[] num = new int[sNum.length];
        for(int i=0; i<sNum.length; i++) {
            num[i] = Integer.parseInt(sNum[i]);
        }
        Arrays.sort(num);
        String min = num[0]+"";
        String max = num[sNum.length-1] + "";

        String answer = min + " " + max;

        Assertions.assertThat(answer).isEqualTo("1 4");
    }

}
