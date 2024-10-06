<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Update user</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <!-- ckediter -->
                <script src="https://cdn.ckeditor.com/4.20.0/standard/ckeditor.js"></script>
                <!-- link css trong the muc resources -->
                <link rel="stylesheet" href="/css/style.css">
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class=" col-md-6 col-12 mx-auto">
                            <h2 class="">Update user</h2>
                            <hr class="">
                            <form:form method="post" action="/admin/user/update" modelAttribute="user" >
                                <div class="mb-3" style="display: none;">
                                    <label for="id" class="form-label">ID:</label>
                                    <form:input type="text" class="form-control" path="id" />
                                </div>
                                <div class="mb-3">
                                    <label for="fullName" class="form-label">full Name :</label>
                                    <form:input type="text" class="form-control" path="fullName" />
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email :</label>
                                    <form:input type="email" class="form-control" path="email" disabled="true" />
                                </div>

                                <div class="mb-3">
                                    <label for="phone" class="form-label">Phone :</label>
                                    <form:input type="text" class="form-control" path="phone" />
                                </div>
                                <div class="mb-3">
                                    <label for="addRess" class="form-label">AddRess :</label>
                                    <form:input type="text" class="form-control" path="addRess" />
                                </div>
                                <!-- <div class="mb-3">
                                    <label for="mota" class="form-label">Mô tả:</label>
                                    <textarea name="mota" path="editor"></textarea>
                                </div> -->
                                <div class="mx-auto" >
                                    <button type="submit" class="btn btn-primary">update</button>
                                    <a href="/admin/user" class="btn btn-success">Back</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>

                <!-- <script>
                    // Khởi tạo CKEditor cho textarea
                    CKEDITOR.replace('editor');
                </script> -->
            </body>

            </html>