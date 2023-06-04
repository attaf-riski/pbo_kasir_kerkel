package pbo_kerkel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class BerasDAO implements DataDAO<Beras, Integer> {
    private Connection koneksi;

    public BerasDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    // not used in the business model now
    @Override
    public void doCreate(Beras t) throws SQLException {
        String sql = "INSERT INTO BERAS(idBeras,harga,satuan) VALUES (?,?,?)";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setInt(1, t.getIdBeras());
        pstmt.setInt(2, t.getHarga());
        pstmt.setString(3, t.getSatuan());
        pstmt.executeUpdate();
        pstmt.close();
    }

    // not used in the business model now
    @Override
    public void doUpdate(Beras t) throws SQLException {
        String sql = "UPDATE Beras SET harga=?,satuan=? WHERE idBeras=?";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setInt(1, t.getHarga());
        pstmt.setString(2, t.satuan);
        pstmt.setInt(3, t.idBeras);
        pstmt.executeUpdate();
        pstmt.close();
    }

    // not used in the business model now
    @Override
    public void doDelete(Beras t) throws SQLException {
        String sql = "DELETE FROM Beras WHERE idBeras=?";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setInt(1, t.getIdBeras());
        pstmt.executeUpdate();
        pstmt.close();
    }

    // used in the business model now
    @Override
    public List<Beras> doRetrieve() throws SQLException {
        List<Beras> temp = new ArrayList<>();
        String sql = "SELECT * FROM Beras b, Sembako br WHERE b.idBeras = br.idSembako";
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Beras k = new Beras(rs.getInt("idSembako"), rs.getString("nama"), rs.getString("jenis"), rs.getInt("harga"),
                    rs.getString("satuan"));
            temp.add(k);
        }
        rs.close();
        stmt.close();
        return temp;
    }

    @Override
    public Beras doGet(Integer e) throws SQLException {
        Beras k = null;
        String sql = "SELECT * FROM Beras b, Sembako br WHERE idSembako ='" + e
                + "' AND b.idBeras = br.idSembako";
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            k = new Beras(rs.getInt("idBeras"), rs.getString("nama"), rs.getString("jenis"), rs.getInt("harga"),
                    rs.getString("satuan"));
        }
        rs.close();
        stmt.close();
        return k;
    }

}
