function get_login() {
    let doc = document.body;
    let password_format = document.createElement("format");
    password_format.setAttribute("action", "login");
    password_format.setAttribute("id", "login");
    doc.appendChild(password_format);
    let span_login_name = document.createElement("span");
    span_login_name.innerHTML = "Name";
    password_format.appendChild(span_login_name);
    let login_name = document.createElement("input");
    login_name.setAttribute("type", "text");
    login_name.setAttribute("id", "login_name");
    password_format.appendChild(login_name);
    let span_login_password = document.createElement("span");
    span_login_password.innerHTML = "Password";
    password_format.appendChild(span_login_password);
    let login_password = document.createElement("input");
    login_password.setAttribute("type", "text");
    login_password.setAttribute("id", "login_password");
    password_format.appendChild(login_password);
    let button_div = document.createElement("div");
    button_div.setAttribute("class", "login_button")
    password_format.appendChild(button_div);
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