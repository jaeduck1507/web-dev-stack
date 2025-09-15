import logo from "./logo.svg";
import "./App.css";

function App() {
  // 기본적으로 한개의 태그가 필요
  // 부모 태그는 한개만 허용(2개 이상 불가능)

  let topic = [
    { id: 1, title: "html", body: "my html" },
    { id: 2, title: "css", body: "my css" },
    { id: 3, title: "js", body: "my js" },
  ];

  return (
    <div className="App">
      <Header
        title="React"
        onChangeMode={
          /* function () {
          alert("I am header!!");
        } */
          (id) => {
            alert("id: " + id);
          }
        }
      ></Header>
      <Nav
        topics={topic}
        onChangeMode={(id) => {
          alert("id: " + id);
        }}
      ></Nav>
      <Article title="Welcome" body="hello, web"></Article>
      <Article title="I am title" body="i am body"></Article>
      <Child name="John"></Child>
    </div>
  );
}

// props title에 있는 값을 보이기
function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={function (event) {
            // a태그의 기본인 클릭동작 방지
            event.preventDefault();
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
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    // lis.push(
    //   <li>
    //     <a href={"/read/" + t.id}>
    //       {t.title} / {t.body}
    //     </a>
    //   </li>
    // );
    lis.push(
      <li>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={function (event) {
            event.preventDefault();
            props.onChangeMode(event.target.id);
          }}
        >
          {t.title} / {t.body}
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
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}

function Child(props) {
  return (
    <div>
      <h3>Hello, {props.name}</h3>
    </div>
  );
}

export default App;
