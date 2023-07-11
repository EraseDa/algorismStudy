package algorism.study.dataStructure;

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
}
