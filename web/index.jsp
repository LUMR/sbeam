<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-5-8
  Time: 下午2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sbeam</title>
    <%@include file="WEB-INF/view/model/js.jsp"%>
</head>
<body>
<%--banner--%>
<jsp:include page="WEB-INF/view/model/banner.jsp"/>
<%--welcome--%>
<%@include file="WEB-INF/view/model/welcome.jsp" %>

<%--content--%>
<div class="content">
    <div class="container">
        <div class="col-md-8 content-left">
            <div class="information">
                <h4>Information</h4>
                <div class="information_grids">
                    <div class="info">
                        <p>" Etiam ante arcu, vestibulum diam. Curabitur quis lectus. Pellentesque dictum odio velit.</p>
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
                        <h5 class="act"><a href="single.html">Action</a></h5>
                        <a href="single.html"><img src="images/c1.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="single.html">Watch Dogs</a></h4>
                            <p>Integer ut leo vitae nibh cursus aliquetr Sed, condimentum bibendum nibh accumsan vel.</p>
                        </div>
                        <div class="more">
                            <a href="single.html">Read more</a>
                        </div>
                    </div>
                    <div class="grid2">
                        <h5 class="race"><a href="single.html">Racing</a></h5>
                        <a href="single.html"><img src="images/c2.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="single.html">Monster Racing</a></h4>
                            <p>Integer ut leo vitae nibh cursus aliquetr Sed, condimentum bibendum nibh accumsan vel.</p>
                        </div>
                        <div class="more">
                            <a href="single.html">Read more</a>
                        </div>
                    </div>
                </div>

                <div class="game-grid-right">
                    <div class="grid3">
                        <h5 class="sport"><a href="single.html">Sports</a></h5>
                        <a href="single.html"><img src="images/c3.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="single.html">FIFA 2015</a></h4>
                            <p>Integer ut leo vitae nibh cursus aliquetr Sed, condimentum bibendum nibh accumsan vel.</p>
                        </div>
                        <div class="more">
                            <a href="single.html">Read more</a>
                        </div>
                    </div>
                    <div class="grid4">
                        <h5 class="arc"><a href="single.html">Arcade</a></h5>
                        <a href="single.html"><img src="images/c4.jpg" class="img-responsive" alt=""/></a>
                        <div class="grid1-info">
                            <h4><a href="single.html">Skylanders</a></h4>
                            <p>Integer ut leo vitae nibh cursus aliquetr Sed, condimentum bibendum nibh accumsan vel.</p>
                        </div>
                        <div class="more">
                            <a href="single.html">Read more</a>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
        <div class="col-md-4 content-right">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs nav2" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Trending</a></li>
                <li role="presentation" ><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Recent Posts</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active re-pad2" id="home">
                    <div class="game1">
                        <div class="col-md-3 tab-pic">
                            <a href="single.html"><img src="images/tr1.jpg" alt="/" class="img-responsive"></a>
                        </div>
                        <div class="col-md-9 tab-pic-info">
                            <h4><a href="single.html">Angry Birds</a></h4>
                            <p>Lorem Ipsum is simply dummy text of the printing industry.</p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="game1">
                        <div class="col-md-3 tab-pic">
                            <a href="single.html"><img src="images/tr3.jpg" alt="/" class="img-responsive"></a>
                        </div>
                        <div class="col-md-9 tab-pic-info">
                            <h4><a href="single.html">Vice City GTA</a></h4>
                            <p>Lorem Ipsum is simply dummy text of the printing industry.</p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="game1">
                        <div class="col-md-3 tab-pic">
                            <a href="single.html"><img src="images/tr2.jpg" alt="/" class="img-responsive"></a>
                        </div>
                        <div class="col-md-9 tab-pic-info">
                            <h4><a href="single.html">Call Of Duty</a></h4>
                            <p>Lorem Ipsum is simply dummy text of the printing industry.</p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane re-pad2" id="profile">
                    <div class="game-post">
                        <div class="col-md-3 tab-pic">
                            <a href="single.html"><img src="images/tr4.jpg" alt="/" class="img-responsive"></a>
                        </div>
                        <div class="col-md-9 tab-post-info">
                            <h4><a href="single.html">IronMan</a></h4>
                            <p>Posted By <a href="#">Admin</a> &nbsp;&nbsp; on June 2, 2015 &nbsp;&nbsp; <a href="#">Comments (10)</a></p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="game-post">
                        <div class="col-md-3 tab-pic">
                            <a href="single.html"><img src="images/tr5.jpg" alt="/" class="img-responsive"></a>
                        </div>
                        <div class="col-md-9 tab-post-info">
                            <h4><a href="single.html">God Of War</a></h4>
                            <p>Posted By <a href="#">Admin</a> &nbsp;&nbsp; on June 2, 2015 &nbsp;&nbsp; <a href="#">Comments (10)</a></p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="game-post">
                        <div class="col-md-3 tab-pic">
                            <a href="single.html"><img src="images/tr6.jpg" alt="/" class="img-responsive"></a>
                        </div>
                        <div class="col-md-9 tab-post-info">
                            <h4><a href="single.html">Need For Speed</a></h4>
                            <p>Posted By <a href="#">Admin</a> &nbsp;&nbsp; on June 2, 2015 &nbsp;&nbsp; <a href="#">Comments (10)</a></p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!---->
            <div class="category blog-ctgry">
                <h4>Top Games</h4>
                <div class="list-group">
                    <a href="#" class="list-group-item">Cras justo odio</a>
                    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                    <a href="#" class="list-group-item">Morbi leo risus</a>
                    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                    <a href="#" class="list-group-item">Vestibulum at eros</a>
                    <a href="#" class="list-group-item">Quisque elementum </a>
                    <a href="#" class="list-group-item">Vestibulum eleifend</a>
                    <a href="#" class="list-group-item">Donec sit amet justo </a>
                </div>
            </div>
            <div class="photo-gallery">
                <h4>Photo Gallery</h4>
                <div class="gallery-1">
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p2.jpg" data-lightbox="example-set"><img class="example-image" src="images/p2.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p1.jpg" data-lightbox="example-set"><img class="example-image" src="images/p1.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p3.jpg" data-lightbox="example-set"><img class="example-image" src="images/p3.jpg" alt=""/></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="gallery-1">
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p4.jpg" data-lightbox="example-set"><img class="example-image" src="images/p4.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p5.jpg" data-lightbox="example-set"><img class="example-image" src="images/p5.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p6.jpg" data-lightbox="example-set"><img class="example-image" src="images/p6.jpg" alt=""/></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="gallery-1">
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p1.jpg" data-lightbox="example-set"><img class="example-image" src="images/p1.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p3.jpg" data-lightbox="example-set"><img class="example-image" src="images/p3.jpg" alt=""/></a>
                    </div>
                    <div class="col-md-4 gallery-grid-pic">
                        <a class="example-image-link" href="images/p4.jpg" data-lightbox="example-set"><img class="example-image" src="images/p4.jpg" alt=""/></a>
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
<%@include file="WEB-INF/view/model/footer.jsp" %>
</body>
</html>
