#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, s;
int cnt;
int arr[21];
int column[16];
int res = 0;

bool check(int row) {
	for (int i = 0; i < row; i++) {
		if (column[row] == column[i]
			|| row - i == abs(column[row] - column[i])) {
			return false;
		}
	}
	return true;
}

void backtracking(int depth) {
	if (depth == n) {
		res++;
		return;
	}
	else{
		for (int i = 0; i < n; i++) {
			column[depth] = i;
			if (check(depth)) {
				backtracking(depth+1);
			}

		}
	}
}

int main() {
	cin >> n;
	backtracking(0);
	cout << res;
}