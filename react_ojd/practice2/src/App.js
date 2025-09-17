import { useState } from "react";
import TaskForm from "./components/TaskForm";
import TaskTable from "./components/TaskTable";

function App() {
  const [task, setTask] = useState("");
  const [deadLine, setDeadLine] = useState("");
  const [taskList, setTaskList] = useState([]);

  const addTask = (taskContents) => {
    setTaskList([...taskList, taskContents]);
  };
  const removeTask = (id) => {
    setTaskList(
      taskList.filter((t) => {
        return t.id !== id;
      })
    );
  };

  return (
    <div className="App">
      <TaskForm addTask={addTask}></TaskForm>
      <hr />
      <TaskTable taskList={taskList} removeTask={removeTask}></TaskTable>
    </div>
  );
}

export default App;
