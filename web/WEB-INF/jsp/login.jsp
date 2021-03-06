<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon icon -->
        <!--<link rel="icon" type="image/png" sizes="16x16" href="../assets/images/favicon.png">-->
        <title>Admin Press Admin Template - The Ultimate Bootstrap 4 Admin Template</title>
        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/vendor/bootstrap/css/bootstrap.min.css">
        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet">
        <!-- You can change the theme colors from here -->
        <link href="${pageContext.request.contextPath}/public/css/blue.css" id="theme" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/public/fonts/font-awesome-4.7.0/css/font-awesome.min.css" id="theme" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>

    <body>
        <c:if test="${LoginInfo!=null}">
            <c:redirect url="index.htm"/>
        </c:if>
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <div class="preloader">
            <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
        </div>
        <!-- ============================================================== -->
        <!-- Main wrapper - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <section id="wrapper">
            <div class="login-register  " style="background-image:url(${pageContext.request.contextPath}/public/images/shopping.jpg);">
                <div class="login-box card">
                    <div class="card-body">
                        <form class="form-horizontal form-material" id="loginform" action="handleLogin.htm">
                            <h3 class="box-title m-b-20">Sign In</h3>
                            <div class="form-group ">
                                <div class="col-xs-12">
                                    <input name="email" class="form-control" type="email" required="" placeholder="Email"> </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <input name="password" class="form-control" type="password" required="" placeholder="Password"> </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12 font-14 d-flex">
                                    <div class="checkbox checkbox-primary pull-left p-t-0 col-sm-6">
                                        <input value="true" name="remember-me" id="checkbox-signup" type="checkbox">
                                        <label for="checkbox-signup"> Remember me </label>
                                    </div> <a href="javascript:void(0)" id="to-recover" class="text-dark pull-right flex-1 col-sm-6 text-right ">
                                        <!-- <i class="fa fa-lock m-r-5"></i> --> Forgot pwd?</a>
                                </div>                        </div>
                            <div class="form-group text-center m-t-20">
                                <div class="col-xs-12">
                                    <button id="submit" class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light"
                                            type="submit">Log In</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 m-t-10 text-center">
                                    <div class="social">
                                        <a href="javascript:void(0)" class="btn  btn-facebook" data-toggle="tooltip" title="Login with Facebook">
                                            <i aria-hidden="true" class="fa fa-facebook"></i> </a>
                                        <a href="javascript:void(0)" class="btn btn-googleplus" data-toggle="tooltip" title="Login with Google">
                                            <i aria-hidden="true" class="fa fa-google-plus"></i> </a>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group m-b-0">
                                <div class="col-sm-12 text-center">
                                    <div>Don't have an account? <a href="register.htm" class="text-info m-l-5"><b>Sign
                                                Up</b></a></div>
                                </div>
                            </div>
                        </form>
                        <form class="form-horizontal" id="recoverform" action="index.html">
                            <div class="form-group ">
                                <div class="col-xs-12">
                                    <h3>Recover Password</h3>
                                    <p class="text-muted">Enter your Email and instructions will be sent to you! </p>
                                </div>
                            </div>
                            <div class="form-group ">
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" required="" placeholder="Email"> </div>
                            </div>
                            <div class="form-group text-center m-t-20">
                                <div class="col-xs-12">
                                    <button class="btn btn-primary btn-lg btn-block text-uppercase waves-effect waves-light"
                                            type="submit">Reset</button>
                                </div>
                                <a href="javascript:void(0)" id="to-login" class="text-dark pull-right flex-1 col-sm-6 text-right ">
                                    <!-- <i class="fa fa-lock m-r-5"></i> --> Return to login</a>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
        <script>
            $(document).ready(function () {
                $("#to-login").click(function () {
                    $("#recoverform").slideUp(), $("#loginform").fadeIn();
                });
                
            })

        </script>
        <script src="${pageContext.request.contextPath}/public/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="${pageContext.request.contextPath}/public/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap.min.js"></script>
        <!-- slimscrollbar scrollbar JavaScript -->
        <script src="${pageContext.request.contextPath}/public/js/jquery.slimscroll.js"></script>
        <!--Wave Effects -->
        <script src="${pageContext.request.contextPath}/public/js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="${pageContext.request.contextPath}/public/js/sidebarmenu.js"></script>
        <!--stickey kit -->
        <script src="${pageContext.request.contextPath}/public/js/sticky-kit.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/jquery.sparkline.min.js"></script>
        <!--Custom JavaScript -->
        <script src="${pageContext.request.contextPath}/public/js/custom.min.js"></script>
        <!-- ============================================================== -->
        <!-- Style switcher -->
        <!-- ============================================================== -->
        <script src="${pageContext.request.contextPath}/public/js/jQuery.style.switcher.js"></script>

    </body>

</html>