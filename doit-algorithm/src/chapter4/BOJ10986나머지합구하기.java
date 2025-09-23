package chapter4;


import java.util.*;
import java.io.*;

public class BOJ10986나머지합구하기 {
    public static void main(String[] Args) throws IOException {

        // 입력 n의 개수가 너무 커져서 Scanner쓰면 시간 초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        //오버플로우 고려
        long[] sum = new long[n];
        long[] remainder = new long[x];

        for(int i = 0; i<n; i++) {
            if(i == 0)
                sum[i] = Integer.parseInt(st.nextToken());
            else
                sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        long answer = 0;

        /*
         (중요)remainder는 인덱스에 의미를 부여하여 활용 -> 서로 같은 개수를 for문으로 돌리면 n*2
         인덱스 자체가 나머지이고 인덱스의 값이 나머지가 같은 값의 개수
         */
        for (int i = 0; i<n; i++) {
            long rep = sum[i] % x;
            if (rep == 0)
                answer ++;
            // rep가 index로 사용됨. index는 무조건! int여야함. long x
            remainder[(int)rep]++;
        }

        // 모듈 공식 활용은 그냥 암기하자 + s[i] - s[j] = 부분합
        for (int i = 0; i<x; i++){
            long y = remainder[i];
            if (y > 1){
                answer += y*(y-1)/2;
            }
        }

        System.out.print(answer);

    }
}
