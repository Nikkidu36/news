//post请求封装
function ajaxPost(url, data, fun) {
    $.ajax({
        url: url,
        type: "post",
        data: data,
        dataType: "json",
        success: fun,
        header:getCookies("token"),
        error: function () {
            alert("请求错误");
        }
    })
}


//先映入jquery-cookies.js
function getCookies(key) {
    return $.cookie(key)
}

function setCookies(key,value) {
    $.cookie(key, value, {path: '/'});
}