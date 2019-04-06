

var UserReturnCode= {


    ACCOUNT_EXIST: 1030,//"帐号注册失败,帐号已经存在"),
    NAME_EXIST: 1031,//"该用户名已经存在"),
    PHONE_NUM_EXIST: 1032,//"该手机号已经注册"),
    EMAIL_EXIST: 1033,//"该邮箱已经注册"),
    CAN_REGISTER: 1034,//"帐号未注册，可以进行注册"),

    REGISTER_SUCCESS: 1035,//"帐号注册成功"),
    REGISTER_FAIL: 1036,//"帐号注册失败")
}

var baseUrl =  "/shiro";
var requestUrl = {

    checkRegisterUrl: baseUrl+"/user/register/check-register-name",
    registerUrl: baseUrl + "/user/register/register",
}


$(function () {

    /**
     *  鼠标离开用户名输入框时，检测当前账户是否已经被注册
     */
    $("#register-registerName").mouseleave(function () {

        console.log(" register-registerName  - mouseleave");
       var  jsonData = {"registerName":""};
        var registerName =  $("#register-registerName").val();
        console.log("register-registerName :" + registerName);
        if((registerName == null)|| (registerName == "")){
            $("#register-registerName-warn").text("注册帐号不能为空");
            return;
        }
        $.ajax({
            type : "post",
            url : requestUrl.checkRegisterUrl,
            //contentType : "application/json;charset=utf-8",
            //数据格式是json串,传进一个person
            /*data :'{"phoneNum" : ${phoneNum},"loginPassword": "password","phoneNumValidate":"phoneNumValidate"}',*/
            data : {registerName:registerName},//JSON.stringify(jsonData),
            dataType: "json",
            success:function(data){
               // var retData = JSON.parse(data);
                console.log("代码:" + data.code + " message = " + data.message);

                if(data.code == UserReturnCode.CAN_REGISTER){
                    console.log("======================")
                    $("#register-registerName-warn").text(data.message);

                    $("#register-submit-btn").attr("disabled",false);

                }
                else if((data.code == UserReturnCode.NAME_EXIST)
                ||(data.code == UserReturnCode.PHONE_NUM_EXIST)
                ||(data.code == UserReturnCode.EMAIL_EXIST)){
                    $("#register-registerName-warn").text(data.message);
                    $("#register-submit-btn").attr("disabled",true);

                }


            }
        });
    })

    $("#register-password").mouseleave(function () {

        var password  = $("#register-password").val();
        console.log("password = " + password);
        if((password == null)|| (password == "")){
            $("#register-password-warn").text("帐号密码不能为空");
            $("#register-submit-btn").attr("disabled",true);
        }
        else{
            $("#register-password-warn").text("");
            $("#register-submit-btn").attr("disabled",false);
        }

    })
    /**
     * 提交注册
     */
    $("#register-submit-btn").click(function () {
        console.log(" register-submit-btn  - click ");
        var  jsonData = {"registerName":"","password":""};
         jsonData.registerName =  $("#register-registerName").val();
         jsonData.password  = $("#register-password").val();
        console.log("registerName:" + jsonData.registerName
        +"  password = " +  jsonData.password);
        if((jsonData.registerName == null)|| (jsonData.registerName == "")){
            $("#register-registerName-warn").text("注册帐号不能为空");
            return;
        }

        $.ajax({
            type : "post",
            url : requestUrl.registerUrl,
            contentType : "application/json;charset=utf-8",
            //数据格式是json串,传进一个person
            /*data :'{"phoneNum" : ${phoneNum},"loginPassword": "password","phoneNumValidate":"phoneNumValidate"}',*/
            data : JSON.stringify(jsonData),
            dataType: "json",
            success:function(data){
                // var retData = JSON.parse(data);
                console.log("代码:" + data.code + " message = " + data.message);

                if(data.code == UserReturnCode.REGISTER_SUCCESS){
                    $("#register-submit-btn-warn").text(data.message);

                 //   $("#register-submit-btn").attr("disabled",false);
                    $("#register-success").show();
                    $("#register-table").hide();

                }
                else {
                    $("#register-submit-btn-warn").text(data.message);
                   // $("#register-submit-btn").attr("disabled",true);

                }


            }
        });
    })


})