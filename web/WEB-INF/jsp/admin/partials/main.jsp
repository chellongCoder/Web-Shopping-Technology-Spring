<%-- 
    Document   : main
    Created on : Dec 22, 2018, 4:24:16 PM
    Author     : chellong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/public/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="${pageContext.request.contextPath}/public/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/public/vendor/jquery/jquery-3.2.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<div class="container-fluid">

    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
            <table class="table table-bordered lnr-text-align-left mt-5">

                <thead class="thead-dark fixed-header">
                    <tr>


                        <c:forEach items="${head}" var="item">
                            <th scope="col">${item}</th>
                            </c:forEach>
                        <th scope="col">
                            <div class="wrap">
                                <button onclick="window.location.href = '/SpringStarter/addNew.htm?choice=${choice}'" class="button">Add new</button>
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                   
                    <c:forEach var="item" items="${ItemInfo}">
                        <tr>
                            <c:choose>
                                <c:when test="${choice == 'Item'}">
                                    <td scope="row" style="width: 100px;">
                                        ${item.idItem}
                                        <!--<div class="header-cart-item-img">-->
                                            <img width="100%" height="18%" src="${item.urlImage}" alt="IMG-PRODUCT" >
                                        <!--</div>-->
                                        
                                    </td>
                                    <td>${item.name}</td>
                                    <td>${item.price}</td>
                                    <td>${item.status}</td>
                                    <td>${item.note}</td>
                                </c:when>
                                <c:when test="${choice == 'Product'}">
                                    <td scope="row">${item.idProduct}</td>
                                    <td>${item.nameProduct}</td>
                                    <td>${item.quantity}</td>
                                </c:when>
                                <c:when test="${choice == 'Store'}">
                                    <td scope="row">${item.idStore}</td>
                                    <td>${item.type}</td>
                                </c:when>
                                <c:when test="${choice == 'Customer'}">
                                    <td scope="row">${item.idCustomer}</td>
                                    <td scope="row">${item.username}</td>
                                    <td scope="row">${item.email}</td>
                                    <td scope="row">${item.name}</td>
                                    <td scope="row">${item.address}</td>
                                    <td scope="row">${item.city}</td>
                                    <td scope="row">${item.country}</td>
                                    <td scope="row">${item.postcode}</td>
                                    <td scope="row">${item.about}</td>
                                    <td scope="row">${item.typeCustomer}</td>
                                </c:when>
                            </c:choose>

                            <td>
                                <a href="#" class="btn btn-danger">delete</a>
                                <a href="#" class="btn btn-info">update</a>
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
    <div>

        <nav aria-label="...">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${currentPage!=1}">
                        <li class="page-item ">
                            <a class="page-link" href="manager.htm?page=${currentPage!=1 ? currentPage-1 : 1}" tabindex="-1">Previous</a>
                        </li>
                    </c:when>    
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a class="page-link" href="manager.htm?page=${currentPage!=1 ? currentPage-1 : 1}" tabindex="-1">Previous</a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <c:forEach begin="1" end="${totalPages}" var="i" step="1">
                    <c:choose>
                        <c:when test="${i==currentPage}">
                            <li class="page-item active">
                                <a class="page-link" href="#">${i}<span class="sr-only">(current)</span></a>
                            </li>
                        </c:when>    
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="manager.htm?page=${i}&choice=${choice}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${currentPage!=totalPages}">
                        <li class="page-item ">
                            <a class="page-link" href="manager.htm?page=${currentPage!=toltalPages ? currentPage+1 : 10}">Next</a>
                        </li>
                    </c:when>    
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a class="page-link" href="manager.htm?page=${currentPage!=toltalPages ? currentPage+1 : 10}">Next</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>Ï
    </div>

</div>

<script>
    $(function () {
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });

        $(window).resize(function (e) {
            if ($(window).width() <= 768) {
                $("#wrapper").removeClass("toggled");
            } else {
                $("#wrapper").addClass("toggled");
            }
        });


        $("#mytable #checkall").click(function () {
            if ($("#mytable #checkall").is(':checked')) {
                $("#mytable input[type=checkbox]").each(function () {
                    $(this).prop("checked", true);
                });

            } else {
                $("#mytable input[type=checkbox]").each(function () {
                    $(this).prop("checked", false);
                });
            }
        });

        $("[data-toggle=tooltip]").tooltip();

    });
</script>