<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">구매 내역</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="breadcrumb-item active text-white">Orders</li>
    </ol>
</div>
<!-- Single Page Header End -->

<!-- Buy List Start -->
<div class="container-fluid py-5">
    <div class="container py-5">
        <div class="d-flex flex-wrap justify-content-between align-items-center gap-3 mb-4">
            <h2 class="mb-0 text-primary"><i class="fas fa-receipt me-2"></i>나의 구매 내역</h2>
            <a href="/" class="btn border border-secondary rounded-pill px-4 py-2 text-primary bg-white">메인으로 돌아가기</a>
        </div>

        <div class="bg-light rounded p-3 p-lg-4">
            <div class="table-responsive">
                <table class="table table-hover align-middle mb-0 bg-white">
                    <thead>
                        <tr class="text-center">
                            <th>주문번호</th>
                            <th class="text-start">상품명</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>총 결제금액</th>
                            <th>상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${empty list}">
                            <tr>
                                <td colspan="6" class="text-center p-5">
                                    <i class="fas fa-box-open fa-3x text-muted mb-3"></i>
                                    <p class="text-muted mb-4">구매하신 내역이 없습니다.</p>
                                    <a href="/cart/search" class="btn btn-primary rounded-pill px-4 py-2">쇼핑하러 가기</a>
                                </td>
                            </tr>
                        </c:if>

                        <c:forEach items="${list}" var="buy">
                            <tr class="text-center">
                                <td>#${buy.buyNum}</td>
                                <td class="text-start fw-bold">
                                    ${buy.productName}
                                </td>
                                <td>
                                    <fmt:formatNumber value="${buy.productPrice}" pattern="#,###"/>원
                                </td>
                                <td>${buy.productEa}개</td>
                                <td class="text-danger fw-bold">
                                    <fmt:formatNumber value="${buy.buyPrice}" pattern="#,###"/>원
                                </td>
                                <td>
                                    <span class="badge bg-success rounded-pill px-3 py-2">결제완료</span>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="mt-4 p-4 bg-light rounded d-flex flex-wrap justify-content-between align-items-center gap-3">
            <div>
                <h5 class="mb-1">요리가 완성되었나요</h5>
                <p class="text-muted mb-0 small">나만의 멋진 레시피를 요리자랑 게시판에 공유해보세요.</p>
            </div>
            <a href="/mycooking/create" class="btn btn-warning fw-bold text-white rounded-pill px-4 py-2">요리자랑 하러가기</a>
        </div>
    </div>
</div>
<!-- Buy List End -->

<jsp:include page="../common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    const serverMessage = "${msg}";
</script>
<script src="${pageContext.request.contextPath}/js/buylist/list.js"></script>
<jsp:include page="../common/scripts.jsp" />
