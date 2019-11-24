import React from 'react';
import { Redirect, Link } from 'react-router-dom';
import { isAuthenticated,getCartProductsByUserId,removeProductFromCart,clearCart } from '../repository';
import CartItem from './CartItem';

export default class Cart extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			products: [],
			total: 0
		}
	}

	componentWillMount() {

				let isLoggedIn = isAuthenticated() ;
		if(!isLoggedIn){
			window.location = '/login';
		}
		
		let user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : {};
		 
		getCartProductsByUserId(user.id).then((products) => {
			let total = 0;
			
			for (var i = 0; i < products.length; i++) {
				console.log("products id " + products[i].cartId);
				total += products[i].productPrice * products[i].quantity;
			}
	    	this.setState({ products, total });
	    });
	}

	removeFromCart = (product) => {
		
		let products = this.state.products.filter((item) => item.productId !== product.productId);

		let user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : {};
		removeProductFromCart(user.id,product.cartId).then((products) => {
			let total = 0;
			for (var i = 0; i < products.length; i++) {
				total += products[i].productPrice * products[i].quantity;
			}
	    	this.setState({ products, total });
	    });

		let total = this.state.total - (product.quantity * product.productPrice) 
		this.setState({products, total});
	}

	clearCarts = () => {
		let user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : {};
		console.log("user " + user.id)
		clearCart(user.id).then(() => {
			this.setState({products: []});
	    });
		
	}

	render() {
		if (!isAuthenticated()) return (<Redirect to="/login" />);
		const { products, total } =  this.state;
		return (
			<div className=" container">
				<h3 className="card-title">Cart</h3>
				<hr/>
				{
					products.map((product, index) => <CartItem product={product} remove={this.removeFromCart} key={index}/>)
				}
				<hr/>
				{ products.length ? <div><h4><small>Total Amount:</small><span className="float-right text-primary">${total}</span></h4><hr/></div>: ''}

				{ !products.length ? <h3 className="text-warning">No item on the cart</h3>: ''}
				<Link to="/checkout"><button className="btn btn-success float-right">Checkout</button></Link>
				<button className="btn btn-danger float-right" onClick={this.clearCarts} style={{ marginRight: "10px" }}>Clear Cart</button>
				<br/><br/><br/>
			</div>
		);
	}
}
