package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import com.vytrack.pages.VehiclesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.tr.Ve;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefinitions {

    VehiclesPage vehiclesPage = new VehiclesPage();
    CreateCarPage createCarPage = new CreateCarPage();

    @Then("user click on {string} button")
    public void user_click_on(String string) {
        vehiclesPage.waitUntilLoaderMaskDisappear();
        if(string.equals("Create Car")){
            vehiclesPage.clickToCreateACar();
        }
    }

    @Then("user adds new car information:")
    public void user_adds_new_car_information(List<Map<String, String>> dataTable) {
        createCarPage.waitUntilLoaderMaskDisappear();

        int row = 1;
        for(Map<String, String> map: dataTable){
            createCarPage.licensePlateElement.sendKeys(map.get("License Plate"));
            createCarPage.driverElement.sendKeys(map.get("Driver"));
            createCarPage.locationElement.sendKeys(map.get("Location"));
            createCarPage.modelYearElement.sendKeys(map.get("Model Year"));
            createCarPage.colorElement.sendKeys(map.get("Color"));

            if(row == dataTable.size()){
                createCarPage.clickSaveAndClose();
            } else {
                createCarPage.clickSaveAndAddNew();
            }
            row++;
        }
    }

}
