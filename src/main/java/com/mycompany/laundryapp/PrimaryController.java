package com.mycompany.laundryapp;

import com.mycompany.laundryapp.models.Staff;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane frm_main;

    @FXML
    private Label lblForgotPass;

    @FXML
    private Label lblSignUp;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    PreparedStatement pstmt;
    ResultSet res;
    Connection con;

    ResourceBundle primaryBundle;

    public void setBundle(ResourceBundle bundle) {
        this.primaryBundle = bundle;
    }

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        if (bundle == null) {
            if (languageN.equals("en")) {
                bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
            } else {
                Locale.setDefault(new Locale("vi", "VN"));
                bundle = ResourceBundle.getBundle("language.MessageBundle");
            }
        }
        initBtnLanguage();
    }

    public void loginIni(String languageMm) {

        String sql = "select * from staffs where SF_username = ?";
        con = database.openConnection();

        try {
            ResourceBundle bundleee;
            if (languageMm == "en") {
                bundleee = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
            } else {
                Locale.setDefault(new Locale("vi", "VN"));
                bundleee = ResourceBundle.getBundle("language.MessageBundle");
            }

            if (txtUserName.getText().equals("") || txtPassword.getText().equals("")) {
                throw new SQLException(bundleee.getString("fillFieldsMessage"));
            }

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtUserName.getText());
            res = pstmt.executeQuery();

            if (res.next()) {
                if (res.getString("SF_password").equals(txtPassword.getText())) {
                    System.out.println("Login successfully");

                    Staff staff = new Staff(res.getInt("SF_id"), res.getString("SF_name"), res.getString("SF_username"),
                            res.getString("SF_phone"), res.getString("SF_address"));
                    btnLogin.getScene().getWindow().hide();

                    System.out.println(staff.getName() + ", " + staff.getUserName()
                            + ", " + staff.getPhone() + ", " + staff.getAddress());
                    try {
                        ResourceBundle bundle;
                        if (languageMm == "en") {
                            bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
                        } else {
                            Locale.setDefault(new Locale("vi", "VN"));
                            bundle = ResourceBundle.getBundle("language.MessageBundle");
                        }
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashBoard.fxml"), bundle);
                        Parent root = loader.load();

                        DashboardController dashboard = loader.getController();

                        dashboard.initData(staff);
                        dashboard.initLanguage(languageMm);
                        dashboard.initBtnLanguage();
                        dashboard.setBundle(bundle);

                        Stage stage = new Stage();
                        Scene scene = new Scene(root, 1080, 600);

                        stage.setScene(scene);

                        stage.show();
//                        App.setRoot("Dashboard"); 

                    } catch (IOException ex) {
                        Logger.getLogger(PrimaryController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    throw new SQLException(bundleee.getString("wrongPassword"));
                }
            } else {
                throw new SQLException(bundleee.getString("usrn"));
            }

            con.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void login() {
        System.out.println("Called login with " + languageN);
        loginIni(languageN);
    }

    public void signUp() {
//        try {
//            App.setRoot("SignUpPage");
//
//        } catch (IOException ex) {
//            Logger.getLogger(PrimaryController.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
        lblLanguageSwitch.getScene().getWindow().hide();
        try {
            ResourceBundle bundle;
            if (languageN.equals("en")) {
                bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
            } else {
                Locale.setDefault(new Locale("vi", "VN"));
                bundle = ResourceBundle.getBundle("language.MessageBundle");
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"), bundle);
            Parent root = loader.load();

            SignUpPageController sC = loader.getController();

            sC.initLanguage(languageN);
            sC.initBtnLanguage();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SignUpPageController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void ForgotPassword() {
        try {
            App.setRoot("ForgotPassPage");

        } catch (IOException ex) {
            Logger.getLogger(PrimaryController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reloadLogin(String languageMm) {
        lblLanguageSwitch.getScene().getWindow().hide();
        try {
            ResourceBundle bundle;
            if (languageN.equals("en")) {
                bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
            } else {
                Locale.setDefault(new Locale("vi", "VN"));
                bundle = ResourceBundle.getBundle("language.MessageBundle");
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"), bundle);
            Parent root = loader.load();

            PrimaryController pmrC = loader.getController();

            pmrC.initLanguage(languageMm);
            pmrC.initBtnLanguage();
            pmrC.setBundle(bundle);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(PrimaryController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void switchLanguage() {
        if (languageN.equals("en")) {
            languageN = "vi";
        } else {
            languageN = "en";
        }
        reloadLogin(languageN);
//        initBtnLanguage();
    }

    public void initLanguage(String langg) {
        this.languageN = langg;
    }

    public void initBtnLanguage() {
//        System.out.println("INBTN "+languageN);
        if (languageN.equals("en")) {
            lblLanguageSwitch.setText("English");
        } else {
            lblLanguageSwitch.setText("Tiếng Việt");
        }
    }
    private String languageN = "en";
    @FXML
    private Label lblLanguageSwitch;

}
