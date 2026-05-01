import java.io.*;

public class CountingRoomsBFS {
    // 1. Static queue to prevent Memory Limit Exceeded (MLE)
    private static int[] qR, qC;
    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int m = reader.nextInt();
        int n = reader.nextInt();

        // 2. 2D array is fine, but read rows directly to save time
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = reader.readRow(n);
        }

        // 3. Use two 1D arrays for the queue to avoid division/modulo
        qR = new int[m * n];
        qC = new int[m * n];

        int rooms = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    rooms++;
                    bfs(grid, i, j, m, n);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(rooms);
        out.close();
    }

    private static void bfs(char[][] grid, int startR, int startC, int m, int n) {
        int head = 0, tail = 0;

        qR[tail] = startR;
        qC[tail] = startC;
        tail++;

        grid[startR][startC] = '#';

        while (head < tail) {
            int r = qR[head];
            int c = qC[head];
            head++;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Boundary check + Visited check
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '.') {
                    grid[nr][nc] = '#';
                    qR[tail] = nr;
                    qC[tail] = nc;
                    tail++;
                }
            }
        }
    }

    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din = new DataInputStream(System.in);
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;

        public int nextInt() throws IOException {
            int ret = 0; byte c = read();
            while (c <= ' ') c = read();
            do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }

        public char[] readRow(int n) throws IOException {
            char[] res = new char[n];
            byte c = read();
            while (c <= ' ') c = read();
            for (int i = 0; i < n; i++) {
                res[i] = (char) c;
                if (i < n - 1) c = read();
            }
            return res;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
