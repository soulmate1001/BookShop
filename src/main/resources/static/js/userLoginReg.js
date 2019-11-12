//验证用户是否存在
function  CheckUser(obj) {
    //alert(obj.value);
    $.ajax({
        url:contextPath + "/user/checkUserName",
        data:{"username":obj.value},
        method:"post",
        success:function (data) {
            $("#msg").css("display","block");
            if(data == 102){
                $("#msg").css("display","block");
                $("#tip").html("用户名不合法!");
                $("#tip").removeClass("alert-success");
                $("#tip").addClass("alert-danger");
            }else{
                $("#msg").css("display","block");
                $("#tip").html("用户名可以使用!");
                $("#tip").removeClass("alert-danger");
                $("#tip").addClass("alert-success");
            }
        }
    })
}
//用户注册
function register() {
    var datas = $("#regForm").serialize();
    $.ajax({
        url:contextPath + "/user/register",
        data:datas,
        method:"post",
        success:function (data) {
            if(data == 'success'){
                alert("注册成功,请登录");
                $("#register").modal("hide");
            }
        }
    })
}

//用户登录
function login() {
    var datas = $("#loginForm").serialize();
    $.ajax({
        url: contextPath + "/user/login",
        data:datas,
        method:"post",
        success:function (data) {   //100表示登录成功    101表示用户不存在    102表示密码错误
            $("#userTip").css("display","none");
            $("#pwdTip").css("display","none");
            if(data == 100){
                $("#login").modal("hide");
                //alert("登录成功!");
                //登录成功之后跳转首页
                window.location.href = contextPath + "/book/index";
            }else if(data == 101){
                $("#userTip").css("display","block");

            }else{
                $("#pwdTip").css("display","block");
            }
        }
    })
}