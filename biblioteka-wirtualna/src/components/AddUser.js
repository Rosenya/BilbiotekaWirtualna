import React, { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function AddUser() {
  const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
  const[name,setName]=useState('')
  const[email,setEmail]=useState('')

  const handleClick=(e)=>{
    e.preventDefault()
    const user={name,email}
    console.log(user)
    fetch("http://localhost:8080/users/addUser",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(user)

  }).then(()=>{
    console.log("Dodano użytkownika")
  })
}

  return (
    <Container>
       <Paper elevation={3} style={paperStyle}>
       <h1 style={{color:"Highlight"}}>Zarejestruj Użytkownika</h1>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Imię" variant="outlined" fullWidth 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth 
      value={email}
      onChange={(e)=>setEmail(e.target.value)}
      />
      <Button variant="contained" onClick={handleClick}>Zarejestruj</Button>
    
    </Box>
    </Paper>
    </Container>
  );
}
