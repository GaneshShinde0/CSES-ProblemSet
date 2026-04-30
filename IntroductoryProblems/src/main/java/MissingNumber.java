
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i=0;i<n-1;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(findMissingNumber(arr));
    }


    private static int findMissingNumber(int[] arr){
        boolean[] b = new boolean[arr.length+2];
        for(int i:arr){
            b[i]=true;
        }
        for(int i=1;i<=arr.length;i++){
            if(!b[i]) return i;
        }
        return arr.length+1;
    }

    private static int findMissingNumberUsingSetTLE(int[] arr){
        Set<Integer> set = new HashSet<>(arr.length);
        for(int i:arr){
            set.add(i);
        }
        for(int i=1;i<=arr.length;i++){
            if(!set.contains(i)) return i;
        }
        return arr.length+1;
    }
}
