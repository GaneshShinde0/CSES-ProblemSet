package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class StringReorder {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String s = br.readLine();
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];
        for(char c:s.toCharArray()){

        }
        out.println(ans);
        out.close();
    }


    private static int[] readArrayFromLength() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}