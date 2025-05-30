const id = document.querySelector("#id");
const pwd = document.querySelector("#pwd");
const pwdIsSame = document.querySelector("#pwdIsSame");
const koname = document.querySelector("#koname");
const email = document.querySelector("#email");
const callNum = document.querySelector("#callNum");
const idText = document.querySelector("#idText");
const pwdText = document.querySelector("#pwdText");
const pwdIsSameText = document.querySelector("#pwdIsSameText");
const konameText = document.querySelector("#konameText");
const emailText = document.querySelector("#emailText");
const callNumText = document.querySelector("#callNumText");
const newB = document.querySelector("#newB");
const cancel = document.querySelector("#cancel");

// 사용자 정보 객체 생성
const idObj = {
  content: id,
  text: idText,
  regExp: /^[a-zA-Z][a-zA-Z\d]{3,11}$/,
  check: false,
  textContent: "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내",
};

const pwdObj = {
  content: pwd,
  text: pwdText,
  regExp: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/,
  check: false,
  textContent: "영문자, 숫자, 특수문자 조합으로 8~15자 이내",
};

const pwdIsSameObj = {
  content: pwdIsSame,
  text: pwdIsSameText,
  regExp: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/,
  check: false,
  textContent: "위 비밀번호와 동일하게",
};

const konameObj = {
  content: koname,
  text: konameText,
  regExp: /^[가-힣]{2,}$/,
  check: false,
  textContent: "한글 2자 이상",
};

const emailObj = {
  content: email,
  text: emailText,
  regExp: /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/,
  check: false,
  textContent: "이메일 형식",
};

const callNumObj = {
  content: callNum,
  text: callNumText,
  regExp: /^010-\d{4}-\d{4}$/,
  check: false,
  textContent: "전화번호 형식",
};

const objList = [idObj, pwdObj, pwdIsSameObj, konameObj, emailObj, callNumObj]; // 객체 배열 생성

// 입력 이벤트 핸들러
const checkHandler = (e, obj, n) => {
  obj.check = false;

  if (e.target.value) {
    if (obj.content.id !== pwdIsSameObj.content.id) {
      if (obj.regExp.test(e.target.value)) {
        obj.text.innerHTML = "OK";
        obj.text.classList.add("green");
        obj.text.classList.remove("red");
        obj.check = true;
      } else {
        obj.text.innerHTML = obj.textContent;
        obj.text.classList.add("red");
        obj.text.classList.remove("green");
      }
    } else {
      if (
        pwdObj.content.value === e.target.value &&
        objList[n - 1].check === true
      ) {
        obj.text.innerHTML = "OK";
        obj.text.classList.add("green");
        obj.text.classList.remove("red");
        obj.check = true;
      } else {
        obj.text.innerHTML = obj.textContent;
        obj.text.classList.add("red");
        obj.text.classList.remove("green");
      }
    }
  } else {
    obj.text.innerHTML = obj.textContent;
    obj.text.classList.remove("green");
    obj.text.classList.remove("red");
  }
  if (obj.content.id === pwdObj.content.id) {
    if (pwdIsSameObj.content.value !== "") {
      objList[n + 1].check = false;
      if (pwdIsSameObj.content.value === e.target.value && objList[n].check) {
        pwdIsSameObj.text.innerHTML = "OK";
        pwdIsSameObj.text.classList.add("green");
        pwdIsSameObj.text.classList.remove("red");
        objList[n + 1].check = true;
      } else {
        pwdIsSameObj.text.innerHTML = pwdIsSameObj.textContent;
        pwdIsSameObj.text.classList.add("red");
        pwdIsSameObj.text.classList.remove("green");
      }
    }
  }
  clickJoin();
};

// 회원 가입 버튼 활성화 조건 (모든 입력을 정확하게 입력했을때)
const clickJoin = () => {
  for (const i of objList) {
    if (!i.check) {
      newB.setAttribute("disabled", "disabled");
      newB.setAttribute("style", "background-color: darkgray;;");
      break;
    }

    newB.removeAttribute("disabled");
    newB.setAttribute("style", "background-color: aqua;");
  }
};

// 입력 이벤트 처리
for (let i = 0; i < objList.length; i++) {
  objList[i].content.addEventListener("input", (e) => {
    checkHandler(e, objList[i], i);
  });
}

// 초기화 이벤트 처리
cancel.addEventListener("click", () => {
  for (const i of objList) {
    i.text.innerHTML = i.textContent;
    i.text.classList.remove("green");
    i.text.classList.remove("red");
    i.check = false;
  }
  clickJoin();
});

newB.addEventListener("click", () => {
  localStorage.setItem(
    id.value,
    JSON.stringify({
      pwd: pwd.value,
      koname: koname.value,
      email: email.value,
      callNum: callNum.value,
    })
  );

  location.href = `http://${location.host}/실습/실습07_객체추가/실습08_로그인.html`;
});
