// 바뀌는 텍스트 객체 생성자 함수
function TextAppend(say, who) {
  this.say = say;
  this.who = who;
}
// 한자리수 시간, 분, 초 두자리로 변환 함수
function isOver10(num) {
  if (num < 10) return `0${num}`;
  else return num;
}

// 태그 호출
const day = ["일", "월", "화", "수", "목", "금", "토"]; // now.getDay()로 인덱스 지정
const now = new Date(); // 현재 시각
const newyear = new Date(now.getFullYear() + 1, 0, 1, 0, 0, 0); // 내년 1월 1일 0시 0분
const main = document.querySelector("#main");
const ymd = document.querySelector("#ymd");
const timer = document.querySelector("#timer");
const remain = document.querySelector("#remain");
const say = document.querySelector("#say");
const who = document.querySelector("#who");

// 남은 시간 계산을 위한 초기값
const remainTime = parseInt((newyear.getTime() - now.getTime()) / 1000); // 얼마나 남은지 시간 체크
const remainS = remainTime % 60; // 몇초 남은지
const remainM = parseInt(remainTime / 60); //초를 분으로 표현
const remainMin = remainM % 60; // 몇분 남은지
const remainH = parseInt(remainM / 60); //분을 시간으로 표현
const remainHour = remainH % 24; // 몇시간 남은지
const remainDay = parseInt(remainH / 24); // 몇일 남은지

// 초기 화면 표시
// 초기 화면 : 현재 시간 및 남은 시간
ymd.textContent = `${now.getFullYear()}년 ${
  now.getMonth() + 1
}월 ${now.getDate()}일 (${day[now.getDay()]})`;
timer.textContent = `${isOver10(now.getHours())}:${isOver10(
  now.getMinutes()
)}:${isOver10(now.getSeconds())}`;

remain.textContent = `올해 남은 시간 ${remainDay}일 ${isOver10(
  remainHour
)}시간 ${isOver10(remainMin)}분 ${isOver10(remainS)}초`;

// 바뀌는 텍스트 100개의 객체 생성(texList 배열에 담아 관리)
const textList = [];
for (let i = 0; i < 100; i++) {
  textList.push(new TextAppend(`say something ${i}`, `who ${i}`));
}

// 바뀌는 텍스트 초기화면 표시
const randomIndex = Math.floor(Math.random() * 101);
say.textContent = textList[randomIndex].say;
who.textContent = textList[randomIndex].who;

let count = 0; // 3초마다 화면 전환을 위한 변수

// 실시간 화면 갱신(1초)
setInterval(() => {
  const now = new Date(); // 현재 시각 1초 단위로 호출 (Date를 계속 호출해줘야 실시간 시간 반영 가능)
  // 현재 시각 실시간
  ymd.textContent = `${now.getFullYear()}년 ${
    now.getMonth() + 1
  }월 ${now.getDate()}일 (${day[now.getDay()]})`;
  timer.textContent = `${isOver10(now.getHours())}:${isOver10(
    now.getMinutes()
  )}:${isOver10(now.getSeconds())}`;

  // 남은 시간 실시간
  const remainTime = parseInt((newyear.getTime() - now.getTime()) / 1000);
  const remainS = remainTime % 60; // 몇초 남은지
  const remainM = parseInt(remainTime / 60); //초를 분으로 표현
  const remainMin = remainM % 60; // 몇분 남은지
  const remainH = parseInt(remainM / 60); //분을 시간으로 표현
  const remainHour = remainH % 24; // 몇시간 남은지
  const remainDay = parseInt(remainH / 24); // 몇일 남은지

  remain.textContent = `올해 남은 시간 ${remainDay}일 ${isOver10(
    remainHour
  )}시간 ${isOver10(remainMin)}분 ${isOver10(remainS)}초`;

  // 4초 단위로 실행되는 부분
  count++;
  if (count === 4) {
    count = 0; // 4초 후 count 초기화로 다시 카운트
    // main의 배경색 rgb 모두 랜덤한 0~255값으로 지정
    main.style.backgroundColor = `rgb(${Math.floor(
      Math.random() * 256
    )},${Math.floor(Math.random() * 256)},${Math.floor(Math.random() * 256)})`;

    // 바뀌는 텍스트 (실시간)
    const randomIndex = Math.floor(Math.random() * 100); // 0~99 랜덤 인덱스
    // 바뀌는 랜덤 텍스트 표시
    say.textContent = textList[randomIndex].say;
    who.textContent = textList[randomIndex].who;
    console.log("랜덤 인덱스 번호 : " + randomIndex);
  }
}, 1000);
