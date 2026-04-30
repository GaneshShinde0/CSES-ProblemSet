
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberSpiral {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] a = new long[2];
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long max = Math.max(x,y);
            long ans;
            if(max%2==0){
                if(y==max){
                    ans = max*max-x+1;
                }else{
                    ans = (max-1)*(max-1)+y;
                }
            }else{
                if(x==max){
                    ans = max*max-y+1;
                }else{
                    ans = (max-1)*(max-1)+x;
                }
            }
            out.println(ans);
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
