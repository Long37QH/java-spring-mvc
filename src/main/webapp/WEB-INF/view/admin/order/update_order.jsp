<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                        const orgImage = "${user.avatar}";
                        if (orgImage) {
                            const urlImage = "/images/avatar/" + orgImage;
                            $("#avatarPreview").attr("src", urlImage);
                            $("#avatarPreview").css({ "display": "block" });
                        }
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
                                <h1 class="mt-4">Manger Order</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="/admin/order">Order</a></li>
                                    <li class="breadcrumb-item active">Update Order</li>
                                </ol>
                                <div class="mt-5 mb-5">
                                    <div class="row">
                                        <div class=" col-md-6 col-12 mx-auto">
                                            <h2 class="">Update order</h2>
                                            <hr class="">
                                            <form:form method="post" action="/admin/order/update" modelAttribute="order">
                                                <div class="row g-3">
                                                    <div class="col">
                                                        Id : ${order.id}
                                                    </div>
                                                    <div class="col">Tông tiền : <fmt:formatNumber type="number" value="${order.totalPrice}"/> đ</td></div>
                                                </div>
                                                <div class="mb-3" style="display: none;">
                                                    <label for="id" class="form-label">ID:</label>
                                                    <form:input type="text" class="form-control" path="id" />
                                                </div>
                                                <div class="row g-3 mt-2 mb-4">
                                                    <div class="col">
                                                        <label for="receiverName" class="form-label">Name:</label>
                                                        <form:input type="text"
                                                            class="form-control" id="receiverName" path="user.fullName" readonly="true" />
                                                    </div>
                                                    <div class="col">
                                                        <label class="form-label">Status:</label>
                                                        <form:select class="form-select" path="status">
                                                            <!-- <option selected></option> -->
                                                            <form:option value="PENDING">PENDING</form:option>
                                                            <form:option value="SHIPPING">SHIPPING</form:option>
                                                            <form:option value="COMPLETE">COMPLETE</form:option>
                                                            <form:option value="CANCEL">CANCEL</form:option>
                                                        </form:select>
                                                    </div>
                                                <div class="mx-auto">
                                                    <button type="submit" class="btn btn-primary">update</button>
                                                    <a href="/admin/order" class="btn btn-success">Back</a>
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