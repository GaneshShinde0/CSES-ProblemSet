import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class EditDistance {
    private static Reader reader = new Reader();
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        char[] s = reader.readLine().toCharArray();
        char[] t = reader.readLine().toCharArray();
        int sLen = s.length, tLen = t.length;
        int[][] dp = new int[sLen+1][tLen+1];
        for(int i=0;i<=sLen;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=tLen;i++){
            dp[0][i] = i;
        }
        long res = 0;
        for(int i=0;i<sLen;i++){
            for(int j=0;j<tLen;j++){
                if(s[i]==t[j]) dp[i+1][j+1]=dp[i][j];
                else{
                    dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1]))+1;
                }
            }
        }
        res = dp[sLen][tLen];
        out.println(res);
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

        public String readLine() throws IOException{
            StringBuilder sb = new StringBuilder();
            int c = read();
            while(c=='\n'|| c== '\r'){
                c = read();
            }
            while(c!=-1 && c!= '\n' && c !='\r'){
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

}
