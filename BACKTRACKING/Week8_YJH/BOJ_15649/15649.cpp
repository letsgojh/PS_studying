#include <iostream>
#include <algorithm>

int result[9];
bool visited[9];
int N = 0,M = 0;

//tmp = index, i = 출력할 숫자
void recursive(int tmp){
    if(tmp == M+1){
        for(int i = 1; i<=M; i++){
            std::cout <<result[i] << " ";
        }
        std::cout <<"\n";
        return;
    }

    for(int i = 1; i<=N; i++){
        if(!visited[i]){
            visited[i] = true;
            result[tmp] = i;
            recursive(tmp+1);
            visited[i] = false;
        }
    }
}

int main(void){

    std::cin >> N >> M;
    std::fill(result,result+9,0);

    recursive(1);

    return 0;
}