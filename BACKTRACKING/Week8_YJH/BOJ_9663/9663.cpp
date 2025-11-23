#include <iostream>
#include <algorithm>
#include <math.h>

bool isused1[40]; //열 확인
bool isused2[40]; //우측 대각선 확인
bool isused3[40]; //좌측 대각선 확인
int N = 0;
int ans = 0;

//tmp는 몇번째 줄인지
void N_Queen(int tmp){
    if(tmp == N+1){
        ans++;
        return;
    }

    for(int i = 1; i<=N; i++){
        //열,좌,우 대각선 방문표시
        if(isused1[i] || isused2[i+tmp]||isused3[std::abs(tmp-i+N)]) //방문했을경우
            continue;
        
        isused1[i] = true;
        isused2[i+tmp] = true;
        isused3[std::abs(tmp-i+N)] = true;
        N_Queen(tmp+1);
        isused1[i] = false;
        isused2[i+tmp] = false;
        isused3[std::abs(tmp-i+N)] = false;
    }
}

int main(void){
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);
    std::cin >> N;
    std::fill(isused1,isused1+40,false);
    std::fill(isused2,isused2+40,false);
    std::fill(isused3,isused3+40,false);


    N_Queen(1);

    std::cout <<ans;
    return 0;
}