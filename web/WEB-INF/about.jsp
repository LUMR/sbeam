<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-8
  Time: 下午3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关于</title>
    <%@include file="/WEB-INF/view/model/js.jsp"%>
</head>
<body>
<%--header--%>
<%@include file="/WEB-INF/view/model/header.jsp"%>
<%--content--%>
<div class="about">
    <div class="container">
        <h2>About Us</h2>
        <div class="about-text">
            <div class="col-md-6 about-text-left">
                <img src="images/g9.jpg" class="img-responsive" alt=""/>
            </div>
            <div class="col-md-6 about-text-right">
                <h4>Suspendisse ac odio lacinia massa ornare blandit at sit amet dui.</h4>
                <p>The point of using content here'orem Ipsum whichbut the majority have  passage of Lorem Ipsum, you need
                    anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators making this the first true generato.</p>
                <p>Lorem Ipsum whichbut the majority have  passage of Lorem Ipsum,  All the Lorem Ipsum generators making this the first you need to be sure there isn't
                    anything embarrassing hidden in the middle of text</p>
                <ul>
                    <li><a href="#">Donec quam andomised words.</a></li>
                    <li><a href="#">Etiam volutpa andomised words</a></li>
                    <li><a href="#">Varius fusce domised words.</a></li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="abt-btm-grids">
            <div class="col-md-3 abt-sec span_1_of_4">
                <div class="num-heading">
                    <div class="number">
                        <figure><span>1</span></figure>
                    </div>
                    <div class="heading">
                        <h4>Donec ultricies</h4>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="heading-desc">
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                </div>
            </div>
            <div class="col-md-3 abt-sec span_1_of_4">
                <div class="num-heading">
                    <div class="number">
                        <figure><span>2</span></figure>
                    </div>
                    <div class="heading">
                        <h4>Cras accumsan</h4>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="heading-desc">
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                </div>
            </div>
            <div class="col-md-3 abt-sec span_1_of_4">
                <div class="num-heading">
                    <div class="number">
                        <figure><span>3</span></figure>
                    </div>
                    <div class="heading">
                        <h4>Fusce rutrum</h4>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="heading-desc">
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                </div>
            </div>
            <div class="col-md-3 abt-sec span_1_of_4">
                <div class="num-heading">
                    <div class="number">
                        <figure><span>4</span></figure>
                    </div>
                    <div class="heading">
                        <h4>Integer vitae</h4>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="heading-desc">
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <!--teamstarts-->
        <div class="team">
            <div class="team-top">
                <h3>Our Team</h3>
            </div>
            <div class="team-bottom">
                <ul class="ch-grid">
                    <li>
                        <div class="ch-item ch-img-1">
                            <div class="ch-info-wrap">
                                <div class="ch-info">
                                    <div class="ch-info-front ch-img-1"></div>
                                    <div class="ch-info-back">
                                        <h3>Pellentesque ut metus </h3>
                                        <p>by Josh Schott</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="ch-item ch-img-2">
                            <div class="ch-info-wrap">
                                <div class="ch-info">
                                    <div class="ch-info-front ch-img-2"></div>
                                    <div class="ch-info-back">
                                        <h3>Mauris sit amet fringilla</h3>
                                        <p>by Jeremy Slagle</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="ch-item ch-img-3">
                            <div class="ch-info-wrap">
                                <div class="ch-info">
                                    <div class="ch-info-front ch-img-3"></div>
                                    <div class="ch-info-back">
                                        <h3>Morbi eget augue</h3>
                                        <p>by Dustin Leer</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!--teamend-->

    </div>
</div>
<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp"%>
</body>
</html>
