package com.example.fdpuser3;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class FoodDeliveryPersonnelUserController {
    String FDPID = "82qjnsa";
    ArrayList<FDPInfo> fdpInfoDataInputList = new ArrayList();
    ArrayList<Equipment> equipmentList = new ArrayList();
    File fdpFile = new File("FDPInfo.bin");
    File equipmentFile = new File("Equipment.bin");

    @FXML
    private AnchorPane reviewContractPane;
    @FXML
    private TableColumn<FDPInfo, String> deliveryAreaColId;
    @FXML
    private Button reviewContractButtonId;
    @FXML
    private TableColumn<FDPInfo, String> endingDateColId;
    @FXML
    private TableColumn<FDPInfo, String> ageColId;
    @FXML
    private TableColumn<FDPInfo, String> nameColId;
    @FXML
    private ComboBox<String> deliveryShiftId;
    @FXML
    private TableColumn<FDPInfo, String> deliveryTypeColId;
    @FXML
    private TableColumn<FDPInfo, String> deliveryShiftColId;
    @FXML
    private Button submitAppButtonId;
    @FXML
    private TableColumn<FDPInfo, String> startingDateColId;
    @FXML
    private DatePicker endingDatePickerId;
    @FXML
    private DatePicker startingDatePickerId;
    @FXML
    private Button checkOrdersButtonId;
    @FXML
    private Button viewNoticeButtonId;
    @FXML
    private ComboBox<String> deliveryTypeId;
    @FXML
    private Button incomeReportButtonId;
    @FXML
    private AnchorPane checkOrdersPane;
    @FXML
    private Button reqEquipmentButtonId;
    @FXML
    private TextField nameId;
    @FXML
    private ComboBox<String> deliveryAreaId;
    @FXML
    private Button cancelDelayButtonId;
    @FXML
    private TableView<FDPInfo> tableViewId;
    @FXML
    private TextField ageId;
    @FXML
    private AnchorPane incomePane;
    @FXML
    private AnchorPane submitApplicationPane;
    @FXML
    private TableView<OrderRequest> tableviewCheckOrderPane;
    @FXML
    private TableColumn<OrderRequest, String> packageColCheckOrderPane;
    @FXML
    private TableColumn<OrderRequest, Integer> DeliveryChargeColCheckOrderPane;
    @FXML
    private TableColumn<OrderRequest, String> deliveryMinColCheckOrderPane;
    @FXML
    private TableColumn<OrderRequest, String> deliveryColHrCheckOrderPane;
    @FXML
    private TableColumn<OrderRequest, String> addressColCheckOrderPane;
    @FXML
    private TextField textFieldSubmitButton;
    @FXML
    private TableView tableviewCancelOrderPane;
    @FXML
    private AnchorPane cancelOrdersPane;
    @FXML
    private TableColumn deliveryColHrCancelOrderPane;
    @FXML
    private DatePicker startDateIncomeReport;
    @FXML
    private TableColumn deliveryMinColCancelOrderPane;
    @FXML
    private TableColumn addressColCancelOrderPane;
    @FXML
    private TableColumn DeliveryChargeColCancelOrderPane;
    @FXML
    private TableColumn packageColCancelOrderPane;
    @FXML
    private DatePicker endDateIncomeReport;
    @FXML
    private BarChart barChartIncomeReportId;
    @FXML
    private LineChart lineChartIncomeReportId;
    @FXML
    private TableView viewNoticeTable;
    @FXML
    private CheckBox bagReqForEquipPaneCheckBox;
    @FXML
    private AnchorPane requestForEqupPane;
    @FXML
    private Label requestForEquipLabel;
    @FXML
    private Label viewNoticeLabel;
    @FXML
    private TableColumn dateColViewNoticeTable;
    @FXML
    private ComboBox<Integer> pairOfGlovesReqForEquipPaneComboBox;
    @FXML
    private TableColumn subjectColViewNoticeTable;
    @FXML
    private CheckBox helmetReqForEquipPaneCheckBox;
    @FXML
    private AnchorPane viewNoticePane;
    @FXML
    private CheckBox phoneCarrierReqForEquipPaneCheckBox;
    @FXML
    private TableColumn typeColViewNoticeTable;
    @FXML
    private CheckBox TShirtReqForEquipPaneCheckBox;
    @FXML
    private ComboBox delayedTimeComboBox;
    @FXML
    private Button helpButtonId;
    @FXML
    private AnchorPane helpPane;
    @FXML
    private Label descriptionOfGoalsLabelHelpPane;

    public FoodDeliveryPersonnelUserController() throws FileNotFoundException {
    }

    public void initialize() {

        // for All the panes to be invisible
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);

        // for Equipment ..
        pairOfGlovesReqForEquipPaneComboBox.getItems().addAll(0,1,2,3);
        /// for Review Contract ..
        this.deliveryAreaId.getItems().addAll(new String[]{"Dhanmondi", "Uttora", "Gulshan", "Mirpur", "Mohammadpur", "Tejgoan"});
        this.deliveryShiftId.getItems().addAll(new String[]{"Morning'10-12'", "Noon'12-15", "Afternoon'15-18", "Evening'18-20", "Night'20-23"});
        this.deliveryTypeId.getItems().addAll(new String[]{"By Walk", "By cycle", "By Motor Cycle", "By Car"});
        this.nameColId.setCellValueFactory(new PropertyValueFactory("name"));
        this.ageColId.setCellValueFactory(new PropertyValueFactory("age"));
        this.deliveryAreaColId.setCellValueFactory(new PropertyValueFactory("deliveryArea"));
        this.deliveryTypeColId.setCellValueFactory(new PropertyValueFactory("deliveryType"));
        this.deliveryShiftColId.setCellValueFactory(new PropertyValueFactory("deliveryShift"));
        this.startingDateColId.setCellValueFactory(new PropertyValueFactory("startDate"));
        this.endingDateColId.setCellValueFactory(new PropertyValueFactory("endDate"));
        this.packageColCheckOrderPane.setCellValueFactory(new PropertyValueFactory("packages"));
        this.DeliveryChargeColCheckOrderPane.setCellValueFactory(new PropertyValueFactory("address"));
        this.deliveryMinColCheckOrderPane.setCellValueFactory(new PropertyValueFactory("address"));
        this.deliveryColHrCheckOrderPane.setCellValueFactory(new PropertyValueFactory("address"));
        this.addressColCheckOrderPane.setCellValueFactory(new PropertyValueFactory("address"));
    }




    ////////////////////////////         Review Contract          //////////////////////
    @FXML
    public void reviewContractButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(true);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);

    }

    @FXML
    public void loadIntoTableButtonReviewContractPane(ActionEvent actionEvent) {
        this.tableViewId.getItems().clear();
        if (!this.nameId.getText().isEmpty() && !this.ageId.getText().isEmpty() && this.deliveryAreaId.getValue() != null && this.deliveryShiftId.getValue() != null && this.deliveryTypeId.getValue() != null) {
            try {
                FDPInfo fdpInfo = new FDPInfo(this.nameId.getText(), this.ageId.getText(), (String)this.deliveryTypeId.getValue(), (String)this.deliveryShiftId.getValue(), (String)this.deliveryAreaId.getValue(), ((LocalDate)this.startingDatePickerId.getValue()).toString(), ((LocalDate)this.endingDatePickerId.getValue()).toString());
                this.fdpInfoDataInputList.add(fdpInfo);
                this.tableViewId.getItems().add(fdpInfo);
            } catch (Exception var4) {
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("Fill all the fields.");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Fill all the fields.");
            a.showAndWait();
        }

    }

    @FXML
    public void submitButtonReviewContractPane(ActionEvent actionEvent) throws IOException {
        ObjectOutputStream oos = null;
        Alert alert;

        if (! tableViewId.getItems().isEmpty()){
        try {

            FileOutputStream fos;
            if (this.fdpFile.exists()) {
                fos = new FileOutputStream(this.fdpFile, true);
                oos = new AppendableObjectOutputStream(fos);
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Approved");
                alert.setContentText("Appendable used.");
                alert.showAndWait();
            } else {
                fos = new FileOutputStream(this.fdpFile, true);
                oos = new ObjectOutputStream(fos);
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Approved");
                alert.setContentText("Appendable not Used.");
                alert.showAndWait();
            }

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Approved");
            alert.setContentText("Fill is written.");
            alert.showAndWait();
            Iterator var8 = this.fdpInfoDataInputList.iterator();

            while(var8.hasNext()) {
                FDPInfo fdpInfo = (FDPInfo)var8.next();
                ((ObjectOutputStream)oos).writeObject(fdpInfo);
            }

            this.fdpInfoDataInputList.clear();
            tableViewId.getItems().clear();
            ((ObjectOutputStream)oos).close();
        } catch (Exception var6) {
            ((ObjectOutputStream)oos).close();
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("File is not written.");
            a.showAndWait();
        }

        }
        else{
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("The table is empty.\n" +
                    "Fill the table then enter Submit");
            alert.showAndWait();

        }
    }

    @FXML
    public void checkOrdersButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(true);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);
    }



    @FXML
    public void pickUpCheckorderPane(ActionEvent actionEvent) {
    }

    @FXML
    public void incomeReportButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(true);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);

    }

    @FXML
    public void cancelDelayButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(true);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);
    }


    //////////////////////////       req for Equipment            /////////////////

    @FXML
    public void reqEquipmentButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(true);
    }


    @FXML
    public void loadButtonReqForEquipPane(ActionEvent actionEvent) throws IOException {
        try {
            Equipment.setFDPID(FDPID);
            equipmentList.add(new Equipment(pairOfGlovesReqForEquipPaneComboBox.getValue(), helmetReqForEquipPaneCheckBox.isSelected(), bagReqForEquipPaneCheckBox.isSelected(), TShirtReqForEquipPaneCheckBox.isSelected(), phoneCarrierReqForEquipPaneCheckBox.isSelected()));
            requestForEquipLabel.setText(equipmentList.getLast().toString());
        } catch(Exception e) {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Gloves ComboBox Must be Filled.");
            a.showAndWait();
        }
    }
    @FXML
    public void submitButtonReqForEquipPane(ActionEvent actionEvent) throws IOException {
        ObjectOutputStream oos = null;

        try {
            Alert alert;
            FileOutputStream fos;
            if (this.equipmentFile.exists()) {
                fos = new FileOutputStream(this.equipmentFile, true);
                oos = new AppendableObjectOutputStream(fos);
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Approved");
                alert.setContentText("Appendable used.");
                alert.showAndWait();
            } else {
                fos = new FileOutputStream(this.equipmentFile, true);
                oos = new ObjectOutputStream(fos);
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Approved");
                alert.setContentText("Appendable not Used.");
                alert.showAndWait();
            }

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Approved");
            alert.setContentText("Fill is written.");
            alert.showAndWait();

            if (! equipmentList.isEmpty()) {
                    oos.writeObject(equipmentList.getLast());

            }
            else{
                oos.close();
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("Please, Load the items before submitting.");
                a.showAndWait();

            }

            equipmentList.clear();
            oos.close();
        } catch (Exception e) {
            oos.close();
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Fill is not Written.");
            a.showAndWait();
        }

    }


    @FXML
    public void submitAppButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(true);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);
    }

    @FXML
    public void viewNoticeButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(true);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);
    }

    @FXML
    public void backButon(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(false);
        requestForEqupPane.setVisible(false);
    }

    @FXML
    public void sendButtonSubmitAApplication(ActionEvent actionEvent) {
    }

    @FXML
    public void CancelButtonCheckorderPane(ActionEvent actionEvent) {
    }

    @FXML
    public void delayButtonCheckorderPane(ActionEvent actionEvent) {
    }

    @FXML
    public void barChartIncomeReportButton(ActionEvent actionEvent) {
    }

    @FXML
    public void LineChartIncomeReportButton(ActionEvent actionEvent) {
    }


    @FXML
    public void createPDF_IncomeReportButton(ActionEvent actionEvent) {
    }

    @FXML
    public void helpButton(ActionEvent actionEvent) {
        reviewContractPane.setVisible(false);
        checkOrdersPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        viewNoticePane.setVisible(false);
        submitApplicationPane.setVisible(false);
        incomePane.setVisible(false);
        helpPane.setVisible(true);
        requestForEqupPane.setVisible(false);
    }

    @FXML
    public void howToRenewContract_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howToReqForEquip_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howToViewNotice_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howToSubmitApplication_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howToCancelOrders_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howTo_CheckOrders_ButtonHelpPane(ActionEvent actionEvent) {
    }
}
