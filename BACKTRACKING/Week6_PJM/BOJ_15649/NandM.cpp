#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


void backtrack(vector<char> v, int N, int M,int count,string answer){
  if(count == M){
    cout << answer << '\n';
  }
  for(int i=1;i<=N;i++){
    if(answer.find(v[i])==string::npos){
      backtrack(v,N,M,count+1,answer+" "+v[i]);
    }
  }
}

int main(void){
  int N,M;
  cin >> N >> M;
  vector<char> v(N+1);
  string answer ="";
  for(int i=1;i<=N;i++){
    v[i] = i+'0';
  }
  for(int i=1;i<=N;i++){
    backtrack(v,N,M,1,string(1,v[i]));
  }
}