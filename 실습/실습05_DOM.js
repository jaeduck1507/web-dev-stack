import quotes from "./quotes.js";

// 바뀌는 텍스트 객체 생성자 함수
function TextAppend(say, who) {
  this.say = say;
  this.who = who;
}
// 한자리수 시간, 분, 초 두자리로 변환 함수
function isOver10(num) {
  //string.padStart(채울공간수, '뭘로 채울것인가')
  if (num < 10) return `0${num}`;
  else return num;
}

//실시간 시간
const nowtime = () => {
  const day = ["일", "월", "화", "수", "목", "금", "토"]; // now.getDay()로 인덱스 지정
  const now = new Date(); // 현재 시각
  const newyear = new Date(now.getFullYear() + 1, 0, 1, 0, 0, 0); // 내년 1월 1일 0시 0분

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
};

// 배경색 변경
const randomBg = () => {
  main.style.backgroundColor = `rgb(${Math.floor(
    Math.random() * 256
  )},${Math.floor(Math.random() * 256)},${Math.floor(Math.random() * 256)})`;
};

// 바뀌는 텍스트 초기화면 표시
const randomText = () => {
  const randomIndex = Math.floor(Math.random() * 101);
  say.textContent = textList[randomIndex].say;
  who.textContent = textList[randomIndex].who;
};

//태그 호출
const main = document.querySelector("#main");
const ymd = document.querySelector("#ymd");
const timer = document.querySelector("#timer");
const remain = document.querySelector("#remain");
const say = document.querySelector("#say");
const who = document.querySelector("#who");

//랜덤 텍스트 생성
const textList = [];
for (let i = 0; i < 100; i++) {
  textList.push(new TextAppend(`say something ${i}`, `who ${i}`));
}

nowtime();
randomBg();
randomText();
let count = 0; // 3초마다 화면 전환을 위한 변수

// 실시간 화면 갱신(1초)
setInterval(() => {
  nowtime();
  // 4초 단위로 실행되는 부분
  count++;
  if (count === 4) {
    randomBg();
    randomText();
    count = 0; // 4초 후 count 초기화로 다시 카운트
    // main의 배경색 rgb 모두 랜덤한 0~255값으로 지정
  }
}, 1000);
