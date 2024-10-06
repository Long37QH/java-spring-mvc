<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Create user</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <!-- ckediter -->
                <script src="https://cdn.ckeditor.com/4.20.0/standard/ckeditor.js"></script>
                <!-- link css trong the muc resources -->
                <link rel="stylesheet" href="/css/style.css">

                <!-- Toastr CSS -->
                <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet" />

                <!-- Toastr JS -->
                <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class=" col-md-6 col-12 mx-auto">
                            <h2 class="">create new user</h2>
                            <hr class="">
                            <form:form method="post" action="/admin/user/creat" modelAttribute="usernew">
                                <div class="mb-3">
                                    <label for="fullName" class="form-label">Họ tên:</label>
                                    <form:input type="text" class="form-control" id="fullName" path="fullName" />
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Địa chỉ Email:</label>
                                    <form:input type="email" class="form-control" id="email" path="email"
                                        aria-describedby="emailHelp" />
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <form:input type="password" class="form-control" id="password" path="passwors" />
                                </div>
                                <div class="mb-3">
                                    <label for="addRess" class="form-label">Địa chỉ:</label>
                                    <form:input type="text" class="form-control" id="addRess" path="addRess" />
                                </div>
                                <div class="mb-3">
                                    <label for="phone" class="form-label">Số điện thoại:</label>
                                    <form:input type="text" class="form-control" id="phone" path="phone" />
                                </div>
                                <!-- <div class="mb-3">
                                    <label for="mota" class="form-label">Mô tả:</label>
                                    <textarea name="mota" id="editor"></textarea>
                                </div> -->
                                <button type="submit" class="btn btn-primary">save</button>
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