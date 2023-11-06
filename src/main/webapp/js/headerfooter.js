document.addEventListener("DOMContentLoaded", function () {
    //load header
    fetch('../Html/header.html').then(response => response.text()).then(content => {
        document.getElementById('header').innerHTML=content;
    })
        .catch(error => {
            console.warn('loi:', error);
        });
    //load footer
    fetch('../Html/footer.html').then(response => response.text()).then(content => {
        document.getElementById('footer').innerHTML=content;
    })
        .catch(error => {
            console.warn('loi:', error);
        });

});