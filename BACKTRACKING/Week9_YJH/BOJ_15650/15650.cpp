#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N = 0, M = 0;

int main(void){
    cin >> N >> M;
    vector<bool> ary(N);
    fill(ary.begin(),ary.begin()+M,true);


    do{
        for(int i = 0; i<N; i++){
            if(ary[i])
                cout << i+1 << " ";
        }
        cout <<"\n";

    }while(prev_permutation(ary.begin(),ary.end()));

    return 0;
}