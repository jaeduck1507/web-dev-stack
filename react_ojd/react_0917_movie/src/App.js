import { useState } from "react";
import Movie from "./components/Movie";
import "./index.css";
import MovieForm from "./components/MovieForm";
import Navbar from "./components/Navbar";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  const [movies, setMovies] = useState([]);

  const removeMovie = (id) => {
    setMovies(
      movies.filter((movie) => {
        return movie.id !== id;
      })
    );
  };

  const addMovie = (movie) => {
    setMovies([...movies, movie]);
  };

  const renderMovies = movies.length
    ? movies.map((movie) => (
        <Movie movie={movie} removeMovie={removeMovie}></Movie>
      ))
    : "등록된 영화가 없습니다";

  return (
    <Router>
      <div className="App">
        <Navbar></Navbar>
        <Routes>
          <Route
            path="/movies"
            element={
              <div>
                <h1>Movie List</h1>
                <MovieForm addMovie={addMovie}></MovieForm>
                {renderMovies}
              </div>
            }
          ></Route>

          <Route path="/users" element={<h1>Users컴포넌트</h1>}></Route>

          <Route path="/" element={<h1>Home컴포넌트</h1>}>
            {" "}
          </Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
