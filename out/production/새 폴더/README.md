# PS_STUDY
- 코딩 테스트 대비를 위한 알고리즘 스터디 저장소
- 업로드한 BOJ, Programmers, LeetCode 문제를 풀고 풀이과정을 공유하며 성장하는 것을 목표로 한다.
- 1주일에 각자 3문제씩 업로드하며, 총 3문제를 푼다.(추가적인 문제 업로드 가능)
- 풀이 소스코드와 풀이를 설명할 readme 파일을 함께 업로드한다.
- baaaarking dog님이 만든 문제집과 강의 영상을 참고한다.

- 문제집 링크 : https://github.com/letsgojh/basic-algo-lecture/blob/master/workbook.md

- 강의 링크 : https://www.youtube.com/watch?v=LcOIobH7ues&list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&index=1


## Folder structure

`[문제유형]/[주차_이름]/[플랫폼이름_문제번호]` 구조를 사용한다.

```
├─.idea
└─BFS #문제유형
    ├─Week1_YJH #주차_이름
    │  ├─BOJ_1926 #플랫폼이름_문제번호
    │  ├─BOJ_2178
    │  │  ├─.vscode
    │  │  ├─src
    │  │  │  ├─ Main.java #문제풀이 소스코드
    │  │  │  ├─ README.md #문제풀이 설명

```


## Conventions

#### File naming
`{name}-{platform}-{문제번호 || 문제이름}`
모두 대문자로 작성
  > ex) KDH-BOJ-10828.cpp, KDH-LEET-29.cpp, KDH-PROG-전화번호목록.cpp

#### Branch naming
`{NAME}/{create || modify || ...}-{platform}-{(문제번호)}`
  > ex) KDH/create-boj-2126

#### Commit message
```
{NAME}: {create || modify || ...} {platform} {문제번호}

ex) 
1576 : create baekjoon 1576

- 기타 변경사항 명시
...
```

1. 추가한 파일 목록을 모두 작성한다.
2. 소스코드, 실행파일, readme 파일 모두 commit한다.
3. 수정 작업을 수행했으면 어떤 부분을 수정했는지 commit message에 명시한다.

#### PR title naming
`{NAME}: {create || modify || ...} {platform} {(문제번호)} {문제이름}`
  > ex) KDH/create-boj-2346 풍선 터뜨리기

## 💪 Commit & PR request

1. `{NAME}/{create || modify || ...}-{platform}-{(문제번호)}` 형식의 branch 생성
   
2. 생성된 branch 내에서 `[문제유형]/[platform_문제 번호]/[이름]` 디렉토리 생성 후 **풀이 코드 및 리뷰 readme 파일** 생성

3. 문제 풀이 완료 시 Pull Request 생성
   - PR 제목: `{NAME}/{create || modify || ...}-{platform}-{(문제번호)} {문제이름}`


## 📖 Code Review

- baekjoon 상위 랭크 실력자들의 코드와 비교/대조