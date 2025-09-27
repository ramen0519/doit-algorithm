package chapter4;

import java.util.*;
import java.io.*;

public class BOJ1253좋다 {
    public static void main(String[] Args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;

            while (start < end) {
                if (start == i) { // target 자신은 제외
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }

                int sum = arr[start] + arr[end];

                if (sum == arr[i]) {
                    count++;
                    break; // arr[i]는 "좋다" 확정
                } else if (sum < arr[i]) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.print(count);
    }
}
