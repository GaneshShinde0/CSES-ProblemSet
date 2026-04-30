
import java.util.Scanner;

public class Permutations {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = getInteger();
        if(n==1) System.out.println(1);
        else if(n<=3){
            System.out.println("NO SOLUTION");
        }else{
            StringBuilder sb = new StringBuilder();
            int temp = 2;
            while(temp<=n){
                sb.append(temp).append(" ");
                temp+=2;
            }
            temp = 1;
            while(temp<=n){
                sb.append(temp).append(" ");
                temp+=2;
            }
            System.out.println(sb.toString().trim());
        }
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
