import axios from 'axios';


const BASE_URL = 'http://localhost:8080';

export function getProducts() {
    
	return axios.get(`${BASE_URL}/products`)
		.then(response => response.data);
}

export function saveUser(userDetails) {
	return axios.post(`${BASE_URL}/user`, userDetails)
		.then(response => response.data);
}


export function getCartProductsByUserId(userid) {
	let token = getToken();
	axios.defaults.headers.common["Authorization"] =
        "Bearer " + token ;
	
	return axios.get(`${BASE_URL}/cart/`+ userid )
		.then(response => response.data);
}

export function addProductToCart(cart) {
	let token = getToken();
	axios.defaults.headers.common["Authorization"] =
        "Bearer " + token ;
	return axios.post(`${BASE_URL}/cart`, cart)
		.then(response => response.data);
}

export function removeProductFromCart(userid,cartid) {
	let token = getToken();
	axios.defaults.headers.common["Authorization"] =
        "Bearer " + token ;
        let url = `${BASE_URL}/user/` + userid  + '/cart/' + cartid
	return axios.delete(url)
		.then(response => response.data);
}

export function updateCartQuantity(cartid,cart) {
	let token = getToken();
	axios.defaults.headers.common["Authorization"] =
        "Bearer " + token ;
        let url = `${BASE_URL}/cart/` + cartid 
	return axios.patch(url,cart)
		.then(response => response.data);
}

export function clearCart(userid) {
	let token = getToken();
	axios.defaults.headers.common["Authorization"] =
        "Bearer " + token ;
        let url = `${BASE_URL}/user/cart/` + userid 
        console.log("url " + url);
	return axios.delete(url)
		.then(response => response.data);
}

export function login (data) {
	return axios.post(`${BASE_URL}/login`, { username: data.name, password: data.password })
		.then(response => {
			localStorage.setItem('x-access-token', response.data.token);
			localStorage.setItem('x-access-token-expiration', Date.now() + 2 * 60 * 60 * 1000);
			localStorage.setItem('user',JSON.stringify(response.data) );

			return response.data
		})
		.catch(err => Promise.reject('Authentication Failed!'));
}

export function isAuthenticated(){
	return localStorage.getItem('x-access-token') && localStorage.getItem('x-access-token-expiration') > Date.now()
}


function getToken() {
    if (localStorage.getItem('user')) {
      return JSON.parse(localStorage.getItem('user')).token;
    }
  }