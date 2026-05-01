import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class RevisitDiceCombinations {
    private static Reader reader = new Reader();
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int n = reader.nextInt();
        int[] dp = new int[n+1];

        long t1 = 1;
        long t2 = 2;
        if(n==1) out.println(t1);
        else if (n==2) out.println(t2);
        else{
            int sub = 0;
            for(int i=3;i<=n;i++){
                if(i>6){
                    sub = 2*sub+1;
                }
                t2 = (t2*2-sub)%MOD;
            }
        }
        out.println(t2);
        out.close();
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
