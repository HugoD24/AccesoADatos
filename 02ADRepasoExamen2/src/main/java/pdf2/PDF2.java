package pdf2;

import java.sql.*;

public class PDF2 {

    static void main() {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros","root","123456789");
            System.out.println("Conexion realizada");

            ej1(cn,"SA");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public static void ej1 (Connection con, String EditorTipo) throws SQLException {
        String sql1= "select nombre_editorial, COUNT(*)\n" +
                "from editoriales left join libros\n" +
                "on cod_editorial = editorial \n" +
                "where tipo= ? \n" +
                "group by nombre_editorial;";

        String sql2= "select nombre_libro, NOMBRE_ESCRITOR \n" +
                "from libros l, editoriales e, escritores es\n" +
                "where e.COD_EDITORIAL = l.EDITORIAL and l.AUTOR = es.COD_ESCRITOR \n" +
                "and NOMBRE_EDITORIAL = ? ";

        PreparedStatement ps = con.prepareStatement(sql1);
        ps.setString(1,EditorTipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            System.out.println(rs.getString(1) + " " + rs.getString(2));

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, rs.getString(1));
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                System.out.println(rs2.getString("nombre_libro") + " " + rs2.getString("NOMBRE_ESCRITOR"));
            }
            rs2.close();
            ps2.close();
        }
        ps.close();
        rs.close();
    }

}
