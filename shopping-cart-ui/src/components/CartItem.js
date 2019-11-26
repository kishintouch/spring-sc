import React from 'react';

export default class CartItem extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			quantity: props.product.quantity
		}
	}

	handleInputChange = event => this.setState({[event.target.name]: event.target.value})
	render(){
		const { product } = this.props;
		return (
		    <div className="card" style={{ marginBottom: "10px"}}>
			  <div className="card-body">
			    <h4 className="card-title">{product.productName}</h4>
			    <h5 className="card-text"><small>price: </small>${product.productPrice}</h5>
			    <span className="card-text text-success"><small>Quantity: </small></span>
			    <input className="card-text" style={{ width: "40px", marginRight: "10px", borderRadius: "3px"}} type="number" value={this.state.quantity} name="quantity" onChange={this.handleInputChange} />
			     
			    <button className="btn btn-sm btn-warning float-right" onClick={() => this.props.remove(product)}>Remove from cart</button>

			    <button className="btn btn-sm btn-warning float-right" style={{ marginRight: "10px" }} onClick={() => this.props.update(product,this.state.quantity)}>Update Cart</button>
			    

			  </div>
			</div>
		)
	}
}
