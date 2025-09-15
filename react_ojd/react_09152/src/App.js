import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  // let mode = "WELCOME";
  let [mode, setMode] = useState("WELCOME");
  let [id, setId] = useState(null);
  let content = null;

  let m_topics = [
    { id: 1, title: "html", body: "my html" },
    { id: 2, title: "css", body: "my css" },
    { id: 3, title: "js", body: "my js" },
  ];

  if (mode === "WELCOME") {
    content = <Article title="welcome mode state" body="STATE WEB"></Article>;
  } else if (mode === "READ") {
    let title = null;
    let body = null;

    for (let i = 0; i < m_topics.length; i++) {
      if (m_topics[i].id === id) {
        title = m_topics[i].title;
        body = m_topics[i].body;
      }
    }

    content = <Article title={title} body={body}></Article>;
  }

  return (
    <div className="App">
      <Header
        title="React!!!"
        onChangeMode={() => {
          setMode("WELCOME");
        }}
      ></Header>
      <Nav
        m_topic={m_topics}
        onChangeMode={(id) => {
          setMode("READ");
          setId(Number(id));
        }}
      ></Nav>
      <Article title="Welcome" body="hello react web"></Article>
      {content}
    </div>
  );
}

function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={(e) => {
            alert("헤더");
          }}
        >
          {props.title}
        </a>
      </h1>
      <h1>
        <a
          href="/"
          onClick={(e) => {
            e.preventDefault();
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

function Nav(props) {
  let lis = [];
  for (let i of props.m_topic) {
    lis.push(
      <li>
        <a
          href={"/read/" + i.id}
          id={i.id}
          onClick={(e) => {
            e.preventDefault();
            props.onChangeMode(e.target.id);
          }}
        >
          {i.title} / {i.body}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ul>{lis}</ul>
    </nav>
  );
}

function Article(props) {
  return (
    <div>
      <h2>{props.title}</h2>
      <p>{props.body}</p>
    </div>
  );
}

export default App;
