# 6198 : 옥상 정원 꾸미기 (골드5)
## 코드 설명
### 1. STACK 안쓰고 풀기

1. 빌딩 갯수 N에 입력 받음
2. N개 만큼 building 배열 생성
3. 0부터 N-1까지 반복하여 배열 탐색
4. tmp에 building[i] 값 저장
5. i+1부터 N-1까지 반복하여 배열 탐색
6. tmp보다 buliding[j]가 크거나 같으면 반복 종료 아니면 cnt++

### 2. STACK 쓰고 풀기

1. 빌딩 갯수 N에 입력 받음
2. N개 만큼 building 배열 생성
3. stack에 0 넣음, 비교할 칸 n 1으로 초기화
4. 만약 building[stack.peek]이 building[n]보다 작거나 같으면 pop 크면 break
5. stack.size 만큼 cnt에 더하기
6. N개 모두 비교하고 cnt 출력
