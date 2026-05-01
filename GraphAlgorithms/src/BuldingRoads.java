import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuldingRoads {

    static class UnionFind{
        int[] parent;
        int[] rank;
        int count;
        UnionFind(int n){
            this.count = 0;
            this.rank = new int[n];
            this.parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x]!=x) parent[x]=find(parent[x]);
            return parent[x];
        }
        void union(int x, int y){
            int xPar = find(x), yPar = find(y);
            if(xPar==yPar) return;
            else if(rank[xPar]<rank[yPar]){
                parent[xPar]=yPar;
            }else if(rank[yPar]<rank[xPar]){
                parent[yPar]=xPar;
            }else{
                parent[yPar]=xPar;
                rank[xPar]++;
            }
            count++;
        }
    }
    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int n = reader.nextInt();
        int e = reader.nextInt();
        UnionFind uf = new UnionFind(n);

        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i]= readArr(2);
            uf.union(edges[i][0]-1,edges[i][1]-1);
        }
        out.println(Math.max(n-uf.count-1,0));
        Set<Integer> parSet = new HashSet<>();
        for(int i=0;i<n;i++)parSet.add(uf.find(uf.parent[i]));
        List<Integer> parList = new ArrayList<>(parSet);
        int start  = parList.get(0)+1;
        for(int i=1;i<parList.size();i++){
            out.println(start+" "+(parList.get(i)+1));
        }
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
