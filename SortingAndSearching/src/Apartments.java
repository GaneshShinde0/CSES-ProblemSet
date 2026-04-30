import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Apartments {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int[] arr = readArr(3);
        int n = arr[0], m = arr[1], k = arr[2];
        int[] applicants = readArr(n);
        int[] apartments = readArr(m);
        Arrays.sort(applicants);
        Arrays.sort(apartments);
        int res = 0;
        for(int i=0, j=0;i<n && j<m;i++){
            while(j<m && apartments[j]+k<applicants[i]){
                j++;
            }
            if(j<m && Math.abs(apartments[j]-applicants[i])<=k){
                res++;
                j++;
            }
        }
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
}
