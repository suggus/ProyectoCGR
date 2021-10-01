package JDBC_Pruebas;

import ConexionBBDD.Conector;

import java.sql.*;

public class Conecta_Pruebas {


    public static void main(String[] args) throws SQLException {
        Connection miConexion;

        Conector cn = new Conector();
        //miConexion = cn.conectorMariaDB();
        miConexion = cn.conectorSQLite();

        //Obtención de metadatos
        DatabaseMetaData datosBBDD = miConexion.getMetaData();
        //Mostramos información de la BBDD
        System.out.println("Gestor de BBDD: " + datosBBDD.getDatabaseProductName());
        System.out.println("Versión del Gestor: " + datosBBDD.getDatabaseProductVersion());
        System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
        System.out.println("Versión del driver: " + datosBBDD.getDriverVersion());

        //Mostramos información de las tablas, columnas,
        ResultSet miMetaResult = datosBBDD.getTables(null, null, "DEP%", null);

        //ResultSet miMetaResult = datosBBDD.getTables(null,null,"empl%",null);
        System.out.println("--Lista de tablas--");
        while (miMetaResult.next()) {
            System.out.println(miMetaResult.getString("TABLE_NAME"));
        }
        miMetaResult = datosBBDD.getColumns(null, null, "EMP%", "%IO%");
        //miMetaResult = datosBBDD.getColumns(null,null,"empl%",null);
        System.out.println("--Lista de columnas--");
        while (miMetaResult.next()) {
            System.out.println(miMetaResult.getString("COLUMN_NAME"));
        }

        //Preparamos la consulta (crear el objeto Statement)
        Statement miSentencia = miConexion.createStatement();

        //1.0 Insertar, actualizar y borrar
        String instruccionSql1 = "INSERT INTO cliente (nombre) VALUES ('Raul')";

        //Ejecutar el SQL
        //1.1 Insertar, actualizar y borrar
        miSentencia.executeUpdate(instruccionSql1);
        System.out.println("Datos insertados correctamente");

        ResultSet miResultSet = miSentencia.executeQuery("SELECT * FROM cliente");

        while (miResultSet.next()){
            System.out.println(miResultSet.getString("Nombre") + " " + miResultSet.getString(2));
        }

        miConexion.close();

    }

}
