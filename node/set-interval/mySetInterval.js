/*
 * setTimeout을 재귀적으로 호출하여 사용자 정의 setInterval을 선언하여, 순서 보장.
 * setTimeout은 지정해놓은 시간만큼 대기 후 작업을 진행하기 때문에, 
 * 재귀적으로 호출하게 되면 setInterval과 달리 선행 작업이 끝나고 interval만큼 기다린 뒤에 실행 됨.
 */
const mySetInterval = () => {
  setTimeout(() => {
    doSomething();
    mySetInterval();
  }, interval);
};