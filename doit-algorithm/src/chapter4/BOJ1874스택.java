package chapter4;

import java.util.*;
import java.io.*;

public class BOJ1874스택 {
    public static void main(String[] Args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); // 출력은 여기 쌓아두기
        int num = 1;      // 다음에 push할 숫자
        boolean result = true;

        for (int i = 0; i < n; i++) {
            int su = A[i];

            if (su >= num) {
                // 아직 안 넣은 숫자라면, su까지 push
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                // 이미 push된 숫자라면, 스택 top 확인
                int top = stack.pop();

                if (top > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if (result) {
            System.out.println(sb.toString());
        }
    }
}
