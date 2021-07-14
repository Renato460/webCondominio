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
<div class="wrapper d-flex justify-content-center align-items-center">
    <div class="card w-50 h-50">
        <div class="card-header ">
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
<<<<<<< HEAD
<<<<<<< HEAD
<hr>
=======
<hr><s:property value="#session['user'].nombre" />
=======
            <hr>
            <div class="text-center fs-3"><s:property value="#session['user'].nombre" /></div>
>>>>>>> 66f27f309a7e9bf53350c2aa9f0c271e9b448d46

>>>>>>> 09f75bf8e5459fc744bdc95e9cf099fab9929ce5
        </div>
        <div class="card-body container">
            <div class="row  d-flex justify-content-center">
                <div class="w-50 table-responsive">
                    <table class="table">
                        <thead class="text-primary">
                        <tr>
                            <th scope="col" class="d-flex justify-content-center">Resumen del Pago</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
<<<<<<< HEAD
<<<<<<< HEAD
                            <th scope="row" class="d-flex justify-content-center"><p>Motivo: <s:property value="#session['user'].pagos.tipo"/></p></th>
                        </tr>
                        <tr>
                            <th scope="row" class="d-flex justify-content-center"><p>Descripción: <s:property value="#session['user'].pagos.descripcion"/></p></th>
                        </tr>
                        <tr>
                            <th scope="row" class="d-flex justify-content-center"><p>Monto: $ <s:property value="#session['user'].pagos.monto"/></p></th>
=======
                            <th scope="row" class="d-flex justify-content-center"><p>Motivo: <s:property value="#session['user'].pagos['tipo']"/></p></th>
=======
                            <td class="text-center"><p>Motivo: <s:property value="#session['user'].pagos['tipo']"/></p></td>
>>>>>>> 66f27f309a7e9bf53350c2aa9f0c271e9b448d46
                        </tr>
                        <tr>
                            <td class="text-center"><p>Descripción: <s:property value="#session['user'].pagos['descripcion']"/></p></td>
                        </tr>
                        <tr>
<<<<<<< HEAD
                            <th scope="row" class="d-flex justify-content-center"><p>Monto: $ <s:property value="#session['user'].pagos['monto']"/></p></th>
>>>>>>> 09f75bf8e5459fc744bdc95e9cf099fab9929ce5
=======
                            <td class="text-center"><p>Monto: $ <s:property value="#session['user'].pagos['monto']"/></p></td>
>>>>>>> 66f27f309a7e9bf53350c2aa9f0c271e9b448d46
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
