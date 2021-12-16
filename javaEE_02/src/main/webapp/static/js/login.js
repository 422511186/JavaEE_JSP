const URL = "/javaEE_02"

window.onload = () => {
    let login_img = document.querySelector("#login_img");

    login_img.onclick = () => {
        window.location.href = URL + "/page/index.jsp"
    }

}
