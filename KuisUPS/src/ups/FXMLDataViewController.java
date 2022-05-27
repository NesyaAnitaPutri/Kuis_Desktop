/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import kuis_ups.db.DBHandler;
import kuis_ups.model.UpsProperty;


public class FXMLDataViewController implements Initializable {

    @FXML
    private TableView<UpsProperty> tblUps;

   
    @FXML
    private TableColumn<UpsProperty, String> colMerk;

    @FXML
    private TableColumn<UpsProperty, String> colKd_ups;

    @FXML
    private TableColumn<UpsProperty, String> colNama_produk;

    @FXML
    private TableColumn<UpsProperty, String> colHarga;

    @FXML
    private TableColumn<UpsProperty, String> colTglProduksi;
    
     
    @FXML
    private MenuItem menuEditData;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

    @FXML
     
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }
    
    @FXML
    void viewEditDataUps(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLEditForm.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataUps(ActionEvent event) {
        UpsProperty t = tblUps.getSelectionModel().getSelectedItem();
        int ans = JOptionPane.showConfirmDialog(null, "Yakin Akan Menghapus?");
        if (ans == JOptionPane.YES_OPTION) {
            DBHandler dh = new DBHandler("MYSQL");
            dh.deleteDataUps(t);
            showDataUps();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataUps();
        tblUps.getSelectionModel().selectedIndexProperty().addListener(evt -> {
//            JOptionPane.showMessageDialog(null,"Test Klik");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataUps() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<UpsProperty> data = dh.getUps();
        colMerk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        colKd_ups.setCellValueFactory(new PropertyValueFactory<>("kd_ups"));
        colNama_produk.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
       
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colTglProduksi.setCellValueFactory(new PropertyValueFactory<>("tgl_produksi"));
        tblUps.setItems(null);
        tblUps.setItems(data);
    }   
    
}

