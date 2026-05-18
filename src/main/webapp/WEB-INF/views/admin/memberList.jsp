<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">Member Management</h1>
	<ol class="breadcrumb justify-content-center mb-0">
		<li class="breadcrumb-item">
			<a href="${pageContext.request.contextPath}/">Home</a>
		</li>
		<li class="breadcrumb-item">
			<a href="${pageContext.request.contextPath}/admin/dashboard">Admin</a>
		</li>
		<li class="breadcrumb-item active text-white">Members</li>
	</ol>
</div>

<div class="container-fluid py-5">
	<div class="container py-5">
		<div class="d-flex justify-content-between align-items-center mb-4">
			<h2 class="mb-0">회원 목록</h2>
			<a href="${pageContext.request.contextPath}/admin/dashboard"
				class="btn border-secondary rounded-pill px-4 text-primary bg-white">
				대시보드
			</a>
		</div>

		<div class="table-responsive">
			<table class="table table-hover align-middle">
				<thead>
					<tr>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>
						<th scope="col">이메일</th>
						<th scope="col">권한</th>
						<th scope="col">사용 여부</th>
						<th scope="col">계정 잠금</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty memberList}">
							<tr>
								<td colspan="6" class="text-center py-5">조회된 회원이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${memberList}" var="member">
								<tr>
									<td>${member.username}</td>
									<td>${member.name}</td>
									<td>${member.email}</td>
									<td>
										<form action="${pageContext.request.contextPath}/admin/memberRoleUpdate"
											method="post" class="d-flex flex-nowrap gap-2 align-items-center">
											<input type="hidden" name="username" value="${member.username}">
											<select name="roleNum" class="form-select form-select-sm" style="min-width: 120px;">
												<c:forEach items="${roleList}" var="role">
													<c:set var="selectedRole" value="false" />
													<c:forEach items="${member.roles}" var="memberRole">
														<c:if test="${memberRole.roleNum eq role.roleNum}">
															<c:set var="selectedRole" value="true" />
														</c:if>
													</c:forEach>
													<option value="${role.roleNum}" ${selectedRole ? 'selected' : ''}>
														${fn:replace(role.roleName, 'ROLE_', '')}
													</option>
												</c:forEach>
											</select>
											<button type="submit"
												class="btn btn-sm border-secondary rounded-pill px-3 text-primary bg-white text-nowrap">
												변경
											</button>
										</form>
									</td>
									<td>
										<c:choose>
											<c:when test="${member.enabled}">활성</c:when>
											<c:otherwise>비활성</c:otherwise>
										</c:choose>
									</td>
									<td>
										<c:choose>
											<c:when test="${member.accountNonLocked}">정상</c:when>
											<c:otherwise>잠김</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp" />
<jsp:include page="../common/scripts.jsp" />
