package chapter4;

import java.util.*;
import java.io.*;

public class BOJ11660PrefixSum2D {
    public static void main(String[] Args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        // 2차원배열은 n+1으로 인덱스에 맞춰 직관적으로 사용한다
        int[][] sum = new int[n+1][n+1];
        int[][] arr = new int[n+1][n+1];
        int temp = 0;

        for(int i =1; i<=n; i++) {
            //매번 호출해서 바인딩한다
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                temp = Integer.parseInt(st.nextToken());
                //사각형 영역의 합 (중요)
                arr[i][j] = temp;
                sum[i][j] = sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+arr[i][j];
            }
        }

        int x1,y1,x2,y2,answer;

        for (int i =0; i<q; i++) {

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());


            answer = sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];
            bw.write(String.valueOf(answer) + "\n");


        }

        bw.flush();

    }
}
