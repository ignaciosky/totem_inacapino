/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarkNess
 */
public class ConexionSQL {
    Connection cnn;
    Statement state;
    ResultSet res;
    
    public ConexionSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bdinacapej?user=root&password=");
            Statement state = cnn.createStatement();
            
        }catch(ClassNotFoundException exc){
            exc.printStackTrace();
            
        
        }catch(SQLException ex){
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public ResultSet consultarAlumno(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bdinacapej?user=root&password=");
            Statement state = cnn.createStatement();
            String query ="select a.nombre, c.nombre from alumno a inner join carrera c on a.idalumno = c.alumno_idalumno;";
            state = cnn.createStatement();
            res = state.executeQuery(query);            
        } catch (Exception ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
        public ResultSet consultarDocente(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bdinacapej?user=root&password=");
            Statement state = cnn.createStatement();
            String query ="select d.nombre, a.nombre, h.horaInicio, h.horaTermino, h.sala from docente d inner join horario h on d.iddocente = h.docente_iddocente inner join asignatura a on a.idasignatura = h.asignatura_idasignatura;";
            state = cnn.createStatement();
            res = state.executeQuery(query);            
        } catch (Exception ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
        public ResultSet login(String rut, String pass){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bdinacapej?user=root&password=");
            Statement state = cnn.createStatement();
            String query ="select * from alumno where rut='"+rut+"'and pass='"+pass+"';";
            
            state = cnn.createStatement();
            res = state.executeQuery(query);            
        } catch (Exception ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
        
        public ResultSet buscarDocente(String nombre){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/bdinacapej?user=root&password=");
            Statement state = cnn.createStatement();
            String query ="select d.nombre, a.nombre, h.horaInicio, h.horaTermino, h.sala from docente d inner join horario h on d.iddocente = h.docente_iddocente inner join asignatura a on a.idasignatura = h.asignatura_idasignatura where d.nombre='"+nombre+"'";
            state = cnn.createStatement();
            res = state.executeQuery(query);            
        } catch (Exception ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
        
    public ResultSet Combo(){
        try{
            String query ="select * from ciudad";
            state = cnn.createStatement();
            res = state.executeQuery(query);  
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return res;
    }
      public int actualizarIndicador(String fallas, String correctas)
    {
       
        int flag=0;
        try {            
           String query="UPDATE `bdinacapej`.`indicadores` SET `fallas`='"+fallas+"', `correctas`='"+correctas+"'  where nombre='consulta'";
            state = cnn.createStatement();
           flag = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
  
}

