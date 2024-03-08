import logo from './logo.svg';
import './App.css';
import TodoView from './Components/TodoView/todoView';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <TodoView />
      </header>
    </div>
  );
}

export default App;
