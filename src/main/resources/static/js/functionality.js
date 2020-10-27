function get_login() {
    let doc = document.body;
    let div = document.createElement("div");
    doc.appendChild(div);
    div.setAttribute("class", "center");
    div.setAttribute("id", "login");
    let password_form = document.createElement("form");
    password_form.setAttribute("onclick", "changeURLPath('/login/')");
    password_form.setAttribute("method", "post");
    div.appendChild(password_form);
    let span_login_name = document.createElement("span");
    span_login_name.innerHTML = "Name";
    password_form.appendChild(span_login_name);
    let login_name = document.createElement("input");
    login_name.setAttribute("type", "text");
    login_name.setAttribute("id", "login_name");
    password_form.appendChild(login_name);
    let span_login_password = document.createElement("span");
    span_login_password.innerHTML = "Password";
    password_form.appendChild(span_login_password);
    let login_password = document.createElement("input");
    login_password.setAttribute("type", "text");
    login_password.setAttribute("id", "login_password");
    password_form.appendChild(login_password);
    let button_div = document.createElement("div");
    button_div.setAttribute("class", "login_button")
    password_form.appendChild(button_div);
    let submit_login = document.createElement("input");
    submit_login.innerHTML = "Bestätigen";
    submit_login.setAttribute("type", "submit");
    let cancel_login = document.createElement("input");
    cancel_login.setAttribute("value", "Abbrechen");
    cancel_login.setAttribute("type", "button");
    cancel_login.setAttribute("onclick", "cancel_login()");
    button_div.appendChild(submit_login);
    button_div.appendChild(cancel_login);
}

function cancel_login() {
    let login = document.getElementById("login");
    document.body.removeChild(login);
}

function changeURLPath(path) {
    window.location.pathname = path;
}

function setBurgerMenu() {
    if (window.innerWidth <= 755 && document.getElementById("menu") === null) {
        let text = document.getElementsByClassName("club_name").item(0);
        let span = text.children.item(0);
        let menu = document.createElement("div");
        menu.setAttribute("id", "menu");
        let menu_burger = document.createElement("div");
        menu_burger.setAttribute("id", "menu_burger");
        menu.appendChild(menu_burger);
        text.insertBefore(menu, span);
    }
    if (window.innerWidth > 755 && document.getElementById("menu") !== null) {
        document.getElementById("menu").remove();
    }
}