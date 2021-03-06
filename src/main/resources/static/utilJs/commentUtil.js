
//post请求封装
function ajaxPost(url, data, fun) {
    $.ajax({
        url: url,
        type: "post",
        data: data,
        dataType: "json",
        headers:{"token":getCookies("token")},
        success: fun,
        async:false,
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

//先映入jquery-cookies.js
// function getCookies(key) {
//     return $.cookie(key)
// }

function setCookies(name,value)
{
    document.cookie=name+"="+value;
}

// function setCookies(key,value) {
//     $.cookie(key, value, {path: '/'});
// }

function getCookies(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}