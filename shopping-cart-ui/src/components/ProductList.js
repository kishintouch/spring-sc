import React from 'react';
import ProductItem from './ProductItem';
import { getProducts } from '../repository';
import { Link } from 'react-router-dom';


export default class ProductList extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			products: [],
			isOpen : false,
			items : []
		}
	}

	componentWillMount() {
		getProducts().then((items) => {
		  this.setState({ items : items });
	      this.setState({ products : items });
	      
	    });
	}
	
	filterList =(event) => {
		console.log('in filter ' + event.target.value )
		let items =this.state.items;
		items = items.filter((item) => {
			return item.productName.toLowerCase().search(event.target.value.toLowerCase()) !== -1 ;
		})

		this.setState({products : items});
	}

	 toggle = (event) => this.setState({isOpen: event.target.value})

	render() {
		const { products } =  this.state;
		console.log("this.state " +  this.state)
		return (
			<div className=" container">
				<input type="text" style={{ width: "100%" ,marginRight: "20px" }} placeholder="Search Products" onChange={this.filterList} />
				<h3 className="card-title">List of Available Products</h3>
	
				<hr/>
				{
					products.map((product, index) => <ProductItem product={product} key={index}/>)
				}
				<hr/>
				<Link to="/checkout"><button className="btn btn-success float-right">Checkout</button></Link>
				<Link to="/cart"><button className="btn btn-primary float-right" style={{  marginRight: "10px" }}>View Cart</button></Link>
				<br/><br/><br/>
			</div>
		);
	}
}
