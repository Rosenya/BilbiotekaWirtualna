import React, { useState } from 'react';
import './App.css';
import Dashboard from './components/Dashboard';
import Preferences from './components/Preferences';
import Login from './components/Login';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";

function App() {
  const [token, setToken] = useState();
  
  if(!token) {
    return <Login setToken={setToken} />
  }
  
  return (
    <div className="App">
   
   <div className="wrapper">
      <h1>Application</h1>
      <Router>
        <Routes>
          <Route path="/dashboard" element={<Dashboard />} />
          </Routes>
          <Routes>
          <Route path="/preferences" element={<Preferences />} />
        </Routes>
      </Router>
    </div>
    </div>
  );
}

export default App;