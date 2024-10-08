<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Dashboard - Hỏi Dân IT</title>
                <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <!-- Toastr CSS -->
                <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet" />
                <!-- Toastr JS -->
                <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

                <!-- jequery image Preview -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    }); 
                </script>
            </head>

            <body class="sb-nav-fixed">
                <!-- Navbar include phan hearder-->
                <jsp:include page="../layout/header.jsp" />
                <!-- end-header -->
                </nav>
                <div id="layoutSidenav">
                    <!-- Navbar include phan sidebar-->
                    <jsp:include page="../layout/sidebar.jsp" />
                    <!-- end-sidebar -->
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manger Users</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Update User</li>
                                </ol>
                                <div class="mt-5 mb-5">
                                    <div class="row">
                                        <div class=" col-md-6 col-12 mx-auto">
                                            <h2 class="">Update user</h2>
                                            <hr class="">
                                            <form:form method="post" enctype="multipart/form-data" action="/admin/user/update" modelAttribute="user" >
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
                                                <div class="row g-3 mb-3">
                                                    <div class="col">
                                                        <label class="form-label">Role:</label>
                                                        <form:select class="form-select" path="role.name">
                                                            <!-- <option selected></option> -->
                                                            <form:option value="ADMIN"/>
                                                            <form:option value="USER"/>
                                                        </form:select>
                                                    </div>
                                                    <div class="col">
                                                        <label for="avatarFile" class="form-label">Avatar:</label>
                                                        <input class="form-control" type="file" id="avatarFile"
                                                            accept=".png, .jpg, .jpeg" name="fileImage" >
                                                    </div>
                                                </div>
                                                <div class=" col-12 mb-3">
                                                    <img style="max-height: 250px; display: none;" alt="avatar Preview"
                                                        id="avatarPreview">
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
                            </div>
                        </main>
                        <!-- include phan footer -->
                        <jsp:include page="../layout/footer.jsp" />
                        <!-- end-footer -->
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
                <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/chart-area-demo.js"></script>
                <script src="js/chart-bar-demo.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/datatables-simple-demo.js"></script> -->
                
                </script>
            </body>

            </html>