<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>muti file upload</title>
</head>
<body>

<form name="upform" action="<%=basePath%>/admin/upload"
      method="POST" enctype="multipart/form-data">

    <input class="browseButton" name="uploadedfile" multiple="true"
           accept=".xlsx,.xls,.txt" id="multiFile" type="file" id="uploader"/>

    <br>
    <fieldset>
        <input type="file" name="file1" id="file1"/> <br/> <br/> <input
            type="file" name="file2" id="file2"/><br/> <br/> <input
            type="file" name="file3" id="file3"/><br/> <br/>
    </fieldset>
    <br>
    <fieldset>
        <input type="text" name="tableName" value="a,b"/> <input
            type="text" name="importType" value="1,2"/> <input type="text"
                                                               name="splitSign" value="1,2"/>
    </fieldset>

    <input type="submit" value="Submit"/><br/> <br/> <input
        type="reset"/>

</form>

<br>

<button id="ajaxSubmitBtn">ajax upload</button>


<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.1.js"></script>
<script type="text/javascript">
    var ctx = "<%=basePath%>/admin"
    $('#multiFile').change(function () {

        var file = this.files[0];
        name = file.name;
        size = file.size;
        type = file.type;
        //your validation

//        $('#file1') = this.files[1];

        console.log(file);
        console.log(this.files[1]);
        console.log(this.files);
        this.files = null;
        console.log(this.files);

    });

    $('#ajaxSubmitBtn').click(function () {

        var formData = new FormData($('form')[0]);

        $.ajax({
            url: ctx+'/upload', //server script to process data
            type: 'POST',
            xhr: function () { // custom xhr
                myXhr = $.ajaxSettings.xhr();
                if (myXhr.upload) { // check if upload property exists
                    myXhr.upload.addEventListener('progress', function (e) {
                        console.log(e);

                    }, false); // for handling the progress of the upload
                }
                return myXhr;
            },
            //Ajax事件
            beforeSend: function (e) {
                console.log(e);
            },
            success: function (e) {
                console.log(e);

            },
            error: function (e) {
                console.log(e);
            },
            // Form数据
            data: formData,
            //Options to tell JQuery not to process data or worry about content-type
            cache: false,
            contentType: false,
            processData: false
        });

    });
</script>
</body>
</html>
