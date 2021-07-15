<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${ pageContext.request.contextPath }/assets/img/logo_condo.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Recepción de Pago
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/paper-dashboard.css" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"/>
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/fontawesome/css/all.min.css"/>
    <!-- CSS Files -->
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/assets/css/main.css"/>


    <!-- CSS Just for demo purpose, don't include it in your project <link href="../assets/demo/demo.css" rel="stylesheet" />-->

</head>
<body class="">
<div class="container rapper d-flex justify-content-center align-items-center h-100">
    <div class="card row col-lg-8 col-sm-12">
        <div class="card-header">
            <div class="d-flex justify-content-center">
                <div class="circleCheck my-0">
                    <div class="spinner-grow text-success" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                </div>
            </div>
            <div class="d-flex justify-content-center ">
                <h3 class="card-title tituloPago">Verificando su pago, por favor espere...</h3>
            </div>

            <hr>
            <div class="text-center fs-3"><s:property value="#session['user'].nombre" /></div>

        </div>
        <div class="card-body">
            <div >
                <div class="table-responsive">
                    <table class="table w-100 h-100">
                        <thead class="text-primary">
                        <tr>
                            <th scope="col" class="d-flex justify-content-center">Resumen del Pago</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="text-center"><p>Motivo: <s:property value="#session['user'].pagos['id']"/></p></td>
                        </tr>
                        <tr>
                            <td class="text-center"><p>Descripción: <s:property value="#session['user'].pagos['descripcion']"/></p></td>
                        </tr>
                        <tr>
                            <td class="text-center"><p>Monto: $ <s:property value="#session['user'].pagos['monto']"/></p></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="card-footer">

        </div>
    </div>
</div>



<!--Modal-->

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
        src="${ pageContext.request.contextPath }/assets/js/pago.js" type="text/javascript"></script>


<!--  Notifications Plugin    -->
<script
        src="${ pageContext.request.contextPath }/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script
        src="${ pageContext.request.contextPath }/assets/js/paper-dashboard.min.js" type="text/javascript"></script>


</body>
</html>
