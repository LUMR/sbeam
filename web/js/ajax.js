/**
 * Created by lumr on 2017/5/11.
 */

//利用ajax上传文件
function uploadFile(input,picture) {
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
        success:function(response){

            $(picture).attr("src",response.src);
        }
    });



}