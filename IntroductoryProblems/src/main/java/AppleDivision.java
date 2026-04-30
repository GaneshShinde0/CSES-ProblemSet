
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class AppleDivision {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] arr = readArrayFromLength();
        long sum = 0, ans = Long.MAX_VALUE, n = arr.length;
        for (int i : arr) sum += i;
        for (int i = 0; i < (1 << n); i++) {
            long currSum = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) currSum += arr[j];
            }
            ans = Math.min(ans, Math.abs(sum-2*currSum));
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