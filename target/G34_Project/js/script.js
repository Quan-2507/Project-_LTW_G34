const bar = document.getElementById('bar');
const close = document.getElementById('close');
const nav = document.getElementById('navbar');

if (bar){
    bar.addEventListener('click',() => {
        nav.classList.add('active');
    })
}

if (close){
    close.addEventListener('click',() => {
        nav.classList.remove('active');
    })
}

const scrollTop = document.querySelector('.scrollTop');
    window.addEventListener('scroll',() => {
        if(window.pageYOffset > 100){
            scrollTop.classList.add('active');
        } else {
            scrollTop.classList.remove('active');
        }
    })

    // Add cart

    let carts = document.querySelectorAll('.add-cart');

    let products = [
        {
            name: 'iPhone 14 128GB',
            tag: 'iphone14',
            price: $799,
            inCart: 0
        }

    ]

    for(let i = 0; i < carts.length; i++){
        carts[i].addEventListener('click',() => {
           cartNumbers(products[i]);
        })
    }

    function onLoadCartNumbers(){
        let productNumbers = localStorage.getItem('cartNumbers');

        if(productNumbers){
            document.querySelector('.cart-js span').textContent = productNumbers;
        }
    }

    function cartNumbers(products){

        let productNumbers = localStorage.getItem('cartNumbers');
        
        productNumbers = parseInt(productNumbers);

        if(productNumbers){
            localStorage.setItem('cartNumbers', productNumbers + 1);
            document.querySelector('.cart-js span').textContent = productNumbers +1;
        } else {
            localStorage.setItem('cartNumbers', 1);
            document.querySelector('.cart-js span').textContent = 1;
        }
        
        setItems(product);
    }

    function setItems(product) {
        let cartItems = localStorage.getItem('productsInCart');
        cartItems = JSON.parse(cartItems);
        product.inCart = 1;
        
        let cartItems = {
            [product.tag]: product
        }
        
        localStorage.setItem("productsInCart",JSON.stringify(cartItems));
    }

    onLoadCartNumbers();