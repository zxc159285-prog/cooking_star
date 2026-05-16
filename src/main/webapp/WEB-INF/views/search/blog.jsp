<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">레시피 검색 결과</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="breadcrumb-item active text-white">Recipe Search</li>
    </ol>
</div>
<!-- Single Page Header End -->

<!-- Blog Search Result Start -->
<div class="container-fluid fruite py-5">
    <div class="container py-5">
        <div class="text-center mx-auto mb-5" style="max-width: 700px;">
            <h2 class="text-primary mb-3">
                <span>'${searchQuery}'</span> 레시피 검색 결과
            </h2>
        </div>

        <div id="recipeResult" class="row g-4" data-query="${searchQuery}">
            <div class="col-12 text-center py-5">
                <div class="spinner-border text-primary" role="status"></div>
            </div>
        </div>
    </div>
</div>
<!-- Blog Search Result End -->

<jsp:include page="../common/footer.jsp" />
<script src="${pageContext.request.contextPath}/js/result.js"></script>
<jsp:include page="../common/scripts.jsp" />
