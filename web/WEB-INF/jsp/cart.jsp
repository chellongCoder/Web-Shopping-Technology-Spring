<%-- 
    Document   : cart.jsp
    Created on : Dec 21, 2018, 5:18:55 PM
    Author     : chellong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cart</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/public/images/icons/favicon.png"/>
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
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/util.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body class="animsition">
        <%@include file="partials/head.jsp" %>
        <c:set var="sum" value="${0}"/>
        <c:set var="i" value="${1}"/>
        <!-- Title Page -->
        <section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(${pageContext.request.contextPath}/public/images/itshirt.jpg);">
            <h2 class="l-text2 t-center">
                Cart
            </h2>
        </section>

        <!-- Cart -->
        <section class="cart bgwhite p-t-70 p-b-100">
            <div class="container">
                <!-- Cart item -->
                <div class="container-table-cart pos-relative">
                    <div class="wrap-table-shopping-cart bgwhite">
                        <table id="table" class="table-shopping-cart">
                            <tr class="table-head">
                                <th class="column-1"></th>
                                <th class="column-2">Product</th>
                                <th class="column-3">Price</th>
                                <th class="column-4 p-l-70">Quantity</th>
                                <th class="column-5">Total</th>
                            </tr>
                            <div>
                                <c:forEach items="${items}" var="item" >
                                    <tr id="row" class="table-row">
                                        <td class="column-1">
                                            <div class="cart-img-product b-rad-4 o-f-hidden">
                                                <img id="urlImage" src="${item.key.urlImage}" alt="IMG-PRODUCT">
                                            </div>
                                        </td>
                                        <td id="name" class="column-2">${item.key.name}</td>
                                        <td id="price" class="column-3">$${item.key.price}</td>
                                        <td class="column-4">
                                            <div class="flex-w bo5 of-hidden w-size17">
                                                <button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
                                                    <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                                                </button>

                                                <input id="quantity${i}" class="size8 m-text18 t-center num-product" type="number" name="num-product1" value="${item.value}">

                                                <button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
                                                    <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                                                </button>
                                            </div>
                                        </td>
                                        <td id="total${i}" class="column-5">$${item.key.price * item.value}</td>
                                        <c:set var="sum" value="${sum + (item.value*item.key.price)}" />
                                    </tr>
                                    <c:set var="i" value="${i + 1}" />
                                </c:forEach>
                            </div>
                        </table>
                    </div>
                </div>

                <div id="" class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
                    <div class="flex-w flex-m w-full-sm">
                        <div class="size11 bo4 m-r-10">
                            <input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="coupon-code" placeholder="Coupon Code">
                        </div>

                        <div class="size12 trans-0-4 m-t-10 m-b-10 m-r-10">
                            <!-- Button -->
                            <a href="#" class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                                Apply coupon
                            </a>
                        </div>
                    </div>

                    <div class="size10 trans-0-4 m-t-10 m-b-10">
                        <!-- Button -->
                        <button id="updateCart" onclick='javascript:updateCart(${items.size()});' class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                            Update Cart
                        </button>
                    </div>

                    <div id="update" ></div>
                </div>

                <!-- Total -->
                <div class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
                    <h5 class="m-text20 p-b-24">
                        Cart Totals
                    </h5>

                    <!--  -->
                    <div class="flex-w flex-sb-m p-b-12">
                        <span class="s-text18 w-size19 w-full-sm">
                            Subtotal:
                        </span>

                        <span class="m-text21 w-size20 w-full-sm">
                            $${items!=null ? sum : 0}
                        </span>
                    </div>

                    <!--  -->
                    <div class="flex-w flex-sb bo10 p-t-15 p-b-20">
                        <span class="s-text18 w-size19 w-full-sm">
                            Shipping:
                        </span>

                        <div class="w-size20 w-full-sm">
                            <p class="s-text8 p-b-23">
                                There are no shipping methods available. Please double check your address, or contact us if you need any help.
                            </p>

                            <span class="s-text19">
                                Calculate Shipping
                            </span>

                            <form action="updateTotals.htm" method="POST">
                                <div class="rs2-select2 rs3-select2 rs4-select2 bo4 of-hidden w-size21 m-t-8 m-b-12">
                                    <select class="selection-2" name="country">
                                        <option>Select a country...</option>
                                        <option value="US">US</option>
                                        <option value="UK">UK</option>
                                        <option value="VietNam">VietNam</option>
                                        <option value="Japan">Japan</option>
                                    </select>
                                </div>

                                <div class="size13 bo4 m-b-12">
                                    <input  class="sizefull s-text7 p-l-15 p-r-15" type="text" name="state" placeholder="State /  country">
                                </div>

                                <div class="size13 bo4 m-b-22">
                                    <input class="sizefull s-text7 p-l-15 p-r-15" type="text" name="postcode" placeholder="Postcode / Zip">
                                </div>

                                <div class="size14 trans-0-4 m-b-10">
                                    <!-- Button -->
                                    <input type="submit" value="Update Totals" class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4"/>  
                                </div>
                            </form>
                        </div>
                    </div>

                    <!--  -->
                    <div class="flex-w flex-sb-m p-t-26 p-b-30">
                        <span class="m-text22 w-size19 w-full-sm">
                            Total:
                        </span>

                        <span class="m-text21 w-size20 w-full-sm">
                            $${items!=null ? sum : 0}
                        </span>
                    </div>

                    <div class="size15 trans-0-4">
                        <!-- Button -->
                        <button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                            Proceed to Checkout
                        </button>
                    </div>
                </div>
            </div>
        </section>



        <!-- Footer -->
        <footer class="bg6 p-t-45 p-b-43 p-l-45 p-r-45">
            <div class="flex-w p-b-90">
                <div class="w-size6 p-t-30 p-l-15 p-r-15 respon3">
                    <h4 class="s-text12 p-b-30">
                        GET IN TOUCH
                    </h4>

                    <div>
                        <p class="s-text7 w-size27">
                            Any questions? Let us know in store at 8th floor, 379 Hudson St, New York, NY 10018 or call us on (+1) 96 716 6879
                            Subtotal  </p>

                        <div class="flex-m p-t-30">
                            <a href="#" class="fs-18 color1 p-r-20 fa fa-facebook"></a>
                            <a href="#" class="fs-18 color1 p-r-20 fa fa-instagram"></a>
                            <a href="#" class="fs-18 color1 p-r-20 fa fa-pinterest-p"></a>
                            <a href="#" class="fs-18 color1 p-r-20 fa fa-snapchat-ghost"></a>
                            <a href="#" class="fs-18 color1 p-r-20 fa fa-youtube-play"></a>
                        </div>
                    </div>
                </div>

                <div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
                    <h4 class="s-text12 p-b-30">
                        Categories
                    </h4>

                    <ul>
                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                Men
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                Women
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                Dresses
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                Sunglasses
                            </a>
                        </li>
                    </ul>
                </div>

                <div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
                    <h4 class="s-text12 p-b-30">
                        Links
                    </h4>

                    <ul>
                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                Search
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                About Us
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                Contact Us
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="${pageContext.request.contextPath}/public/#" class="s-text7">
                                Returns
                            </a>
                        </li>
                    </ul>
                </div>

                <div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
                    <h4 class="s-text12 p-b-30">
                        Help
                    </h4>

                    <ul>
                        <li class="p-b-9">
                            <a href="#" class="s-text7">
                                Track Order
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="#" class="s-text7">
                                Returns
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="" class="s-text7">
                                Shipping
                            </a>
                        </li>

                        <li class="p-b-9">
                            <a href="#" class="s-text7">
                                FAQs
                            </a>
                        </li>
                    </ul>
                </div>

                <div class="w-size8 p-t-30 p-l-15 p-r-15 respon3">
                    <h4 class="s-text12 p-b-30">
                        Newsletter
                    </h4>

                    <form>
                        <div class="effect1 w-size9">
                            <input class="s-text7 bg6 w-full p-b-5" type="text" name="email" placeholder="email@example.com">
                            <span class="effect1-line"></span>
                        </div>

                        <div class="w-size2 p-t-20">
                            <!-- Button -->
                            <button class="flex-c-m size2 bg4 bo-rad-23 hov1 m-text3 trans-0-4">
                                Subscribe
                            </button>
                        </div>

                    </form>
                </div>
            </div>

        </footer>



        <!-- Back to top -->
        <div class="btn-back-to-top bg0-hov" id="myBtn">
            <span class="symbol-btn-back-to-top">
                <i class="fa fa-angle-double-up" aria-hidden="true"></i>
            </span>
        </div>

        <!-- Container Selection -->
        <div id="dropDownSelect1"></div>
        <div id="dropDownSelect2"></div>



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
                            $(".selection-1").select2({
                                minimumResultsForSearch: 20,
                                dropdownParent: $('#dropDownSelect1')
                            });

                            $(".selection-2").select2({
                                minimumResultsForSearch: 20,
                                dropdownParent: $('#dropDownSelect2')
                            });
                            function updateCart(size) {
                                $("#update").empty();
                                var url = "updateCart.htm?";
                                var quantities = [];
                                for (var i = 1; i <= size; i++) {
                                    var value = $("#quantity" + i).val();
                                    console.log("value", value);
                                    quantities.push(value);
                                    if (i === 1) {
                                        url = url + "idItem=" + value;
                                    } else {
                                        url = url + "&idItem=" + value;
                                    }

                                }
                                console.log("url ", url);
                                console.log("quantities ", quantities);
                                var a = $("#updateCart");
//                a.href = "updateCart
                                $.post("/SpringStarter/updateCart.htm", {
                                    quantities: JSON.stringify(quantities)
                                }, function (data) {
                                    var cart = JSON.parse(data);
                                    console.log("cart ", cart);
                                    for (var i = 0; i < Object.keys(cart).length; i++) {
                                        console.log(Object.keys(cart)[i], cart[Object.keys(cart)[i]]);
                                        console.log(JSON.parse(Object.keys(cart)[i]));
                                        var key = JSON.parse(Object.keys(cart)[i]);
                                        var value = cart[Object.keys(cart)[i]];
                                        $("#total" + (i + 1)).html("$" + (key.price * value));


//       
                                    }
                                    if (data) {

                                        $("#update").append(`
                        <div class="alert alert-success" role="alert">
                            <h4 class="alert-heading">Well done!</h4>
                            <p>Update success.</p>
                            <hr>
                            <p class="mb-0"></p>
                        </div>
                    `)

                                    }
                                    console.log("data", data);
                                });
                            }
        </script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/public/js/main.js"></script>

    </body>
</html>
