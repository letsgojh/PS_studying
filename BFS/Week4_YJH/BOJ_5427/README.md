# 5427 : 불
## 코드 설명

1. 불! 문제와 같이 queue 두개 만들어서 bfs돌리기
2. 먼저 불_bfs를 먼저 돌린 후, person_bfs를 돌린다.
3. person_bfs를 돌리는 도중 만약 해당 지역에 불이 방문을 안했다면 원래자리 + 1 값 넣기
4. 만약 person_bfs를 돌리는 도중 해당 지역에 불이 방문을 했다면, 불이 방문하는데 걸린시간 보다 짧을 경우만 값 갱신

## 애로 사항

bufferedReader랑 bufferedWriter 사용해봤는데 이거 왜이리 어렵노
bw.write만 해서는 출력안되고, bw.flush로 버퍼 안에 있는거 싹다 비워줘야한다.
