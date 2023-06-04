package pbo_kerkel.model;

// Nama File : SembakoDAO.java
// Deskripsi : DAO Sembako
// Pembuat : 
// Tanggal : Minggu, 4 Juni 2023

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class SembakoDAO implements DataDAO<Sembako, Integer> {
    private Connection koneksi;

    public SembakoDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void doCreate(Sembako t) throws SQLException {
        String sql = "INSERT INTO SEMBAKO(nama) VALUES (?)";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setString(1, sql);
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void doUpdate(Sembako t) throws SQLException {
        String sql = "UPDATE SEMBAKO SET nama=? WHERE idSembako=?";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setString(1, t.getNamaSembako());
        pstmt.setInt(2, t.getIdSembako());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void doDelete(Sembako t) throws SQLException {
        String sql = "DELETE FROM Sembako WHERE idSembako=?";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setInt(1, t.getIdSembako());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public List<Sembako> doRetrieve() throws SQLException {
        List<Sembako> temp = new ArrayList<>();
        String sql = "SELECT * FROM Sembako";
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Sembako k = new Sembako(rs.getInt("idSembako"), rs.getString("nama"), rs.getString("jenis"));
            temp.add(k);
        }
        rs.close();
        stmt.close();
        return temp;
    }

    @Override
    public Sembako doGet(Integer e) throws SQLException {
        Sembako k = null;
        String sql = "SELECT * FROM Sembako WHERE idSembako ='" + e + "'";
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            k = new Sembako(rs.getInt("idSembako"), rs.getString("nama"), rs.getString("jenis"));
        }
        rs.close();
        stmt.close();
        return k;
    }

}
