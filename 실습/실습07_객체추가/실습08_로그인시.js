const h1 = document.querySelector("h1");
const logout = document.querySelector("#logout");

h1.innerHTML = `${sessionStorage.getItem("userName")}님 환영합니다!!`;
logout.addEventListener("click", () => {
  sessionStorage.removeItem("userName");
  location.href = `http://${location.host}/실습/실습07_객체추가/실습08_로그인.html`;
});
