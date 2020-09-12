

document.addEventListener("DOMContentLoaded", function () {

    let authForm = document.querySelector(".auth_form");
    let enterBtn = document.querySelector(".enter_btn");



    enterBtn.addEventListener("click", function () {
        // Кнопка войти
        let emailField = authForm.querySelector(".user_field");
        let passwordField = authForm.querySelector(".password_field");

        helper.getHttpPromise({
            method: "POST",
            url: "/api/public/login/login",
            contentType: "application/json",
            jsonData: {
                email: emailField.value,
                password: passwordField.value
            }
        }).then(function (response) {
            var data = JSON.parse(response);
            console.log(data);

            if (data.success) {
                window.location = "/";
            }
        });

    });

});