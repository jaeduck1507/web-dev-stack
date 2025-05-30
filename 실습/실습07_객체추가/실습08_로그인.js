const id = document.querySelector("#id");
const pwd = document.querySelector("#pwd");
const login = document.querySelector("#login");

login.addEventListener("click", () => {
  if (localStorage[id.value] !== undefined) {
    const idInfo = JSON.parse(localStorage[id.value]);
    if (idInfo.pwd === pwd.value) {
      sessionStorage.setItem("userName", idInfo.koname);
      location.href = `http://${location.host}/실습/실습07_객체추가/실습08_로그인시.html`;
    } else {
      alert("비밀번호가 틀립니다");
    }
  } else {
    alert("아이디 정보가 없습니다");
  }
});
