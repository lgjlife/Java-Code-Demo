


var projectPath = "/demo";
var Url = {

    actuatorUrl : function() {
        return (projectPath + "/actuator" );
    },
    beansUrl  : function() {
        return (projectPath + "/actuator/beans" );
    }
}
$(function () {
    $("#dispalyCtrlBtn").click(function () {
        console.log("" + $("#dispalyCtrlBtn").text());
        if($("#dispalyCtrlBtn").text() == "收起列表"){
            $("#menuDiv").hide();
            $("#dispalyCtrlBtn").text("展开列表");

        }
        else{
            $("#menuDiv").show();
            $("#dispalyCtrlBtn").text("收起列表");
        }
    })
})


/**
 * beansButton 按键 处理
 */

$(function () {

    $("#beansButton").click(function () {
        console.log("beansButton 按下");


        $.ajax({
            type : "get",
            url : Url.beansUrl(),
            // contentType : "application/x-www-form-urlencoded",
            //  data : jsonData,//JSON.stringify(jsonData),
            dataType: "text",
            success:function(data){
                var obj = JSON.parse(data);

                console.log("beansButton 接受数据");

                for(var c in obj){
                    console.log("-" + c);

                    var obj1 = obj[c];
                    for(var c1 in obj1){
                        console.log("--" + c1);

                        var obj2 = obj1[c1];
                        for(var c2 in obj2){
                            console.log("---" + c2);

                            var obj3 = obj2[c2];
                            for(var c3 in obj3){
                                console.log("----" + c3);
                            }
                        }
                    }
                }

                 var objLink = obj._links;
                 for(var c in objLink){
                     console.log(c);
                 }

                 var txt = "<td>bean</td>"
                     + "<td>scope</td>"
                     + "<td>type</td>"
                     + "<td>dependencies</td>";
                 $("#detailTr").clear();
                 $("#detailTr").prepend(txt);
                 var beans  = obj.contexts.application.beans;

                var i = 0;
                for(var bean in  beans){

                    var txt ="<tr>"
                        + "<td>" + getSubFromDot(bean) + "</td>"
                        + "<td>" + beans[bean].scope + "</td>"
                        + "<td>" + beans[bean].type + "</td>"
                        + "<td>" + beans[bean].dependencies + "</td>"
                        + "<tr>";
                    $("#detailBody").clear();
                    $("#detailBody").append(txt);



                }
            }
        })

    })
})

/**
 * 获取从“.”后的字符串
 * qqq.www.eee  ---> eee
 * @param str
 * @returns {string | *}
 */
function getSubFromDot(str){
    var index = str.lastIndexOf(".");
    var  str = str.substr(index+1,str.length);
    return str;
}

/**
 * actuatorButton 按键 处理
 */

$(function () {
    $("#actuatorButton").click(function () {
        console.log("actuatorButton 按下");

        var  str1 = "asdfg.fdgf";
        var  str2 = "wqewreqwr";

        var index1 = str1.lastIndexOf(".");
        var index2 = str2.lastIndexOf(".");

        console.log("index1 = " + index1);
        console.log("index2 = " + index2);

        var  str3 = str1.substr(index1+1,str1.length);
        var  str4 = str2.substr(index2+1,str2.length);

        console.log("str3 = " + str3);
        console.log("str4 = " + str4);

        $.ajax({
            type : "get",
            url : Url.actuatorUrl(),
           // contentType : "application/x-www-form-urlencoded",
          //  data : jsonData,//JSON.stringify(jsonData),
            dataType: "text",
            success:function(data){
                var obj = JSON.parse(data);

                console.log("actuatorButton 接受数据");

                var objLink = obj._links;
                for(var c in objLink){
                    console.log(c);
                }

               var txt = "<td>条目</td>"
                        + "<td>链接</td>"
                        + "<td>templated</td>";

                $("#detailTr").prepend(txt);

                for(var c in  objLink){

                    var txt ="<tr>"
                        + "<td>" + c + "</td>"
                        + "<td>" + objLink[c].href + "</td>"
                        + "<td>" + objLink[c].templated + "</td>"
                        + "<tr>";
                    $("#detailBody").prepend(txt);
                }
            }
        })

    })
})


