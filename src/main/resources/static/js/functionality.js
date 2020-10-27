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