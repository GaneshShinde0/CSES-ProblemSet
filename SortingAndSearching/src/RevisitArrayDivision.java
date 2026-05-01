import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RevisitArrayDivision {
    private static Reader reader = new Reader();

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int n = reader.nextInt();
        int x = reader.nextInt();
        int[] arr = readArr(n);
        int sum = Arrays.stream(arr).sum();
        int size = (sum+x)/x;
        int currSum = 0;
        int maxSum = 0;
        int groups = 1;
        for(int i:arr){
            currSum+=i;
            if(groups==(x)){
                maxSum = Math.max(maxSum, currSum);
            }else if(currSum>size){
                currSum = i;
                groups++;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        out.println(maxSum);
        out.close();
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
