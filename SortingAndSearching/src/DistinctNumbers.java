import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class DistinctNumbers {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int[] arr = readArrayFromLength();
        Set<Integer> set = new HashSet<>();
        for(int i:arr) set.add(i);
        System.out.println(set.size());
    }

    private static int[] readArrayFromLength(){
        try {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            return arr;
        }catch(Exception e){
            System.out.println("IOException");
        }
        return new int[]{-1,-1};
    }
}
