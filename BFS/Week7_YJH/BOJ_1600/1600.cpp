#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>

#define MAX_MOVE 31
#define MAX_SIZE 200

//반례
//2
//10 2
//0 0 1 0 0 1 0 0 1 0
//0 0 1 1 0 0 0 0 1 0

int K = 0, W = 0, H = 0,horse_move_cnt = 0;
int horse_y[8] = {-1,-2,-2,-1,1,2,2,1};
int horse_x[8] = {-2,-1,1,2,2,1,-1,-2}; //설정 잘못해서 한참 찾음..하..
int dy[4] = {0,-1,0,1};
int dx[4] = {-1,0,1,0};
int graph[MAX_SIZE][MAX_SIZE];
int distance[MAX_MOVE][MAX_SIZE][MAX_SIZE];
std::queue<std::tuple<int,int,int>> Q;

void bfs(){

    Q.push({0,0,0});
    distance[0][0][0] =1;

    while(!Q.empty()){
        std::tuple<int, int,int> tmp = Q.front(); Q.pop();
        int z1 = std::get<0>(tmp);
        int y1 = std::get<1>(tmp);
        int x1 = std::get<2>(tmp);

        if(z1 < K){    
            for(int i = 0; i<8; i++){
                int ny = y1 + horse_y[i];
                int nx = x1 + horse_x[i];

                if(ny < 0 || nx < 0 || ny >= H || nx >= W) {
                    //std::cout << "1\n";
                    continue;
                }
                if(graph[ny][nx] == 1){
                     continue;
                }
                if(distance[z1+1][ny][nx]){ 
                    continue; //already exists..
                }
                distance[z1+1][ny][nx] = distance[z1][y1][x1] + 1;
                Q.push({z1+1,ny,nx});
            }
        }

        for(int i = 0; i<4; i++){
            int ny = y1 + dy[i];
            int nx = x1 + dx[i];

            if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
            if(graph[ny][nx] == 1) continue;
            if(distance[z1][ny][nx]) continue;
            distance[z1][ny][nx] = distance[z1][y1][x1] + 1;
            Q.push({z1,ny,nx});
        }
    }
}


int main(void){
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);

    std::cin >> K;
    std::cin >> W >> H;


    for(int i = 0 ; i<H; i++){
        for(int k = 0; k<W; k++){
            std::cin >> graph[i][k];
        }
    }

    int ans = 1e9;
    bfs();

    for(int i = 0; i<=K; i++){
        if(distance[i][H-1][W-1]){
            if(ans >= distance[i][H-1][W-1])
                ans = distance[i][H-1][W-1];
        }
    }

    if(ans == 1e9)
        std::cout << -1;
    else
        std::cout << ans-1;

    return 0;
}