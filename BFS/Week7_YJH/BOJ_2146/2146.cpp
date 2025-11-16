#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

#define MAX_SIZE 100

int N = 0;
int M = 1000000; //get minimum value
int graph[MAX_SIZE][MAX_SIZE];
int island[MAX_SIZE][MAX_SIZE]; //record island's area
int distance[MAX_SIZE][MAX_SIZE]; //distance between islands
std::queue<std::pair<int,int>> Q;
int dy[4] = {0,-1,0,1};
int dx[4] = {-1,0,1,0};



void distinguish_island(int y, int x, int island_num){
  Q.push({y,x});
  island[y][x] = island_num;

  while(!Q.empty()){
    std::pair<int,int> tmp = Q.front(); Q.pop();
    int y1 = tmp.first;
    int x1 = tmp.second;

    for(int i = 0; i<4; i++){
      int ny = y1 + dy[i];
      int nx = x1 + dx[i];

      if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if(island[ny][nx] > 0 ) continue;
      if(graph[ny][nx] == 1 && island[ny][nx] == 0){
        island[ny][nx] = island_num;
        Q.push({ny,nx});
      }
    }
  }
}

int record_distance(int island_num, int distance[MAX_SIZE][MAX_SIZE]){

  std::queue<std::pair<int,int>> Queue;

  for(int i = 0; i<N; i++){
    for(int k = 0; k<N; k++){
      if(island[i][k] == island_num){
        Queue.push({i,k});
        distance[i][k] = 0;
      }
    }
  }

  while(!Queue.empty()){
    std::pair<int,int> tmp = Queue.front(); Queue.pop();
    int y1 = tmp.first;
    int x1 = tmp.second;

    for(int i = 0; i<4; i++){
      int ny = y1 + dy[i];
      int nx = x1 + dx[i];

      if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if(graph[ny][nx] == 1 &&island[ny][nx] != island_num)
        return distance[y1][x1];
      
      if(graph[ny][nx] == 0 && distance[ny][nx] == -1){
        Queue.push({ny,nx});
        distance[ny][nx] = distance[y1][x1] + 1;
      }
    }
  }

  return 1e9;
  
}

int main(void){
  std::ios::sync_with_stdio(0);
  std::cin.tie(0);

  std::cin >> N;

  for(int i = 0; i<N; i++){
    for(int k = 0; k<N; k++){
      std::cin >> graph[i][k];
    }
  }

  int island_num = 1; //record island..

  for(int i = 0; i<N; i++){
    for(int k = 0; k<N; k++){
      if(graph[i][k] == 1 && island[i][k] == 0){
        distinguish_island(i,k,island_num);
        island_num++;
      }
    }
  }


  for(int i = 1; i<=island_num; i++){
    for(int i = 0; i<N; i++){
      std::fill(distance[i],distance[i] + N,-1);
    }
    
    int tmp = record_distance(i,distance);

    if(M >= tmp)
      M = tmp;
  }

  std::cout << M;

  return 0;
}