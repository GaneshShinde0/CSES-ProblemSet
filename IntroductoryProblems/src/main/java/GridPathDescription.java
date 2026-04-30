import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GridPathDescription {
    static boolean[][] vis = new boolean[9][9];
    static char[] path;
    static int ans = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        path = br.readLine().toCharArray();

        // mark borders as visited → eliminates boundary checks
        for (int i = 0; i < 9; i++) {
            vis[0][i] = vis[8][i] = true;
            vis[i][0] = vis[i][8] = true;
        }

        dfs(1, 1, 0);
        System.out.println(ans);
    }

    static void dfs(int i, int j, int step) {

        // reached end
        if (i == 7 && j == 1) {
            if (step == 48) ans++;
            return;
        }

        // used all steps but not at end
        if (step == 48) return;

        // 🔥 split pruning (core logic)
        if (vis[i][j-1] && vis[i][j+1] && !vis[i-1][j] && !vis[i+1][j]) return;
        if (vis[i-1][j] && vis[i+1][j] && !vis[i][j-1] && !vis[i][j+1]) return;

        vis[i][j] = true;

        char c = path[step];

        if (c == '?' || c == 'R') {
            if (!vis[i][j+1]) dfs(i, j+1, step+1);
        }
        if (c == '?' || c == 'L') {
            if (!vis[i][j-1]) dfs(i, j-1, step+1);
        }
        if (c == '?' || c == 'U') {
            if (!vis[i-1][j]) dfs(i-1, j, step+1);
        }
        if (c == '?' || c == 'D') {
            if (!vis[i+1][j]) dfs(i+1, j, step+1);
        }

        vis[i][j] = false;
    }
}