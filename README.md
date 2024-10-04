# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 목록 (TODO)

- [ v ] 사용자 입력 받기 (자동차 대수, 시도 회수)
- [ v ] 입력된 값이 유효하지 않은 경우(숫자가 아님 or 자동차가 2대 미만 or 시도 회수가 0이하) 재입력 받기
- [ v ] 0~9 사이 랜덤값 생성
- [ v ] 전진 여부 확인 (생성된 랜덤값 기준) - 4이상이면 전진, 4미만이면 정지
- [ v ] 자동차별 상태 초기화(생성)
- [ v ] 자동차 전진
- [ v ] 자동차 상태 출력
- [ v ] 경주 시작
- [ v ] 자동차 대수 대신 자동차 이름 입력
  - 쉼표(,)로 구분해서 자동차 이름 리스트 추출
  - 기존 자동자 대수는 자동차 이름 개수로 대체
- [ v ] 자동차 상태 출력 시 이름도 같이 출력
- [ v ] 우승자 집계
  - 우승자는 한명 이상일 수 있음
- [ v ] 우승자 출력
  - 자동차 이름을 쉼표(,)로 구분해서 우승자 출력
