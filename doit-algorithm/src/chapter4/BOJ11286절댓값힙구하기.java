package chapter4;

import java.util.*;
import java.io.*;

public class BOJ11286절댓값힙구하기 {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) ->{
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB)
                        return a-b;
                    else
                        return absA - absB;
                }
        );

        int n = Integer.parseInt(st.nextToken());
        int rep;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rep = Integer.parseInt(st.nextToken());
            if (rep == 0){
                if (pq.isEmpty())
                    bw.write(0 + " \n");
                else
                    bw.write(pq.poll() + " \n");
            }
            else
                pq.add(rep);
        }

        bw.flush();
        bw.close();
    }
}