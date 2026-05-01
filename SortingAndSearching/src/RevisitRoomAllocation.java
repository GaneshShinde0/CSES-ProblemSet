import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RevisitRoomAllocation {
    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int n = reader.nextInt();
        int[][] arrivalAndLeave = new int[n][2];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=0;i<n;i++){
            arrivalAndLeave[i] = readArr(2);
            int a = arrivalAndLeave[i][0];
            int l = arrivalAndLeave[i][1];
            tm.put(a,tm.getOrDefault(a,0)+1);
            tm.put(l,tm.getOrDefault(l,0)-1);
        }
        Arrays.sort(arrivalAndLeave,(a, b)->Integer.compare(a[1],b[1]));
        int res = 0;
        int curr = 0;
        for(Map.Entry<Integer, Integer> e:tm.entrySet()){
            curr+=e.getValue();
            res = Math.max(curr, res);
        }
        out.println(res);
        res = 0;
        curr = 0;
        int room = 0;
        for(Map.Entry<Integer, Integer> e:tm.entrySet()){
            curr+=e.getValue();
//            res = Math.max(curr, res);
            out.print(((room)%res+1)+" ");
            if(e.getValue()==1){
                room++;
            }

        }
//        int room = 0;
//        int dep = arrivalAndLeave[0][1];
//        for(int i=0;i<n;i++){
//            int a = arrivalAndLeave[i][0];
//            int l = arrivalAndLeave[i][1];
//            out.print(((room)%res+1)+" ");
//            if(a<dep){
//                room++;
//            }
//            dep = l;
//        }
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
