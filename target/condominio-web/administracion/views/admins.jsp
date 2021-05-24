<!--
=========================================================
* Paper Dashboard 2 - v2.0.1
=========================================================

* Product Page: https://www.creative-tim.com/product/paper-dashboard-2
* Copyright 2020 Creative Tim (https://www.creative-tim.com)

Coded by www.creative-tim.com

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Directiva
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/paper-dashboard.css" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"/>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/fontawesome/css/all.min.css"/>
    <!-- CSS Files -->
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/css/buttons.bootstrap4.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/css/dataTables.bootstrap5.min.css"/>

    <!-- CSS Just for demo purpose, don't include it in your project <link href="../assets/demo/demo.css" rel="stylesheet" />-->

</head>

<body class="">
<div class="wrapper ">
    <div class="sidebar" data-color="white" data-active-color="danger">
        <div class="logo">
            <a href="https://www.creative-tim.com" class="simple-text logo-mini">
                <div class="logo-image-small">
                    <img src="${ pageContext.request.contextPath }/assets/img/logo-small.png">
                </div>
                <!-- <p>CT</p> -->
            </a>
            <a href="https://www.creative-tim.com" class="simple-text logo-normal">
                <s:property value="#session['user'].nombre" />
                <!-- <div class="logo-image-big">
                  <img src="../assets/img/logo-big.png">
                </div> -->
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="active ">
                    <a href="./dashboard.html">
                        <i class="nc-icon nc-bank"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setTablaUsuarios()">
                        <i class="nc-icon nc-circle-10"></i>
                        <p>Usuarios</p>
                    </a>
                </li>
                <li>
                    <a href="./map.html">
                        <i class="nc-icon nc-pin-3"></i>
                        <p>Maps</p>
                    </a>
                </li>
                <li>
                    <a href="./notifications.html">
                        <i class="nc-icon nc-bell-55"></i>
                        <p>Notifications</p>
                    </a>
                </li>
                <li>
                    <a href="./user.html">
                        <i class="nc-icon nc-single-02"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li>
                    <a href="./tables.html">
                        <i class="nc-icon nc-tile-56"></i>
                        <p>Table List</p>
                    </a>
                </li>
                <li>
                    <a href="./typography.html">
                        <i class="nc-icon nc-caps-small"></i>
                        <p>Typography</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="./upgrade.html">
                        <i class="nc-icon nc-spaceship"></i>
                        <p>Upgrade to PRO</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-toggle">
                        <button type="button" class="navbar-toggler">
                            <span class="navbar-toggler-bar bar1"></span>
                            <span class="navbar-toggler-bar bar2"></span>
                            <span class="navbar-toggler-bar bar3"></span>
                        </button>
                    </div>
                    <a class="navbar-brand" href="javascript:;">Dashboard</a>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="navbar-brand" href="javascript:;">
                                Salir
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="card card-stats">
                        <div class="card-body ">
                            <div class="row">
                                <div class="col-5 col-md-4">
                                    <div class="icon-big text-center icon-warning">
                                        <i class="nc-icon nc-globe text-warning"></i>
                                    </div>
                                </div>
                                <div class="col-7 col-md-8">
                                    <div class="numbers">
                                        <p class="card-category">Capacity</p>
                                        <p class="card-title">150GB<p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <hr>
                            <div class="stats">
                                <i class="fa fa-refresh"></i>
                                Update Now
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="card card-stats">
                        <div class="card-body ">
                            <div class="row">
                                <div class="col-5 col-md-4">
                                    <div class="icon-big text-center icon-warning">
                                        <i class="nc-icon nc-money-coins text-success"></i>
                                    </div>
                                </div>
                                <div class="col-7 col-md-8">
                                    <div class="numbers">
                                        <p class="card-category">Revenue</p>
                                        <p class="card-title">$ 1,345<p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <hr>
                            <div class="stats">
                                <i class="fa fa-calendar-o"></i>
                                Last day
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="card card-stats">
                        <div class="card-body ">
                            <div class="row">
                                <div class="col-5 col-md-4">
                                    <div class="icon-big text-center icon-warning">
                                        <i class="nc-icon nc-vector text-danger"></i>
                                    </div>
                                </div>
                                <div class="col-7 col-md-8">
                                    <div class="numbers">
                                        <p class="card-category">Errors</p>
                                        <p class="card-title">23<p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <hr>
                            <div class="stats">
                                <i class="fa fa-clock-o"></i>
                                In the last hour
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="card card-stats">
                        <div class="card-body ">
                            <div class="row">
                                <div class="col-5 col-md-4">
                                    <div class="icon-big text-center icon-warning">
                                        <i class="nc-icon nc-favourite-28 text-primary"></i>
                                    </div>
                                </div>
                                <div class="col-7 col-md-8">
                                    <div class="numbers">
                                        <p class="card-category">Followers</p>
                                        <p class="card-title">+45K<p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <hr>
                            <div class="stats">
                                <i class="fa fa-refresh"></i>
                                Update now
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card" id="cuerpo">

                    </div>
                </div>
            </div>
        </div>
        <footer class="footer footer-black  footer-white ">
            <div class="container-fluid">
                <div class="row">
                    <nav class="footer-nav">
                        <ul>
                            <li><a href="https://www.creative-tim.com" target="_blank">Creative Tim</a></li>
                            <li><a href="https://www.creative-tim.com/blog" target="_blank">Blog</a></li>
                            <li><a href="https://www.creative-tim.com/license" target="_blank">Licenses</a></li>
                        </ul>
                    </nav>
                    <div class="credits ml-auto">
              <span class="copyright">
                © <script>
                  document.write(new Date().getFullYear())
                </script>, made with <i class="fa fa-heart heart"></i> by Creative Tim
              </span>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>


<!--Modal-->

<div class="modal fade" id="residenteMultas" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Multas</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <!-- FORMULARIO DE RESERVA -->
                <div id="tablaMulta">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 reservaNombre">
                                    <span class="input-group-text" id="basic-addon1">Nombre</span>
                                    <input type="text" class="form-control reservaId" name="nombre"
                                           aria-label="Nombre" aria-describedby="basic-addon1" id="nombreResidente">
                                </div>

                                <div class="input-group mb-2">
                                    <span class="input-group-text" id="basic-addon2">RUN</span>
                                    <input type="text" class="form-control rutP" placeholder="12345678-9" name="rut"
                                        aria-label="Rut" aria-describedby="basic-addon2" id="rutResidente">
                                </div>

                                <div id="cuerpoMulta"></div>



                            </div>
                        </div>
                    </div>
                </div>


                <!-- FINAL FORMULARIO DE RESERVA -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="modalid1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Registro Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div id="form_reserva">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">Usuario</span>
                                    <input type="text" class="form-control " name="usuario"
                                           aria-label="Usuario" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">Password</span>
                                    <input type="password" class="form-control " name="password"
                                           aria-label="Password" aria-describedby="basic-addon1">
                                </div>

                                <div class="input-group mb-2">
                                <span class="input-group-text" id="basic-addon1">Horario</span>
                                <select name="rol" id="rol" class="form-select " aria-label="Default select example">
                                    <option selected>Seleccione Rol</option>
                                    <option value="1">Administrador</option>
                                    <option value="2">Conserje</option>
                                    <option value="3">Directiva</option>
                                    <option value="4">Residente</option>
                                </select>
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">Nombre</span>
                                    <input type="text" class="form-control " name="nombre"
                                           aria-label="Nombre" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">Apellido Paterno</span>
                                    <input type="text" class="form-control " name="apaterno"
                                           aria-label="Apellido Paterno" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">Apellido Materno</span>
                                    <input type="text" class="form-control " name="amaterno"
                                           aria-label="Apellido Materno" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2">
                                    <span class="input-group-text" id="basic-addon1">RUN</span> <input
                                        type="text" class="form-control " placeholder="12345678-9" name="rut"
                                        aria-label="Rut" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">Nacionalidad</span>
                                    <input type="text" class="form-control " name="nacionalidad"
                                           aria-label="Nacionalidad" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">Telefono</span>
                                    <input type="text" class="form-control" name="telefono"
                                           aria-label="Telefono" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">e-mail</span>
                                    <input type="email" class="form-control " name="email"
                                           aria-label="email" aria-describedby="basic-addon1">
                                </div>
                                <select name="condominio" id="condominio" class="form-select mb-2" aria-label="Default select example">
                                    <option selected>Seleccione Condominio</option>
                                </select>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" id="basic-addon1">N°Vivienda</span>
                                    <input type="text" class="form-control" name="vivienda"
                                           aria-label="vivienda" aria-describedby="basic-addon1">
                                </div>
                                <div id="spin" class="col-12"></div>
                                <button id="btn" class="btn btn-primary btn-lg" onclick="getcondominios()">Confirmar
                                    Registro</button>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<!--   Core JS Files   -->
<script
        src="${ pageContext.request.contextPath }/assets/js/jquery.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/popper.min.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/plugins/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/admin-ajax.js" type="text/javascript"></script>


<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/JSZip-2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/pdfmake-0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/pdfmake-0.1.36/vfs_fonts.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/js/dataTables.bootstrap5.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.bootstrap4.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.print.min.js"></script>
<!--  Notifications Plugin    -->
<script
        src="${ pageContext.request.contextPath }/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script
        src="${ pageContext.request.contextPath }/assets/js/paper-dashboard.min.js" type="text/javascript"></script>



<!-- Paper Dashboard DEMO methods, don't include it in your project! <script src="../assets/demo/demo.js"></script>
<script>
    $(document).ready(function() {
        // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
        demo.initChartsPages();
    });
</script>
-->


</body>
</html>