package com.example.fdpuser3;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FoodDeliveryPersonnelUserController {
    ArrayList<FDPInfo> fdpInfoDataInputList = new ArrayList();
    ArrayList<FDPInfo> fdpDataInFileList = new ArrayList();
    File fdpFile = new File("FDPInfo.bin");
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
    private TableView<OrderFood> tableviewCheckOrderPane;
    @FXML
    private TableColumn<OrderFood, String> packageColCheckOrderPane;
    @FXML
    private TableColumn<OrderFood, Integer> DeliveryChargeColCheckOrderPane;
    @FXML
    private TableColumn<OrderFood, String> deliveryMinColCheckOrderPane;
    @FXML
    private TableColumn<OrderFood, String> deliveryColHrCheckOrderPane;
    @FXML
    private TableColumn<OrderFood, String> addressColCheckOrderPane;
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
    private ComboBox pairOfGlovesReqForEquipPaneComboBox;
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
    private AnchorPane helpPane;
    @FXML
    private Label descriptionOfGoalsLabelHelpPane;
    @FXML
    private Button helpButtonId;

    public FoodDeliveryPersonnelUserController() throws FileNotFoundException {
    }

    public void initialize() {
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

    @FXML
    public void reviewContractButton(ActionEvent actionEvent) {
    }

    @FXML
    public void viewIntoTableButton(ActionEvent actionEvent) {
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
    public void submitButton(ActionEvent actionEvent) throws IOException {
        ObjectOutputStream oos = null;

        try {
            Alert alert;
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
            ((ObjectOutputStream)oos).close();
        } catch (Exception var6) {
            ((ObjectOutputStream)oos).close();
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Fill is not Written.");
            a.showAndWait();
        }

    }

    @FXML
    public void checkOrdersButton(ActionEvent actionEvent) {
    }

    @FXML
    public void LoadButtonCheckorderPane(ActionEvent actionEvent) {
    }

    @FXML
    public void pickUpCheckorderPane(ActionEvent actionEvent) {
    }

    @FXML
    public void incomeReportButton(ActionEvent actionEvent) {
    }

    @FXML
    public void cancelDelayButton(ActionEvent actionEvent) {
    }

    /** @deprecated */
    @Deprecated
    public void reportToManagerButton(ActionEvent actionEvent) {
    }

    @FXML
    public void reqEquipmentButton(ActionEvent actionEvent) {
    }

    @FXML
    public void submitAppButton(ActionEvent actionEvent) {
    }

    @FXML
    public void viewNoticeButtonI(ActionEvent actionEvent) {
    }

    @FXML
    public void backButon(ActionEvent actionEvent) {
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
    public void loadButtonReqForEquipPaneCheckBox(ActionEvent actionEvent) {
    }

    @FXML
    public void submitButtonReqForEquipPaneCheckBox(ActionEvent actionEvent) {
    }

    @FXML
    public void helpButton(ActionEvent actionEvent) {
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

    @FXML
    public void createPDF_IncomeReportButton(ActionEvent actionEvent) {
    }
}
