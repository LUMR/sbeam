/**
 * Created by lumr on 2017/5/11.
 */
//利用ajax上传文件
function uploadFile(input, picture) {
    var formData = new FormData();
    formData.append('file', $(input)[0].files[0]);
    $.ajax({
        url: '/user/upload',
        type: 'POST',
        cache: false,
        data: formData,
        processData: false,//不处理发送的数据
        contentType: false,//不添加请求头
        //成功后的操作
        success: function (response) {

            $(picture).attr("src", response.src);
        }
    });
}
function checkName(name) {
    $.post("/user/checkName", {"name": name.value}, function (data) {
        if (data == 'true') {
            $("#message").text("用户名已存在，不能使用");
            NameNotExist = false;
        } else {
            $("#message").text("用户名可以使用");
            NameNotExist = true;
        }
    });
}

function addGame(url) {
    $.get(url, function (data) {
            if (data == -1)
                alert("添加错误，请先登陆");
            if (data == 0)
                alert("你已拥有该游戏。");
            if (data > 0){
                $("#gameNum").text(data);
                alert("添加到购物车成功");
            }
        }
    )
}

