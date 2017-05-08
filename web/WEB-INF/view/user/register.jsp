<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-8
  Time: 下午3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册</title>
    <%@include file="/WEB-INF/view/model/js.jsp"%>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp"%>
<%--register--%>
<div class="contact">
    <div class="container">
        <h2>Contact</h2>
        <div class="map">
            <h4>How to find us :</h4>
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3886.684442427422!2d80.23489400000001!3d13.055746999999991!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a52665faca71f3d%3A0x4eb15438d7a22677!2sFrench+Loaf!5e0!3m2!1sen!2sin!4v1433740002194" style="border:0"></iframe>

        </div>
        <div class="address">
            <div class="col-md-4 address-grids">
                <h4>Address :</h4>
                <ul>
                    <li><p>Eiusmod Tempor inc<br>
                        St Dolore Place,<br>
                        Kingsport 56777</p>
                    </li>
                </ul>
            </div>
            <div class="col-md-4 address-grids">
                <h4>Phone :</h4>
                <p>+2 123 456 789</p>
                <p>+2 987 654 321</p>
            </div>
            <div class="col-md-4 address-grids">
                <h4>Email :</h4>
                <p><a href="mailto:example@email.com">mail@example.com</a></p>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="contact-form">
            <h4>Contact Form</h4>
            <form>
                <input type="text" placeholder="Name" required="">
                <input type="email" placeholder="Email" required="">
                <input type="text" placeholder="Telephone" required="">
                <textarea placeholder="Message" required=""></textarea>
                <button class="btn1 btn-1 btn-1b">Submit</button>
            </form>
        </div>
    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp"%>
</body>
</html>
