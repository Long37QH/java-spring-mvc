<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>List user</title>
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
                        <div class="col-12 mx-auto">
                            <div class="d-flex justify-content-between mb-2">
                                <h2 class="">List Users</h2>
                                <a class="btn btn-primary" href="/admin/user/creat">Create</a>
                            </div>
                            <hr class="">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>Email</th>
                                        <th>Full Name</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${listUser1}">
                                        <tr>
                                            <th>${user.id}</th>
                                            <td>${user.fullName}</td>
                                            <td>${user.email}</td>
                                            <td>
                                                <a class="btn btn-success" href="/admin/user/${user.id}">Xem</a>
                                                <a class="btn btn-warning mx-2 "
                                                    href="/admin/user/update/${user.id}">Sua</a>
                                                <a class="btn btn-danger" href="/admin/user/delete/${user.id}">Xoa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- <script>
                    // Khởi tạo CKEditor cho textarea
                    CKEDITOR.replace('editor');
                </script> -->

                <script type="text/javascript">
                    $(document).ready(function () {
                        toastr.options = {
                            "closeButton": true,
                            "debug": false,
                            "newestOnTop": true,
                            "progressBar": true,
                            "positionClass": "toast-top-right", // Thay đổi vị trí hiển thị
                            "preventDuplicates": true,
                            "showDuration": "300",
                            "hideDuration": "1000",
                            "timeOut": "3000", // Thời gian tồn tại của thông báo
                            "extendedTimeOut": "1000",
                            "showEasing": "swing",
                            "hideEasing": "linear",
                            "showMethod": "fadeIn",
                            "hideMethod": "fadeOut"
                        };
                        // Check if there's a flash attribute 'message'
                        <c:if test="${not empty message}">
                            toastr.success("${message}");
                        </c:if>
                    });
                </script>

            </body>

            </html>