#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int answer =0;
int cols[15];
bool promising(int level){
  for(int i=0;i<level;i++){
    if(cols[i]==cols[level] || abs(cols[level]-cols[i])==level -i){
      return false;
    }
    
  }
  return true;
}

void backtracking(int row, int N){
  if(row==N){
    answer++;
    return;
  }
  for(int i=0;i<N;i++){
    cols[row]=i;
    if(promising(row)){
      backtracking(row+1,N);
    }
  }
}

int main(){
  int N;
  cin >> N;
  backtracking(0,N);
  cout<< answer;
}