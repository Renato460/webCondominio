
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="${ pageContext.request.contextPath }/assets/img/logo_condo.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Administración
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
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/js/OwlCarousel2-2.3.4/dist/assets/owl.carousel.min.css"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@fancyapps/ui/dist/fancybox.css"
    />

</head>

<body class="">
<div class="wrapper ">
    <div class="sidebar" data-color="white" data-active-color="danger">
        <div class="logo">
            <a href="javascript:location.reload()" class="simple-text logo-mini">
                <div class="logo-image-small">
                    <img src="${ pageContext.request.contextPath }/assets/img/logo-small.png">
                </div>
                <!-- <p>CT</p> -->
            </a>
            <a href="javascript:location.reload()" class="simple-text logo-normal">
                <s:property value="#session['user'].nombre" />

                <!-- <div class="logo-image-big">
                  <img src="../assets/img/logo-big.png">
                </div> -->
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="active ">
                    <a href="javascript:location.reload()">
                        <i class="nc-icon nc-bank"></i>
                        <p>Home</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setTablaUsuarios()">
                        <i class="nc-icon nc-circle-10"></i>
                        <p>Usuarios</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setAnuncio()">
                        <i class="far fa-map"></i>
                        <p>Anuncios</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setTabla()">
                        <i class="nc-icon nc-bell-55"></i>
                        <p>Multas</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setTablaViviendas()">
                        <i class="fas fa-city"></i>
                        <p>Condominios</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setTablaGastosComunes()">
                        <i class="nc-icon nc-tile-56"></i>
                        <p>Pago Manual</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setTablaMorosos()">
                        <i class="far fa-times-circle"></i>
                        <p>Morosos</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:setTablaServicios()">
                        <i class="fas fa-car"></i>
                        <p>Servicios</p>
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

                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="navbar-brand" href="logout.action">
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
                                        <p class="card-category">Condominios</p>
                                        <p class="card-title" id="cantcondos"><p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <hr>
                            <div class="stats">
                                <i class="fa fa-refresh"></i>
                                Numero de condominios existentes
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
                                        <p class="card-category">Morosos</p>
                                        <p class="card-title " id="cantmorosos"><p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <hr>
                            <div class="stats">
                                <i class="fa fa-calendar-o"></i>
                                Cantidad de Morosos
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
                                        <i class="fas fa-money-bill-wave text-danger"></i>
                                    </div>
                                </div>
                                <div class="col-7 col-md-8">
                                    <div class="numbers">
                                        <p class="card-category">Multas</p>
                                        <p class="card-title" id="cantmultas"><p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <hr>
                            <div class="stats">
                                <i class="fa fa-refresh"></i>
                                Numero de Condominios
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div id="cuerpo0">
                        <div class="owl-carousel d-flex justify-content-center">

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

        </footer>
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
                <form id="formsetusuario">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text">Usuario</span>
                                    <input type="text" id="usuario" class="form-control " name="usuario"
                                           aria-label="Usuario" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text">Password</span>
                                    <input type="password" id="password" class="form-control " name="password"
                                           aria-label="Password" aria-describedby="basic-addon1">
                                </div>

                                <div class="input-group mb-2">



                                <span class="input-group-text">Rol</span>


                                <select name="rol" id="rol" class="form-select " aria-label="rol">
                                    <option selected>Seleccione Rol</option>
                                    <option value="1">Administrador</option>
                                    <option value="2">Conserje</option>
                                    <option value="3">Directiva</option>
                                    <option value="4">Residente</option>
                                </select>
                                </div>
                                <div class="input-group mb-2 ">


                                    <span class="input-group-text" >Nombre</span>

                                    <input type="text" id="nombre" class="form-control " name="nombre"
                                           aria-label="Nombre" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Apellido Paterno</span>
                                    <input type="text" id="apaterno" class="form-control " name="apaterno"
                                           aria-label="Apellido Paterno" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">

                                    <span class="input-group-text">Apellido Materno</span>

                                    <input type="text" id="amaterno" class="form-control " name="amaterno"
                                           aria-label="Apellido Materno" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2">
                                    <span class="input-group-text" >RUN</span>

                                    <input onfocusout="validarRut()" type="text" id="rut" class="form-control " placeholder="12345678-9" name="rut"
                                        aria-label="Rut" aria-describedby="basic-addon1">
                                </div>

                                <div class="input-group mb-2 ">
                                    <span class="input-group-text">Nacionalidad</span>

                                    <input type="text" class="form-control " id="nacionalidad" name="nacionalidad"
                                           aria-label="Nacionalidad" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">

                                    <span class="input-group-text">Telefono</span>

                                    <input type="text" class="form-control" id="telefono" name="telefono"
                                           aria-label="Telefono" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >e-mail</span>
                                    <input type="email" class="form-control " id="email" name="email"
                                           aria-label="email" aria-describedby="basic-addon1">
                                </div>
                                <select name="condominio" id="condominio" class="form-select mb-2" aria-label="Condominio">
                                    <option selected>Seleccione Condominio</option>
                                </select>
                                <div class="input-group mb-2 ">
                                    <select name="vivienda" id="vivienda" class="form-select mb-2" aria-label="vivienda">
                                        <option selected>Seleccione Vivienda</option>
                                    </select>
                                </div>
                                <div id="cuerpoAlerta" class=" col-lg-12 mt-3"></div>
                                <button type="submit"  class="btn btn-primary btn-lg btnEnviarForma">
                                    Confirmar Registro</button>

                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalid2" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Registro Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="formsetcondominio">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Nombre Condominio</span>
                                    <input type="text" id="nombrecondo" class="form-control " name="nombrecondo"
                                           aria-label="Nombre Condominio" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Calle</span>
                                    <input type="text" id="calle" class="form-control " name="calle"
                                           aria-label="Calle" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Numero </span>
                                    <input type="number" id="numero" class="form-control " name="numero"
                                           aria-label="Numero" aria-describedby="basic-addon1">
                                </div>


                                <select name="region" id="region" class="form-select mb-2" aria-label="region" >


                                    <option selected>Seleccione Region </option>
                                </select>
                                <select name="comunas" id="comunas" class="form-select mb-2" aria-label="region" >
                                    <option selected>Seleccione Comuna </option>
                                </select>
                                <div id="cuerpoAlerta2" class=" col-lg-12 mt-3"></div>
                                <button type="submit"  class="btn btn-primary btn-lg btnEnviarForma">
                                    Confirmar Registro</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="modalid3" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Registro Vivienda</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="formsetvivienda">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Numero Vivienda</span>
                                    <input type="text" id="numerovivienda" class="form-control " name="numerovivienda"
                                           aria-label="Numero Vivienda" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Titular</span>
                                    <input type="text" id="titular" class="form-control " name="titular"
                                           aria-label="Nombre titular" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Rut Titular</span>
                                    <input type="text" id="ruttitular" class="form-control " name="ruttitular"
                                           aria-label="Rut titular" aria-describedby="basic-addon1">
                                </div>
                                <div id="cuerpoAlerta3" class=" col-lg-12 mt-3"></div>
                                <button type="submit"  class="btn btn-primary btn-lg btnEnviarFormaVivienda">
                                    Confirmar Registro</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modalid7" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Registro Vivienda</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="formupdatevivienda">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Numero Vivienda</span>
                                    <input type="text" id="editnumerovivienda" class="form-control " name="numerovivienda"
                                           aria-label="Numero Vivienda" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Titular</span>
                                    <input type="text" id="edittitular" class="form-control " name="titular"
                                           aria-label="Nombre titular" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Rut Titular</span>
                                    <input type="text" id="editruttitular" class="form-control " name="ruttitular"
                                           aria-label="Rut titular" aria-describedby="basic-addon1">
                                </div>
                                <div id="cuerpoAlerta7" class=" col-lg-12 mt-3"></div>
                                <button type="submit"  class="btn btn-primary btn-lg btnEnviarFormaeditVivienda">
                                    Actualizar</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Modal edit -->
<div class="modal fade" id="modalid4" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Editar Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="formedituser">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Nombre</span>
                                    <input type="text" id="nombreedit" class="form-control " name="nombreedit"
                                           aria-label="Nombre" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Apellido Paterno</span>
                                    <input type="text" id="apaternoedit" class="form-control " name="apaternoedit"
                                           aria-label="Apellido Paterno" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Apellido Materno </span>
                                    <input type="text" id="amaternoedit" class="form-control " name="amaternoedit"
                                           aria-label="Apellido Materno" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Run </span>
                                    <input type="text" onfocusout="validarRut()" id="rutedit"  class="form-control " name="rutedit"
                                           aria-label="RUN" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Nacionalidad </span>
                                    <input type="text" id="nacionalidadedit" class="form-control " name="nacionalidadedit"
                                           aria-label="Nacionalidad" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Telefono </span>
                                    <input type="text" id="telefonoedit" class="form-control " name="telefonoedit"
                                           aria-label="Telefono" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Correo </span>
                                    <input type="text" id="correoedit" class="form-control " name="correoedit"
                                           aria-label="Correo" aria-describedby="basic-addon1">
                                </div>
                                <div id="cuerpoAlerta4" class=" col-lg-12 mt-3"></div>
                                <button type="submit"  class="btn btn-primary btn-lg btnEnviarFormaEdit">
                                    Actualizar </button>

                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modalid5" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Agregar Gasto Comun</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="formsetgastocomun">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Titulo/nombre Gasto comun</span>
                                    <input type="text" id="nombregc" class="form-control " name="nombregc"
                                           aria-label="Nombre" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Valor Mensual</span>
                                    <input type="text" id="Valorgc" class="form-control " name="valor"
                                           aria-label="Valor Mensual" aria-describedby="basic-addon1">
                                    <div id="cuerpoAlerta5" class=" col-lg-12 mt-3"></div>
                                    <button type="submit"  class="btn btn-primary btn-lg btnEnviarFormagc">
                                        Agregar Gasto Comun </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalid6" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Editar Gasto Comun</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="formeditgastocomun">
                    <div class="container">
                        <div class="row">

                            <div class='col-lg-12'>

                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Titulo/nombre Gasto comun</span>
                                    <input type="text" id="editnombregc" class="form-control " name="nombregc"
                                           aria-label="Nombre" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-2 ">
                                    <span class="input-group-text" >Valor Mensual</span>
                                    <input type="text" id="editValorgc" class="form-control " name="valor"
                                           aria-label="Valor Mensual" aria-describedby="basic-addon1">
                                    <div id="cuerpoAlerta6" class=" col-lg-12 mt-3"></div>
                                    <button type="submit"  class="btn btn-primary btn-lg btnEnviarUpdate">
                                        Actualizar </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
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
        src="${ pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.bundle.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/plugins/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/admin-ajax.js" type="text/javascript"></script>

<script src="${ pageContext.request.contextPath }/assets/js/ckeditor/ckeditor.js"></script>


<script
        src="${ pageContext.request.contextPath }/assets/js/residente-js/anuncio-ajax.js"></script>

<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/setAnuncio.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/OwlCarousel2-2.3.4/dist/owl.carousel.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/@fancyapps/ui/dist/fancybox.umd.js"></script>



<script
        src="${ pageContext.request.contextPath }/assets/js/conserje-js/multasEdi.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/setMulta.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/listaResidente.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/condominios.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/conserje-js/PagoManualGC.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/multa-ajax.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/Morosos.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/administrador-js/reservasListas.js" type="text/javascript"></script>

<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/JSZip-2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/pdfmake-0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/pdfmake-0.1.36/vfs_fonts.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/DataTables-1.10.24/js/dataTables.bootstrap5.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.bootstrap4.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/dataTable/Buttons-1.7.0/js/buttons.print.min.js"></script>

<script type="text/javascript" src="${ pageContext.request.contextPath }/assets/js/rutValidar.js"></script>
<!--  Notifications Plugin    -->
<script
        src="${ pageContext.request.contextPath }/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script
        src="${ pageContext.request.contextPath }/assets/js/paper-dashboard.min.js" type="text/javascript"></script>
<script
        src="${ pageContext.request.contextPath }/assets/js/main.js" type="text/javascript"></script>



</body>
</html>
