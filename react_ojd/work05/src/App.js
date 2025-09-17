import { useState } from "react";

function App() {
  let [userList, setUserList] = useState([]);
  let [name, setName] = useState("");
  let [age, setAge] = useState("");

  function addUser() {
    if (name.trim() && age.trim()) {
      setUserList([...userList, { name, age }]);
      setName("");
      setAge("");
    }
  }

  function userDel(index) {
    // filter는 배열을 순회하면서 조건에 맞는 요소만 골라서 새로운 배열을 만드는 함수
    // filter함수는 최대 두개의 인자를 가지는데,
    // 첫번째 인자는 i번째 요소(사용하지 않는다면 _로 지정)
    // 두번째 인자는 배열의 index
    let newUser = userList.filter((_, i) => i !== index);
    setUserList(newUser);
  }

  return (
    <div className="App">
      <h1>사용자 목록</h1>
      <div>
        <input
          type="text"
          value={name}
          placeholder="이름을 입력하세요"
          onChange={(e) => {
            setName(e.target.value);
          }}
        />
        <br />
        <input
          type="text"
          value={age}
          placeholder="나이를 입력하세요"
          onChange={(e) => {
            setAge(e.target.value);
          }}
        />
        <input type="button" value="확인" onClick={addUser} />
      </div>
      <table border="1">
        <tr>
          <th>이름</th>
          <th>나이</th>
          <th>비고</th>
        </tr>
        {userList.map((u, index) => (
          <tr>
            <td>{u.name}</td>
            <td>{u.age}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={() => {
                  userDel(index);
                }}
              />
            </td>
          </tr>
        ))}
      </table>
    </div>
  );
}

export default App;
