#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;
bool visited[9];
int v[9];
int res[9];


void backtracking(int depth) {
	if (depth == m) {
		bool check = false;
		for (int i = 1; i < m; i++) {
			if (v[i] < v[i - 1]) {
				check = true;
				break;
			}
		}
		if (check == false) {
			for (int i = 0; i < m; i++) {
				cout << v[i] << " ";
			}
			cout << "\n";
		}
		return;
	}
	else {
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				v[depth] = i;
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}
}
int main() {
	cin >> n >> m;
	backtracking(0);
}