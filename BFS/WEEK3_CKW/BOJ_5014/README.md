# 스타트링크 (실버1) - BFS
## 코드 설명

Queue.poll + U, Queue.poll - D 가 조건에 위배되지않는 경우 add
G랑 같으면 count[tmp] 출력

### 조건
- 조건 1 : count배열(queue.poll+U 같이 변화된 값)이 더 커야함, 이유 : 만약 count가 더 작은 경우에는 더 적은 버튼 클릭으로 그 수에 도달하는 최적 수가 존재한다는 뜻이기 때문
- 조건 2 : visit배열이 false인 경우, 이유 : bfs니까 방문한 수는 굳이 다시 방문할 필요 없음
