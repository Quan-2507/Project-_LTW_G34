function ValidateLoginForm() {
    RemoveAllErrorMessage();

    var LoginEmail = document.getElementById('LoginEmail').value;
    var LoginPassword = document.getElementById('LoginPassword').value;
    var PasswordValidationMessage;
    var	emailValidationMessage;

    emailValidationMessage = isValidEmail(LoginEmail);
    if(emailValidationMessage != "valid"){
        ShowErrorMessage('LoginEmail',emailValidationMessage);
        return false;
    }

    PasswordValidationMessage = isValidPassword(LoginPassword);
    if(PasswordValidationMessage != "valid"){
        ShowErrorMessage('LoginPassword',PasswordValidationMessage);
        return false;
    }
    return true;
}
function ValidateRegistrationForm(){

    RemoveAllErrorMessage();

    var RegiName = document.getElementById('RegiName').value;
    var RegiEmailAddres = document.getElementById('RegiEmailAddres').value;
    var RegiPassword = document.getElementById('RegiPassword').value;
    var RegiConfirmPassword = document.getElementById('RegiConfirmPassword').value;

    var PasswordValidationMessage;
    var ConfirmPasswordMessage;
    var	emailValidationMessage;

    if(RegiName == ""){
        ShowErrorMessage('RegiName',"Hãy điền họ và tên.");
        return false;
    }else if(RegiName.length < 4 || RegiName.length > 20){
        ShowErrorMessage('RegiName',"Tên phải trên 3 ký tự và dưới 20 ký tự.");
        return false;
    }

    emailValidationMessage = isValidEmail(RegiEmailAddres);

    if(emailValidationMessage != "valid"){
        ShowErrorMessage('RegiEmailAddres',emailValidationMessage);
        return false;
    }

    PasswordValidationMessage = isValidPassword(RegiPassword);
    if(PasswordValidationMessage != "valid"){
        ShowErrorMessage('RegiPassword',PasswordValidationMessage);
        return false;
    }

    ConfirmPasswordMessage = isValidPassword(RegiConfirmPassword);
    if(ConfirmPasswordMessage != "valid"){
        ShowErrorMessage('RegiConfirmPassword',ConfirmPasswordMessage);
        return false;
    }

    if(RegiPassword != RegiConfirmPassword){
        ShowErrorMessage('RegiConfirmPassword',"Mật khẩu không khớp.");
        return false;
    }

    return true;
}

function ValidateForgotPasswordForm(){

    RemoveAllErrorMessage();

    var forgotPassEmail = document.getElementById('forgotPassEmail').value;

    var	emailValidationMessage;
    emailValidationMessage = isValidEmail(forgotPassEmail);

    if(emailValidationMessage != "valid"){
        ShowErrorMessage('forgotPassEmail',emailValidationMessage);
        return false;
    }
}

function ValidateResetPasswordForm(){

    RemoveAllErrorMessage();

    var NewPassword = document.getElementById('NewPassword').value;
    var ConfirmNewPassword = document.getElementById('ConfirmNewPassword').value;

    var PasswordValidationMessage;
    var ConfirmPasswordMessage;

    PasswordValidationMessage = isValidPassword(NewPassword);
    if(PasswordValidationMessage != "valid"){
        ShowErrorMessage('NewPassword',PasswordValidationMessage);
        return false;
    }

    ConfirmPasswordMessage = isValidPassword(ConfirmNewPassword);
    if(ConfirmPasswordMessage != "valid"){
        ShowErrorMessage('ConfirmNewPassword',ConfirmPasswordMessage);
        return false;
    }

    if(NewPassword != ConfirmNewPassword){
        ShowErrorMessage('ConfirmNewPassword',"Mật khẩu không khớp.");
        return false;
    }

    return true;
}


function RemoveAllErrorMessage(){

    var allErrorMessage = document.getElementsByClassName('error-message');
    var allErrorFiled = document.getElementsByClassName('error-input');
    var i;

    for(i=(allErrorMessage.length - 1); i>=0; i--){
        allErrorMessage[i].remove();
    }

    for(i=(allErrorFiled.length-1);i>=0;i--){
        allErrorFiled[i].classList.remove('error-input');
    }
}

function ShowErrorMessage(InputBoxID,Message){

    var InputBox = document.getElementById(InputBoxID);
    InputBox.classList.add('error-input');
    InputBox.focus();

    var ErrorMessageElement = document.createElement("p");
    ErrorMessageElement.innerHTML = Message;
    ErrorMessageElement.classList.add('error-message');
    ErrorMessageElement.setAttribute("id",InputBoxID+'-error');

    InputBox.parentNode.insertBefore(ErrorMessageElement, InputBox.nextSibling);

}

function isValidEmail(email){

    const emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if(email == ""){
        return "Hãy nhập Email";
    }

    if(emailRegex.test(email) == false){
        return "Địa chỉ email không hợp lệ.";
    }

    return "valid";
}

function isValidPassword(password) {

    const minLength = 8;
    const letterNumberRegexSpecialChar = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[a-zA-Z\d!@#$%^&*]{8,}$/;

    if(password == ""){
        return "Hãy nhập mật khẩu."
    }

    if (password.length < minLength ) {
        return "Mật khẩu phải trên 8 ký tự.";
    }

    if (!letterNumberRegexSpecialChar.test(password)) {
        return "Mật khẩu phải bao gồm chữ, số và ký tự.";
    }
    return "valid";
}