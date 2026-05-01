import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RevisitCollectingNumbers2 {
    private static Reader reader = new Reader();

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] arr = readArr(n);
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],i);
        }
        int rounds = 0,curr=1;
        while(curr<=n){
            int pos = hm.get(curr);
            while(curr<n && hm.get(curr+1)>pos){
                pos = hm.get(curr+1);
                curr++;
            }
            curr++;
            rounds++;
        }
        for(int i=0;i<m;i++){
            int start = reader.nextInt()-1;
            int end = reader.nextInt()-1;
            if(arr[start]<arr[end]){
                rounds++;
            }else{
                rounds--;
            }
//            swap(arr,start, end);
            out.println(rounds);
        }
        out.close();
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static Map<Integer, Integer> getFrequencyHashMapFromArray(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        return hm;
    }

    private static int[] readArr(int n) {
        if (reader == null) reader = new Reader();
        try {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }
            return arr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Custom Reader class for fast input
    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        // Reads the next integer from input
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        // Reads the next byte from the buffer
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        // Fills the buffer with new data
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
    }

}
