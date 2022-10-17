import * as React from 'react';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Box from '@mui/material/Box';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";

// @return navigation tab exclusively for admin role visible after validation. due to lack of time it's only set here as a placeholder

export default function NavTabAdmin() {

      const [value, setValue] = React.useState(0);
    
      const handleChange = (event, newValue) => {
        setValue(newValue);
      };
    
      return (
      <Router>
        <div>
          <Box sx={{ width: '100%', bgcolor: 'background.paper', display: 'flex'}}>
            
            <Tabs value={value} onChange={handleChange} centered orientation="vertical" >
            <Tab label="Strona Główna" />
            <Tab label="Użytkownicy" />
            <Tab label="Książki" />
            <Tab label="Wypożyczenia" />

            </Tabs>
            

          
        </Box>
        
        </div>
      </Router>
        
      );
    }
