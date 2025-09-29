package chapter4;

import java.util.*;
import java.io.*;

public class BOJ12891DNA비밀번호 {
    public static void main(String[] Args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        // index에 의미부여해서 count하기
        int[] count = new int[4];
        int[] min = new int[4];

        st = new StringTokenizer(br.readLine());
        // for문 타이핑할 시간 줄일 수 있다.
        char[] arr = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        for (int i =0; i <w; i++) {
            if ( arr[i] == 'A')
                count[0]++;
            else if ( arr[i] == 'C' )
                count[1]++;
            else if ( arr[i] == 'G' )
                count[2]++;
            else if ( arr[i] == 'T' )
                count[3]++;
        }

        int answer = 0;

        /*
        bool bigger = true;
        for (int i = 0; i < 4; i++) {
            if (count[i] < min[i]) {
                bigger = false;
            }
        }

        if (bigger)
            answer ++;
         */
        answer ++;
        for (int i = 0; i < 4; i++) {
            if (count[i] < min[i]) {
                answer --;
                break;
            }
        }

        // 공통적인 부분은 static 메서드로 만들어보자. add(char[], char), sub(char[], char)
        for ( int i = w; i < n; i++) {
            if ( arr[i] == 'A')
                count[0]++;
            else if ( arr[i] == 'C' )
                count[1]++;
            else if ( arr[i] == 'G' )
                count[2]++;
            else if ( arr[i] == 'T' )
                count[3]++;

            if ( arr[i-w] == 'A')
                count[0]--;
            else if ( arr[i-w] == 'C' )
                count[1]--;
            else if ( arr[i-w] == 'G' )
                count[2]--;
            else if ( arr[i-w] == 'T' )
                count[3]--;

            answer ++;
            for (int j = 0; j < 4; j++) {
                if (count[j] < min[j]) {
                    answer --;
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}