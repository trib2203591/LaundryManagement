/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.laundryapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author myngo
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane ItemsManage;

    @FXML
    private Button aboutUsBtn;

    @FXML
    private AnchorPane aboutUsForm;

    @FXML
    private Button itemManageBtn;

    @FXML
    private Button newOrderBtn;

    @FXML
    private AnchorPane newOrderForm;

    @FXML
    private Button orderListBtn;

    @FXML
    private AnchorPane orderListForm;

    @FXML
    private Button serviceManageBtn;

    @FXML
    private Button servicesBtn;

    @FXML
    private AnchorPane servicesForm;

    @FXML
    private AnchorPane servicesManage;

    @FXML
    private Button statisticsBtn;

    @FXML
    private AnchorPane statisticsForm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Stage stage = (Stage) .getScene().getWindow();
    }

    public void switchManageCategory(ActionEvent e) {
        if (e.getSource() == serviceManageBtn) {
            servicesManage.setVisible(true);
            ItemsManage.setVisible(false);
        } else {
            servicesManage.setVisible(false);
            ItemsManage.setVisible(true);
        }
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == orderListBtn) {
            orderListBtn.getStyleClass().add("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
                    
            orderListForm.setVisible(true);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(false);
        } else if (event.getSource() == newOrderBtn) {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().add("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(true);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(false);
        } else if (event.getSource() == servicesBtn) {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().add("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(true);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(false);
        } else if (event.getSource() == statisticsBtn) {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().add("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(true);
            aboutUsForm.setVisible(false);
        } else {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().add("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(true);
        }
    }

}