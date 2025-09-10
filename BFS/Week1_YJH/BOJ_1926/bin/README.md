# 1926 : 그림
## 코드 설명

1. bfs 기본 문제
2. 도화지의 그림 저장하는 graph 이차원 배열과, 방문 여부를 기록하는 visited 이차원 배열 생성
3. 전체 graph를 순환하며 graph값이 1이며, 방문하지 않은 부분에 bfs를 돌리며 maxPictureSize를 기록
4. 총 그림의 개수를 기록하기 위해 bfs 끝난 후 pictureNum 1증가