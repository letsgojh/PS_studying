#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

void printAnswer(vector<int> answer, int M){
  for(int i=0;i<M;i++){
    cout << answer[i] << " ";
  }
  cout << endl;
}

void backtrack(vector<int> v, int N, int M,int count,int index,vector<int> answer){
  if(count==M){
    printAnswer(answer,M);
  }else{
    if(N-index+1 <M-count){
      return;
    }
    for(int i=index;i<=N;i++){
      vector<int> tem;
      copy(answer.begin(),answer.end(),back_inserter(tem));
      tem.push_back(i);
      backtrack(v,N,M,count+1,i+1,tem);
    }
  }
}

int main(void){
  int N,M;
  cin >> N >> M;
  vector<int> v(N+1);
  for(int i=1;i<=N;i++){
    v[i] = i;
  }
  for(int i=1;i<=N;i++){
    backtrack(v,N,M,1,i+1,vector<int>(1,i));
  }

}