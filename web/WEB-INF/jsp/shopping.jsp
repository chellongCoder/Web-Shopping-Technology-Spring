<%-- 
    Document   : shopping
    Created on : Dec 6, 2018, 10:28:06 PM
    Author     : chellong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Product</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/public/images/icons/favicon.png" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/fonts/themify/themify-icons.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/fonts/elegant-font/html-css/style.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/vendor/slick/slick.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/nouislider.css"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/util.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body class="animsition">
        <c:if test="${LoginInfo == null}">
            <c:redirect url="login.htm"/>
        </c:if>
        <%@include file="partials/head.jsp" %>
        <!-- Title Page -->
        <section class="bg-title-page p-t-50 p-b-40 flex-col-c-m" style="background-image: url(${pageContext.request.contextPath}/public/images/itshirt.jpg);">
            <h2 class="l-text2 t-center">
                IT Shirt
            </h2>
            <p class="m-text13 t-center" style="color : #138496">
                New Arrivals Women Collection 2018
            </p>
        </section>


        <!-- Content page -->
        <section class="bgwhite p-t-55 p-b-65">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-4 col-lg-3 p-b-50">
                        <div class="leftbar p-r-20 p-r-0-sm">
                            <!--  -->
                            <h4 class="m-text14 p-b-7">
                                Categories
                            </h4>

                            <ul class="p-b-54">
                                <li class="p-t-4">
                                    <c:choose>
                                        <c:when test="${typeStore==null || typeStore=='all'}">
                                            <a href="shopping.htm?typeStore=all" class="s-text13 active1">
                                                All
                                            </a>
                                        </c:when>    
                                        <c:otherwise>
                                            <a href="shopping.htm?typeStore=all" class="s-text13 ">
                                                All
                                            </a>
                                        </c:otherwise>
                                    </c:choose>

                                </li>
                                <c:forEach var="item" items="${StoreInfo}">

                                    <c:choose>
                                        <c:when test="${item.type == typeStore}">
                                            <li class="p-t-4">
                                                <a href="selectStore.htm?typeStore=${item.type}" class="s-text13 active1">
                                                    ${item.type}
                                                </a>
                                            </li>
                                        </c:when>    
                                        <c:otherwise>
                                            <li class="p-t-4">
                                                <a href="selectStore.htm?typeStore=${item.type}" class="s-text13">
                                                    ${item.type}
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </ul>

                            <!--  -->
                            <h4 class="m-text14 p-b-32">
                                Filters
                            </h4>

                            <div class="filter-price p-t-22 p-b-50 bo3">
                                <div class="m-text15 p-b-17">
                                    Price
                                </div>

                                <div class="wra-filter-bar">
                                    <div id="filter-bar"></div>
                                </div>

                                <div class="flex-sb-m flex-w p-t-16">
                                    <div class="w-size11">
                                        <!-- Button -->
                                        <a onclick='return handleFilter()' href="#" id="filter" class="flex-c-m size4 bg7 bo-rad-15 hov1 s-text14 trans-0-4">
                                            Filter
                                        </a>
                                    </div>

                                    <div class="s-text3 p-t-10 p-b-10">
                                        Range: $<span id="value-lower">1000</span> - $<span id="value-upper">3000</span>
                                    </div>
                                </div>
                            </div>

                            <div class="filter-color p-t-22 p-b-50 bo3">
                                <div class="m-text15 p-b-12">
                                    Color
                                </div>

                                <ul class="flex-w">
                                    <li class="m-r-10">
                                        <input class="checkbox-color-filter" id="color-filter1" type="checkbox" name="color-filter1">
                                        <label class="color-filter color-filter1" for="color-filter1"></label>
                                    </li>

                                    <li class="m-r-10">
                                        <input class="checkbox-color-filter" id="color-filter2" type="checkbox" name="color-filter2">
                                        <label class="color-filter color-filter2" for="color-filter2"></label>
                                    </li>

                                    <li class="m-r-10">
                                        <input class="checkbox-color-filter" id="color-filter3" type="checkbox" name="color-filter3">
                                        <label class="color-filter color-filter3" for="color-filter3"></label>
                                    </li>

                                    <li class="m-r-10">
                                        <input class="checkbox-color-filter" id="color-filter4" type="checkbox" name="color-filter4">
                                        <label class="color-filter color-filter4" for="color-filter4"></label>
                                    </li>

                                    <li class="m-r-10">
                                        <input class="checkbox-color-filter" id="color-filter5" type="checkbox" name="color-filter5">
                                        <label class="color-filter color-filter5" for="color-filter5"></label>
                                    </li>

                                    <li class="m-r-10">
                                        <input class="checkbox-color-filter" id="color-filter6" type="checkbox" name="color-filter6">
                                        <label class="color-filter color-filter6" for="color-filter6"></label>
                                    </li>

                                    <li class="m-r-10">
                                        <input class="checkbox-color-filter" id="color-filter7" type="checkbox" name="color-filter7">
                                        <label class="color-filter color-filter7" for="color-filter7"></label>
                                    </li>
                                </ul>
                            </div>

                            <div class="search-product pos-relative bo4 of-hidden">
                                <input class="s-text7 size6 p-l-23 p-r-50" type="text"  id="search-product" name="search-product" placeholder="Search Products...">
                                <a hidden href="#" id="search" class="hidden">click</a>
                                <button class="flex-c-m size5 ab-r-m color2 color0-hov trans-0-4">
                                    <i class="fs-12 fa fa-search" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-8 col-lg-9 p-b-50">
                        <!--  -->
                        <div class="flex-sb-m flex-w p-b-35">
                            <form id="products" method="POST" action="filter-by-type-product.htm" class="flex-w">
                                <div class="form-group w-size12 m-t-5 m-b-5 m-r-10">
                                    <select class="select-product form-control" name="type-product">
                                        <option value="">---Select Product---</option>
                                        <c:forEach items="${typeProducts}" var="item">
                                            <c:choose>
                                                <c:when test="${item.nameProduct.equals(selectedProduct)}">
                                                    <option selected value="${item.nameProduct}">${item.nameProduct}</option>
                                                </c:when>    
                                                <c:otherwise>
                                                    <option value="${item.nameProduct}">${item.nameProduct}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group w-size12 m-t-5 m-b-5 m-r-10">
                                    <select class="select-price form-control" name="price">
                                        <option value="">Price</option>
                                        <c:forEach begin="0" end="${prices.size()-1}" var="i">
                                            <c:choose>
                                                <c:when test="${i==prices.size()-1}">
                                                    <c:choose>
                                                        <c:when test="${selectedPrice == prices[i]}">
                                                            <option selected value="${prices[prices.size()-1]}-${""}">$${prices[prices.size()-1]}+</option> 
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${prices[prices.size()-1]}-${100000}">$${prices[prices.size()-1]}+</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${selectedPrice == prices[i]}">
                                                            <option selected value="${prices[i]}-${prices[i+1]}">$${prices[i]} - $${prices[i+1]}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${prices[i]}-${prices[i+1]}">$${prices[i]} - $${prices[i+1]}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:forEach>

                                    </select>
                                </div>
                            </form>

                            <span class="s-text8 p-t-5 p-b-5">
                                Showing ${(currentPage-1)*ITEM_PER_PAGE} - ${(currentPage-1)*ITEM_PER_PAGE+ItemInfo.size()} of ${totalItems} results
                            </span>
                        </div>
                        <!-- Product -->
                        <div id="number">1</div>
                        <div class="row">
                            <c:forEach items="${ItemInfo}" var="item">

                                <div class="col-sm-12 col-md-6 col-lg-4 p-b-50">
                                    ${item.name} 
                                    <div class="block2">
                                        <div class="block2-img wrap-pic-w of-hidden pos-relative">
                                            <div>
                                                <c:choose>
                                                    <c:when test="${item.status=='NEW'}">
                                                        <div  style="background-color: #138496; opacity: 0.7; border-radius: 20px; padding:5px; position: absolute; top : 5; left : 5; color : white">new</div>
                                                    </c:when>    
                                                    <c:otherwise>
                                                        <div  style="background-color: orangered; opacity: 0.7; border-radius: 20px; padding:5px; position: absolute; top : 5; left : 5; color : white">sale</div>
                                                    </c:otherwise>
                                                </c:choose>
                                                <%--<c:out value="${item.status}"/>--%>
                                                <!--<div  style="background-color: #138496; border-radius: 20px; padding:5px; position: absolute; top : 5; left : 5; color : white">new</div>-->
                                            </div>
                                            <c:choose>
                                                <c:when test="${item.urlImage=='' || item.urlImage==null}">
                                                    <img src="${pageContext.request.contextPath}/public/images/notItem.jpg" alt="IMG-PRODUCT">
                                                </c:when>    
                                                <c:otherwise>
                                                    <img src="${item.urlImage}" alt="IMG-PRODUCT">
                                                    <br />
                                                </c:otherwise>
                                            </c:choose>


                                            <div class="block2-overlay trans-0-4">
                                                <a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
                                                    <i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
                                                    <i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
                                                </a>

                                                <div class="block2-btn-addcart w-size1 trans-0-4"> 
                                                    <c:choose>
                                                        <c:when test="${item.urlImage=='' || item.urlImage==null}">
                                                            <a  href="#" class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">Add to Cart</a>
                                                        </c:when>    
                                                        <c:otherwise>
                                                            <a onclick='javascript:addItemToCart(${item.idItem});' href="#" class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">Add to Cart</a>
                                                            <br />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="block2-txt p-t-20">
                                            <a href="product-detail.html" class="block2-name dis-block s-text3 p-b-5">
                                                ${item.note=='' ? 'IT Shirt : Coding every where!' : item.note}
                                            </a>

                                            <span class="block2-price m-text6 p-r-5">
                                                ${item.price}$
                                            </span>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                        </div>

                        <!--                    
                        
                        <!-- Pagination -->
                        <div class="flex-m flex-w p-t-26">
                            <!--<a href="#" class="active-pagination" style="padding-left: 10px; padding-right: 10px; border-radius: 20px; margin-right: 10px">1</a>-->

                            <c:forEach var="i" begin="1" end="${totalPages}" step="1">
                                <c:choose>
                                    <c:when test="${i==currentPage}">
                                        <a  href="#" class="active-pagination" style="padding-left: 10px; padding-right: 10px; border-radius: 20px; margin-right: 10px">${i}</a>
                                    </c:when>    
                                    <c:otherwise>
                                        <a href="shopping.htm?page=${i}&typeStore=${typeStore}&product=${selectedProduct}" class="" style="padding-left: 10px; padding-right: 10px; border-radius: 30px; margin-right: 10px; background-color:rgba(0, 0, 0, 0.3); color: white">${i}</a>   
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <%@include file="partials/footer.jsp" %>

        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/bootstrap/js/popper.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/select2/select2.min.js"></script>
        <script type="text/javascript">
            var search = "";
            var link = document.getElementById("search");
            $('#search-product').on('input',function(e){
                search = $("#search-product").val();
                console.log("search ", search);
                link.href = "shopping.htm";
           });
            var items = {};
            function addItemToCart(sku)
            {
//                items[sku] = sku;
//                console.log("item ", items);
                $(".header-cart-wrapitem").empty();
                console.log("asdasd");
                $.post("/SpringStarter/addtocart.htm", {
                    idItem: sku
                }, function (data) {
                    
                    var json = JSON.parse(data);
                    console.log("json ", json);
                    
                    $("#number").html(json);
                    var sum = 0;
                    for (var i = 0; i < Object.keys(json).length; i++) {
                        var item = JSON.parse(Object.keys(json)[i]);
                        console.log("item ", item);
                        var url = item.urlImage.split("/");
                        var name = url[url.length-1].split(".")[i];
                        var sum = sum + (item.price * json[Object.keys(json)[i]]);
                        var amount = json[Object.keys(json)[i]];
                        console.log("json[0] ", item, amount);
                        $(".header-cart-wrapitem").append(`
                                <li class="header-cart-item">
                                    <div class="header-cart-item-img">
                                        <img src="`+item.urlImage+`" alt="IMG">
                                    </div>

                                    <div class="header-cart-item-txt">
                                        <a href="#" class="header-cart-item-name">
                                            `+name+`
                                        </a>

                                        <span class="header-cart-item-info">
                                            `+amount +` x `+ item.price+`
                                        </span>
                                    </div>
                                </li>`);
                    }
                   
                    $(".header-cart-total").html("Total: $" + sum);
                    $(".header-icons-noti").html(Object.keys(json).length);
                }).done(function () {
                    console.log("done");
                }).fail(function (xhr, textStatus, errorThrown) {
                });
            }
            $(".selection-1").select2({
                minimumResultsForSearch: 20,
                dropdownParent: $('#dropDownSelect1')
            });

            $(".selection-2").select2({
                minimumResultsForSearch: 20,
                dropdownParent: $('#dropDownSelect2')
            });
            $(".select-product").change(function () {
                $("#products").submit();
            });
            $(".select-price").change(function () {
                $("#products").submit();
            });
            
            
        </script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/daterangepicker/moment.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/slick/slick.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/js/slick-custom.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/sweetalert/sweetalert.min.js"></script>
        <script type="text/javascript">
            $('.block2-btn-addcart').each(function () {
                var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
                $(this).on('click', function () {
                    swal(nameProduct, "is added to cart !", "success");
                });
            });

            $('.block2-btn-addwishlist').each(function () {
                var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
                $(this).on('click', function () {
                    swal(nameProduct, "is added to wishlist !", "success");
                });
            });
        </script>

        <!--===============================================================================================-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/vendor/noui/nouislider.min.js"></script>
        <script type="text/javascript">
            /*[ No ui ]
             ===========================================================*/
            var filterBar = document.getElementById('filter-bar');

            noUiSlider.create(filterBar, {
                start: [0, 3000],
                connect: true,
                range: {
                    'min': 0,
                    'max': 3000
                }
            });

            var skipValues = [
                document.getElementById('value-lower'),
                document.getElementById('value-upper')
            ];

            filterBar.noUiSlider.on('update', function (values, handle) {
                skipValues[handle].innerHTML = Math.round(values[handle]);
            });

            function handleFilter() {
                console.log("ok", );
                var min = document.getElementById('value-lower').innerHTML;
                var max = document.getElementById('value-upper').innerHTML;
                var a = document.getElementById('filter'); //or grab it by tagname etc
                a.href = "shopping.htm?min=" + min + "&max=" + max;
            }
        </script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/public/js/main.js"></script>

    </body>
</html>
