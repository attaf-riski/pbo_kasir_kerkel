package pbo_kerkel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MinyakDAO implements DataDAO<Minyak, Integer> {

    private Connection koneksi;

    public MinyakDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void doCreate(Minyak t) throws SQLException {
        String sql = "INSERT INTO MINYAK(idMinyak,harga,satuan,merk) VALUES (?,?,?)";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setInt(1, t.getIdMinyak());
        pstmt.setInt(2, t.getHarga());
        pstmt.setString(3, t.getSatuan());
        pstmt.setString(4, t.getMerk());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public List<Minyak> doRetrieve() throws SQLException {
        List<Minyak> temp = new ArrayList<>();
        String sql = "SELECT * FROM Minyak b, Sembako br WHERE b.idMinyak = br.idSembako";
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Minyak k = new Minyak(rs.getInt("idSembako"), rs.getString("nama"), rs.getString("jenis"),
                    rs.getInt("harga"),
                    rs.getString("satuan"), rs.getString("merk"));
            temp.add(k);
        }
        rs.close();
        stmt.close();
        return temp;
    }

    @Override
    public void doUpdate(Minyak t) throws SQLException {
        String sql = "UPDATE MINYAK SET harga=?,satuan=?,merk=? WHERE idMinyak=?";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setInt(1, t.getHarga());
        pstmt.setString(2, t.getSatuan());
        pstmt.setString(3, t.getMerk());
        pstmt.setInt(4, t.getIdMinyak());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void doDelete(Minyak t) throws SQLException {
        String sql = "DELETE FROM Minyak WHERE idMinyak=?";
        PreparedStatement pstmt = koneksi.prepareStatement(sql);
        pstmt.setInt(1, t.getIdSembako());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public Minyak doGet(Integer e) throws SQLException {
        Minyak k = null;
        String sql = "SELECT * FROM Minyak b, Sembako br WHERE idSembako ='" + e
                + "' AND b.idMinyak = br.idSembako";
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            k = new Minyak(rs.getInt("idSembako"), rs.getString("nama"), rs.getString("jenis"),
                    rs.getInt("harga"),
                    rs.getString("satuan"), rs.getString("merk"));
        }
        rs.close();
        stmt.close();
        return k;
    }

}
