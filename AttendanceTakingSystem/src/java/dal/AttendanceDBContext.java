/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Attendance;
import entity.Report;
import entity.Session;
import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nghia
 */
public class AttendanceDBContext extends DBContext<Attendance> {

    public Report getAbsentPercentage(int gid, int subid, int iid, int stuid) {
        Report r = new Report();
        try {
            String sql = "select COUNT(s.isAtt) as [total], COUNT(CASE WHEN a.[status] = 0 THEN a.[status] END) as [absent]\n"
                    + "from [Session] s \n"
                    + "LEFT JOIN [Group_Student] gs ON s.gid = gs.gid\n"
                    + "INNER JOIN [Group] g ON s.gid = g.gid \n"
                    + "LEFT JOIN [Student] st ON st.stuid = gs.stuid\n"
                    + "LEFT JOIN [Attendance] a ON s.sesid = a.sesid AND a.stuid = st.stuid\n"
                    + "INNER JOIN [Instructor] i ON i.iid = s.iid\n"
                    + "INNER JOIN [Subject] su ON su.subid = g.subid\n"
                    + "WHERE g.gid = ? AND su.subid = ? AND i.iid = ? AND st.stuid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            stm.setInt(2, subid);
            stm.setInt(3, iid);
            stm.setInt(4, stuid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                r.setTotal_session(rs.getInt("total"));
                r.setAbsent(rs.getInt("absent"));
                r.setPercentage(r.getTotal_session(), r.getAbsent());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public ArrayList<Attendance> getAttendanceReport(int gid, int subid, int iid, int stuid) {
        ArrayList<Attendance> atts = new ArrayList<>();
        try {
            String sql = "select st.stuid, st.stuname, a.[status], s.isAtt from [Session] s LEFT JOIN [Group_Student] gs ON s.gid = gs.gid\n"
                    + "INNER JOIN [Group] g ON s.gid = g.gid \n"
                    + "LEFT JOIN [Student] st ON st.stuid = gs.stuid\n"
                    + "LEFT JOIN [Attendance] a ON s.sesid = a.sesid AND a.stuid = st.stuid\n"
                    + "INNER JOIN [Instructor] i ON i.iid = s.iid\n"
                    + "INNER JOIN [Subject] su ON su.subid = g.subid\n"
                    + "WHERE g.gid = ? AND su.subid = ? AND i.iid = ? AND st.stuid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            stm.setInt(2, subid);
            stm.setInt(3, iid);
            stm.setInt(4, stuid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                Session s = new Session();
                s.setIsAtt(rs.getBoolean("isAtt"));
                a.setSession(s);
                a.setStatus(rs.getBoolean("status"));
                atts.add(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public ArrayList<Attendance> getAttendances(int sessid) {
        ArrayList<Attendance> atts = new ArrayList<>();
        try {
            String sql = "SELECT s.stuid,s.stuname,ISNULL(a.status,0) as [status], \n"
                    + "  ISNULL(a.description,'') as [description],\n"
                    + "  ISNULL(a.att_datetime, GETDATE()) as [att_datetime],\n"
                    + "  a.sesid\n"
                    + "  FROM [Session] ses INNER JOIN [Group] g ON ses.gid = g.gid\n"
                    + "	 INNER JOIN [Group_Student] gs ON g.gid = gs.gid\n"
                    + "	 INNER JOIN [Student] s ON s.stuid = gs.stuid\n"
                    + "  LEFT JOIN Attendance a ON s.stuid = a.stuid \n"
                    + "  AND ses.sesid = a.sesid\n"
                    + "  WHERE ses.sesid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sessid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance att = new Attendance();
                Student student = new Student();
                Session session = new Session();
                student.setId(rs.getInt("stuid"));
                student.setName(rs.getString("stuname"));
                session.setId(sessid);
                att.setStudent(student);
                att.setSession(session);
                att.setStatus(rs.getBoolean("status"));
                att.setDescription(rs.getString("description"));
                att.setDatetime(rs.getTimestamp("att_datetime"));
                atts.add(att);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    @Override
    public ArrayList<Attendance> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendance get(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
