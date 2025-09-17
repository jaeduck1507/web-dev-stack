import React from "react";
import { useState } from "react";
import InputField from "./InputField";

const TaskForm = ({ addTask }) => {
  const [task, setTask] = useState("");
  const [deadLine, setDeadLine] = useState("");

  const onSubmit = (e) => {
    e.preventDefault();
    addTask({ id: Date.now(), task, deadLine });
    setTask("");
    setDeadLine("");
  };

  return (
    <form onSubmit={onSubmit}>
      <InputField
        placeholder="할일을 입력하세요"
        value={task}
        onChange={(e) => {
          setTask(e.target.value);
        }}
      ></InputField>
      <br />
      <InputField
        placeholder="마감일 (예: 2025-09-20)"
        value={deadLine}
        onChange={(e) => {
          setDeadLine(e.target.value);
        }}
      ></InputField>
      <input type="submit" value="추가" />
    </form>
  );
};

export default TaskForm;
