package com.example.fdpuser3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.ArrayList;

public class OnlineCustomerController {

    String customerName = "Saif Nasim";
    String customerEmail = "saifnasim@gmail.com";
    int customerPhone = 123456789;
    String customerAddress = "Mirpur 10,Sen Para";


    ArrayList<CustomerOrders> customerOrderList = new ArrayList<>();
    ArrayList<CustomerOrders> priceList = new ArrayList<>();
    ArrayList<PickUpOrders> pickUpOrderList = new ArrayList<>();
    ArrayList<Order> ordersForCancelledList = new ArrayList<>();


    File customerOrdersFile = new File("CustomerOrders.bin");
    File pickUpOrdersFile = new File("PickUpOrders.bin");

    @FXML
    private AnchorPane cancelOrdersPane;

    @FXML
    private AnchorPane helpPane;

    @FXML
    private Label descriptionOfGoalsLabelHelpPane;

    @FXML
    private AnchorPane pickUpPane;
    @FXML
    private AnchorPane checkOrderHistoryPane;
    @FXML
    private AnchorPane reportPane;
    @FXML
    private AnchorPane rateFoodPane;
    @FXML
    private AnchorPane tipPane;
    @FXML
    private Button submitButtonRateFood;
    @FXML
    private ComboBox GiveRatingComboBoxRateFoof;
    @FXML
    private TableColumn foodPackageColRateFood;
    @FXML
    private TextField commenttextFieldRateFood;
    @FXML
    private TableColumn orderDateColRateFood;
    @FXML
    private TableColumn orderTimeColRateFood;
    @FXML
    private TableView tableViewRateFood;
    @FXML
    private Label foodDetailsLabelRateFood;
    @FXML
    private TableColumn costColRateFood;
    @FXML
    private TextArea harassmenTextAreaReportPane;
    @FXML
    private ComboBox emploteeTypeComboBoxReportPane;
    @FXML
    private TextArea reportStatementTextAreaReportPane;
    @FXML
    private ComboBox commonReportsComboBoxReportPane;
    @FXML
    private ComboBox emploteeNameComboBoxReportPane;
    @FXML
    private ComboBox harassmentTypeComboBoxReportPane;
    @FXML
    private CheckBox harassmentCheckBoxReportPane;
    @FXML
    private AnchorPane orderFoodPane;


    // Order food table View SubTableCancelPaneClass@FXML
    @FXML
    private TableView<CustomerOrders> tableViewIdOrderFoodPane;
    @FXML
    private TableColumn<CustomerOrders, String> foodNameColIdOrderFoodPane;
    @FXML
    private TableColumn<CustomerOrders, Float> pricePerQuantityColIdOrderFoodPane;
    @FXML
    private TableColumn<CustomerOrders, Integer> quantityColIdOrderFoodPane;
    @FXML
    private TableColumn<CustomerOrders, Float> subTotalColIdOrderFoodPane;

    // order food comboBox //
    @FXML
    private ComboBox<String> selectFoodTypeComboBoxOrderFoodPane;
    @FXML
    private ComboBox<Integer> selectFoodQuantityComboBoxOrderFoodPane;
    @FXML
    private ComboBox<String> selectBevarageTypeComboBoxOrderFoodPane;
    @FXML
    private ComboBox<Integer> selectBevarageQuantityComboBoxOrderFoodPane;
    @FXML
    private Label priceLabelOrderFoodPane;
    @FXML
    private Label totalPriceLabelIdOrderPane;


    // PickUp Order table View //
    @FXML
    private TableView<PickUpOrders> tableViewIdPickUpPane;
    @FXML
    private TableColumn<PickUpOrders, String> foodIdCol1PickUpPane;
    @FXML
    private TableColumn<PickUpOrders, String> foodNameColIdPickUpPane;
    @FXML
    private TableColumn<PickUpOrders, Float> pricePerQuantityColIdPickUpPane;
    @FXML
    private TableColumn<PickUpOrders, Integer> quantityColIdPickUpPane;
    @FXML
    private TableColumn<PickUpOrders, Float> subTotalColIdPickUpPane;
    @FXML
    private TableColumn<PickUpOrders, Integer> pickUpHrColIdPickUpPane;
    @FXML
    private TableColumn<PickUpOrders, String> am_pm_col_PickUpPane;
    @FXML
    private TableColumn<PickUpOrders, Integer> pickUpMinColIdPickUpPane;


    // comboBox and radio buttons , label PickUp Pane  //
    @FXML
    private RadioButton amRadioButtonPickUpPane;
    @FXML
    private ComboBox<Integer> selectPickUpHourComboBoxPickUpPane;
    @FXML
    private RadioButton pmRadioButtonPickUpPane;
    @FXML
    private ComboBox<Integer> selectQuantityComboBoxPickUpPane;
    @FXML
    private Label totalPriceLabelIdPickUpPane;
    @FXML
    private ComboBox<String> selectFoodOrBeverageComboBoxPickUpPane;
    @FXML
    private ComboBox<Integer> selectPickUpMinComboBoxPickUpPane;

    // TableView CancelOrderPane
    @FXML
    private TableView<Order> tableviewCancelOrderPane;
    @FXML
    private TableColumn<Order, String> packageColCancelOrderPane;
    @FXML
    private TableColumn<Order, String> addressColCancelOrderPane;
    @FXML
    private TableColumn<Order, Integer> deliveryColHrCancelOrderPane;
    @FXML
    private TableColumn<Order, Integer> deliveryMinColCancelOrderPane;
    @FXML
    private TableColumn<Order, Float> deliveryCostColCancelOrderPane;
    @FXML
    private TableColumn<Order,String> PickUp_DeliverycolCancelPane;
    @FXML
    private Label totalPriceToBePaidLabelIdOrderPane;
    @FXML
    private TextArea detailsAboutOrderCancelPane;



    public void initialize() {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);


        // setting table view for Order Food  pane//
        tableViewIdOrderFoodPane.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        foodNameColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("food_drinkName"));
        pricePerQuantityColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("pricePerQuantity"));
        quantityColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        subTotalColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("subTotal"));

        // temporary ComboBox for OrderFoodPane //
        selectFoodTypeComboBoxOrderFoodPane.getItems().addAll("Chicken Nuggets 8", "Burger with Chicken", "1 Bowl rice with Chicken", "BBQ Burger with Chicken", "Small Chess Burger");
        selectFoodQuantityComboBoxOrderFoodPane.getItems().addAll(-5, -3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        selectBevarageTypeComboBoxOrderFoodPane.getItems().addAll("500 ml Pepsi", "1L pepsi", "1.25L pepsi", "2L pepsi");
        selectBevarageQuantityComboBoxOrderFoodPane.getItems().addAll(-5, -3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        // TableView for PickUpPane //
        tableViewIdOrderFoodPane.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        foodIdCol1PickUpPane.setCellValueFactory(new PropertyValueFactory<>("foodId"));
        foodNameColIdPickUpPane.setCellValueFactory(new PropertyValueFactory<>("food_BeverageName"));
        pricePerQuantityColIdPickUpPane.setCellValueFactory(new PropertyValueFactory<>("food_BeveragePrice"));
        quantityColIdPickUpPane.setCellValueFactory(new PropertyValueFactory<>("food_BeverageQuantity"));
        subTotalColIdPickUpPane.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        pickUpHrColIdPickUpPane.setCellValueFactory(new PropertyValueFactory<>("pickUpHour"));
        am_pm_col_PickUpPane.setCellValueFactory(new PropertyValueFactory<>("AmPm"));
        pickUpMinColIdPickUpPane.setCellValueFactory(new PropertyValueFactory<>("pickupMin"));


        //temporary ComboBox for  PickUp Pane//
        selectFoodOrBeverageComboBoxPickUpPane.getItems().addAll("Chicken Nuggets 8", "Burger with Chicken", "1 Bowl rice with Chicken", "BBQ Burger with Chicken", "Small Chess Burger", "500 ml Pepsi", "1L pepsi", "1.25L pepsi", "2L pepsi");
        selectQuantityComboBoxPickUpPane.getItems().addAll(-5, -3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // others in PickUpPane //
        selectPickUpHourComboBoxPickUpPane.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        selectPickUpMinComboBoxPickUpPane.getItems().addAll(00, 10, 20, 30, 40, 50);
        ToggleGroup group = new ToggleGroup();
        amRadioButtonPickUpPane.setToggleGroup(group);
        pmRadioButtonPickUpPane.setToggleGroup(group);


        // Temporary Adding price to the priceList
        priceList.add(new CustomerOrders("Chicken Nuggets 8", 400));
        priceList.add(new CustomerOrders("Burger with Chicken", 500));
        priceList.add(new CustomerOrders("1 Bowl rice with Chicken", 500));
        priceList.add(new CustomerOrders("BBQ Burger with Chicken", 750));
        priceList.add(new CustomerOrders("Small Chess Burger", 300));
        priceList.add(new CustomerOrders("500 ml Pepsi", 30));
        priceList.add(new CustomerOrders("1L pepsi", 50));
        priceList.add(new CustomerOrders("1.25L pepsi", 60));
        priceList.add(new CustomerOrders("2L pepsi", 80));


        // TableView for cancelOrderPane  //
        tableviewCancelOrderPane.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        packageColCancelOrderPane.setCellValueFactory(new PropertyValueFactory<>("packages"));
        addressColCancelOrderPane.setCellValueFactory(new PropertyValueFactory<>("address"));
        deliveryColHrCancelOrderPane.setCellValueFactory(new PropertyValueFactory<>("deliveryHour"));
        deliveryMinColCancelOrderPane.setCellValueFactory(new PropertyValueFactory<>("deliveryMinute"));
        deliveryCostColCancelOrderPane.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        PickUp_DeliverycolCancelPane.setCellValueFactory(new PropertyValueFactory<>("pick_delivery"));


    }


    ///////             [ OrderFoodPane ]               ////////////
    @FXML
    public void orderFoodButton(ActionEvent actionEvent) {
        orderFoodPane.setVisible(true);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @FXML
    public void viewIntoTableButtonOrderFoodPane(ActionEvent actionEvent) {
        float total_price = 0;

        if (selectFoodTypeComboBoxOrderFoodPane.getValue() == null && selectBevarageTypeComboBoxOrderFoodPane.getValue() == null
        ) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Select Beverage type or Food type");
            a.showAndWait();
        } else {
            if (selectFoodQuantityComboBoxOrderFoodPane.getValue() == null && selectBevarageQuantityComboBoxOrderFoodPane.getValue() == null) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("Select Quantity of selected type(Food or Beverage)");
                a.showAndWait();

            } else {
                tableViewIdOrderFoodPane.getItems().clear();
                float price = 0f;
                boolean food_drinkNameFound = false;

                if (!(selectFoodQuantityComboBoxOrderFoodPane.getValue() == null)) {

                    for (CustomerOrders order : priceList) {
                        if (order.getFood_drinkName().equals(selectFoodTypeComboBoxOrderFoodPane.getValue())) {
                            price = order.getPricePerQuantity();
                        }
                    }
                    for (CustomerOrders order : customerOrderList) {
                        if (order.getFood_drinkName().equals(selectFoodTypeComboBoxOrderFoodPane.getValue())) {
                            order.setQuantity(order.getQuantity() + selectFoodQuantityComboBoxOrderFoodPane.getValue());
                            order.setSubTotal(order.getSubTotal() + selectFoodQuantityComboBoxOrderFoodPane.getValue() * price);

                            food_drinkNameFound = true;
                        }
                    }
                    if (!food_drinkNameFound) {
                        customerOrderList.add(new CustomerOrders(selectFoodTypeComboBoxOrderFoodPane.getValue(), price, selectFoodQuantityComboBoxOrderFoodPane.getValue()));

                    }
                    for (CustomerOrders order : customerOrderList) {
                        if (order.getQuantity() <= 0) {
                            order.setQuantity(0);
                        }
                        if (order.getSubTotal() <= 0) {
                            order.setSubTotal(0);
                        }
                        tableViewIdOrderFoodPane.getItems().add(order);
                    }
                } else {

                    for (CustomerOrders order : priceList) {
                        if (order.getFood_drinkName().equals(selectBevarageTypeComboBoxOrderFoodPane.getValue())) {
                            price = order.getPricePerQuantity();
                        }
                    }
                    for (CustomerOrders order : customerOrderList) {
                        if (order.getFood_drinkName().equals(selectBevarageTypeComboBoxOrderFoodPane.getValue())) {
                            order.setQuantity(order.getQuantity() + selectBevarageQuantityComboBoxOrderFoodPane.getValue());
                            order.setSubTotal(order.getSubTotal() + selectBevarageQuantityComboBoxOrderFoodPane.getValue() * price);
                            food_drinkNameFound = true;

                        }
                    }
                    if (!food_drinkNameFound) {
                        customerOrderList.add(new CustomerOrders(selectBevarageTypeComboBoxOrderFoodPane.getValue(), price, selectBevarageQuantityComboBoxOrderFoodPane.getValue()));

                    }
                    for (CustomerOrders order : customerOrderList) {
                        if (order.getQuantity() <= 0) order.setQuantity(0);
                        if (order.getSubTotal() <= 0) order.setSubTotal(0);

                        tableViewIdOrderFoodPane.getItems().add(order);
                    }
                }

            }
        }
        totalPriceGiverOrderFoodPane();

    }


    @FXML
    public void removeFromTableButtonOrderFoodPane(ActionEvent actionEvent) {

        CustomerOrders removedOrder = tableViewIdOrderFoodPane.getSelectionModel().getSelectedItem();
        tableViewIdOrderFoodPane.getItems().remove(removedOrder);

        customerOrderList.removeIf(orders -> orders.getFood_drinkName().equals(removedOrder.getFood_drinkName()));
        totalPriceGiverOrderFoodPane();
    }

    @FXML
    public void placeOrderButtonOrderFoodPane(ActionEvent actionEvent) throws IOException {
        ObjectOutputStream oos = null;
        FileOutputStream fos;
        Alert alert;
        if (customerOrderList.isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Check The Table");
            alert.setContentText("Table is empty.");
            alert.showAndWait();

        } else {
            if (totalPriceGiverOrderFoodPane() < 149) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Order Price Check");
                alert.setContentText("Order Price Must be above 149 tk");
                alert.showAndWait();

            } else {
                try {
                    if (customerOrdersFile.exists()) {
                        fos = new FileOutputStream(customerOrdersFile, true);
                        oos = new AppendableObjectOutputStream(fos);
                        alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Approved");
                        alert.setContentText("Appendable used.");
                        alert.showAndWait();
                    } else {
                        fos = new FileOutputStream(customerOrdersFile, true);
                        oos = new ObjectOutputStream(fos);
                        alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Approved");
                        alert.setContentText("Appendable not Used.");
                        alert.showAndWait();
                    }


                    for (CustomerOrders orders1 : customerOrderList) {
                        oos.writeObject(orders1);
                    }
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Approved");
                    alert.setContentText("Fill is written.");
                    alert.showAndWait();

                    customerOrderList.clear();
                    tableViewIdOrderFoodPane.getItems().clear();
                    oos.close();
                } catch (Exception var6) {

                    oos.close();
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("File is not written.");
                    a.showAndWait();
                }
            }
        }
    }


    public float totalPriceGiverOrderFoodPane() {

        float total_price = 0;
        for (CustomerOrders order : customerOrderList) {
            total_price = order.getSubTotal() + total_price;
        }
        totalPriceLabelIdOrderPane.setText("total Price :" + total_price + "Taka");
        totalPriceToBePaidLabelIdOrderPane.setText("Total Price to be paid :" + (total_price + 40) + "Taka");


        return total_price;


    }

    @FXML
    public void selectBeverageTypeComboBoxOnActionOrderFoodPane(ActionEvent actionEvent) {
        selectFoodTypeComboBoxOrderFoodPane.setDisable(true);
        selectFoodQuantityComboBoxOrderFoodPane.setDisable(true);

        for (CustomerOrders order : priceList) {
            if (selectBevarageTypeComboBoxOrderFoodPane.getValue().equals(order.getFood_drinkName())) {
                priceLabelOrderFoodPane.setText(order.getPricePerQuantity() + "Taka");
            }
        }
    }

    @FXML
    public void selectFoodTypeComboBoxOnActionOrderFoodPane(ActionEvent actionEvent) {
        selectBevarageTypeComboBoxOrderFoodPane.setDisable(true);
        selectBevarageQuantityComboBoxOrderFoodPane.setDisable(true);

        for (CustomerOrders order : priceList) {
            if (selectFoodTypeComboBoxOrderFoodPane.getValue().equals(order.getFood_drinkName())) {
                priceLabelOrderFoodPane.setText(order.getPricePerQuantity() + "Taka");
            }
        }
    }

    @FXML
    public void enableTypesButtonOrderFoodPane(ActionEvent actionEvent) {
        selectBevarageTypeComboBoxOrderFoodPane.setValue(null);
        selectBevarageQuantityComboBoxOrderFoodPane.setValue(null);
        selectFoodTypeComboBoxOrderFoodPane.setValue(null);
        selectFoodQuantityComboBoxOrderFoodPane.setValue(null);
        disablityCheck();
        priceLabelOrderFoodPane.setText("Your Price per quantity .");


    }

    public void disablityCheck() {
        if (selectFoodTypeComboBoxOrderFoodPane.isDisabled()) selectFoodTypeComboBoxOrderFoodPane.setDisable(false);
        if (selectFoodQuantityComboBoxOrderFoodPane.isDisabled())
            selectFoodQuantityComboBoxOrderFoodPane.setDisable(false);
        if (selectBevarageTypeComboBoxOrderFoodPane.isDisabled())
            selectBevarageTypeComboBoxOrderFoodPane.setDisable(false);
        if (selectBevarageQuantityComboBoxOrderFoodPane.isDisabled())
            selectBevarageQuantityComboBoxOrderFoodPane.setDisable(false);

    }


    @FXML
    public void backButon(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @FXML
    public void reportButton(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(true);
        helpPane.setVisible(false);
    }

    @FXML
    public void tipGivingButton(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(true);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @FXML
    public void helpButton(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(true);
    }


    @FXML
    public void rateFoodButton(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(true);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);
    }







///////         ////////////////       [ pickUpPane ]               ////////////

    @FXML
    public void pickUpButton(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(true);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @FXML
    public void viewIntoTableButtonPickUpPane(ActionEvent actionEvent) {

        if (selectFoodOrBeverageComboBoxPickUpPane.getValue() == null || selectQuantityComboBoxPickUpPane.getValue() == null
                || selectPickUpHourComboBoxPickUpPane.getValue() == null || selectPickUpMinComboBoxPickUpPane.getValue() == null
        ){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Don't leave any ComboBox Unselected");
            a.showAndWait();
        }
        else {
            if(! amRadioButtonPickUpPane.isSelected() && !pmRadioButtonPickUpPane.isSelected()){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("Choose AM or PM");
                a.showAndWait();
            }
            else{
                tableViewIdPickUpPane.getItems().clear();
                String am_pm;
                float pricePerUnit = 0;
                boolean food_drinkNameFound = false;

                if (amRadioButtonPickUpPane.isSelected()) am_pm = "AM";
                else am_pm = "PM";

                for(CustomerOrders order : priceList){
                    if (order.getFood_drinkName().equals(selectFoodOrBeverageComboBoxPickUpPane.getValue()))
                    {
                        pricePerUnit = order.getPricePerQuantity();
                    }
                }
                for( PickUpOrders order : pickUpOrderList){
                    order.setAmPm(am_pm);
                    order.setPickUpHour(selectPickUpHourComboBoxPickUpPane.getValue());
                    order.setPickupMin(selectPickUpMinComboBoxPickUpPane.getValue());
                    if( order.getFood_BeverageName().equals(selectFoodOrBeverageComboBoxPickUpPane.getValue()))
                    {
                        order.setFood_BeverageQuantity(order.getFood_BeverageQuantity()+selectQuantityComboBoxPickUpPane.getValue() );
                        order.setSubTotal(order.getSubTotal() + selectQuantityComboBoxPickUpPane.getValue()*pricePerUnit );
                        food_drinkNameFound = true ;

                    }
                }
                if(! food_drinkNameFound){
                    pickUpOrderList.add(new PickUpOrders(am_pm,selectFoodOrBeverageComboBoxPickUpPane.getValue(),pricePerUnit, selectQuantityComboBoxPickUpPane.getValue(),selectPickUpHourComboBoxPickUpPane.getValue(),selectPickUpMinComboBoxPickUpPane.getValue()));
                }

                for( PickUpOrders order : pickUpOrderList){
                    if (order.getFood_BeverageQuantity() <= 0) order.setFood_BeverageQuantity(0);
                    if (order.getSubTotal() <= 0) order.setSubTotal(0);
                    tableViewIdPickUpPane.getItems().add(order);
                }
            }
            totalPriceGiverPickUpPane();
        }

    }

    public float totalPriceGiverPickUpPane(){
        float total_price_forPickUpPane = 0 ;
        for(PickUpOrders perOrder : pickUpOrderList){
            total_price_forPickUpPane = perOrder.getSubTotal() + total_price_forPickUpPane;
        }
        totalPriceLabelIdPickUpPane.setText("total Price :" + total_price_forPickUpPane + "Taka");
        return total_price_forPickUpPane;
    }

    public void removeSelectedOrders( PickUpOrders removedOrders ){
        pickUpOrderList.removeIf(selectedOrder -> selectedOrder.getAmPm().equals(removedOrders.getAmPm()) && selectedOrder.getPickUpHour() == removedOrders.getPickUpHour()
                && selectedOrder.getPickupMin() == removedOrders.getPickupMin()
                && selectedOrder.getFood_BeverageName().equals(removedOrders.getFood_BeverageName()));

    }

    @FXML
    public void removeSelectedButtonPickUpPane(ActionEvent actionEvent) {
        PickUpOrders newRemovedOrder = tableViewIdPickUpPane.getSelectionModel().getSelectedItem();
        tableViewIdPickUpPane.getItems().remove(newRemovedOrder);
        removeSelectedOrders(newRemovedOrder);
        totalPriceGiverPickUpPane();
    }




    @FXML
    public void pickUpOrderButtonPickUpPane(ActionEvent actionEvent) throws IOException {
        Alert alert;
        if(pickUpOrderList.isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Check The Table");
            alert.setContentText("Table is empty.");
            alert.showAndWait();

        }

        else {
            ObjectOutputStream oos = null;
            FileOutputStream fos;
            try {

                if (pickUpOrdersFile.exists()) {
                    fos = new FileOutputStream(pickUpOrdersFile, true);
                    oos = new AppendableObjectOutputStream(fos);
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Approved");
                    alert.setContentText("Appendable used.");
                    alert.showAndWait();
                } else {
                    fos = new FileOutputStream(pickUpOrdersFile, true);
                    oos = new ObjectOutputStream(fos);
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Approved");
                    alert.setContentText("Appendable not Used.");
                    alert.showAndWait();
                }

                // Writing File ......
                oos.writeObject(new Order(customerAddress,customerEmail,customerName,pickUpOrderList,totalPriceGiverPickUpPane(),"Pick UP"));

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Approved");
                alert.setContentText("Fill is written.");
                alert.showAndWait();

                pickUpOrderList.clear();
                tableViewIdPickUpPane.getItems().clear();
                oos.close();
            } catch (Exception var6) {
                if (!(oos == null)){
                    oos.close();
                }
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("File is not written.");
                a.showAndWait();
            }
        }
    }








    ///////////////////////           cancelOrderPane               ///////////////////////////

    @FXML
    public void cancelOrderButton(ActionEvent actionEvent) throws Exception {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(true);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);


        Alert alert;
        if (!pickUpOrdersFile.exists()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pick Ups");
            alert.setContentText("No Pick Ups");
            alert.showAndWait();
        } else {

            FileInputStream fis = null;
            ObjectInputStream ois = null;
            Order orders;
            try {
                fis = new FileInputStream(pickUpOrdersFile);
                ois = new ObjectInputStream(fis);
                tableviewCancelOrderPane.getItems().clear();
                ordersForCancelledList.clear();
                while (true) {
                    try {
                        orders = (Order) ois.readObject();
                        ordersForCancelledList.add(new Order(orders.getPackages(), orders.getAddress(), orders.getDeliveryHour(), orders.getDeliveryMinute(), orders.getTotalCost(), orders.getPickUpOrdersListOrderClass(),orders.getPick_delivery()));
                        tableviewCancelOrderPane.getItems().add(orders);
                    } catch (Exception e) {
                        break;

                    }
                }

                fis.close();
                ois.close();

            } catch (Exception e) {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            }
        }
    }

    @FXML
    public void SeelnDetailsButtonCancelPane(ActionEvent actionEvent) {

        Order selectedOrder = tableviewCancelOrderPane.getSelectionModel().getSelectedItem();
        if( selectedOrder == null ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection Error");
            alert.setContentText("No Order Selected");
            alert.showAndWait();
        }
        else{
            for(Order order : ordersForCancelledList){
                if(selectedOrder.getPackages().equals(order.getPackages())){
                    detailsAboutOrderCancelPane.setText(order.printFoodBeverage());
                }
            }
        }
    }



    @FXML
    public void CancelButtonCancelOrderPane(ActionEvent actionEvent) throws IOException {
        Order removedOrder = tableviewCancelOrderPane.getSelectionModel().getSelectedItem();
        tableviewCancelOrderPane.getItems().remove(removedOrder);
        Alert  alert;

        if(removedOrder == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection Error");
            alert.setContentText("No file Selected");
            alert.showAndWait();
        }
        else{
            ObjectOutputStream oos = null;
            FileOutputStream fos;
            try {

                if (pickUpOrdersFile.exists()) pickUpOrdersFile.delete();

                fos = new FileOutputStream(pickUpOrdersFile, true);
                oos = new ObjectOutputStream(fos);

                // Writing File ......
                for (Order order : ordersForCancelledList) {
                    oos.writeObject(order);
                }

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Approved");
                alert.setContentText("Fill is written.");
                alert.showAndWait();

                oos.close();
            }
            catch (Exception var6) {
                if (!(oos == null)){
                    oos.close();
                }
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("File is not written.");
                a.showAndWait();
            }

        }
    }


    @FXML
    public void orderHistory(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(false);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(true);
        reportPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @FXML
    public void howToCancelOrders_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void submitButtonReportPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howToRateFood_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howToReport_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howTo_doPickUp_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void howTo_orderFood_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @FXML
    public void _ButtonHelpPane(ActionEvent actionEvent) {
    }










}
