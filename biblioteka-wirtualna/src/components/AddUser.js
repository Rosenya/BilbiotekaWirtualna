import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

// const useStyles = makeStyles((theme) => ({
//   root: {
//     '& > *': {
//       margin: theme.spacing(1),
     
//     },
//   },
// }));
export default function AddUser() {
  const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
  const[name,setName]=useState('')
  const[email,setEmail]=useState('')
  const[user,setUser]=useState([])
  // const classes = useStyles();

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
useEffect(()=>{
fetch("http://localhost:8080/user")
.then(res=>res.json())
.then((result)=>{
  setUser(result);
}
)
},[])

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
      <h2></h2>
      <Button variant="contained" onClick={handleClick}>Zarejestruj</Button>
      



    
    {/* <h1>Urzytkownicy</h1>
    <Paper elevation={3} style={paperStyle}>
     {user.map(user=>(
     <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={user.id}>
     Id:{user.id}<br/>
     Name:{user.name}<br/>
     Address:{user.address}
     </Paper>
     ))
    } */}
    

 
    </Box>
    </Paper>
    </Container>
  );
} 
