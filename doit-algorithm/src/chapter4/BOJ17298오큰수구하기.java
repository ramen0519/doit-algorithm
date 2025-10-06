package chapter4;

import java.util.*;
import java.io.*;

public class BOJ17298오큰수구하기{
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        Deque<Integer> deq = new ArrayDeque<>();

        for (int i =0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        deq.addLast(0);
        for( int i = 1; i < n; i++) {
            while( !deq.isEmpty() && arr[deq.peekLast()] < arr[i] ) {
                answer[deq.pollLast()] = arr[i];
            }
            deq.addLast(i);
        }

        while(!deq.isEmpty()) {
            answer[deq.pollLast()] = -1;
        }

        for ( int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}