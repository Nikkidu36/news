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

function ajaxPostJson(url,data,fun) {
    $.ajax({
        url: url,
        type: "post",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: fun,
        header:getCookies("token"),
        error: function () {
            alert("请求错误");
        }
    })
}

//url传值
function RequestParameter() {
    var url = window.location.search; //获取url中"?"符后的字串
    url = decodeURI(url);
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
        }
    }
    return theRequest
}

// 先映入jquery-cookies.js
function getCookies(key) {
    return $.cookie(key)
}

function setCookies(key,value) {
    $.cookie(key, value, {path: '/'});
}