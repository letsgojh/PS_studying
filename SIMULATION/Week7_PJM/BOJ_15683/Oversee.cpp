#include <iostream>
#include <vector>
#include <algorithm>
#define UP 0
#define LEFT 1
#define DOWN 2
#define RIGHT 3

using namespace std;

int answer = 65;
vector<int> cctv;
int N, M;
vector< vector<int> > originalMap;
int drow[] = {-1, 0, 1, 0};
int dcol[] = {0, -1, 0, 1};

vector< vector< vector<int> > > moveCctv={ //moveCctv[CCTV_Number][방법수][방향]
  {{0},{1},{2},{3}}, //1번
  {{0,2},{1,3}}, // 2번
  {{0,1},{1,2},{2,3},{3,0}}, // 3번
  {{0,1,2},{1,2,3},{2,3,0},{3,0,1}}, // 4번
  {{0,1,2,3}} // 5번
};

bool isRoad(int row, int col){
  if(row<0 || row >=N){
    return false;
  }
  if(col<0 || col >=M){
    return false;
  }
  if(originalMap[row][col]==6){
    return false;
  }
  return true;
}

void check_sight(int row, int col, int direction, vector<vector<int>>& curMap) {
  // UP, LEFT, DOWN, RIGHT 순서
  while (true) {
      row += drow[direction];
      col += dcol[direction];

      if (!isRoad(row, col)) break;
      
      if (curMap[row][col] == 0) {
          curMap[row][col] = 7; //감시한 영역
      }
  }
}
void dfs(int cctv_idx, vector<vector<int>> curMap) {
  if (cctv_idx == cctv.size()) {
      int tem = 0;
      for (int row = 0; row < N; row++) {
          for (int col = 0; col < M; col++) {
              if (curMap[row][col] == 0) tem++;
          }
      }
      answer = min(answer, tem);
      return;
  }

  int row = cctv[cctv_idx]/M;
  int col = cctv[cctv_idx]%M;
  int cctvType = curMap[row][col]-1;
  for (int i = 0; i < moveCctv[cctvType].size(); i++) {
      vector<vector<int>> nextMap = curMap;
      for (int dir=0;dir<moveCctv[cctvType][i].size();dir++) {
          check_sight(row, col, moveCctv[cctvType][i][dir], nextMap);
      }
      dfs(cctv_idx + 1, nextMap);
  }
}

int main(void){
  ios_base :: sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> N >> M;
  originalMap = vector< vector<int> >(N, vector<int>(M,0));
  for(int i=0;i<N;i++){
    for(int j=0;j<M;j++){
      cin >> originalMap[i][j];
      if((originalMap[i][j] !=0) && (originalMap[i][j] !=6)){
        cctv.push_back(M*i+j);
      }
    }
  }
  dfs(0,originalMap);

  cout << answer;
}