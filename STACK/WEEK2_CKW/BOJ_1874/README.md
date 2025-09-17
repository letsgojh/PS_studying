# 1874 : 스택 수열 (실버2)
## 코드 설명

1. 정수 갯수 n 입력받음
2. 정수 갯수만큼 배열에 정수 저장
3. 스택의 push는 오름차순으로 한다고 했으므로 정수 a 생성(1씩 더해서 push할 변수)
4. stack이 비어있으면 ++a push 하고 ans에 + 추가
5. stack.peek 가 num[i]가 같다면 pop하고 ans에 - 추가
6. 다르면 ++a push하고 ans에 + 추가
7. 만약에 a가 n보다 커진다면 반복 종료
8. stack에 남은게 있으면 "NO" 출력
9. stack에 남은거 없으면 ans 출력

## 애로 사항

1. BufferedWriter 썼는데 출력 초과 발생
2. String ans로 해봤는데 메모리 초과 발생
3. Stringbuilder 를 사용하니 해결됐다