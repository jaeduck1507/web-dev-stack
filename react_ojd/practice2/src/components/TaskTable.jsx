import React from "react";
import { useState } from "react";

const TaskTable = ({ taskList, removeTask }) => {
  return (
    <table border="1">
      <tr>
        <th>할일</th>
        <th>마감일</th>
        <th>삭제</th>
      </tr>
      {taskList.map((t) => (
        <tr>
          <td>{t.task}</td>
          <td>{t.deadLine}</td>
          <td>
            <input
              type="button"
              value="삭제"
              onClick={() => {
                removeTask(t.id);
              }}
            />
          </td>
        </tr>
      ))}
    </table>
  );
};

export default TaskTable;
