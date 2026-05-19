/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import latihan.database.Connector;
import latihan.model.AndroidDeveloper;
import latihan.model.Kandidat;
import latihan.model.WebsiteDeveloper;

/**
 *
 * @author Pongo
 */
public class KandidatDAO {

    public void insert(Kandidat k) {
        String query = "INSERT INTO recruit (nama, path, writing, coding, interview, score, status)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Connector.connect();) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, k.getNama());
            ps.setString(2, k.getPath());
            ps.setInt(3, k.getWriting());
            ps.setInt(4, k.getCoding());
            ps.setInt(5, k.getInterview());
            ps.setFloat(6, k.calculateFinalScore());
            k.setStatus();
            ps.setString(7, k.getStatus());

            ps.executeUpdate();

            ps.close();
            System.out.println("Data Berhasil ditambahkan");

        } catch (SQLException e) {
            System.out.println("Data gagal ditambahkan" + e.getMessage());
        }
    }

    public void update(Kandidat k) {
        String query = "UPDATE recruit SET "
                + "nama = ?, "
                + "path = ?, "
                + "writing = ?,"
                + "coding = ?, "
                + "interview = ?,"
                + "score = ?,"
                + "status = ? "
                + "WHERE id = ?";

        try (Connection conn = Connector.connect();) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, k.getNama());
            ps.setString(2, k.getPath());
            ps.setInt(3, k.getWriting());
            ps.setInt(4, k.getCoding());
            ps.setInt(5, k.getInterview());
            k.setStatus();
            ps.setFloat(6, k.calculateFinalScore());
            ps.setString(7, k.getStatus());

            ps.setInt(8, k.getId());

            ps.executeUpdate();
            ps.close();
            System.out.println("Data berhasil diupdate");

        } catch (SQLException e) {
            System.out.println("Data gagal diupdate" + e.getMessage());
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM recruit WHERE id = ?";
        try (Connection conn = Connector.connect()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Data berhasil dihapus");
        } catch (SQLException e) {
            System.out.println("Data gagal dihapus" + e.getMessage());
        }

    }

    public List<Kandidat> getAll() {
        List<Kandidat> list = new ArrayList<>();
        String query = "SELECT * FROM recruit";

        try (Connection conn = Connector.connect()) {
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String path = rs.getString("path");
                int writing = rs.getInt("writing");
                int coding = rs.getInt("coding");
                int interview = rs.getInt("interview");
                
                Kandidat k;
                if(path.equals("Android Developer")) {
                    k = new AndroidDeveloper(nama,path, writing, coding, interview);
                }else {
                    k = new WebsiteDeveloper(nama, path, writing, coding, interview);
                }
                k.setStatus();
                k.setId(id);
                
                list.add(k);
            }

        } catch (SQLException e) {
            System.out.println("Read Gagal" + e.getMessage());
            return null;
        }
        
        System.out.println("Read berhasil");
        return list;
    }

}
