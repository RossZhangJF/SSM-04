<%--
  Created by IntelliJ IDEA.
  User: PC_01
  Date: 2019/10/24
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
上传文件的模态框
--%>
<!-- Modal -->
<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改头像</h4>
            </div>
            <form method="post" action="upload" enctype="multipart/form-data">
                <div class="modal-body">
                    <input type="file" name="fileImg" id="fileImg" accept="image/*">
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-primary" value="上传头像"></input>
                </div>
            </form>
        </div>
    </div>
</div>
