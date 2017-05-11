<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-8
  Time: 下午2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sbeam</title>
    <%@include file="/WEB-INF/view/model/js.jsp" %>
</head>
<body>
<%--banner--%>
<jsp:include page="/WEB-INF/view/model/banner.jsp"/>
<%--welcome--%>
<%@include file="/WEB-INF/view/model/welcome.jsp" %>

<%--content--%>
<div class="content">
    <div class="container">
        <div class="col-md-8 content-left">
            <div class="information">
                <h4>最新消息</h4>
                <div class="information_grids">
                    <div class="info">
                        <p>温州皮革厂倒闭啦，老板带着小姨子跑路啦，所以有游戏5折大甩卖，你没听错，5折！买不了吃亏，买不了上当！</p>
                        <a href="about.html">Read more</a>
                    </div>
                    <div class="info-pic">
                        <img src="images/ps.png" class="img-responsive" alt=""/>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="games-grids">
                <div class="game-grid-left">
                    <div class="grid1">
                        <h5 class="act"><a href="single.html">${hotGames[0].category.name}</a></h5>
                        <a href="/library/game/${hotGames[0].id}"><img src="images/c1.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="/library/game/${hotGames[0].id}">${hotGames[0].name}</a></h4>
                            <p>${hotGames[0].description}</p>
                        </div>
                        <div class="more">
                            <a href="/library/game/${hotGames[0].id}">Read more</a>
                        </div>
                    </div>
                    <div class="grid2">
                        <h5 class="race"><a href="/library/game/${hotGames[1].id}">${hotGames[1].category.name}</a></h5>
                        <a href="single.html"><img src="images/c2.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="/library/game/${hotGames[1].id}">${hotGames[1].name}</a></h4>
                            <p>${hotGames[1].description}</p>
                        </div>
                        <div class="more">
                            <a href="/library/game/${hotGames[1].id}">Read more</a>
                        </div>
                    </div>
                </div>

                <div class="game-grid-right">
                    <div class="grid3">
                        <h5 class="sport"><a href="/library/game/${hotGames[2].id}">${hotGames[2].category.name}</a></h5>
                        <a href="/library/game/${hotGames[2].id}"><img src="images/c3.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="/library/game/${hotGames[2].id}">${hotGames[2].name}</a></h4>
                            <p>${hotGames[2].description}</p>
                        </div>
                        <div class="more">
                            <a href="/library/game/${hotGames[2].id}">Read more</a>
                        </div>
                    </div>
                    <div class="grid4">
                        <h5 class="arc"><a href="/library/game/${hotGames[3].id}">${hotGames[3].category.name}</a></h5>
                        <a href="/library/game/${hotGames[3].id}"><img src="images/c4.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="/library/game/${hotGames[3].id}">${hotGames[3].name}</a></h4>
                            <p>${hotGames[3].description}</p>
                        </div>
                        <div class="more">
                            <a href="/library/game/${hotGames[3].id}">Read more</a>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/">企业网站模板</a></div>
        <div class="col-md-4 content-right">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs nav2" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                          data-toggle="tab">最近购买</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">
                    最近上架
                </a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active re-pad2" id="home">
                    <c:forEach items="${buyGames}" var="game">
                        <div class="game1">
                            <div class="col-md-3 tab-pic">
                                <a href="single.html"><img src="images/tr1.jpg" alt="/" class="img-responsive"></a>
                            </div>
                            <div class="col-md-9 tab-pic-info">
                                <h4><a href="/library/game/${game.id}">${game.name}</a></h4>
                                <p>${game.description}</p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </c:forEach>


                </div>
                <div role="tabpanel" class="tab-pane re-pad2" id="profile">
                    <c:forEach items="${newGames}" var="game">
                        <div class="game-post">
                            <div class="col-md-3 tab-pic">
                                <a href="/library/game/${game.id}"><img src="images/tr4.jpg" alt="/" class="img-responsive"></a>
                            </div>
                            <div class="col-md-9 tab-post-info">
                                <h4><a href="/library/game/${game.id}">${game.name}</a></h4>
                                <p>Posted By <a href="#">Admin</a> &nbsp;&nbsp; on ${game.pubdate.toLocaleString()}&nbsp;&nbsp;
                                    <a href="#">Comments (10)</a></p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </c:forEach>

                </div>
            </div>
            <!---->
            <div class="category blog-ctgry">
                <h4>热门游戏</h4>
                <div class="list-group">
                    <c:forEach items="${hotGames}" var="game">
                        <a href="/library/game/${game.id}" class="list-group-item">${game.name}</a>
                    </c:forEach>
                </div>
            </div>
            <div class="photo-gallery">
                <h4>Photo Gallery</h4>
                <div class="gallery-1">
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p2.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p2.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p1.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p1.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p3.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p3.jpg" alt=""/></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="gallery-1">
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p4.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p4.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p5.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p5.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p6.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p6.jpg" alt=""/></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="gallery-1">
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p1.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p1.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p3.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p3.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p4.jpg" data-lightbox="example-set"><img
                                class="example-image" src="images/p4.jpg" alt=""/></a>
                    </div>
                    <div class="clearfix"></div>
                </div>

            </div>

        </div>
        <div class="clearfix"></div>
    </div>
</div>
<script src="js/lightbox-plus-jquery.min.js"></script>

<%--footer--%>
<%@include file="/WEB-INF/view/model/footer.jsp" %>
</body>
</html>
