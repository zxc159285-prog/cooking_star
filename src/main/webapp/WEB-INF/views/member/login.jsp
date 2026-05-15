<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">로그인</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="breadcrumb-item active text-white">Login</li>
    </ol>
</div>
<!-- Single Page Header End -->

<!-- Login Start -->
<div class="container-fluid contact py-5">
    <div class="container py-5">
        <div class="p-5 bg-light rounded">
            <div class="row g-4 justify-content-center">
                <div class="col-lg-6">
                    <form action="/member/login" method="post">
                        <div class="mb-3">
                            <label for="username" class="form-label">아이디</label>
                            <input type="text" name="username" id="username" value="${cookie.rememberId.value}" class="w-100 form-control border-0 py-3 mb-4" placeholder="Your ID">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">비밀번호</label>
                            <input type="password" name="password" id="password" class="w-100 form-control border-0 py-3 mb-4" placeholder="Your Password">
                        </div>
                        <div class="form-check mb-3">
                            <input type="checkbox" name="rememberId" value="1" id="rememberId" class="form-check-input">
                            <label class="form-check-label" for="rememberId">ID 저장하기</label>
                        </div>
                        <div class="form-check mb-4">
                            <input type="checkbox" name="rememberMe" id="exampleCheck1" class="form-check-input">
                            <label class="form-check-label" for="exampleCheck1">로그인 유지</label>
                        </div>
                        <button type="submit" class="w-100 btn form-control border-secondary py-3 bg-white text-primary">로그인</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Login End -->

<jsp:include page="../common/footer.jsp" />
<jsp:include page="../common/scripts.jsp" />