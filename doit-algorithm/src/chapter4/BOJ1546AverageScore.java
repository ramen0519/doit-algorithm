package chapter4;

import java.util.*;

public class BOJ1546AverageScore {
    public static void main(String[] Args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        // 오타 제대로 확인
        double[] scores = new double[n];

        double max = 0;
        double sum = 0;

        for (int i =0; i<n; i++) {
            double temp = Double.parseDouble(sc.next());
            if (temp > max)
                max = temp;
            scores[i] = temp;
        }

        // 문제 조건 제대로 읽기 (*100 누락)
        for (int i =0; i<n; i++) {
            double temp = scores[i]/max*100;
            sum += temp;
        }

        System.out.print(sum/n);
    }
}
