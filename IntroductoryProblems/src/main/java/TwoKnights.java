
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoKnights {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        for(int k=1;k<=n;k++){
            long totalPos = k*k;

            // first can be placed at totalPos and secondCan be placed at (totalPos-1)
            // They are interchangable so /2
            long howManyWaysKnightCanBePlaced = (totalPos*(totalPos-1))/2;
            if(k>2){
                // They can attack each other only when the grid given is of size(3,2) or (3,2)
                // Knights attack within 2*3 and 3*2 rectangles; there are 2(k-1)(k-2) of each type, totaling 4(k-1)(k-2) subtractions.
                howManyWaysKnightCanBePlaced-=4*(k-1)*(k-2); // Subtracting Positions Where Knight Can Attack Each Other.

            }
            out.println(howManyWaysKnightCanBePlaced);
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
