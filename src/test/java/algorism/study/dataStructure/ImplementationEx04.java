package algorism.study.dataStructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ImplementationEx04 {

    @Test
    @DisplayName("점 찍기")
    void pointCount(){
        int k = 2;
        int d = 4;
        ArrayList<Long> front= new ArrayList<>();
        ArrayList<Long> back= new ArrayList<>();

        for(long a=0;a*k<=d ;a++) {
            //ath.pow(d,2) - Math.pow(a*k,2) 얘를 제곱근으로 만들어
            //그리고 b*k를 <=제곱근 형태로 넣어
            long line = (long)Math.floor(Math.sqrt(Math.pow(d,2)-Math.pow(a*k,2)));
            for(long b=0;b*k<=line;b++) {
                    front.add(a*k);
                    back.add(b*k);

            }
        }
    }

    @Test
    @DisplayName("카펫")
    void carpet(){
        int brown = 10;
        int yellow = 2;
        int sum = brown + yellow;

        int[] answer = new int[2];
        int width=0, height=0;
        for(int i=1; ;i++) {
            if((brown/2 - i +2)%1 ==0) {
                width=i;
                height = brown/2 - width + 2;

                if(width*height==sum) {
                    answer[0] = height;
                    answer[1] = width;
                    break;
                }
            }
        }
        Assertions.assertArrayEquals(new int[]{4, 3},answer);
    }
}

