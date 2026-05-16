<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">저장한 레시피</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="breadcrumb-item active text-white">Saved Links</li>
    </ol>
</div>
<!-- Single Page Header End -->

<!-- Saved Links Start -->
<div class="container-fluid py-5">
    <div class="container py-5">
        <div class="bg-light rounded p-3 p-lg-4">
            <div class="table-responsive">
                <table class="table table-hover align-middle mb-0 bg-white">
                    <thead>
                        <tr>
                            <th>레시피 제목</th>
                            <th>레시피 링크</th>
                            <th class="text-end">관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="d">
                            <tr>
                                <td>
                                    <div class="resultDiv" data-div="${d.searchNum}">
                                        <h3 class="h5 mb-0">${d.searchTitle}</h3>
                                    </div>
                                </td>
                                <td>
                                    <a href="${d.link}" target="_blank" rel="noopener noreferrer">${d.link}</a>
                                </td>
                                <td class="text-end">
                                    <button type="button" class="btn btn-sm btn-danger rounded-pill px-3 linkBtn" data-num="${d.searchNum}">삭제</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- Saved Links End -->

<jsp:include page="../common/footer.jsp" />
<script src="${pageContext.request.contextPath}/js/search/delete.js"></script>
<jsp:include page="../common/scripts.jsp" />
