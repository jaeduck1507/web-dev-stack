//DOMContentLoaded 이벤트는 html 문서의 구조가 완전히 로드된 후 발생
window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  // 클릭 이벤트
  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    //클릭 이벤트가 일어나면 행하고자 하는 코드 작성
    alert("클릭 이벤트 발생!");
    // click 색상 변경
    click.style.background = "black";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블 클릭 발생");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (e) => {
    alert("우클릭 발생");
    e.preventDefault(); // 우클릭방지
    console.log(e);
  });

  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    console.log("mouseenter");
    // 배경색상은 lightblue, 텍스트는 mouse Enter! 변경
    hover.style.background = "lightblue";
    hover.innerHTML = "mouse Enter!";
  });
  hover.addEventListener("mouseleave", () => {
    console.log("mouseleave");
    // 배경색상은 navy, 텍스트는 mouse leave! 변경
    hover.style.background = "navy";
    hover.innerHTML = "mouse leave!";
  });

  // 폼 이벤트
  // input 실시간 반영
  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    // console.log(e.target.value);
    inputResult.textContent = e.target.value;
  });

  // select 선택값 출력
  const selct = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  selct.addEventListener("change", (e) => {
    console.log(e.target.value);
    selectResult.textContent = e.target.value;
  });

  const form = document.querySelector("#form");
  const inputText = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    // 값이 없는경우만 전송 불가, 값이 있으면 전송
    if (inputText.value === "") e.preventDefault();
    console.log(inputText.value);
  });

  // 키 이벤트 : keydown, keypress, keyup
  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyResult");
  keyboard.addEventListener("keydown", (e) => {
    keyResult.textContent = e.key;
    if (e.key === "Enter") alert("엔터");
  });

  // 박스 움직이기
  const move = document.querySelector(".moveBox");
  let x = 0,
    y = 0;
  document.addEventListener("keydown", (e) => {
    console.log(e.key);
    // ArrowLeft ArrowUp ArrowRight ArrowDown
    if (e.key === "ArrowUp") {
      // top이 -인 경우
      y -= 5;
    } else if (e.key === "ArrowDown") {
      // top이 +인 경우
      y += 5;
    } else if (e.key === "ArrowLeft") {
      // left이 -인 경우
      x -= 5;
    } else if (e.key === "ArrowRight") {
      // left이 +인 경우
      x += 5;
    }

    move.style.top = `${y}px`;
    move.style.left = `${x}px`;

    // switch (e.key) {
    //   case "ArrowUp":
    //     // top이 -인 경우
    //     y -= 5;
    //     move.style.top = `${y}px`;
    //     break;
    //   case "ArrowDown":
    //     // top이 +인 경우
    //     y += 5;
    //     move.style.top = `${y}px`;
    //     break;
    //   case "ArrowLeft":
    //     // left이 -인 경우
    //     x -= 5;
    //     move.style.left = `${x}px`;
    //     break;
    //   case "ArrowRight":
    //     x += 5;
    //     move.style.left = `${x}px`;
    //     break;
    // }
  });

  // 스크롤 이벤트
  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  window.addEventListener("wheel", (e) => {
    // console.log(e.deltaY);
    // 휠을 올렸더니 -
    if (e.deltaY < 0) wheel.textContent = "휠 위로 스크롤 중";
    // 휠을 내렸더니 +
    else if (e.deltaY > 0) wheel.textContent = "휠 아래로 스크롤 중";
  });

  window.addEventListener("scroll", (e) => {
    // 전체 높이
    // console.log("scroll height : ", document.documentElement.scrollHeight);
    // 화면 보이는 높이
    // console.log("inner height : ", window.innerHeight);

    // console.log("scrolly : ", window.scrollY);
    // scrollHeight === innerHeight + scrollY
    // scrollHeight - innerHeight : 스크롤 총 내리는 높이
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    const percent = (window.scrollY / totalHeight) * 100;
    // console.log(percent);
    scroll.style.width = `${percent}%`;
  });

  //이벤트 위임
  // 이미지가 클릭될 때마다 해당 이미지 지우기
  // 1. 이미지마다 이벤트 걸려면 반복문 필요!
  //   const img = document.querySelectorAll(".container img");
  //   console.log(img);
  //   for (const i of img) {
  //     i.addEventListener("click", (e) => {
  //       //   i.style.display = "none";
  //       console.log(e.currentTarget);
  //       e.currentTarget.style.display = "none";
  //     });
  //   }

  // 2. 부모의 컨테이너에 이벤트 걸기

  const container = document.querySelector(".container");
  const removeHandler = (e) => {
    console.log(e.target); // 내가 클릭한 이미지
    console.log(e.currentTarget); // 이벤트 걸린 본인
    if (e.target !== e.currentTarget) {
      e.target.style.display = "none";
    }
  };
  container.addEventListener("click", removeHandler);
});
