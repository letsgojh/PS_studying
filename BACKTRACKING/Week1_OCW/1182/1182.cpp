#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, s;
int cnt;
int arr[21];
bool visited[21];
int res = 0;
void backtracking(int depth) {
	if (depth == n) {
		int cnt = 0, check = 0;
		for(int i = 0 ; i < n; i++){
			if (visited[i] == false) {
				check += arr[i];
				cnt++;
			}
		}
		if (check == s && cnt!=0) res++;
		return;
	}
	else{
			visited[depth] = true;
			backtracking(depth + 1);
			visited[depth] = false;
			backtracking(depth + 1);
	}
}

int main() {
	cin >> n >> s;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];

	}
	
	backtracking(0);
	cout << res;
}