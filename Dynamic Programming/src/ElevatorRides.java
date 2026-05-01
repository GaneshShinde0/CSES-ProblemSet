import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class ElevatorRides {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int[] arr= readArr();
        int n = arr[0], x = arr[1];
        int[] weights = readArr();
        Arrays.sort(weights);
        int res = 0;
        int left = 0, right = n-1;
        int box = x;
        while(left<=right){
            while(right>=0 && weights[right]<=box){
                box-=weights[right];
                weights[right]=-1;
                right--;
            }
            while(left<n && weights[left]<=box){
                box-=weights[left];
                weights[left]=-1;
                left++;
            }
            box=x;
            res++;
        }
        if((left<n && weights[left]!=-1) || (right>=0 && weights[right] !=-1)) res++;
        System.out.println(res);
    }

    private static int[] readArrayFromLength(){
        try {
            int n = Integer.parseInt(br.readLine());
            int[] arr = readArr(n);
        }catch(Exception e){
            System.out.println("IOException");
        }
        return new int[]{-1,-1};
    }

    private static int[] readArr(int n) {
        int[] arr = new int[n];
        String[] s = null;
        try {
            s = br.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }
    private static int[] readArr() {
        String[] s = null;
        try {
            s = br.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }
}
