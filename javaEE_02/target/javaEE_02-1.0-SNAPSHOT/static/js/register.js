const URL = "/javaEE_02"
window.onload = () => {
    let register_img = document.querySelector("#register_img");

    register_img.onclick = () => {
        window.location.href = URL + "/page/index.jsp"
    }

}
