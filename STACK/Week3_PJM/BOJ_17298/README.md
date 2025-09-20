### 문제 설명(오큰수 - 17298) - 골드 4
> 수열의 각 원소 Ai에 대해서 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 구하는 프로그램.
> 예시 A=[3,5,2,7] answer [5,7,7,-1]

### 코드
1. stack, int배열 2개 사용(입력값, 출력값 저장)
2. 초기에 stack에 0을 집어 넣고 시작
3. 입력값배열[index] > 입력값배열[stack.top] 일 때, 입력값배열[index] < 입력값배열[stack.top] 이 될 때 까지 pop해서 answer[stack.top()]에 arr[index]저장 이후에 stack에 index추가
4. 그 외에 경우 stack에 index 저장
5. stack에 남아있는 인덱스들 기준으로 answer 모두 -1로 초기화

