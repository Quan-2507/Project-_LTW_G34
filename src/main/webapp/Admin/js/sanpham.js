var form = document.getElementById("myForm"),
    imgInput = document.querySelector(".img"),
    file = document.getElementById("imgInput"),
    userName = document.getElementById("name"),
    price = document.getElementById("price"),
    des = document.getElementById("des"),
    submitBtn = document.querySelector(".submit"),
    userInfo = document.getElementById("data"),
    modal = document.getElementById("userForm"),
    modalTitle = document.querySelector("#userForm .modal-title"),
    newUserBtn = document.querySelector(".newUser")


let getData = localStorprice.getItem('productProfile') ? JSON.parse(localStorprice.getItem('productProfile')) : []

let isEdit = false, editId
showInfo()

newUserBtn.addEventListener('click', ()=> {
    submitBtn.innerText = 'Submit',
        modalTitle.innerText = "Điền vào form"
    isEdit = false
    imgInput.src = "./imprice/Profile Icon.webp"
    form.reset()
})


file.onchange = function(){
    if(file.files[0].size < 1000000){  // 1MB = 1000000
        var fileReader = new FileReader();

        fileReader.onload = function(e){
            imgUrl = e.target.result
            imgInput.src = imgUrl
        }

        fileReader.readAsDataURL(file.files[0])
    }
    else{
        alert("Tệp ảnh quá lớn, vui lòng chọn tệp nhỏ hơn!")
    }
}


function showInfo(){
    document.querySelectorAll('.productDetails').forEach(info => info.remove())
    getData.forEach((element, index) => {
        let createElement = `<tr class="productDetails">
            <td>${index+1}</td>
            <td><img src="${element.picture}" alt="" width="50" height="50"></td>
            <td>${element.productName}</td>
            <td>${element.productPrice}</td>
            <td>${element.productDes}</td>


            <td>
                <button class="btn btn-success" onclick="readInfo('${element.picture}', '${element.productName}', '${element.productPrice}', '${element.productDes}')" data-bs-toggle="modal" data-bs-target="#readData"><i class="bi bi-eye"></i></button>

                <button class="btn btn-primary" onclick="editInfo(${index}, '${element.picture}', '${element.productName}', '${element.productPrice}', '${element.productDes}')" data-bs-toggle="modal" data-bs-target="#userForm"><i class="bi bi-pencil-square"></i></button>

                <button class="btn btn-danger" onclick="deleteInfo(${index})"><i class="bi bi-trash"></i></button>
                            
            </td>
        </tr>`

        userInfo.innerHTML += createElement
    })
}
showInfo()


function readInfo(pic, name, price, des){
    document.querySelector('.showImg').src = pic,
        document.querySelector('#showName').value = name,
        document.querySelector("#showPrice").value = price,
        document.querySelector("#showDes").value = des
}


function editInfo(index, pic, name, price, des){
    isEdit = true
    editId = index
    imgInput.src = pic
    userName.value = name
    price.value = price
    des.value =des

    submitBtn.innerText = "Update"
    modalTitle.innerText = "Update The Form"
}


function deleteInfo(index){
    if(confirm("Are you sure want to delete?")){
        getData.splice(index, 1)
        localStorprice.setItem("productProfile", JSON.stringify(getData))
        showInfo()
    }
}


form.addEventListener('submit', (e)=> {
    e.preventDefault()

    const information = {
        picture: imgInput.src == undefined ? "./imprice/Profile Icon.webp" : imgInput.src,
        productName: Name.value,
        productPrice: price.value,
        productDes: des.value
    }

    if(!isEdit){
        getData.push(information)
    }
    else{
        isEdit = false
        getData[editId] = information
    }

    localStorprice.setItem('productProfile', JSON.stringify(getData))

    submitBtn.innerText = "Submit"
    modalTitle.innerHTML = "Fill The Form"

    showInfo()

    form.reset()

    imgInput.src = "./imprice/Profile Icon.webp"

    // modal.style.display = "none"
    // document.querySelector(".modal-backdrop").remove()
})
