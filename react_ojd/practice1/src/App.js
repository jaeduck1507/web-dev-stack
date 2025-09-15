import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let [menu, setMenu] = useState(0);
  let menuList = [
    { id: 0, menu: "메뉴" },
    { id: 1, menu: "짜장" },
    { id: 2, menu: "짬뽕" },
  ];
  let content = null;
  if (menu === 1 || menu === 2) {
    content = <p>{menuList[menu].menu + "을 선택함"}</p>;
  } else {
    content = <p>메뉴 없음</p>;
  }

  return (
    <div className="App">
      <Header></Header>
      <Article
        menuList={menuList}
        content={content}
        onChangeMode={(menu) => {
          setMenu(menu);
        }}
      ></Article>
    </div>
  );
}

function Header() {
  return (
    <header>
      <h1>메뉴 선택</h1>
    </header>
  );
}

function Article(props) {
  let lis = [];
  for (let i of props.menuList) {
    lis.push(<option value={i.id}>{i.menu}</option>);
  }
  return (
    <article>
      <select
        onChange={(e) => {
          props.onChangeMode(Number(e.target.value));
        }}
      >
        {lis}
      </select>
      {props.content}
    </article>
  );
}

export default App;
