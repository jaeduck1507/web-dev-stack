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
checkList = [false, false, false, false, false, false]; // 각 입력 부분 완성 되어있는지 확인

const clickJoin = () => {
  for (const i of checkList) {
    if (!i) {
      newB.setAttribute("disabled", "disabled");
      newB.setAttribute("style", "background-color: darkgray;;");
      break;
    }

    newB.removeAttribute("disabled");
    newB.setAttribute("style", "background-color: aqua;");
  }
};

id.addEventListener("input", (e) => {
  checkList[0] = false;
  const idReg = /^[a-zA-Z][a-zA-Z\d]{3,11}$/;
  if (e.target.value) {
    if (idReg.test(e.target.value)) {
      idText.innerHTML = "OK";
      idText.classList.add("green");
      idText.classList.remove("red");
      checkList[0] = true;
    } else {
      idText.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
      idText.classList.add("red");
      idText.classList.remove("green");
    }
  } else {
    idText.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    idText.classList.remove("green");
    idText.classList.remove("red");
  }
  clickJoin();
});

pwd.addEventListener("input", (e) => {
  checkList[1] = false;

  const pwdReg =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  if (e.target.value) {
    if (pwdReg.test(e.target.value)) {
      pwdText.innerHTML = "OK";
      pwdText.classList.add("green");
      pwdText.classList.remove("red");
      checkList[1] = true;
    } else {
      pwdText.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
      pwdText.classList.add("red");
      pwdText.classList.remove("green");
    }
  } else {
    pwdText.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    pwdText.classList.remove("green");
    pwdText.classList.remove("red");
  }
  if (pwdIsSame.value !== "") {
    checkList[2] = false;
    if (pwdIsSame.value === e.target.value && checkList[1]) {
      pwdIsSameText.innerHTML = "OK";
      pwdIsSameText.classList.add("green");
      pwdIsSameText.classList.remove("red");
      checkList[2] = true;
    } else {
      pwdIsSameText.innerHTML = "위 비밀번호와 동일하게";
      pwdIsSameText.classList.add("red");
      pwdIsSameText.classList.remove("green");
    }
  }
  clickJoin();
});

pwdIsSame.addEventListener("input", (e) => {
  checkList[2] = false;

  if (e.target.value) {
    if (pwd.value === e.target.value && checkList[1] === true) {
      pwdIsSameText.innerHTML = "OK";
      pwdIsSameText.classList.add("green");
      pwdIsSameText.classList.remove("red");
      checkList[2] = true;
    } else {
      pwdIsSameText.innerHTML = "위 비밀번호와 동일하게";
      pwdIsSameText.classList.add("red");
      pwdIsSameText.classList.remove("green");
    }
  } else {
    pwdIsSameText.innerHTML = "위 비밀번호와 동일하게";
    pwdIsSameText.classList.remove("green");
    pwdIsSameText.classList.remove("red");
  }

  clickJoin();
});

koname.addEventListener("input", (e) => {
  checkList[3] = false;
  const konameReg = /^[가-힣]{2,}$/;
  if (e.target.value) {
    if (konameReg.test(e.target.value)) {
      konameText.innerHTML = "OK";
      konameText.classList.add("green");
      konameText.classList.remove("red");
      checkList[3] = true;
    } else {
      konameText.innerHTML = "이름을 입력해주세요";
      konameText.classList.add("red");
      konameText.classList.remove("green");
    }
  } else {
    konameText.innerHTML = "이름을 입력해주세요";
    konameText.classList.remove("green");
    konameText.classList.remove("red");
  }
  clickJoin();
});

email.addEventListener("input", (e) => {
  checkList[4] = false;
  const emailReg = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
  if (e.target.value) {
    if (emailReg.test(e.target.value)) {
      emailText.innerHTML = "OK";
      emailText.classList.add("green");
      emailText.classList.remove("red");
      checkList[4] = true;
    } else {
      emailText.innerHTML = "이메일을 입력해주세요";
      emailText.classList.add("red");
      emailText.classList.remove("green");
    }
  } else {
    emailText.innerHTML = "이메일을 입력해주세요";
    emailText.classList.remove("green");
    emailText.classList.remove("red");
  }
  clickJoin();
});

callNum.addEventListener("input", (e) => {
  checkList[5] = false;
  const callNumReg = /^010-\d{4}-\d{4}$/;
  if (e.target.value) {
    if (callNumReg.test(e.target.value)) {
      callNumText.innerHTML = "OK";
      callNumText.classList.add("green");
      callNumText.classList.remove("red");
      checkList[5] = true;
    } else {
      callNumText.innerHTML = "전화번호를 입력해주세요";
      callNumText.classList.add("red");
      callNumText.classList.remove("green");
    }
  } else {
    callNumText.innerHTML = "전화번호를 입력해주세요";
    callNumText.classList.remove("green");
    callNumText.classList.remove("red");
  }
  clickJoin();
});

cancel.addEventListener("click", () => {
  idText.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
  idText.classList.remove("green");
  idText.classList.remove("red");

  pwdText.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
  pwdText.classList.remove("green");
  pwdText.classList.remove("red");

  pwdIsSameText.innerHTML = "위 비밀번호와 동일하게";
  pwdIsSameText.classList.remove("green");
  pwdIsSameText.classList.remove("red");

  konameText.innerHTML = "이름을 입력해주세요";
  konameText.classList.remove("green");
  konameText.classList.remove("red");

  emailText.innerHTML = "이메일을 입력해주세요";
  emailText.classList.remove("green");
  emailText.classList.remove("red");

  callNumText.innerHTML = "전화번호를 입력해주세요";
  callNumText.classList.remove("green");
  callNumText.classList.remove("red");
});
