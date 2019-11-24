import React from 'react';
import { isAuthenticated ,addProductToCart } from '../repository';
import { Alert } from 'reactstrap';


export default class ProductItem extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			quantity: 1,
			id: 0,
			isOpen : false
		}
	}

	 

	handleInputChange = event => this.setState({[event.target.name]: event.target.value})

	addToCart = (product) => {
		 
		let isLoggedIn = isAuthenticated() ;
		if(isLoggedIn){
			let user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : {};
		      const cartData = {
		        userId: user.id,
		        cartProducts : {productId: product.id,quantity: this.state.quantity}
		      };
		     
	          addProductToCart(cartData)
		      .then(this.setState({isOpen: true}))
		      .catch(err => alert(err));
		}else {
			 window.location = '/login';
		}

		this.setState({visible:true},()=>{
	      window.setTimeout(()=>{
	        this.setState({isOpen:false})
	      },5000)
	    });
	}

	render(){
		const { product } = this.props;
		return (

		    <div className="card" style={{ marginBottom: "10px"}}>
		    	<Alert color="success"  isOpen={this.state.isOpen} fade={true}>
		        	Item Added to Cart Success fully..!
		        </Alert>
			  <div className="card-body">
			    <h4 className="card-title">{product.productName}</h4>
			    <p className="card-text">{product.productDescription}</p>
			    <h5 className="card-text"><small>price: </small>${product.productPrice}</h5>
			    <span className="card-text"><small>Product Model: </small>{product.productModel}</span>
			    
			    
			    	<div>
			    		<button className="btn btn-sm btn-warning float-right" onClick={() => this.addToCart(product)}>Add to cart</button>
			    		<input type="number" value={this.state.quantity} name="quantity" onChange={this.handleInputChange} className="float-right" style={{ width: "60px", marginRight: "10px", borderRadius: "3px"}}/>
			    	</div> 
			 	

			  </div>
			</div>
		)
	}
}
