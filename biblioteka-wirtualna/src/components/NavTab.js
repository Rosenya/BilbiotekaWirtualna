import * as React from 'react';
import Box from '@mui/material/Box';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";

import AdminPanel from './AdminPanel'
import Fantasy from './Fantastyka';

// @return navigation tab for a whole page

export default function NavTab() {
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
  
    <Box sx={{ width: '100%', bgcolor: 'background.paper' }}>
      <Router>
       <Tabs orientation="vertical" value={value} onChange={handleChange} centered  >
       <Link to="/Fantasy">
        <Tab label="Fantastyka" />
        </Link>
        <Routes>
            <Route path="/fantastyka" element={<Fantasy />} />
          </Routes>
        <Tab label="Horror" />
        <Tab label="Legendarze" />
        <Tab label="Literatura Faktu" />
        <Tab label="Kryminał" />
        <Tab label="Poradniki" />
        
          <Link to="/AdminPanel">
          <Tab label="Panel Administracyjny" />

          </Link>
          
          <Routes>
            <Route path="/AdminPanel" element={<AdminPanel />} />
          </Routes>
         
      </Tabs>
      </Router>
    </Box> 
    
  );
}