#include <iostream>
#include <vector>
#include <algorithm> //copy ary
#include <cmath>
#include <cstring> //for memcpy


using namespace std;

int N = 0, M = 0;
int seen_by_cctv = 0;
int ans = 1e9;
int graph[8][8];


vector<pair<int,int>> cctvs;

vector<vector<vector<int>>> cctv_dirs = {
    {},
    {{0},{1},{2},{3}},                // 1번 CCTV
    {{0,2},{1,3}},                    // 2번 CCTV
    {{0,1},{1,2},{2,3},{3,0}},        // 3번 CCTV
    {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},// 4번 CCTV
    {{0,1,2,3}}                       // 5번 CCTV
};


int search_direction(int size){ //size : number of cctv, change direction into quaternary
    return pow(4,size);
}


void left_search(int y, int x,int record, int tmpgraph[8][8]){
    int tmp_y = y;
    int tmp_x = x-1;
    int count = 0;

    while(tmp_y >= 0 && tmp_x >=0 && tmp_y < N && tmp_x < M){
        if(tmpgraph[tmp_y][tmp_x] == -1){ //already other cctv record..
            tmp_x--;
            continue;
        }
        if(tmpgraph[tmp_y][tmp_x] >= 1 && tmpgraph[tmp_y][tmp_x] <=5){//이때 좌표 이동을 시키지 않아서 무한루
            tmp_x--;
            continue;
        }
        if(tmpgraph[tmp_y][tmp_x] == 6)
            break;

        if(record != 0) //0일때는 탐색용
            tmpgraph[tmp_y][tmp_x] = record;
        tmp_x--;
        count++;
    }
}

void right_search(int y, int x,int record,int tmpgraph[8][8]){
    int tmp_y = y;
    int tmp_x = x+1;
    int count = 0;

    while(tmp_y >= 0 && tmp_x >=0 && tmp_y < N && tmp_x < M){
        if(tmpgraph[tmp_y][tmp_x] == -1){ //already other cctv record..
            tmp_x++;
            continue;;
        }
        if(tmpgraph[tmp_y][tmp_x] >= 1 && tmpgraph[tmp_y][tmp_x] <=5){//이때 좌표 이동을 시키지 않아서 무한루
            tmp_x++;
            continue;
        }
        if(tmpgraph[tmp_y][tmp_x] == 6)
            break;

        if(record != 0) //0일때는 탐색용
            tmpgraph[tmp_y][tmp_x] = record;
        tmp_x++;
    }

}

void up_search(int y, int x,int record,int tmpgraph[8][8]){
    int tmp_y = y-1;
    int tmp_x = x;
    int count = 0;

    while(tmp_y >= 0 && tmp_x >=0 && tmp_y < N && tmp_x < M){
        if(tmpgraph[tmp_y][tmp_x] == -1){ //already other cctv record..
            tmp_y--;
            continue; //처음에 break했는데 그 뒤에 볼 게 더있을 수도 있으므로 continue
        }
        if(tmpgraph[tmp_y][tmp_x] >= 1 && tmpgraph[tmp_y][tmp_x] <=5){ //이때 좌표 이동을 시키지 않아서 무한루프
            tmp_y--;
            continue;
        }
        if(tmpgraph[tmp_y][tmp_x] == 6)
            break;

        if(record != 0) //0일때는 탐색용
            tmpgraph[tmp_y][tmp_x] = record;
        tmp_y--;
    }

}

void down_search(int y, int x, int record, int tmpgraph[8][8]){
    int tmp_y = y+1;
    int tmp_x = x;
    int count = 0;

    while(tmp_y >= 0 && tmp_x >=0 && tmp_y < N && tmp_x < M){
        if(tmpgraph[tmp_y][tmp_x] == -1){ //already other cctv record..
            tmp_y++;
            continue;
        }
        if(tmpgraph[tmp_y][tmp_x] >= 1 && tmpgraph[tmp_y][tmp_x] <=5){//이때 좌표 이동을 시키지 않아서 무한루
            tmp_y++;
            continue;
        }    
        if(tmpgraph[tmp_y][tmp_x] == 6)
            break;


        if(record != 0) //0일때는 탐색용
            tmpgraph[tmp_y][tmp_x] = record;
        tmp_y++;
    }

}

void search(){

    int cctv_direction = search_direction(cctvs.size());

    for(int i = 0; i<cctv_direction; i++){

        vector<int> dirs(cctvs.size());
        int mask = i;

        for(int k = 0; k<cctvs.size();  k++){
            dirs[k] = mask%4;
            mask /=4;
        }

        int tmp_graph [8][8];
        memcpy(tmp_graph, graph, sizeof(graph)); //make tmp graph

        for(int k = 0; k<cctvs.size(); k++){
            int y = cctvs[k].first;
            int x = cctvs[k].second;
            int cctv_type = graph[y][x];

            int dirIndex = dirs[k]%cctv_dirs[cctv_type].size();//add because of segfault..

            for(int d : cctv_dirs[cctv_type][dirIndex]){
                if(d == 0) up_search(y,x,-1,tmp_graph);
                if(d == 1) right_search(y,x,-1,tmp_graph);
                if(d == 2) down_search(y,x,-1,tmp_graph);
                if(d == 3) left_search(y,x,-1,tmp_graph);     
            }
        }

        int blind = 0;
        for(int y1 = 0; y1 < N; y1++){
            for(int x1 = 0; x1 < M; x1++){
                if(tmp_graph[y1][x1] == 0){
                    blind++;
                }
            }
        }

        ans = min(ans,blind);
    }
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;

    for(int i = 0; i<N; i++){
        for(int k = 0; k<M; k++){
            cin>>graph[i][k];

            if(graph[i][k] >= 1 && graph[i][k] <= 5){ //record cctv
                cctvs.push_back({i,k});
            }
        }
    }

    search();

    cout << ans;

    return 0;
}