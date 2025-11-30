#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, K;
int R, C;
int ans;

int notebook[42][42];
int sticker[12][12];
int cpy_sticker[12][12];

bool check(int x, int y) {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (notebook[x + i][y + j] == 1 && sticker[i][j] == 1) {
                return false;
            }
        }
    }
    return true;
}

void marking(int x, int y) {

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (sticker[i][j] == 1) {
                notebook[x + i][y + j] = 1;
            }
        }
    }
}

void rotattion() {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cpy_sticker[j][R - 1 - i] = sticker[i][j];
        }
    }

    swap(R, C);

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            sticker[i][j] = cpy_sticker[i][j];
        }
    }
}

void paste(int depth) {
    if (depth == 4) return;

    for (int i = 0; i <= N - R; i++) {
        for (int j = 0; j <= M - C; j++) {
            if (check(i, j)) {
                marking(i, j);
                return;
            }
        }
    }

    rotattion();
    paste(depth + 1);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;

    for (int i = 0; i < K; i++) {
        cin >> R >> C;
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                cin >> sticker[j][k];
            }
        }
        paste(0);
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (notebook[i][j]) ans++;
        }
    }
    cout << ans;

    return 0;
}