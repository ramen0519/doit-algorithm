package chapter4;

import java.util.*;
import java.io.*;

public class BOJ11003_최솟값찾기_슬라이딩윈도우_덱 {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deq = new LinkedList<>();

        for ( int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!deq.isEmpty() && deq.getLast().value > now) {
                deq.removeLast();
            }

            deq.addLast(new Node(now, i));

            if(deq.getFirst().index <= i - len) {
                deq.removeFirst();
            }

            bw.write(deq.getFirst().value + " " );
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}