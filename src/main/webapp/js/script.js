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

    