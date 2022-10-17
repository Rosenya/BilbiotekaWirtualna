import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

//@return GET and POST http methods for book entity

export default function AddBook() {
  const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
  const[name,setName]=useState('')
  const[author,setAuthor]=useState('')
  const[tome,setTome]=useState('')
  const[type,setType]=useState('')
  const[ean,setEan]=useState('')
  const[status,setStatus]=useState('')
  const[availibility,setAvailibility]=useState('')  
  const[book,setBook]=useState([])

  const handleClick=(e)=>{
    e.preventDefault()
    const book={name,author,tome,type,ean,status,availibility}
    console.log(book)
    fetch("http://localhost:8080/books/addBook",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(book)

  }).then(()=>{
    console.log("Dodano książkę")
  })
}

useEffect(()=>{
    fetch("http://localhost:8080/books")
    .then(res=>res.json())
    .then((result)=>{
      setBook(result);
    }
  )
},[])

  return (
    <Container>
       <Paper elevation={3} style={paperStyle}>
       <h1 style={{color:"Highlight"}}>Dodaj książkę</h1>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Nazwa" variant="outlined" fullWidth 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Autor" variant="outlined" fullWidth 
      value={author}
      onChange={(e)=>setAuthor(e.target.value)}
      />
      <h2></h2>
      <TextField id="outlined-basic" label="Tom" variant="outlined" fullWidth 
      value={tome}
      onChange={(e)=>setTome(e.target.value)}
      />
      <TextField id="outlined-basic" label="Format" variant="outlined" fullWidth 
      value={type}
      onChange={(e)=>setType(e.target.value)}
      />
      <h3></h3>
      <TextField id="outlined-basic" label="Ean" variant="outlined" fullWidth 
      value={ean}
      onChange={(e)=>setEan(e.target.value)}
      />
      <TextField id="outlined-basic" label="Status" variant="outlined" fullWidth 
      value={status}
      onChange={(e)=>setStatus(e.target.value)}
      />
      <h4></h4>
      <TextField id="outlined-basic" label="Dostępność" variant="outlined" fullWidth 
      value={availibility}
      onChange={(e)=>setAvailibility(e.target.value)}
      />
      <Button variant="contained" onClick={handleClick}>Dodaj</Button>
   
    </Box>
    
    </Paper>
    <Box
    component="form"
    sx={{
      '& > :not(style)': { m: 1, width: '25ch' },
    }}
    noValidate
    autoComplete="off"
    >
    
    <Paper elevation={3} style={paperStyle}>
      <h1 style={{color:"Highlight"}}>Lista Książek</h1>
     {book.map(book=>(   
     <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={book.id}>
     id:{book.id}<br/>
     name:{book.name}<br/>
     author:{book.author}<br/>
     tome:{book.tome}<br/>
     type:{book.type}<br/>
     ean:{book.ean}<br/>
     status:{book.status}<br/>
     availibility:{book.availibilityn}
     </Paper>
     ))
    }
    </Paper>
     </Box>
    </Container>
  );
}

