package chapter4;

import java.util.*;
import java.io.*;

public class BOJ2164카드게임{
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> deq = new ArrayDeque<>();

        for ( int i = 1; i < n+1; i++) {
            deq.addLast(i);
        }

        for (int i = 0; i < n-1; i++) {
            deq.pollFirst();
            deq.addLast(deq.pollFirst());

        }

        System.out.print(deq.peekLast());


    }
}