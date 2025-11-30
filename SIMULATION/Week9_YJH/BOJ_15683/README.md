# 15683 : 감시
## 코드 설명
1. 먼저 그래프를 돌며 cctv의 좌표 기록
2. 전체 cctv의 방향 경우의 수를 4진수로 표현하기 ex) cctv 3개라면 4*4*4 = 64개의 방향 (물론 2번과 5번 cctv는 방향 2개지만 편의를 위해 4방향으로 한다.)(search_direction)
3. search_direction의 값을 4로 나눌때 마다 각 값이 각 cctv의 방향을 의미한다. 
4. cctv_dirs의 index마다 각 cctv에 해당하는 방향을 삽입한다 ex)  cctv_dirs[1][1] = 1, cctv_dirs[1][2] = 2, cctv_dirs[5][1] = {0,1,2,3} =>각 index에 맞게 반복문 돌릴 수 있도록
5. cctv_dirs에 맞는 각 index의 탐색을 up_search,down_search,right_search,left_search로 조진 후, 보았다고 -1로 기록한다(이때 원본을 회수하지 않고 원본 copy해서 기록)(경우의 수가 너무 많기때문)
6. 각 경우의 수 그래프 탐색하며, 0이 가장 적을때 출력

## 애로 사항
1. for(int d : cctv_dirs[cctv_type][dirIndex]) 여기 원래 코드가 for(int d : cctv_dirs[cctv_type][dirs[k]])였는데, 5번같은 방향은 index가 1개밖에 없는데 다른 index참조 하여 segmentation fault발생함. 따라서 dirIndex 코드를 추가

2. search는 리팩토링이 가능한데 너무 귀찮아서 안했다..(만드는게 더귀찮은가?ㅋㅋ)

3. ~_search 하는거에서 -1이 발견되면(이미 기록되었을경우) break했는데, 그 뒤에도 더 볼 것이 남아 있을 수 있기 때문에 continue로 바꿔주었다.

4. 하 그냥 개어려웠다. 코드 다시 짤 수 있을지 의문이다.