package chapter4;

import java.util.*;
import java.io.*;

public class BOJ11659PrefixSum {
    // br, bw에서는 IOException 꼭 처리하기
    public static void main(String[] Args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //st 매번 선언하지 않기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int[] arr = new int[n1];
        int[] s = new int[n1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0)
                s[i] = arr[i];
            else
                s[i] = s[i-1] + arr[i];
        }

        for(int i =0; i<n2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            if(start == 0)
                System.out.println(s[end]);
            else
                System.out.println(s[end]-s[start-1]);
        }
    }
}
