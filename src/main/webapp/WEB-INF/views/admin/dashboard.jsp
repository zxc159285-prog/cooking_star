<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">Admin Dashboard</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="breadcrumb-item active text-white">Admin</li>
    </ol>
</div>

<div class="container-fluid py-5">
    <div class="container py-5">
        <div class="row g-4">
            <div class="col-md-6">
                <div class="bg-light rounded p-4 text-center">
                    <h5 class="mb-3">전체 회원 수</h5>
                    <h1 class="text-primary mb-0">${member}</h1>
                </div>
            </div>
            <div class="col-md-6">
                <div class="bg-light rounded p-4 text-center">
                    <h5 class="mb-3">전체 레시피 수</h5>
                    <h1 class="text-primary mb-0">${recipe}</h1>
                </div>
            </div>
        </div>

        <div class="row g-4 mt-4">
            <div class="col-md-6">
                <a href="${pageContext.request.contextPath}/admin/memberList"
                   class="btn border-secondary py-3 px-5 rounded-pill text-primary bg-white w-100">
                    회원 목록 관리
                </a>
            </div>
            <div class="col-md-6">
                <a href="${pageContext.request.contextPath}/admin/recipeList"
                   class="btn border-secondary py-3 px-5 rounded-pill text-primary bg-white w-100">
                    레시피 목록 관리
                </a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp" />
<jsp:include page="../common/scripts.jsp" />
