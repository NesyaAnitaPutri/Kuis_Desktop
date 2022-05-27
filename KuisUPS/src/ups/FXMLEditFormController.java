/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;
import kuis_ups.db.DBHandler;
import kuis_ups.model.Ups;
import kuis_ups.model.UpsProperty;


public class FXMLEditFormController implements Initializable {
    
    @FXML
    private Button btnSave;

   

    @FXML
    private DatePicker dpTanggalProduksi;

    @FXML
    private ToggleGroup merk;

    @FXML
    private RadioButton rdIca;

    @FXML
    private RadioButton rdTopaz;
    
    @FXML
    private RadioButton rdSfc;

    @FXML
    private TextField kd_ups;

    @FXML
    private TextField tfNama;
    
    @FXML
    private TextField tfHarga;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(kd_ups.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalProduksi.getValue().toString());
        String merk ="";
        if(rdIca.isSelected())
            merk = rdIca.getText();
        if(rdSfc.isSelected())
            merk = rdSfc.getText();
        if(rdTopaz.isSelected())
            merk = rdTopaz.getText();
        System.out.println(merk);
       
        System.out.println(tfHarga.getText());
        
        Ups t = new Ups(kd_ups.getText(),tfNama.getText(),dpTanggalProduksi.getValue().toString(),
        merk, tfHarga.getText());
        
        DBHandler dh = new DBHandler("MYSQL");
        dh.addUps(t);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
