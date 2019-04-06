



var baseUrl =  "/shiro";


var login ={
    "UserReturnCode":{
        LOGIN_SUCCESS:1000,//"用户登录成功"
        LOGIN_FAIL:1001,//"用户登录失败"
        LOGIN_PASSWORD_ERR:1002,//"用户登录失败,密码错误"
        LOGIN_LOCK_ACCOUNT:1003,//"用户登录失败，账户被锁定"
        LOGIN_PASSWORD_ERR_MORE:1004,//"用户登录失败，密码错误过多"
    },

    "requestUrl":{
        loginUrl: baseUrl+"/user/login/in",
        logoutUrl: baseUrl + "/user/login/out",
    },
    "checkInputNull":function () {

        //检测帐号空
        var loginName  = $("#login-loginName").val();
        console.log("loginName = " + loginName);
        if((loginName == null)|| (loginName == "")){
            $("#login-loginName-warn").text("帐号不能为空");
            return false;
        }
        else{
            $("#login-loginName-warn").text("");
        }

        var loginPassword  = $("#login-loginPassword").val();
        console.log("loginPassword = " + loginPassword);
        if((loginPassword == null)|| (loginPassword == "")){
            $("#login-loginPassword-warn").text("帐号密码不能为空");
            return false;
        }
        else{
            $("#login-loginPassword-warn").text("");
        }
        return true;
    },

    //登录请求
    "login":function () {
        if(login.checkInputNull() == false){
            console.log("帐号或者密码不能为空！");
            return;
        }

        console.log("执行登录请求.......... ");
        var  jsonData = {"loginName":"","loginPassword":""};
        jsonData.loginName =  $("#login-loginName").val();
        jsonData.loginPassword  = $("#login-loginPassword").val();
        console.log("loginName:" + jsonData.loginName
            +"  loginPassword = " +  jsonData.loginPassword);


        $.ajax({
            type : "post",
            url : login.requestUrl.loginUrl,
            contentType : "application/json;charset=utf-8",
            //数据格式是json串,传进一个person
            /*data :'{"phoneNum" : ${phoneNum},"loginPassword": "password","phoneNumValidate":"phoneNumValidate"}',*/
            data : JSON.stringify(jsonData),
            dataType: "json",
            success:function(data){
                // var retData = JSON.parse(data);
                console.log("代码:" + data.code + " message = " + data.message);

                if(data.code == login.UserReturnCode.LOGIN_SUCCESS){
                    $("#login-submit-btn-warn").text("");

                    //   $("#register-submit-btn").attr("disabled",false);
                    $("#login-success").show();
                    $("#login-table").hide();

                }
                else {
                    $("#login-submit-btn-warn").text(data.message);
                    // $("#register-submit-btn").attr("disabled",true);

                }


            }
        });

    },

}

$(function () {

    //账户登录提交
    $("#login-submit-btn").click(function () {
        console.log("$(\"#login-submit-btn\").click");
        login.login();
    })

})