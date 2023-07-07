package algorism.study.dataStructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(answer).isEqualTo("1 4");
    }

/*
길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)

예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면

A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
즉, 이 경우가 최소가 되므로 29를 return 합니다.

배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
 */


    @Test
    @DisplayName("정확성은 검증했으나 효율성 실패")
    void makeMin(){
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        int length = A.length;
        int sum = 0;

        Arrays.sort(A);
        Integer[] array = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        for(int i=0; i<length; i++) {
            sum += A[i] * array[i];
        }
        assertThat(sum).isEqualTo(29);
    }

    @Test
    @DisplayName("컬렉션 없이 풀기")
    void makeMin02(){
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        int length = A.length;
        int sum = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<length; i++) {
            int j=length-1-i;
            sum += A[i]*B[j];
        }
        assertThat(sum).isEqualTo(29);
    }
}
