import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConcertTickets {
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] ticketPrice = readArr(n);
        int[] maxPrice = readArr(m);
        TreeMap<Integer, Integer> tickets = new TreeMap<>();
        for (int ticket:ticketPrice) {
            tickets.put(ticket, tickets.getOrDefault(ticket, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            Integer bestTicket = tickets.floorKey(maxPrice[i]);
            if (bestTicket == null) {
                out.println("-1");
            } else {
                out.println(bestTicket);
                int count = tickets.get(bestTicket);
                if (count == 1) {
                    tickets.remove(bestTicket);
                } else {
                    tickets.put(bestTicket, count - 1);
                }
            }
        }
        out.close();
    }
//    private static int[] readArr() {
//        String[] s = null;
//        try {
//            s = br.readLine().split(" ");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        int[] arr = new int[s.length];
//        for (int i = 0; i < s.length; i++) {
//            arr[i] = Integer.parseInt(s[i]);
//        }
//        return arr;
//    }

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
