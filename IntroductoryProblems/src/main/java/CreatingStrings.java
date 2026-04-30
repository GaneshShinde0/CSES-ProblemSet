
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CreatingStrings {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s = br.readLine();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = String.valueOf(arr);
        Set<String> set = new HashSet<>();
        permute(set,s,0);
        out.println(set.size());
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String word:list){
            out.println(word);
        }
        out.close();
    }

    private static void permute(Set<String> li, String s, int i) {
        if(s.length()==i){
            li.add(s);
        }else{
            for(int start= i;start<s.length();start++){
                s = swap(s,i,start);
                permute(li,s,i+1);
                s = swap(s,i,start);
            }
        }
    }
    private static String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return String.valueOf(arr);
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
