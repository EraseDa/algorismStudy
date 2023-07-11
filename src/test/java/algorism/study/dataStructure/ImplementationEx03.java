package algorism.study.dataStructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class ImplementationEx03 {
    /*문제 설명
    두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 
    중 공통이 되는 가장 작은 숫자를 의미합니다. 
    예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, 
    n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
    n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, 
    solution을 완성해 주세요.
    
    제한 사항
    arr은 길이 1이상, 15이하인 배열입니다.
    arr의 원소는 100 이하인 자연수입니다.*/
    @Test
    @DisplayName("N개의 최소공배수")
    void multiple(){
        int[] arr = {2,6,8,14};
        int[] copyArr = new int[arr.length];
        for(int i = 0; i<arr.length; i++) {
            copyArr[i] = arr[i];
        }//배열 복사. 기존 배열을 건드리지 않기 위해 복사해둠
        Arrays.sort(copyArr);

        for(int i = copyArr.length-1; i>0; i--) {
            //복사한 배열에 copyArr[i]와 copyArr[i-1]의 최대 공약수를 구함
            BigInteger big = BigInteger.valueOf(copyArr[i]);
            BigInteger small = BigInteger.valueOf(copyArr[i - 1]);
            //둘의 최소공배수를 구한 후, 복사한 배열의 [i-1]에 집어넣기
            copyArr[i-1] = big.multiply(small).divide(big.gcd(small)).intValue();
        }
    }

    /*DP문제
    * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
    * 칸이 총 4개 있을 때, 효진이는
        (1칸, 1칸, 1칸, 1칸)
        (1칸, 2칸, 1칸)
        (1칸, 1칸, 2칸)
        (2칸, 1칸, 1칸)
        (2칸, 2칸)의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
        * 멀리뛰기에 사용될 칸의 수 n이 주어질 때,
        * 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
        * 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
        * 예를 들어 4가 입력된다면, 5를 return하면 됩니다.*/

    @Test
    @DisplayName("멀리뛰기")
    void jump(){
        int n = 4;
        long[] arr = new long[n];
        //n==1일 경우 고려해야함 n==1이면 arr[1]은 에러
        arr[0] = 1;
        arr[1] = 2;
        for(int i = 2; i<arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        Assertions.assertThat(arr[n-1]).isEqualTo(5);
    }

}
