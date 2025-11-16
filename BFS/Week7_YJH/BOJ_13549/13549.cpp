#include <iostream>
#include <queue>
#include <algorithm>

#define MAX_SIZE 100001
int N = 0,M = 0;


int distance[MAX_SIZE];

void print_distance(){
    for(int i =0 ; i<21; i++){
        std::cout << distance[i] << " ";
    }
    std::cout << "\n";
}

void move_fast(int num,std::queue<int> &Queue){
    int tmp = num;
    if(!tmp) return; //0인경우 무한루프이므로
    while(tmp <= 100000 &&!distance[M]){
        if(!distance[tmp]){ //if not visited

            distance[tmp] = distance[num];
            Queue.push(tmp);

            if(tmp == M) return;
        }
        tmp *=2; 
    }
}

void bfs(std::queue<int> &Queue){

    while(!distance[M]){
        int tmp = Queue.front(); Queue.pop();

        std::vector<int> v = {tmp+1,tmp-1}; //이렇게 하여 우선순위가 밀리지 않게 한다
        //ex) 4 6-> 이미 queue에는 4 8 16 32 ... 쌓여있음
        //3과 5를 엄청 나중에 처리
        //하지만 38번 line을 통해 우선순위 앞당기기
        //또한 다른방식으로 처리시 4 6 반례를 처리하지 못함(더 작은 값이 나오는 것을 캐치하지 못하고 종료하므로)

        for(int ele : v){
            //print_distance();
            if(ele < 0 || ele >100000) continue;
            if(distance[ele]) continue;

            distance[ele] = distance[tmp]+1;
            Queue.push(ele);
            move_fast(ele,Queue);
        }
    }
}

int main(void){
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);

    std::queue<int> Queue;
    std::cin >> N >> M;
    std::fill(distance,distance+MAX_SIZE,0);

    distance[N] = 1;
    Queue.push(N);
    move_fast(N,Queue);
    bfs(Queue);

    std::cout << distance[M]-1;

    return 0;
}