import { useState } from 'react';
import logo from './logo.svg';

function App() {

  let [count, setCount] = useState(0);
  let [msg, setMsg] = useState('');

  function down(){
    setCount( --count )
  }

  function up(){
    setCount( ++count )
  }

  function reset(){
    setCount(0);
  }

 

  function changeNum( event ){
    setCount( Number( event.target.value ) )
  }

  function checkEvenOdd(){

    if( count == 0 ){
      setMsg( '현재 카운트는 0입니다' )
    }else if( count % 2 == 0 ){
      setMsg('현재 카운트는 짝수입니다')
    }else{
      setMsg('현재 카운트는 홀수입니다')
    }

  }

  return (
    <div className="App">
      <input type="button" value="-" onClick={down}/>
      <input type="button" value="0" onClick={reset}/>
      <input type="button" value="+" onClick={up}/>
      <input type="text" value={count} onChange={ changeNum }/>
      <span>{count}</span>

      <br/>
 
      <input type="button" 
             value="짝수/홀수 확인" 
             onClick={ checkEvenOdd }/>

      <br/>

      <span>{msg}</span>

    </div>
  );
}

export default App;
