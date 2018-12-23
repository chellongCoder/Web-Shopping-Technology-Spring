<%-- 
    Document   : form
    Created on : Dec 22, 2018, 8:33:53 PM
    Author     : chellong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/public/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="${pageContext.request.contextPath}/public/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/public/vendor/jquery/jquery-3.2.1.min.js"></script>
<!DOCTYPE html>
<style>
    body{
        margin: 0;
        padding: 0;
        font-family: sans-serif;
    }
    .formBox{
        margin-top: 90px;
        padding: 50px;
    }
    .formBox  h1{
        margin: 0;
        padding: 0;
        text-align: center;
        margin-bottom: 50px;
        text-transform: uppercase;
        font-size: 48px;
    }
    .inputBox{
        position: relative;
        box-sizing: border-box;
        margin-bottom: 50px;
    }
    .inputBox .inputText{
        position: absolute;
        font-size: 24px;
        line-height: 50px;
        transition: .5s;
        opacity: .5;
    }
    .inputBox .input{
        position: relative;
        width: 100%;
        height: 50px;
        background: transparent;
        border: none;
        outline: none;
        font-size: 24px;
        border-bottom: 1px solid rgba(0,0,0,.5);

    }
    .focus .inputText{
        transform: translateY(-30px);
        font-size: 18px;
        opacity: 1;
        color: #00bcd4;

    }
    textarea{
        height: 100px !important;
    }
    .button{
        width: 100%;
        height: 50px;
        border: none;
        outline: none;
        background: #03A9F4;
        color: #fff;
    },
    .input-file-container {
        position: relative;
        width: 225px;
    } 
    .js .input-file-trigger {
        display: block;
        padding: 14px 45px;
        background: #39D2B4;
        color: #fff;
        font-size: 1em;
        transition: all .4s;
        cursor: pointer;
    }
    .js .input-file {
        position: absolute;
        top: 0; left: 0;
        width: 225px;
        opacity: 0;
        padding: 14px 0;
        cursor: pointer;
    }
    .js .input-file:hover + .input-file-trigger,
    .js .input-file:focus + .input-file-trigger,
    .js .input-file-trigger:hover,
    .js .input-file-trigger:focus {
        background: #34495E;
        color: #39D2B4;
    }

    .file-return {
        margin: 0;
    }
    .file-return:not(:empty) {
        margin: 1em 0;
    }
    .js .file-return {
        font-style: italic;
        font-size: .9em;
        font-weight: bold;
    }
    .js .file-return:not(:empty):before {
        content: "Selected file: ";
        font-style: normal;
        font-weight: normal;
    }






    /* Useless styles, just for demo styles */


    .txtcenter {
        margin-top: 4em;
        font-size: .9em;
        text-align: center;
        color: #aaa;
    }
    .copy {
        margin-top: 2em;
    }
    .copy a {
        text-decoration: none;
        color: #1ABC9C;
    }

</style>
<div class="container-fluid">
    <div class="container">
        <div class="formBox">
            <form method="POST" action="submitAddNew.htm" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-sm-12">
                        <h1>Add New ${choice}</h1>
                    </div>
                </div>
                <c:forEach items="${head}" var="item">
                    <c:choose>
                        <c:when test="${item == 'Id'}">
                            <div class="row ">
                              
                            </div> 
                        </c:when>
                        <c:otherwise>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="inputBox ">
                                        <div class="inputText">${item}</div>
                                        <input type="text" name="${item}" class="input">
                                    </div>
                                </div>
                            </div> 
                        </c:otherwise>
                    </c:choose>

                </c:forEach>

                <c:if test="${choice == 'Item'}">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group input-file" name="Fichier1">
                                    <input type="text" class="form-control" placeholder='Choose a file...' />			
                                    <span class="input-group-btn">
                                        <button class="btn btn-default btn-choose" type="button">Choose</button>
                                    </span>
                                </div>
                            </div>
                            <!-- COMPONENT END -->
                            <div class="form-group">
                                <button type="reset" class="btn btn-danger">Reset</button>
                            </div>
                            <p class="file-return"></p>
                        </div>
                    </div>
                </c:if>

                <div class="row">
                    <div class="col-sm-12">
                        <input type="submit" name="" class="button" value="Submit">
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".input").focus(function () {
        $(this).parent().addClass("focus");
    })
    function bs_input_file() {
        $(".input-file").before(
                function () {
                    if (!$(this).prev().hasClass('input-ghost')) {
                        var element = $("<input type='file' name='photo' class='input-ghost' style='visibility:hidden; height:0'>");
                        element.attr("name", $(this).attr("name"));
                        element.change(function () {
                            element.next(element).find('input').val((element.val()).split('\\').pop());
                        });
                        $(this).find("button.btn-choose").click(function () {
                            element.click();
                        });
                        $(this).find("button.btn-reset").click(function () {
                            element.val(null);
                            $(this).parents(".input-file").find('input').val('');
                        });
                        $(this).find('input').css("cursor", "pointer");
                        $(this).find('input').mousedown(function () {
                            $(this).parents('.input-file').prev().click();
                            return false;
                        });
                        return element;
                    }
                }
        );
    }
    $(function () {
        bs_input_file();
    });
</script>