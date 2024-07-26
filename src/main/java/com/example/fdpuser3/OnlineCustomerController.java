package com.example.fdpuser3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OnlineCustomerController {

    ArrayList<CustomerOrders> customerOrderList = new ArrayList<>();
    ArrayList<CustomerOrders> priceList = new ArrayList<>();
    ArrayList<PickUpOrders> pickUpOrderList = new ArrayList<>();

    File customerOrdersFile = new File("CustomerOrders.bin");
    @javafx.fxml.FXML
    private TableView tableviewCancelOrderPane;
    @javafx.fxml.FXML
    private AnchorPane cancelOrdersPane;
    @javafx.fxml.FXML
    private TableColumn deliveryColHrCancelOrderPane;
    @javafx.fxml.FXML
    private AnchorPane helpPane;
    @javafx.fxml.FXML
    private TableColumn deliveryMinColCancelOrderPane;
    @javafx.fxml.FXML
    private TableColumn addressColCancelOrderPane;
    @javafx.fxml.FXML
    private Label descriptionOfGoalsLabelHelpPane;
    @javafx.fxml.FXML
    private TableColumn DeliveryChargeColCancelOrderPane;
    @javafx.fxml.FXML
    private TableColumn packageColCancelOrderPane;
    @javafx.fxml.FXML
    private AnchorPane pickUpPane;
    @javafx.fxml.FXML
    private AnchorPane checkOrderHistoryPane;
    @javafx.fxml.FXML
    private AnchorPane reportPane;
    @javafx.fxml.FXML
    private AnchorPane rateFoodPane;
    @javafx.fxml.FXML
    private AnchorPane tipPane;
    @javafx.fxml.FXML
    private Button submitButtonRateFood;
    @javafx.fxml.FXML
    private ComboBox GiveRatingComboBoxRateFoof;
    @javafx.fxml.FXML
    private TableColumn foodPackageColRateFood;
    @javafx.fxml.FXML
    private TextField commenttextFieldRateFood;
    @javafx.fxml.FXML
    private TableColumn orderDateColRateFood;
    @javafx.fxml.FXML
    private TableColumn orderTimeColRateFood;
    @javafx.fxml.FXML
    private TableView tableViewRateFood;
    @javafx.fxml.FXML
    private Label foodDetailsLabelRateFood;
    @javafx.fxml.FXML
    private TableColumn costColRateFood;
    @javafx.fxml.FXML
    private TextArea harassmenTextAreaReportPane;
    @javafx.fxml.FXML
    private ComboBox emploteeTypeComboBoxReportPane;
    @javafx.fxml.FXML
    private TextArea reportStatementTextAreaReportPane;
    @javafx.fxml.FXML
    private ComboBox commonReportsComboBoxReportPane;
    @javafx.fxml.FXML
    private ComboBox emploteeNameComboBoxReportPane;
    @javafx.fxml.FXML
    private ComboBox harassmentTypeComboBoxReportPane;
    @javafx.fxml.FXML
    private CheckBox harassmentCheckBoxReportPane;
    @javafx.fxml.FXML
    private AnchorPane orderFoodPane;


    // Order food table View //
    @javafx.fxml.FXML
    private TableView<CustomerOrders> tableViewIdOrderFoodPane;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrders,String> foodIdColOrderFoodPane;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrders,String> foodNameColIdOrderFoodPane;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrders,Float> pricePerQuantityColIdOrderFoodPane;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrders,Integer> quantityColIdOrderFoodPane;
    @javafx.fxml.FXML
    private TableColumn<CustomerOrders,Float> subTotalColIdOrderFoodPane;

    // order food comboBox //
    @javafx.fxml.FXML
    private ComboBox<String> selectFoodTypeComboBoxOrderFoodPane;
    @javafx.fxml.FXML
    private ComboBox<Integer> selectFoodQuantityComboBoxOrderFoodPane;
    @javafx.fxml.FXML
    private ComboBox<String> selectBevarageTypeComboBoxOrderFoodPane;
    @javafx.fxml.FXML
    private ComboBox<Integer> selectBevarageQuantityComboBoxOrderFoodPane;
    @javafx.fxml.FXML
    private Label priceLabelOrderFoodPane;
    @javafx.fxml.FXML
    private Label totalPriceLabelIdOrderPane;




    // PickUp Order table View //
    @javafx.fxml.FXML
    private TableView<PickUpOrders> tableViewIdPickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,String> foodIdCol1PickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,String> foodNameColIdPickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,Float> pricePerQuantityColIdPickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,Integer> quantityColIdPickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,Float> subTotalColIdPickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,Integer> pickUpHrColIdPickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,String> am_pm_col_PickUpPane;
    @javafx.fxml.FXML
    private TableColumn<PickUpOrders,Integer> pickUpMinColIdPickUpPane;


    // comboBox and radio buttons , label PickUp Pane  //
    @javafx.fxml.FXML
    private RadioButton amRadioButtonPickUpPane;
    @javafx.fxml.FXML
    private ComboBox<Integer> selectPickUpHourComboBoxPickUpPane;
    @javafx.fxml.FXML
    private RadioButton pmRadioButtonPickUpPane;
    @javafx.fxml.FXML
    private ComboBox<Integer> selectQuantityComboBoxPickUpPane;
    @javafx.fxml.FXML
    private Label totalPriceLabelIdPickUpPane;
    @javafx.fxml.FXML
    private ComboBox<String> selectFoodOrBeverageComboBoxPickUpPane;
    @javafx.fxml.FXML
    private ComboBox<Integer> selectPickUpMinComboBoxPickUpPane;


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
        foodIdColOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("food_drinkId"));
        foodNameColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("food_drinkName"));
        pricePerQuantityColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("pricePerQuantity"));
        quantityColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        subTotalColIdOrderFoodPane.setCellValueFactory(new PropertyValueFactory<>("subTotal"));

        // temporary ComboBox for OrderFoodPane //
        selectFoodTypeComboBoxOrderFoodPane.getItems().addAll("Chicken Nuggets 8","Burger with Chicken","1 Bowl rice with Chicken", "BBQ Burger with Chicken", "Small Chess Burger"   );
        selectFoodQuantityComboBoxOrderFoodPane.getItems().addAll(-5,-3,-1,1,2,3,4,5,6,7,8,9,10);
        selectBevarageTypeComboBoxOrderFoodPane.getItems().addAll("500 ml Pepsi", "1L pepsi","1.25L pepsi","2L pepsi");
        selectBevarageQuantityComboBoxOrderFoodPane.getItems().addAll(-5,-3,-1,1,2,3,4,5,6,7,8,9,10);



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
        selectFoodOrBeverageComboBoxPickUpPane.getItems().addAll("Chicken Nuggets 8","Burger with Chicken","1 Bowl rice with Chicken", "BBQ Burger with Chicken", "Small Chess Burger","500 ml Pepsi", "1L pepsi","1.25L pepsi","2L pepsi" );
        selectQuantityComboBoxPickUpPane.getItems().addAll(-5,-3,-1,1,2,3,4,5,6,7,8,9,10);

        // others in PickUpPane //
        selectPickUpHourComboBoxPickUpPane.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        selectPickUpMinComboBoxPickUpPane.getItems().addAll(00,10,20,30,40,50);
        ToggleGroup group = new ToggleGroup();
        amRadioButtonPickUpPane.setToggleGroup(group);
        pmRadioButtonPickUpPane.setToggleGroup(group);



        // Temporary Adding price to the priceList
        priceList.add(new CustomerOrders("Chicken Nuggets 8",400));
        priceList.add(new CustomerOrders("Burger with Chicken",500));
        priceList.add(new CustomerOrders("1 Bowl rice with Chicken",500));
        priceList.add(new CustomerOrders("BBQ Burger with Chicken",750));
        priceList.add(new CustomerOrders("Small Chess Burger",300));
        priceList.add(new CustomerOrders("500 ml Pepsi",30));
        priceList.add(new CustomerOrders("1L pepsi",50));
        priceList.add(new CustomerOrders("1.25L pepsi",60));
        priceList.add(new CustomerOrders("2L pepsi",80));



    }

    ///////             [ OrderFoodPane ]               ////////////
    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
    public void viewIntoTableButtonOrderFoodPane(ActionEvent actionEvent) {
        float total_price = 0;

        if(selectFoodTypeComboBoxOrderFoodPane.getValue() == null && selectBevarageTypeComboBoxOrderFoodPane.getValue() == null
        ){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Select Beverage type or Food type");
            a.showAndWait();
        }
        else{
            if(selectFoodQuantityComboBoxOrderFoodPane.getValue() == null && selectBevarageQuantityComboBoxOrderFoodPane.getValue() == null){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setContentText("Select Quantity of selected type(Food or Beverage)");
                a.showAndWait();

            }
            else{
                tableViewIdOrderFoodPane.getItems().clear();
                float price  = 0f;
                boolean  food_drinkNameFound = false;

                if(! (selectFoodQuantityComboBoxOrderFoodPane.getValue() == null)){

                    for(CustomerOrders order : priceList){
                        if (order.getFood_drinkName().equals(selectFoodTypeComboBoxOrderFoodPane.getValue()))
                        {
                            price = order.getPricePerQuantity();
                        }
                    }
                    for(CustomerOrders order : customerOrderList){
                        if(order.getFood_drinkName().equals(selectFoodTypeComboBoxOrderFoodPane.getValue())){
                            order.setQuantity(order.getQuantity()+selectFoodQuantityComboBoxOrderFoodPane.getValue() );
                            order.setSubTotal(order.getSubTotal() + selectFoodQuantityComboBoxOrderFoodPane.getValue()*price );

                            food_drinkNameFound = true ;
                        }
                    }
                    if(! food_drinkNameFound){
                        customerOrderList.add(new CustomerOrders(selectFoodTypeComboBoxOrderFoodPane.getValue(),price,selectFoodQuantityComboBoxOrderFoodPane.getValue()));

                    }
                    for(CustomerOrders order : customerOrderList){
                        if (order.getQuantity() <= 0){
                            order.setQuantity(0);
                        }
                        if (order.getSubTotal() <= 0){
                            order.setSubTotal(0);
                        }
                        tableViewIdOrderFoodPane.getItems().add(order);
                    }
                }
                else {

                    for(CustomerOrders order : priceList){
                        if (order.getFood_drinkName().equals(selectBevarageTypeComboBoxOrderFoodPane.getValue()))
                        {
                            price = order.getPricePerQuantity();
                        }
                    }
                    for(CustomerOrders order : customerOrderList){
                        if(order.getFood_drinkName().equals(selectBevarageTypeComboBoxOrderFoodPane.getValue())){
                            order.setQuantity(order.getQuantity()+selectBevarageQuantityComboBoxOrderFoodPane.getValue() );
                            order.setSubTotal(order.getSubTotal() + selectBevarageQuantityComboBoxOrderFoodPane.getValue()*price );
                            food_drinkNameFound = true ;

                        }
                    }
                    if(! food_drinkNameFound){
                        customerOrderList.add(new CustomerOrders(selectBevarageTypeComboBoxOrderFoodPane.getValue(),price,selectBevarageQuantityComboBoxOrderFoodPane.getValue()));

                    }
                    for(CustomerOrders order : customerOrderList){
                        if (order.getQuantity() <= 0) order.setQuantity(0);
                        if (order.getSubTotal() <= 0) order.setSubTotal(0);

                        tableViewIdOrderFoodPane.getItems().add(order);
                    }
                }

            }
        }
        totalPriceGiverOrderFoodPane();

    }


    @javafx.fxml.FXML
    public void removeFromTableButtonOrderFoodPane(ActionEvent actionEvent) {

        CustomerOrders removedOrder = tableViewIdOrderFoodPane.getSelectionModel().getSelectedItem();
        tableViewIdOrderFoodPane.getItems().remove(removedOrder);

        customerOrderList.removeIf(orders -> orders.getFood_drinkName().equals(removedOrder.getFood_drinkName()));
        totalPriceGiverOrderFoodPane();
    }

    @javafx.fxml.FXML
    public void placeOrderButtonOrderFoodPane(ActionEvent actionEvent) throws IOException {
        ObjectOutputStream oos = null;
        FileOutputStream fos;
        Alert alert;
        if(customerOrderList.isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Check The Table");
            alert.setContentText("Table is empty.");
            alert.showAndWait();

        }

        else {
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


    public void totalPriceGiverOrderFoodPane(){

        float total_price = 0 ;
        for(CustomerOrders order : customerOrderList){
            total_price = order.getSubTotal() + total_price;
        }
        totalPriceLabelIdOrderPane.setText("total Price :" + total_price + "Taka");



    }

    @javafx.fxml.FXML
    public void selectBeverageTypeComboBoxOnActionOrderFoodPane(ActionEvent actionEvent) {
        selectFoodTypeComboBoxOrderFoodPane.setDisable(true);
        selectFoodQuantityComboBoxOrderFoodPane.setDisable(true);

        for(CustomerOrders order : priceList){
            if (selectBevarageTypeComboBoxOrderFoodPane.getValue().equals(order.getFood_drinkName())){
                priceLabelOrderFoodPane.setText(order.getPricePerQuantity() + "Taka");
            }
        }
    }

    @javafx.fxml.FXML
    public void selectFoodTypeComboBoxOnActionOrderFoodPane(ActionEvent actionEvent) {
        selectBevarageTypeComboBoxOrderFoodPane.setDisable(true);
        selectBevarageQuantityComboBoxOrderFoodPane.setDisable(true);

        for(CustomerOrders order : priceList){
            if (selectFoodTypeComboBoxOrderFoodPane.getValue().equals(order.getFood_drinkName())){
                priceLabelOrderFoodPane.setText(order.getPricePerQuantity() + "Taka");
            }
        }
    }
    @javafx.fxml.FXML
    public void enableTypesButtonOrderFoodPane(ActionEvent actionEvent) {
        selectBevarageTypeComboBoxOrderFoodPane.setValue(null);
        selectBevarageQuantityComboBoxOrderFoodPane.setValue(null);
        selectFoodTypeComboBoxOrderFoodPane.setValue(null);
        selectFoodQuantityComboBoxOrderFoodPane.setValue(null);
        disablityCheck();
        priceLabelOrderFoodPane.setText("Your Price per quantity .");



        }
    public void disablityCheck(){
        if (selectFoodTypeComboBoxOrderFoodPane.isDisabled())  selectFoodTypeComboBoxOrderFoodPane.setDisable(false);
        if (selectFoodQuantityComboBoxOrderFoodPane.isDisabled())  selectFoodQuantityComboBoxOrderFoodPane.setDisable(false);
        if (selectBevarageTypeComboBoxOrderFoodPane.isDisabled())  selectBevarageTypeComboBoxOrderFoodPane.setDisable(false);
        if (selectBevarageQuantityComboBoxOrderFoodPane.isDisabled()) selectBevarageQuantityComboBoxOrderFoodPane.setDisable(false);

    }






    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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


    @javafx.fxml.FXML
    public void cancelOrderButton(ActionEvent actionEvent) {
        orderFoodPane.setVisible(false);
        pickUpPane.setVisible(false);
        cancelOrdersPane.setVisible(true);
        tipPane.setVisible(false);
        rateFoodPane.setVisible(false);
        checkOrderHistoryPane.setVisible(false);
        reportPane.setVisible(false);
        helpPane.setVisible(false);
    }

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
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
                float price = 0;
                boolean food_drinkNameFound = false;

                if (amRadioButtonPickUpPane.isSelected()) am_pm = "AM";
                else am_pm = "PM";

                for(CustomerOrders order : priceList){
                    if (order.getFood_drinkName().equals(selectFoodOrBeverageComboBoxPickUpPane.getValue()))
                    {
                        price = order.getPricePerQuantity();
                    }
                }
                for( PickUpOrders order : pickUpOrderList){
                    if(order.getAmPm().equals(am_pm) && order.getPickUpHour() == selectPickUpHourComboBoxPickUpPane.getValue()
                            && order.getPickupMin() == selectPickUpMinComboBoxPickUpPane.getValue()
                            && order.getFood_BeverageName().equals(selectFoodOrBeverageComboBoxPickUpPane.getValue()))
                    {
                        order.setFood_BeverageQuantity(order.getFood_BeverageQuantity()+selectQuantityComboBoxPickUpPane.getValue() );
                        order.setSubTotal(order.getSubTotal() + selectQuantityComboBoxPickUpPane.getValue()*price );
                        food_drinkNameFound = true ;

                    }
                }
                if(! food_drinkNameFound){
                    pickUpOrderList.add(new PickUpOrders(am_pm,selectFoodOrBeverageComboBoxPickUpPane.getValue(),price, selectQuantityComboBoxPickUpPane.getValue(),selectPickUpHourComboBoxPickUpPane.getValue(),selectPickUpMinComboBoxPickUpPane.getValue()));
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

    public void totalPriceGiverPickUpPane(){
        float total_price_forPickUpPane = 0 ;
        for(PickUpOrders perOrder : pickUpOrderList){
            total_price_forPickUpPane = perOrder.getSubTotal() + total_price_forPickUpPane;
        }
        totalPriceLabelIdPickUpPane.setText("total Price :" + total_price_forPickUpPane + "Taka");
    }

    public void removeSelectedOrders( PickUpOrders removedOrders ){
        pickUpOrderList.removeIf(selectedOrder -> selectedOrder.getAmPm().equals(removedOrders.getAmPm()) && selectedOrder.getPickUpHour() == removedOrders.getPickUpHour()
                && selectedOrder.getPickupMin() == removedOrders.getPickupMin()
                && selectedOrder.getFood_BeverageName().equals(removedOrders.getFood_BeverageName()));

    }

    @javafx.fxml.FXML
    public void removeSelectedButtonPickUpPane(ActionEvent actionEvent) {
        PickUpOrders newRemovedOrder = tableViewIdPickUpPane.getSelectionModel().getSelectedItem();
        tableViewIdPickUpPane.getItems().remove(newRemovedOrder);
        removeSelectedOrders(newRemovedOrder);
        totalPriceGiverPickUpPane();
    }











    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
    public void howToCancelOrders_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitButtonReportPane(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void howToRateFood_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void howToReport_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void howTo_doPickUp_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void howTo_orderFood_ButtonHelpPane(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void _ButtonHelpPane(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void pickUpOrderButtonPickUpPane(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void CancelButtonCancelOrderPane(ActionEvent actionEvent) {
    }



}
