
import './App.css';
import Appbar from './components/Appbar'
import NavTab from './components/NavTab'
import AddUser from './components/AddUser'

function App() {
  return (
    <div className="App">
    <Appbar/>
    <NavTab/>
    
    <AddUser/>   
   
    </div>
  );
}

export default App;