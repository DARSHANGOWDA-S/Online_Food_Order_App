package com.orderapp.Online_Order_App.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.orderapp.Online_Order_App.entity.Food;
import com.orderapp.Online_Order_App.repository.FoodRepository;

@Service
public class FoodServiceImplementation implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food getFoodById(Integer id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Food with ID: " + id + " not found"));
    }

    @Override
    public List<Food> getAllFood(int pageNum, int pageSize) {
        return foodRepository.findAll(PageRequest.of(pageNum, pageSize)).getContent();
    }

    @Override
    public Food updateFood(Food food, Integer id) {
        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Food with ID: " + id + " not found"));

        // Update only the fields that are not null or empty
        if (food.getName() != null) {
            existingFood.setName(food.getName());
        }
        if (food.getDescribtion() != null) {
            existingFood.setDescribtion(food.getDescribtion());
        }
        if (food.getPrice() != null) {
            existingFood.setPrice(food.getPrice());
        }

        return foodRepository.save(existingFood);
    }

    @Override
    public void deleteFood(Integer id) {
        if (!foodRepository.existsById(id)) {
            throw new NoSuchElementException("Food with ID: " + id + " not found");
        }
        foodRepository.deleteById(id);
    }
}
