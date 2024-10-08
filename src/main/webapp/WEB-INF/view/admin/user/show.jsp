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
                                    <li class="breadcrumb-item active">User</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between mb-2">
                                                <h3 class="">List Users</h3>
                                                <a class="btn btn-primary" href="/admin/user/creat">Create user</a>
                                            </div>
                                            <hr class="">
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>id</th>
                                                        <th>Email</th>
                                                        <th>Full Name</th>
                                                        <th>Role</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="user" items="${listUser1}">
                                                        <tr>
                                                            <th>${user.id}</th>
                                                            <td>${user.fullName}</td>
                                                            <td>${user.email}</td>
                                                            <td>${user.role.name}</td>
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