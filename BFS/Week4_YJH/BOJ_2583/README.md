# 2583 : 영역 구하기
## 코드 설명

1. 사각형 중 색칠된 곳 + 방문한 곳은 왼쪽 하단에 1표시를 하여 하나만 표시하였다.
ex) 0 0 -> 이러면 왼쪽 하단 사각형이 색칠된 것
    1 0
2. 기존에 알던 왼쪽->오른쪽, 위->밑 으로 가는 index가 아닌, 왼쪽->오른쪽, 밑 ->위 로 가는 index이므로
좌표를 변환시켜 주었다.
=> 새로운 y좌표 = M - start_y,  새로운 x좌표 = start_x(x좌표는 변함이 없다)
3. 그 이외는 평범한 bfs이다..

## 애로 사항
0. index가 기존에 알고있던 2차원 배열과 바뀌어서 혼란스러웠다.
1. ArrayList를 정렬할때는 Collection 클래스의 sort 메서드를 사용하면된다.
ex) Collections.sort(List);
2. 아니면 Arrays 클래스의 sort를 사용해도 된다(사실 이게 더 편함)
ex) Arrays.sort(List)
3. 기본적으로 두 메서드 전부 오름차순 정렬이지만, 내림차순 정렬을 할때 Collections 클래스의 sort 메서드는 비교연산자 포함시켜줘야한다.
4. Arrays 클래스의 sort 메서드는 Collections.reverseOrder()을 두번째 인자로 넣어주면된다.
ex) Arrays.sort(List, Collections.reverseOrder());