package ConexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    Connection conexion;

    public Conector() {
    }

    public Connection conectorSQLite() {
        Connection conector = null;
        try {
            //Cargamos el driver
            Class.forName("org.sqlite.JDBC");
            //Establecemos la conexión con la base de datos
            conector = DriverManager.getConnection("jdbc:sqlite:BBDD_SQLite.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conector;
    }

    public Connection conectorMariaDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","u12345");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public Connection establecerConexion(int bbdd){
        switch (bbdd){
            case 1 -> conexion = conectorSQLite();
            default-> conexion = null;
        }
        return conexion;
    }


}
