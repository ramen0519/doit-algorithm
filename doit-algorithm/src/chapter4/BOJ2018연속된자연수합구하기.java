package chapter4;

import java.util.*;

public class BOJ2018연속된자연수합구하기 {
    public static void main(String[] Args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] sum = new int[n+1];

        // 메모리 제한 조건 -> arr[]없이 바로 합구하기
        for ( int i = 1; i<=n; i++) {
            sum[i] = i + sum[i-1];
        }

        int start = 0;
        int end = 1;
        int count = 0;

        // end = start = n인 조건, 즉 엣지케이스 생각해볼것
        while (end <= n) {

            int rep = sum[end] - sum[start];

            if(rep == n) {
                count ++;
                end ++;
                continue;
            }
            else if (rep > n) {
                start++;
                continue;
            }
            else {
                end++;
                continue;
            }
        }

        System.out.print(count);
    }
}