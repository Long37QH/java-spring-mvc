<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <!-- Navbar start -->
            <div class="container-fluid fixed-top">
                <!-- <div class="container topbar bg-primary d-none d-lg-block">
                <div class="d-flex justify-content-between">
                    <div class="top-info ps-2">
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a
                                href="#" class="text-white">123 Street, New York</a></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#"
                                class="text-white">Email@Example.com</a></small>
                    </div>
                    <div class="top-link pe-2">
                        <a href="#" class="text-white"><small class="text-white mx-2">Privacy
                                Policy</small>/</a>
                        <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                        <a href="#" class="text-white"><small class="text-white ms-2">Sales and
                                Refunds</small></a>
                    </div>
                </div>
            </div> -->
                <div class="container px-0">
                    <nav class="navbar navbar-light bg-white navbar-expand-xl">
                        <a href="index.html" class="navbar-brand">
                            <h1 class="text-primary display-6">LapShop37</h1>
                        </a>
                        <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarCollapse">
                            <span class="fa fa-bars text-primary"></span>
                        </button>
                        <div class="collapse navbar-collapse bg-white justify-content-between mx-5 "
                            id="navbarCollapse">
                            <div class="navbar-nav">
                                <a href="/" class="nav-item nav-link active">Trang Chủ</a>
                                <a href="product/1" class="nav-item nav-link">Sản phẩm</a>
                                <!-- <a href="product/1" class="nav-item nav-link">Shop Detail</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="cart.html" class="dropdown-item">Cart</a>
                                    <a href="chackout.html" class="dropdown-item">Chackout</a>
                                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                    <a href="404.html" class="dropdown-item">404 Page</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a> -->
                            </div>
                            <div class="d-flex m-3 me-0">
                                <!-- <button
                                    class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4"
                                    data-bs-toggle="modal" data-bs-target="#searchModal"><i
                                        class="fas fa-search text-primary"></i></button> -->

                                <!-- phân hiển thị khi đăng nhập -->
                                <c:if test="${not empty pageContext.request.userPrincipal}">

                                    <a href="#" class="position-relative me-4 my-auto">
                                        <i class="fa fa-shopping-bag fa-2x"></i>
                                        <span
                                            class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                                            style="top: -5px; left: 15px; height: 20px; min-width: 20px;">3</span>
                                    </a>
                                    <div class="dropdown my-auto">
                                        <a href="#" class="dropdown" role="button" id="dropdownMenuLink"
                                            data-bs-toggle="dropdown" aria-expanded="false" data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                            <i class="fas fa-user fa-2x"></i>
                                        </a>

                                        <ul class="dropdown-menu dropdown-menu-end p-4" aria
                                            labelledby="dropdownMenuLink">
                                            <li class="d-flex align-items-center flex-column" style="min-width: 300px;">
                                                <img style="width: 150px; height: 150px; border-radius: 50%; overflow: hidden;"
                                                    src="/images/avatar/${sessionScope.avatar}" />
                                                <div class="text-center my-3">
                                                    <!-- lấy thông tin tài khoản đăng nhập tư pring security -->
                                                    <!-- <c:out value="${pageContext.request.userPrincipal.name}" /> -->
                                                    <c:out value="${sessionScope.fullname}" />
                                                </div>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Quản lý tài khoản</a></li>

                                            <li><a class="dropdown-item" href="#">Lịch sử mua hàng</a></li>
                                            <li>
                                                <hr class="dropdown-divider">
                                            </li>
                                            <li>
                                                <form action="/logout" method="post" >
                                                    <input type="hidden" name="${_csrf.parameterName}"
                                                            value="${_csrf.token}" />
                                                    <button class="dropdown-item" >Đăng xuất</button>
                                                </form>
                                            </li>
                                        </ul>
                                    </div>
                                </c:if>
                                <!-- hiển thị khi chưa đăng nhập -->
                                 <c:if test="${ empty pageContext.request.userPrincipal}" >
                                    <a href="/login" class="my-auto">
                                        <i class="fas fa-user fa-2x"></i>
                                    </a>
                                 </c:if>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
            <!-- Navbar End -->