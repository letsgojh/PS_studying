#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int v[9];
bool visited[9];

void dfs(int depth){
	if (depth == m) {
		for (int i = 0; i < m; i++) {
			cout << v[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			visited[i] = true;
			v[depth] = i;
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}

int main() {
	cin >> n >> m;
	dfs(0);
}
