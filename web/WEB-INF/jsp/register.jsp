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
        <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/public/images/favicon.png">
        <title>Admin Press Admin Template - The Ultimate Bootstrap 4 Admin Template</title>
        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/public/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet">
        <!-- You can change the theme colors from here -->
        <link href="${pageContext.request.contextPath}/public/css/blue.css" id="theme" rel="stylesheet">
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
            <div class="login-register" style="background-image:url(${pageContext.request.contextPath}/public/images/shopping.jpg);">
                <div class="login-box card">
                    <div class="card-body">
                        <form class="form-horizontal form-material" id="loginform" action="handleRegister.htm">
                            <h3 class="box-title m-b-20">Sign Up</h3>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <input id="name" name="name" class="form-control" type="text" required="" placeholder="Name">
                                    <span id="error_name" class="text-danger"></span>
                                </div>
                            </div>
                            <div class="form-group ">
                                <div class="col-xs-12">
                                    <input id="email" name="email" class="form-control" type="text" required="" placeholder="Email">
                                    <span id="error_email" class="text-danger"></span>
                                </div>
                            </div>
                            <div class="form-group ">
                                <div class="col-xs-12">
                                    <input id="password" name="password" class="form-control" type="password" required="" placeholder="Password">
                                    <span id="error_password" class="text-danger"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <input id="confirm" name="comfirm" class="form-control" type="password" required="" placeholder="Confirm Password">
                                    <span id="error_confirm" class="text-danger"></span>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12">
                                    <div class="checkbox ">
                                        <input name="checkbox-signup" id="checkbox-signup" type="checkbox">
                                        <label for="checkbox-signup"> I agree to all <a href="#">Terms</a></label>
                                        <span id="error_term" class="text-danger"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group text-center m-t-20">
                                <div class="col-xs-12">
                                    <button id="submit" class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light" type="submit">Sign Up</button>
                                </div>
                            </div>
                            <div class="form-group m-b-0">
                                <div class="col-sm-12 text-center">
                                    <div>Already have an account? <a href="login.htm" class="text-info m-l-5"><b>Sign In</b></a></div>
                                </div>
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
        <script>
            $(document).ready(function () {
                $flag = 1;
                /***** Personal Data Validation ****/
                $("#name").focusout(function () {
                    if ($(this).val() == '') {
                        $(this).css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_name").text("* You have to enter your first name!");
                    } else {
                        $(this).css("border-color", "#2eb82e");
                        $('#submit').attr('disabled', false);
                        $("#error_name").text("");

                    }
                });
                /***** Email Validation ****/

                function validateEmail(sEmail) {
                    var filter = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/;
                    if (filter.test(sEmail)) {
                        return true;
                    } else {
                        return false;
                    }
                }
                $("#email").focusout(function () {
                    var sEmail = $('#email').val();
                    if ($.trim(sEmail).length == 0) {
                        $(this).css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_email").text("Please enter valid email address");

                        e.preventDefault();
                    }
                    if (validateEmail(sEmail)) {
                        $(this).css("border-color", "#2eb82e");
                        $('#submit').attr('disabled', false);
                        $("#error_email").text("");
                        ;
                    } else {
                        $(this).css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_email").text("Invalid email address");
                        e.preventDefault();
                    }
                });
                /***** Login Data Validation ****/

                $("#password").focusout(function () {
                    if ($(this).val() == '') {
                        $(this).css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_password").text("* You have to enter your Password!");
                    } else {
                        $(this).css("border-color", "#2eb82e");
                        $('#submit').attr('disabled', false);
                        $("#error_password").text("");
                    }
                });
                $("#confirm").focusout(function () {
                    if ($("#confirm").val() !== $("#password").val()) {
                        $("#confirm").css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_confirm").text("Passwords Do not match!");
                    } else {
                        $(this).css("border-color", "#2eb82e");
                        $('#submit').attr('disabled', false);
                        $("#error_confirm").text("");
                    }
                });
                var check;
                $("#test-with-is").on("click", function () {

                });
                /***+* Submit Validation ****/
                $("#submit").click(function () {
                    if ($("#name").val() == '') {
                        $("#name").css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_name").text("* You have to enter your first name!");
                    }

                    if ($("#email").val() == '') {
                        $("#email").css("border-color", "#FF0000");
                        $('#submit').attr('disabled', true);
                        $("#error_email").text("* You have to enter your Email  !");
                    }

                    if ($("#password").val() == '') {
                        $("#password").css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_password").text("Enter a Password");
                    }

                    if ($("#confirm").val() == '') {
                        $("#confirm").css("border-color", "#cd2d00");
                        $('#submit').attr('disabled', true);
                        $("#error_confirm").text("Confirm Password");
                    }
                    var check = $("#checkbox-signup").is(":checked");
                    if (check) {
                        $("#error_term").text("");
                    } else {
                        $('#submit').attr('disabled', true);
                        $("#error_term").text("Please agree the term");
                    }
                });


            });
        </script>
    </body>

</html>