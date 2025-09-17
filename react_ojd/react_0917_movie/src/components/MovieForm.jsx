import React from "react";
import { useState } from "react";
import InputField from "./InputField";
const MovieForm = ({ addMovie }) => {
  const [movieTitle, setMovieTitle] = useState("");
  const [movieYear, setMovieYear] = useState("");

  const [titleError, setTitleError] = useState("");
  const [yearError, setYearError] = useState("");

  const validateForm = () => {
    let validated = true;

    if (!movieTitle) {
      setTitleError("영화제목을 입력하세요");
      validated = false;
    }

    if (!movieYear) {
      setYearError("개봉연도를 입력하세요");
      validated = false;
    }

    return validated;
  };

  const onSubmit = (e) => {
    e.preventDefault();

    setTitleError("");
    setYearError("");
    if (validateForm()) {
      addMovie({ id: Date.now(), title: movieTitle, year: movieYear });
      setMovieTitle("");
      setMovieYear("");
    }
  };

  return (
    <form onSubmit={onSubmit}>
      <InputField
        value={movieTitle}
        placeholder={"영화제목을 입력하세요"}
        onChange={(e) => {
          setMovieTitle(e.target.value);
        }}
        errorMessage={titleError}
      ></InputField>

      <InputField
        value={movieYear}
        placeholder={"개봉연도을 입력하세요"}
        onChange={(e) => {
          setMovieYear(e.target.value);
        }}
        errorMessage={yearError}
      ></InputField>

      <input type="submit" value="영화 등록" />
    </form>
  );
};

export default MovieForm;

/*
export defalut function MovieForm() {}
*/
