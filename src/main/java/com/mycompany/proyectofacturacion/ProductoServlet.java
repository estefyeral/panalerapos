package com.mycompany.proyectofacturacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet; // 🔥 IMPORTANTE
import java.util.List;

@WebServlet("/ProductoServlet") // 🔥 ESTO ES CLAVE
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ProductosDAO dao = new ProductosDAO();

        try {
            String accion = request.getParameter("accion");

            // 🔥 ELIMINAR
            if (accion != null && accion.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminarProducto(id);
                response.sendRedirect("ProductoServlet");
                return;
            }

            // 🔥 EDITAR (FORMULARIO)
            if (accion != null && accion.equals("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Producto p = dao.obtenerPorId(id);

                out.println("<h2>Editar Producto</h2>");
                out.println("<form method='post'>");

                out.println("<input type='hidden' name='id' value='" + p.getId() + "'>");
                out.println("Nombre: <input type='text' name='nombre' value='" + p.getNombre() + "'><br>");
                out.println("Marca: <input type='text' name='marca' value='" + p.getMarca() + "'><br>");
                out.println("Precio: <input type='text' name='precio' value='" + p.getPrecioVenta() + "'><br>");
                out.println("Stock: <input type='text' name='stock' value='" + p.getStock() + "'><br>");

                out.println("<input type='submit' value='Actualizar'>");
                out.println("</form>");
                return;
            }

            // 🔥 LISTAR
            out.println("<h1>Lista de productos</h1>");

            List<Producto> lista = dao.listarProductos();

            // 🔥 ESTILO (OPCIONAL)
            out.println("<style>");
            out.println("table{border-collapse:collapse;width:70%;}");
            out.println("th,td{padding:10px;border:1px solid black;text-align:center;}");
            out.println("th{background:#4CAF50;color:white;}");
            out.println("a{margin:5px;text-decoration:none;color:blue;}");
            out.println("</style>");

            out.println("<table>");
            out.println("<tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Stock</th><th>Acciones</th></tr>");

            for (Producto p : lista) {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getPrecioVenta() + "</td>");
                out.println("<td>" + p.getStock() + "</td>");

                out.println("<td>");
                out.println("<a href='ProductoServlet?accion=editar&id=" + p.getId() + "'>Editar</a> | ");
                out.println("<a href='ProductoServlet?accion=eliminar&id=" + p.getId() + "' onclick='return confirm(\"¿Eliminar?\")'>Eliminar</a>");
                out.println("</td>");

                out.println("</tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductosDAO dao = new ProductosDAO();

        try {
            String idParam = request.getParameter("id");
            
            String nombre = request.getParameter("nombre");
            String marca = request.getParameter("marca");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            // 🔥 ACTUALIZAR
            if (idParam != null && !idParam.isEmpty()) {

                int id = Integer.parseInt(idParam);

                Producto p = new Producto(id, "COD001", nombre, marca, precio, stock, "2026-12-31", "img.jpg");
                dao.actualizarProducto(p);

            } else {
                // 🔥 INSERTAR
                Producto p = new Producto(0, "COD001", nombre, marca, precio, stock, "2026-12-31", "img.jpg");
                dao.insertarProducto(p);
            }

            response.sendRedirect("ProductoServlet");

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}