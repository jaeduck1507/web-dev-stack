import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let [greet, setGreet] = useState("");
  let [msg, setMsg] = useState("");

  function nameChange(e) {
    e.preventDefault();

    let name = e.target.myname.value;
    setGreet("안녕하세요 " + name + "님, 오늘의 기분은?");
  }

  function moodChange(e) {
    let mood = e.target.value;

    if (mood === "행복") {
      setMsg("행복하군요");
    } else if (mood === "슬픔") {
      setMsg("흐규흐규");
    } else if (mood === "화남") {
      setMsg("화가 나는군요");
    } else {
      setMsg("");
    }
  }

  return (
    <div className="App">
      <form onSubmit={nameChange}>
        <input type="text" name="myname" placeholder="이름을 입력하세요" />

        <input type="submit" value="인사하기" />
      </form>

      <p>{greet}</p>

      <MyMood mood={moodChange}></MyMood>
      <p>{msg}</p>
    </div>
  );
}

// {}활용하여 특정 파라미터 받기 가능
function MyMood({ mood }) {
  return (
    <div>
      <select onChange={mood}>
        <option value=""> 기분을 선택하세요 </option>
        <option value="행복">행복</option>
        <option value="슬픔">슬픔</option>
        <option value="화남">화남</option>
      </select>
    </div>
  );
}

export default App;
