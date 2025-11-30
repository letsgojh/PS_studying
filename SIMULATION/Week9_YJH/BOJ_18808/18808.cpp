#include <iostream>
#include <vector>

using namespace std;

int N, M, K;
int sticker_row = 0, sticker_col = 0;
int graph[40][40];

bool canAttach(int y, int x, vector<pair<int,int>>& sticker){
    for(auto &p : sticker){
        int ny = y + p.first;
        int nx = x + p.second;
        if(ny < 0 || ny >= N || nx < 0 || nx >= M) return false;
        if(graph[ny][nx] == 1) return false;
    }
    return true;
}

void attach(int y, int x, vector<pair<int,int>>& sticker){
    for(auto &p : sticker){
        graph[y + p.first][x + p.second] = 1;
    }
}

vector<pair<int,int>> rotation(vector<pair<int,int>>& sticker, int &R, int &C){
    vector<pair<int,int>> ret;
    for(auto &p : sticker){
        ret.push_back({ p.second, R - 1 - p.first });
    }
    swap(R, C);
    return ret;
}

int main(){

    cin >> N >> M >> K;

    for(int i = 0; i<K; i++){
        cin >> sticker_row >> sticker_col;

        vector<pair<int,int>> sticker_move;

        for(int y = 0; y < sticker_row; y++){
            for(int x = 0; x < sticker_col; x++){
                int v;
                cin >> v;
                if(v == 1) 
                    sticker_move.push_back({y, x});
            }
        }

        bool place = false;
        int R = sticker_row;
        int C = sticker_col;

        for(int rot = 0; rot < 4; rot++){
            for(int y = 0; y <= N - R; y++){
                for(int x = 0; x <= M - C; x++){
                    if(canAttach(y, x, sticker_move)){
                        attach(y, x, sticker_move);
                        place = true;
                        break;
                    }
                }
                if(place) break;
            }
            if(place) break;
            sticker_move = rotation(sticker_move, R, C);
        }
    }

    int answer = 0;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(graph[i][j] == 1) answer++;
        }
    }
    cout << answer;

    return 0;
}
