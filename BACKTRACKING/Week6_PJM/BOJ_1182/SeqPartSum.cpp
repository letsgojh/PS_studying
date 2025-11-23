#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int answer =0;
void backtracking(vector<int> v,int index,int N,int S,int cur_sum){
  if(index==N){
    if(cur_sum == S){
      answer++;
    }
    return;
  }
  backtracking(v,index+1,N,S,cur_sum+v[index]);
  backtracking(v,index+1,N,S,cur_sum);
}

int main(void){
  int N,S;
  cin >> N >> S;
  vector<int> v(N);
  for(int i=0;i<N;i++){
    cin >> v[i];
  }
  backtracking(v,0,N,S,0);
  if(S==0){
    answer--;
  }
  cout << answer;
}