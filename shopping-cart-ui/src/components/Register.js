import React from "react";
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import { saveUser } from '../repository';
import { Alert } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class Register extends React.Component {
 constructor(props) {
    super(props);
    this.state = {
      name: '',
      emailAddress : '',
      age : '',
      password : '',
      gender : '',
      deliveryAddress : '',
      billingAddress : '',
      isOpen : false
    }
  }
handleInputChange = event => this.setState({[event.target.name]: event.target.value})

  mySubmitHandler = (event) => { 
    event.preventDefault();
    
      const cartData = {
            name: this.state.name,
            emailAddress : this.state.emailAddress,
            age : this.state.age,
            gender : this.state.gender,
            deliveryAddress : this.state.deliveryAddress,
            billingAddress : this.state.billingAddress,
            password : this.state.password
          };
     
           saveUser(cartData)
          .then(res => 
            this.setState({ 
                name: '',
                emailAddress : '',
                age : '',
                password : '',
                gender : '',
                deliveryAddress : '',
                billingAddress : '',
                isOpen : true
            })
            )

          .catch(err => alert(err));

          this.setState({visible:true},()=>{
             window.setTimeout(()=>{
             this.setState({isOpen:false})
            },5000)
          });
  }

render() {
  
  return (
    <div className="card" style={{ marginBottom: "10px"}}>
    <Alert color="success"  isOpen={this.state.isOpen} fade={true}>
          Registered User Successfully .Click here to <Link to="/login"><button className="btn btn-success ">Login</button></Link>
    </Alert>
     <h3 className="card-title">Register User</h3>
     <Form onSubmit={this.mySubmitHandler}>
     <div className="card-body">
       <FormGroup>
          <Label for="name">Name </Label>
          <Input type="text" style={{ width: "400px" ,marginRight: "20px" }} value={this.state.name} name="name" id="name" onChange={this.handleInputChange} placeholder="Your name" />
        </FormGroup>
        <FormGroup>
          <Label for="examplePassword">Password</Label>
          <Input type="password" style={{ width: "400px" }} value={this.state.password} name="password" id="examplePassword" onChange={this.handleInputChange} placeholder="Password" />
        </FormGroup>

        <FormGroup>
          <Label for="emailAddress">Email </Label>
          <Input type="email" style={{ width: "400px" ,marginRight: "20px" }} value={this.state.emailAddress} name="emailAddress" id="emailAddress" onChange={this.handleInputChange} placeholder="Type your email Address" />
        </FormGroup>

        <FormGroup>
          <Label for="age">Age </Label>
          <Input type="number" style={{ width: "400px" ,marginRight: "20px" }} value={this.state.age} name="age" id="age" onChange={this.handleInputChange} placeholder="Your Age" />
        </FormGroup>

        <FormGroup tag="fieldset">
         <Label for="gender">Gender </Label>
          <FormGroup check>
            <Label check>
              <Input type="radio" value="MALE"  onChange={this.handleInputChange} value={this.state.gender} name="gender" />{' '}
              Male
            </Label>
          </FormGroup>
          <FormGroup check>
            <Label check>
              <Input type="radio" value="FEMALE" onChange={this.handleInputChange} value={this.state.gender} name="gender" />{' '}
              Female
            </Label>
          </FormGroup>
        </FormGroup>

        <FormGroup>
        <Label for="billingAddress">Billing Address</Label>
        <Input type="textarea" style={{ width: "500px" }} onChange={this.handleInputChange} value={this.state.billingAddress} name="billingAddress" id="billingAddress" />
        </FormGroup>

        <FormGroup>
        <Label for="deliveryAddress">Deliver Address</Label>
        <Input type="textarea" style={{ width: "500px" }} onChange={this.handleInputChange} value={this.state.deliveryAddress} name="deliveryAddress" id="deliveryAddress" />
        </FormGroup>

         <FormGroup>
          <Button className="btn  btn-success" >Submit</Button>
        </FormGroup>
        </div>
       
      </Form>
      </div>
  );
}
}

