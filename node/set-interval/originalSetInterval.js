/*
 * setInterval은 다른 interval이 running 되고 있는 동안에도
 * 또 다른 setInterval의 callback이 호출 될 수 있습니다.
 * 즉, 지정해놓은 interval보다 callback이 오래 걸리면,
 * 선행 작업이 끝나지도 않은채 또 다른 callback을 시작할 수도 있음.
 * https://developer.mozilla.org/en-US/docs/Web/API/WindowOrWorkerGlobalScope/setInterval#delay_restrictions
 */
setInterval(() => {
  doSomething();
}, interval);