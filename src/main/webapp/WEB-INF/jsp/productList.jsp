<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
	
		<div class="row pb-3">
			<div class="col-12 pb-1">
				<!-- bo loc -->
				<div
					class="d-flex align-items-center justify-content-between mb-4">
					<div></div>
					<div class="ml-2">
						<!--<div class="btn-group">
							<button type="button"
								class="btn btn-sm btn-light dropdown-toggle"
								data-toggle="dropdown">Sorting</button>
							<div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="#">Latest</a> <a
									class="dropdown-item" href="#">Popularity</a> <a
									class="dropdown-item" href="#">Best Rating</a>
							</div>
						</div>
						<div class="btn-group ml-2">
							<button type="button"
								class="btn btn-sm btn-light dropdown-toggle"
								data-toggle="dropdown">Showing</button>
							<div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="#">10</a> <a
									class="dropdown-item" href="#">20</a> <a
									class="dropdown-item" href="#">30</a>
							</div>
						</div>  -->

					</div>
				</div>
				<!--ket thuc bo loc -->
			
			<div  class="row">
					
				<c:forEach items="${ListProduct}" var="product">

					<div class="col-lg-4 col-md-6 col-sm-6 pb-1 " id="product-item">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden py-4">
								<img class="img-fluid w-100" src="img/${product.getImgPath()}"
									alt="">
								<div class="product-action">
									<%-- <a class="btn btn-outline-dark btn-square"
										href="addtocart?ProductID=${product.getProductID()}&soluong=1"><i
										class="fa fa-shopping-cart"></i></a> --%>
										<form action="cart" method="post" class="btn btn-outline-dark btn-square">
    												<input type="hidden" name="ProductID" value="${product.getProductID()}">
  													  <input type="hidden" name="soluong" value="1">
    												<button type="submit" class="btn btn-outline-dark btn-square">
        											<i class="fa fa-shopping-cart"></i>
    												</button>
													</form>
										 <a
										class="btn btn-outline-dark btn-square"
										href="detail?ProductID=${product.getProductID()}"><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h5 text-decoration-none text-truncate"
									href="detail?ProductID=${product.getProductID()}">${product.getName()}</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>${product.getUnit_price()}${product.getPrice()}</h5>
									<h6 class="text-muted ml-2">
										<del>${product.getUnit_price()}${product.getPrice()}</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<p class="text-dark">${rvDAO.avgTotalStarReviews(product.getProductID())}
										<i class="fa fa-star text-primary mr-1"></i>(${rvDAO.totalReviewsOfProductID(product.getProductID())}
										Reviews)
									</p>

								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<nav aria-label="Page navigation example">
		<ul class="pagination" id="pagination">
		  
		  <!-- <li class="page-item"><a class="page-link"  onclick="fetchProducts((event),${pageNo-1})">Previous</a></li>
		  <li class="page-item"><a class="page-link" href="#">${totalPage}</a></li>
		  <li class="page-item"><a class="page-link" href="#">${pageNo+2}</a></li>
		  <li class="page-item"><a class="page-link" href="#">${pageNo+3}</a></li>
		  <li class="page-item"><a class="page-link" onclick="fetchProducts((event),${pageNo+1})">Next</a></li> -->

		  <%-- Nút Previous --%>
        <c:if test="${pageNo > 0}">
            <li class="page-item"><a class="page-link"  onclick="fetchProducts((event),${pageNo-1})">Previous</a></li>
        </c:if>

        <%-- Liên kết đến các trang --%>
        <c:forEach begin="1" end="${totalPage}" var="pageNum">
            <c:choose>
                <c:when test="${pageNum - 1 == pageNo}">
                    
					<li class="page-item"><a class="page-link" href="#" onclick="fetchProducts((event),${pageNum - 1})"><strong>${pageNum}</strong></a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="#" onclick="fetchProducts((event),${pageNum - 1})">${pageNum}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <%-- Nút Next --%>
        <c:if test="${pageNo + 1 < totalPage}">
            <li class="page-item"><a class="page-link" onclick="fetchProducts((event),${pageNo+1})">Next</a></li>
        </c:if>
		</ul>
	  </nav>


							
						
					