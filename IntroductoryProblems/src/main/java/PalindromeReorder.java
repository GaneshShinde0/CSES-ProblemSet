
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PalindromeReorder {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s = br.readLine();
        int[] freq = new int[128];
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        int ones = 0;
        for(int i=0;i<128;i++){
            if(freq[i]%2==1) ones++;
            if(ones>1){
                out.println("NO SOLUTION");
                out.close();
                return;
            }
        }
        char single = ' ';
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<128;i++){
            if(freq[i]%2==1){
                single = (char)i;
            }
            sb.append(((char)i+"").repeat(freq[i]/2));
        }
        String reverse = sb.reverse().toString();
        sb.reverse();
        if(single!=' ') sb.append(single);
        sb.append(reverse);
        out.println(sb);
        out.close();
    }

    private static int getInteger(){
        return sc.nextInt();
    }
    private static int[] readArrayFromLength(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
