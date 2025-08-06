package com.orderapp.Online_Order_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.orderapp.Online_Order_App.dto.ResponseStructure;
import com.orderapp.Online_Order_App.entity.Food;
import com.orderapp.Online_Order_App.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/food/api")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/savee")
    public ResponseEntity<ResponseStructure<Food>> createFood(@RequestBody Food food) {
        Food saved = foodService.createFood(food);

        ResponseStructure<Food> apiResponse = new ResponseStructure<>();
        apiResponse.setData(saved);
        apiResponse.setMessage("Food saved successfully");
        apiResponse.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseStructure<Food>> getById(@PathVariable Integer id) {
        Food response = foodService.getFoodById(id);

        ResponseStructure<Food> apiResponse = new ResponseStructure<>();
        apiResponse.setData(response);
        apiResponse.setMessage("Food item found");
        apiResponse.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseStructure<List<Food>>> getAllFoods(
        @RequestParam(defaultValue = "0") int pageNum,
        @RequestParam(defaultValue = "5") int pageSize
    ) {
        List<Food> foodList = foodService.getAllFood(pageNum, pageSize);

        ResponseStructure<List<Food>> apiResponse = new ResponseStructure<>();
        apiResponse.setData(foodList);
        apiResponse.setMessage("All food items fetched successfully");
        apiResponse.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Food>> updateFood(
        @PathVariable Integer id,
        @RequestBody Food updatedFood
    ) {
        Food updated = foodService.updateFood(updatedFood, id);

        ResponseStructure<Food> apiResponse = new ResponseStructure<>();
        apiResponse.setData(updated);
        apiResponse.setMessage("Food item updated successfully");
        apiResponse.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteFood(@PathVariable Integer id) {
        foodService.deleteFood(id);

        ResponseStructure<String> apiResponse = new ResponseStructure<>();
        apiResponse.setData("Food item deleted successfully");
        apiResponse.setMessage("Deleted");
        apiResponse.setStatusCode(HttpStatus.NO_CONTENT.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
    }
}