package chapter4;

import java.util.*;
import java.io.*;

public class BOJ1940주몽의명령 {
    public static void main(String[] Args) throws IOException {

        // 입력값 n이 10000개 넘어가므로 버퍼리더 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for ( int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int count = 0;

        while (start != end) {

            int rep = arr[start] + arr[end];

            if (rep == sum){
                count ++;
                start++;
                continue;
            }

            if (rep > sum) {
                end --;
                continue;
            }

            if (rep < sum) {
                start++;
            }
        }

        System.out.print(count);
    }
}
