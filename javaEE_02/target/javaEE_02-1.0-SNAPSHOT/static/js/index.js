const URL = "/javaEE_02"


//绑定加减
function a(id) {
    let _nums = document.querySelector("#_nums_" + id)
    let nums_front = document.querySelector("#nums_front_" + id)
    let nums_after = document.querySelector("#nums_after_" + id)
    nums_front.onclick = () => {
        let num = _nums.innerHTML
        --num
        if (num >= 0)
            _nums.innerHTML = num
        else {
        }
    }
    nums_after.onclick = () => {
        let num = _nums.innerHTML
        ++num
        _nums.innerHTML = num
    }
}

// 获取商品列表绑定
function getList() {
    fetch("http://localhost:8080/javaEE_02/getCartListServlet")
        .then(res => {
            return res.json()
        }).then(js => {
            if (js==null)
                return;
        for (let i = 0; i < js.length; i++) {
            console.log(js[i].commodity.id)
            a(js[i].commodity.id)

        }
    }).catch(e => {
        alert(e)
    })
}

window.onload = () => {
    let header_title = document.querySelector("#header_title")
    let login = document.querySelector("#login")
    let register = document.querySelector("#register")
    let shopping_items = document.querySelector("#shopping_items")
    let Cart = document.querySelector("#Cart")
    let Cart_items = document.querySelector("#Cart_items")
    let Exit = document.querySelector("#Exit")

    //设置单击鼠标事件
    if (login != null)
        login.onclick = () => {
            window.location.href = URL + "/page/login.jsp"
        }
    if (register != null)
        register.onclick = () => {
            window.location.href = URL + "/page/register.jsp"
        }
    if (header_title != null)
        header_title.onclick = () => {
            Cart_items.style.display = 'none'
            shopping_items.style.display = 'flex'
        }
    if (Cart != null)
        Cart.onclick = () => {
            Cart_items.style.display = 'block'
            shopping_items.style.display = 'none'

        }
    if (Exit != null)
        Exit.onclick = () => {
            fetch('http://localhost:8080/javaEE_02/exit')
            location.reload()
        }

    //添加到购物车
    function addCart() {
        let listOf = document.querySelectorAll(".item");

        fetch("http://localhost:8080/javaEE_02/getCommodities")
            .then(res => {
                return res.json()
            }).then(js => {
            for (let i = 0; i < js.length; i++) {

                listOf[i].addEventListener("dblclick", () => {

                    fetch("http://localhost:8080/javaEE_02/addCartServlet?commodity_id=" + js[i].id, {
                        method: 'POST',
                    }).then(res => {
                        return res.text()
                    }).then(res => {
                        console.log(res)
                        alert(res)
                        location.reload()
                    })
                })
            }
        }).catch(e => {
            alert(e)
        })
    }

    addCart();
    getList()

}

