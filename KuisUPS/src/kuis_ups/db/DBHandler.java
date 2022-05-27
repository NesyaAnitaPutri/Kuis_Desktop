
package kuis_ups.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kuis_ups.model.Ups;
import kuis_ups.model.UpsProperty;


public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addUps(Ups t){
        String insertTv = "INSERT INTO `produk`(`kd_ups`, `nama_produk`, `tgl_produksi`, `harga`)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertTv);
            stmtInsert.setString(1, t.getKd_Ups());
            stmtInsert.setString(2, t.getNama());
            stmtInsert.setString(3, t.getTglProduksi());
            stmtInsert.setString(4, t.getHarga());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<UpsProperty> getUps(){
        ObservableList<UpsProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT `kd_ups`, `nama_produk`, `tgl_produksi`, `merk`,  `harga` FROM `produk` ORDER BY `kd_ups`";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                UpsProperty t = new UpsProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    public void deleteDataUps(UpsProperty t){
        String deleteDataUps = "DELETE FROM produk WHERE `produk`.`kd_ups` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteDataUps);
            stmtDelete.setString(1, t.getKd_ups());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editDataUps(UpsProperty t){
        String editDataUps = "UPDATE `produk` SET `produk`.`kd_ups` = ?, `produk`.`nama_produk` = ?,`produk`.`tgl_produksi` = ?,`produk`.`merk` = ?,`produk`.`harga` = ? WHERE `produk`.`kd_ups` = ?";
        try {
            PreparedStatement stmtUpdate = conn.prepareStatement(editDataUps);
            stmtUpdate.setString(1, t.getKd_ups());
            stmtUpdate.setString(2, t.getNama_produk());
            stmtUpdate.setString(3, t.getTgl_produksi());
            stmtUpdate.setString(4, t.getMerk());
            stmtUpdate.setString(5, t.getHarga());
            stmtUpdate.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
