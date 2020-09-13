

document.addEventListener("DOMContentLoaded", function () {

    let authForm = document.querySelector(".auth_form");
    let enterBtn = document.querySelector(".enter_btn");
    let authTypePanel = document.querySelector(".auth_type");
    let animatedUnderscore = authTypePanel.querySelector(".animated_underscore");
    let formSliderWrapper = document.querySelector(".form_slider_wrapper");


    function setUnderscorePosition (position) {
        //
        switch (position) {
            case "LEFT":
                animatedUnderscore.classList.remove("animated_underscore__right");
                animatedUnderscore.classList.add("animated_underscore__left");
                formSliderWrapper.classList.remove("form_slider_wrapper__ecp");
                break;
            case "RIGHT":
                animatedUnderscore.classList.remove("animated_underscore__left");
                animatedUnderscore.classList.add("animated_underscore__right");
                formSliderWrapper.classList.add("form_slider_wrapper__ecp");
                break;
        }
    }

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

            if (data.success) {
                window.location = "/";
            } else {
                let errorMessage = authForm.querySelector(".error_message");
                errorMessage.innerHTML = "Не правильный логин или пароль";
            }
        }, function (error) {
            console.log(error);
            let errorMessage = authForm.querySelector(".error_message");
            errorMessage.innerHTML = "Не правильный логин или пароль";
        });

    });

    authTypePanel.addEventListener("click", function (evt) {

        let target = evt.target;

        let selection = target.closest(".auth_type__selection");

        if (!selection) {
            return;
        }

        if (selection.classList.contains("login_passw_btn")) {
            setUnderscorePosition("LEFT");
        }

        if (selection.classList.contains("ecp_btn")) {
            setUnderscorePosition("RIGHT");
        }

    });




});