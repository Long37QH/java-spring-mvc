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
                        const avatarFile = $("#image");
                        const orgImage = "${product.image}";
                        if(orgImage){
                            const urlImage = "/images/product/"+orgImage;
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
                                <h1 class="mt-4">Manger Product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Update Product</li>
                                </ol>
                                <div class="mt-5 mb-5">
                                    <div class="row">
                                        <div class=" col-md-6 col-12 mx-auto">
                                            <h2 class="">Update a product</h2>
                                            <hr class="">
                                            <form:form enctype="multipart/form-data" modelAttribute="product"
                                                method="post" action="/admin/product/update">

                                                <div class="mb-3" style="display: none;">
                                                    <label for="id" class="form-label">ID:</label>
                                                    <form:input type="text" class="form-control" path="id" />
                                                </div>

                                                <div class="row g-3">
                                                    <div class="col">
                                                        <c:set var="errorProductname">
                                                            <form:errors path="name" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <label for="name" class="form-label">Name:</label>
                                                        <form:input type="text"
                                                            class="form-control ${not empty errorProductname ? 'is-invalid' : ''}"
                                                            id="name" path="name" />
                                                        ${errorProductname}
                                                    </div>
                                                    <div class="col">
                                                        <c:set var="errorPrice">
                                                            <form:errors path="price" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <label for="price" class="form-label">Price:</label>
                                                        <form:input type="number"
                                                            class="form-control ${not empty errorPrice ? 'is-invalid' : ''}"
                                                            id="price" placeholder="0.0" path="price" />
                                                        ${errorPrice}
                                                    </div>
                                                    <div class="mb-3">
                                                        <c:set var="errorDetailDesc">
                                                            <form:errors path="detailDesc" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <label for="detailDesc" class="form-label">Detail
                                                            Description</label>
                                                        <form:textarea type="text"
                                                            class="form-control ${not empty errorDetailDesc ? 'is-invalid' : ''}"
                                                            id="detailDesc" rows="3" path="detailDesc" />
                                                        ${errorDetailDesc}
                                                    </div>
    
                                                    <div class="row g-3">
                                                        <div class="col">
                                                            <c:set var="errorshortDesc">
                                                                <form:errors path="shortDesc" cssClass="invalid-feedback" />
                                                            </c:set>
                                                            <label for="shortDesc" class="form-label">Short Description:</label>
                                                            <form:input type="text" class="form-control ${not empty errorshortDesc ? 'is-invalid' : ''}" id="shortDesc"
                                                                path="shortDesc" />
                                                            ${errorshortDesc}
                                                        </div>
                                                        <div class="col">
                                                            <c:set var="errorquantity">
                                                                <form:errors path="quantity" cssClass="invalid-feedback" />
                                                            </c:set>
                                                            <label for="quantity" class="form-label">Quality:</label>
                                                            <form:input type="number" class="form-control ${not empty errorquantity ? 'is-invalid' : ''}" id="quantity"
                                                                placeholder="0" path="quantity" />
                                                            ${errorquantity}
                                                        </div>
                                                    </div>
    
                                                    <div class="row g-3">
                                                        <div class="col">
                                                            <label class="form-label">Factory:</label>
                                                            <form:select class="form-select" path="factory">
                                                                <!-- <option selected></option> -->
                                                                <form:option value="APPLE">Apple(Macbook)</form:option>
                                                                <form:option value="LENOVO">Lenovo</form:option>
                                                                <form:option value="ACER">Acer</form:option>
                                                                <form:option value="HP">HP</form:option>
                                                                <form:option value="ASUS">Asus</form:option>
                                                                <form:option value="MSI">MSI</form:option>
                                                            </form:select>
                                                        </div>
                                                        <div class="col">
                                                            <label class="form-label">Target:</label>
                                                            <form:select class="form-select" path="target">
                                                                <!-- <option selected></option> -->
                                                                <form:option value="GAMING">Gaming</form:option>
                                                                <form:option value="SINH VIEN-VANPHONG">sinh viên - văn phòng</form:option>
                                                                <form:option value="THIET-KE-DO-HOA">Thiết kế đồ họa
                                                                </form:option>
                                                                <form:option value="MONG-NHE">Mỏng nhẹ</form:option>
                                                                <form:option value="DOANH-NHANH">Doanh nhân</form:option>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <div class="mt-2 mb-3">
                                                        <label for="image" class="form-label">Images:</label>
                                                        <input class="form-control" type="file" id="image"
                                                            accept=".png, .jpg, .jpeg" name="ImageProduct">
                                                    </div>
                                                    <div class=" col-12 mb-3">
                                                        <img style="max-height: 250px; display: none;" alt="avatar Preview"
                                                            id="avatarPreview">
                                                    </div>
                                                </div>

                                                <div class="mb-5">
                                                    <button type="submit" class="btn btn-primary">save</button>
                                                    <a href="/admin/product" class="btn btn-success">Back</a>
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
            </body>

            </html>