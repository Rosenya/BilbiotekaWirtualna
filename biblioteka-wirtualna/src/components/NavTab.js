import * as React from 'react';
import Box from '@mui/material/Box';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';

export default function NavTab() {
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Box sx={{ width: '100%', bgcolor: 'background.paper' }}>
       <Tabs orientation="vertical" value={value} onChange={handleChange} centered  >
        <Tab label="Fantastyka" />
        <Tab label="Horror" />
        <Tab label="Legendarze" />
        <Tab label="Literatura Faktu" />
        <Tab label="Kryminał" />
        <Tab label="Poradniki" />
      </Tabs>
    </Box>
  );
}