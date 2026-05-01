import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class LongestCommonSubsequence {
    private static Reader reader = new Reader();
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int sLen = reader.nextInt(), tLen = reader.nextInt();
        int[] s = readArr(sLen);
        int[] t = readArr(tLen);
        int[][] dp = new int[sLen+1][tLen+1];
        long res = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sLen;i++){
            for(int j=0;j<tLen;j++){
                if(s[i]==t[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        int i = sLen, j=tLen;
        while(i>0 && j>0){
            if(s[i-1]==t[j-1]){
                sb.insert(0, s[i-1]+" ");
                i--;
                j--;
            }else if(dp[i-1][j]>=dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        res = dp[sLen][tLen];
        out.println(res);
        out.println(sb.toString().trim());
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
