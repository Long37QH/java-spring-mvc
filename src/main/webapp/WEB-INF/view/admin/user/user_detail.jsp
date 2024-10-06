<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Detail ${user.id}</title>
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
                        <div class="col-12 mx-auto">
                            <div class="d-flex justify-content-between mb-2">
                                <h2 class="">Detail User by id = ${user.id}</h2>
                                <a class="btn btn-info" href="/admin/user">Back</a>
                            </div>
                            <hr class="">
                            <div class="card" style="width: 60%;">
                                <div class="card-header ">
                                    User Info
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">ID : ${user.id}</li>
                                    <li class="list-group-item">Email : ${user.email}</li>
                                    <li class="list-group-item">Full Name : ${user.fullName}</li>
                                    <li class="list-group-item">Phone : ${user.phone}</li>
                                    <li class="list-group-item">AddRess : ${user.addRess}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- <script>
                    // Khởi tạo CKEditor cho textarea
                    CKEDITOR.replace('editor');
                </script> -->
            </body>

            </html>