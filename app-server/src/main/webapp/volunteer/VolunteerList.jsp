
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="copyright" content="MACode ID, https://macodeid.com/">

  <title>함께해요 : 봉사목록</title>

    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    
    <link rel="stylesheet" href="../assets/css/maicons.css">
  
    <link rel="stylesheet" href="../assets/vendor/animate/animate.css">
  
    <link rel="stylesheet" href="../assets/vendor/owl-carousel/css/owl.carousel.css">
  
    <link rel="stylesheet" href="../assets/vendor/fancybox/css/jquery.fancybox.css">
  
    <link rel="stylesheet" href="../assets/css/theme.css">

</head>
<body>

  <!-- Back to top button -->
  <div class="back-to-top"></div>


  <!---------------------------------------- header ---------------------------------------------->
  <header>
    <div class="top-bar">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-8">
            <div class="d-inline-block">
              <span class="mai-mail fg-primary"></span> <a href="mailto:contact@mail.com">contact@mail.com</a>
            </div>
            <div class="d-inline-block ml-2">
              <span class="mai-call fg-primary"></span> <a href="tel:+0011223495">+0011223495</a>
            </div>
          </div>
          <div class="col-md-4 text-right d-none d-md-block">
            <div class="social-mini-button">
              <a href="#"><span class="mai-logo-facebook-f"></span></a>
              <a href="#"><span class="mai-logo-twitter"></span></a>
              <a href="#"><span class="mai-logo-youtube"></span></a>
              <a href="#"><span class="mai-logo-linkedin"></span></a>
            </div>
          </div>
        </div>
      </div> <!-- .container -->
    </div> <!-- .top-bar -->

    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <a href="index.html" class="navbar-brand">Reve<span class="text-primary">Tive.</span></a>

        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse" id="navbarContent">
          <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
            <li class="nav-item active">
              <a href="index.html" class="nav-link">함께해요</a>
            </li>
            <li class="nav-item">
              <a href="about.html" class="nav-link">소통해요</a>
            </li>
            <li class="nav-item">
              <a href="services.html" class="nav-link">챌린지</a>
            </li>
            <li class="nav-item">
              <a href="portfolio.html" class="nav-link">모금함</a>
            </li>
            <li class="nav-item">
              <a href="blog.html" class="nav-link">고객센터</a>
          </ul>
        </div>
      </div> <!-- .container -->
    </nav> <!-- .navbar -->

    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../assets/img/bg_image_3.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Portfolio</li>
              </ol>
            </nav>
            <h1 class="fg-white text-center">Projects</h1>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->
  </header>

  <main>
    <div class="page-section">
      <div class="container">
        <div class="filterable-btn">
          <button class="btn active" data-filter="*">전체</button>
          <button class="btn" data-filter=".web">비대면</button>
          <button class="btn" data-filter=".mobile">아동</button>
          <button class="btn" data-filter=".desktop">청소년</button>
          <button class="btn" data-filter=".desktop">노인</button>
          <button class="btn" data-filter=".desktop">장애인</button>
          <button class="btn" data-filter=".desktop">동물</button>
          <button class="btn" data-filter=".desktop">환경</button>
          <button class="btn" data-filter=".desktop">기타</button>
        </div>
          <div class="card_body" style="overflow: hidden; box-sizing: border-box; width:100%;" >
           <c:forEach items="${volunteerList}" var="volunteerRequestDTO" >
           
			        <div class="card" style="width: 33.33%; float: left; padding:0 5%;  box-sizing: border-box; border: none;">
			          <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" class="card-img-top" alt="..."> 
			          <div class="card-body">
			            <h5 class="card-title"><a href='detail?no=${volunteerRequestDTO.no}'>${volunteerRequestDTO.title}</a></h5>
			            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			            <a href="#" class="btn btn-primary">상세보기</a>
			          </div>
			        </div>
			        
           </c:forEach>
          </div>
      </div>
       
    <!--  
         <div class="card" style="width: 33.33%; float: left;  box-sizing: border-box; padding: 0 5%; border: none; ">
          <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title"><a href='detail?no=${volunteerRequestDTO.no}'>${volunteerRequestDTO.title}</a></h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>R
          </div>
        </div>

        <div class="card" style="width: 33.33%; float: left;  box-sizing: border-box; padding: 0 5%; border: none;">
          <img src="https://cdn-icons-png.flaticon.com/512/3039/3039788.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
  -->

     


        <div class="grid mt-3">
          <div class="grid-item mobile">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-1.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-1.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item mobile">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-2.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-2.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item web desktop">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-3.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-3.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item web">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-4.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-4.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item mobile">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-5.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-5.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item web desktop">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-6.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-6.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item web">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-7.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-7.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item mobile">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-8.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-8.jpg" alt="">
              </a>
            </div>
          </div>
          <div class="grid-item mobile">
            <div class="portfolio">
              <a href="../assets/img/portfolio/work-9.jpg" data-fancybox="portfolio">
                <img src="../assets/img/portfolio/work-9.jpg" alt="">
              </a>
            </div>
          </div>
        </div> <!-- .grid -->
        <div class="mt-5 text-center">
          <button class="btn btn-primary">Load More</button>
        </div>
      </div> <!-- .container -->
    </div> <!-- .page-section -->
  </main>

 <!---------------------------------------- footer ---------------------------------------------->

  <footer class="page-footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 py-3">
          <h3>Reve<span class="fg-primary">Tive.</span></h3>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Contact Information</h5>
          <p>301 The Greenhouse, Custard Factory, London, E2 8DY.</p>
          <p>Email: example@mail.com</p>
          <p>Phone: +00 112323980</p>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Company</h5>
          <ul class="footer-menu">
            <li><a href="#">Career</a></li>
            <li><a href="#">Resources</a></li>
            <li><a href="#">News & Feed</a></li>
          </ul>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Newsletter</h5>
          <form action="#">
            <input type="text" class="form-control" placeholder="Enter your email">
            <button type="submit" class="btn btn-primary btn-sm mt-2">Submit</button>
          </form>
        </div>
      </div>

      <hr>

      <div class="row mt-4">
        <div class="col-md-6">
          <p>Copyright 2020. This template designed by <a href="https://macodeid.com">MACode ID</a></p>
        </div>
        <div class="col-md-6 text-right">
          <div class="sosmed-button">
            <a href="#"><span class="mai-logo-facebook-f"></span></a>
            <a href="#"><span class="mai-logo-twitter"></span></a>
            <a href="#"><span class="mai-logo-youtube"></span></a>
            <a href="#"><span class="mai-logo-linkedin"></span></a>
          </div>
        </div>
      </div>
    </div>
  </footer> <!-- // container  -->

  
<script src="../assets/js/jquery-3.5.1.min.js"></script>

<script src="../assets/js/bootstrap.bundle.min.js"></script>

<script src="../assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>

<script src="../assets/vendor/wow/wow.min.js"></script>

<script src="../assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>

<script src="../assets/vendor/isotope/isotope.pkgd.min.js"></script>

<script src="../assets/js/google-maps.js"></script>

<script src="../assets/js/theme.js"></script>

</body>
</html>















