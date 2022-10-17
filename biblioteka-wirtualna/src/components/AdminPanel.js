import React from 'react';
import '../index.css';


import AddUser from './AddUser'
import AddBook from './AddBook'

import Box from '@mui/material/Box';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';

export default function AdminPanel(){

  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

return(
  <div>
   
  <Box sx={{ width: '100%', bgcolor: 'background.paper', display: 'flex'}}>
    
    <Tabs value={value} onChange={handleChange} centered orientation="vertical" >
    <Tab label="Strona Główna" />
    <Tab label="Użytkownicy" />
    <Tab label="Książki" />
    <Tab label="Wypożyczenia" />

    </Tabs>
    

  
</Box>
 <AddUser/>
 <AddBook/>
</div>
);
}