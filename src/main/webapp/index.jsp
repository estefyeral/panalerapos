<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pañalera POS</title>
</head>
<body>

<h1>Registrar Producto</h1>

<form action="ProductoServlet" method="post">

    Nombre: <input type="text" name="nombre"><br>
    Marca: <input type="text" name="marca"><br>
    Precio: <input type="number" name="precio"><br>
    Stock: <input type="number" name="stock"><br>

    <button type="submit">Guardar</button>

</form>

</body>
</html>