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

const checkHandler = (e, obj, n) => {
  checkList[n] = false;

  if (e.target.value) {
    if (obj.content.id !== pwdIsSameObj.content.id) {
      if (obj.regExp.test(e.target.value)) {
        obj.text.innerHTML = "OK";
        obj.text.classList.add("green");
        obj.text.classList.remove("red");
        checkList[n] = true;
      } else {
        obj.text.innerHTML = obj.textContent;
        obj.text.classList.add("red");
        obj.text.classList.remove("green");
      }
    } else {
      if (
        pwdObj.content.value === e.target.value &&
        checkList[n - 1] === true
      ) {
        obj.text.innerHTML = "OK";
        obj.text.classList.add("green");
        obj.text.classList.remove("red");
        checkList[n] = true;
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
      checkList[n + 1] = false;
      if (pwdIsSameObj.content.value === e.target.value && checkList[1]) {
        pwdIsSameObj.text.innerHTML = "OK";
        pwdIsSameObj.text.classList.add("green");
        pwdIsSameObj.text.classList.remove("red");
        checkList[n + 1] = true;
      } else {
        pwdIsSameObj.text.innerHTML = pwdIsSameObj.textContent;
        pwdIsSameObj.text.classList.add("red");
        pwdIsSameObj.text.classList.remove("green");
      }
    }
  }
  clickJoin();
};

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
  checkHandler(e, idObj, 0);
});

pwd.addEventListener("input", (e) => {
  checkHandler(e, pwdObj, 1);
});

pwdIsSame.addEventListener("input", (e) => {
  checkHandler(e, pwdIsSameObj, 2);
});

koname.addEventListener("input", (e) => {
  checkHandler(e, konameObj, 3);
});

email.addEventListener("input", (e) => {
  checkHandler(e, emailObj, 4);
});

callNum.addEventListener("input", (e) => {
  checkHandler(e, callNumObj, 5);
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
