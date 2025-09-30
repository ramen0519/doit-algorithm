package chapter4;

import java.util.*;
import java.io.*;

public class Main {
    public static void BOJ11003최솟값찾기_슬라이딩윈도우 (String Args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        int[] count = new int[n]
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int rep = Integer.parseInt(st.nextToken());
            arr[i] = rep;
        }

        int min = arr[0];

        for (int i = 0; i < len; i++) {
            if (arr[i] < min)
                min = arr[i];
            bw.write(min + " ");
        }

        for (int i = len; i < n; i++) {
            int rep = Math.min(arr[i], arr[i-len+1]);
            if (rep < min)
                min = rep;
            bw.write(min + " ");
        }

        bw.flush();
        bw.close();
    }
}
