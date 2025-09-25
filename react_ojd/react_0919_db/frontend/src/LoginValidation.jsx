import React from "react";

function LoginValidation(values) {
  console.log(values.hasOwnProperty("name"));

  if (values.name == "") {
    alert("이름을 입력해주세요");
    return;
  }

  if (values.email == "") {
    alert("이메일을 입력하세요");
    return;
  }
  if (values.password == "") {
    alert("비밀번호을 입력하세요");
    return;
  }
}

export default LoginValidation;
