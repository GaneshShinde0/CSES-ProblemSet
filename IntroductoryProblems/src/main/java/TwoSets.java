
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSets {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine().trim());
        long sum = n*(n+1)/2;
        if(sum%2!=0){
            out.println("NO");
        }else{
            out.println("YES");
            List<Long> set1 = new ArrayList<>();
            List<Long> set2 = new ArrayList<>();
            long target = sum/2;
            for(long i=n;i>=1;i--){
                if(target>=i){
                    target-=i;
                    set1.add(i);
                }else{
                    set2.add(i);
                }
            }
            out.println(set1.size());
            for(long x:set1) out.print(x+" ");
            out.println();
            out.println(set2.size());
            for(long x:set2) out.print(x+" ");
        }
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
