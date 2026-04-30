
import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        print(n);
    }
    private static void print(long n){
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");
        while(n!=1){
            if(n%2==0){
                n/=2;
            }else{
                n=3*n+1;
            }
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
