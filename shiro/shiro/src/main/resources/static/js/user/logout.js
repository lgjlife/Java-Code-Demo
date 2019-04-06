



var logout = {

    "requestUrl":{
        logoutUrl: baseUrl + "/user/login/out",
        homePageUri:baseUrl,
    },

    "logout":function (logoutName) {
        $.ajax({
            type : "delete",
            url : logout.requestUrl.logoutUrl,
           // contentType : "application/json;charset=utf-8",
            //数据格式是json串,传进一个person
            /*data :'{"phoneNum" : ${phoneNum},"loginPassword": "password","phoneNumValidate":"phoneNumValidate"}',*/
            data : {"logoutName":logoutName},//JSON.stringify(jsonData),
            dataType: "json",
            success:function(data){
                // var retData = JSON.parse(data);
                console.log("代码:" + data.code + " message = " + data.message);




            }
        });
    },

}

$(function () {

    //账户登录提交
    $("#home-logout").click(function () {
        console.log("home-logout click");
        var logoutName = $("#home-logout").text();
        console.log("logoutName = " + logoutName);
        if((logoutName == null) || (logoutName == "")){
            $.get(logout.requestUrl.homePageUri,null);
            return;
        }
        logout.logout(logoutName);
    })

})




