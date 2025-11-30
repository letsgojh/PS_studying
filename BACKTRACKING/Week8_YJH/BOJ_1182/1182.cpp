#include <iostream>
#include <algorithm>

int ary[21];
bool vis[21]; //방문체크
int N = 0, S = 0;
int ans = 0; //전체 부분수열 개수

void recursive(int n, int tmp){
    if(tmp == N){ //전부 다 방문했을때
        if(n == S) //S와 같다면, 그러나 공집합은 제외 =>여기서 걸러버리면 S가 0일때는 하나도 못찾음
            ans++;
        return;
    }
    recursive(n,tmp+1); //ary[tmp] 원소를 포함하지 않는경우
    recursive(n+ary[tmp],tmp+1); //ary[tmp] 원소를 포함하는경우
}

int main(void){
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);
    
    std::fill(ary,ary+21,0);
    std::fill(vis,vis+21,false);

    std::cin >> N >> S;

    for(int i = 0; i<N; i++)
        std::cin >> ary[i];

    int tmp = 0; //방문횟수 체크

    recursive(0,tmp);

    if(S == 0) ans--;
    std::cout << ans;

    return 0;
}