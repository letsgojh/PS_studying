# 9663 : N-Queens (골드 5)
## 코드 설명

1. board를 1차원 배열로 생성 (board[a]=b -> a:row, b:col)
2. 재귀함수 nQueen으로 한 줄 씩 검사
3. a 열에 놓을 수 있는 위치인지 check 함수로 확인
4. check 함수가 True 반환 시 다음 열 검사