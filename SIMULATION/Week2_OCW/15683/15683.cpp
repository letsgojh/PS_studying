#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int room[8][8];
vector<pair<int, int>> cctv;
int ans = 987654321;

int dx[4] = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 (시계방향)
int dy[4] = { 1, 0, -1, 0 };

vector<int> dir[6] = { {}, {0}, {0, 2}, {0, 3}, {0, 2, 3}, {0, 1, 2, 3} };

void check(int x, int y, int direct) {
    direct %= 4;

    while (1) {
        int n_x = x + dx[direct];
        int n_y = y + dy[direct];

        if (n_x < 0 || n_y < 0 || n_x >= N || n_y >= M) break;
        if (room[n_x][n_y] == 6) break;
        if (room[n_x][n_y] == 0) room[n_x][n_y] = 7;

        x = n_x;
        y = n_y;
    }
}

void dfs(int depth) {
    if (depth == cctv.size()) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 0) cnt++;
            }
        }
        ans = min(ans, cnt);
        return;
    }

    int x = cctv[depth].first;
    int y = cctv[depth].second;
    int type = room[x][y];

    int backup[8][8];

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                backup[j][k] = room[j][k];
            }
        }

        for (int j = 0; j < dir[type].size(); j++) {
            check(x, y, dir[type][j] + i);
        }

        dfs(depth + 1);

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                room[j][k] = backup[j][k];
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> room[i][j];
            if (room[i][j] != 0 && room[i][j] != 6)
                cctv.push_back({ i,j });
        }
    }

    dfs(0);
    cout << ans << '\n';

    return 0;
}