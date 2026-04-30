
import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        int[] arr = readArrayFromLength();
        long res = 0;
        int curr = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<curr){
                res+=curr-arr[i];
            }else{
                curr = arr[i];
            }
        }
        System.out.println(res);
    }


    private static int[] readArrayFromLength(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
