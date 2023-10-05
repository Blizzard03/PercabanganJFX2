/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package percabanganjfx2.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import percabanganjfx2.Models.PercabanganJFX2models;

/**
 *
 * @author Muhamad Ariq Rasyid
 */
public class PercabanganJFX2tController implements Initializable {

    private final PercabanganJFX2models dt = new PercabanganJFX2models();

    @FXML
    private TextField txtbeli;
    @FXML
    private RadioButton rdbpensil;
    @FXML
    private ToggleGroup Barang;
    @FXML
    private RadioButton rdbpulpen;
    @FXML
    private RadioButton rdbbuku;
    @FXML
    private TextField txtbayar;
    @FXML
    private Button btnhitung;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    @FXML
    private ToggleButton tgbunit;
    @FXML
    private ToggleGroup Satuan;
    @FXML
    private ToggleButton tgbpaket;
    @FXML
    private ToggleButton tgbbox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void hitungklik(ActionEvent event) {
        {
            dt.setBeli(Integer.parseInt(txtbeli.getText()));
            int kode = 1;
            if (rdbbuku.isSelected()) {
                kode = 3;
            } else if (rdbpulpen.isSelected()) {
                kode = 2;
            }
            dt.setPilihbarang(kode);
            kode = 1;
            if (tgbbox.isSelected()) {
                kode = 3;
            } else if (tgbpaket.isSelected()) {
                kode = 2;
            }
            dt.setPilihsatuan(kode);
            int harga = 2000;
            if (dt.getPilihbarang() == 2) {
                harga = 3000;
            } else if (dt.getPilihbarang() == 3) {
                harga = 5000;
            }
            int jumlah = 1;
            if (dt.getPilihsatuan() == 2) {
                jumlah = 5;
            } else if (dt.getPilihsatuan() == 3) {
                jumlah = 20;
            }
            int bayar = harga * jumlah * dt.getBeli();
            txtbayar.setText(String.valueOf(bayar));

        }
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        rdbpensil.setSelected(true);
        tgbunit.setSelected(true);
        txtbayar.setText("");
        txtbeli.setText("");
    }

    @FXML
    private void keluarlik(ActionEvent event) {
        System.exit(0);
    }

}
