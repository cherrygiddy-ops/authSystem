package com.authservice.system.client.services;

import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthCategoriesService {
    private final OrderServiceClient orderServiceClient;

    // ✅ Add category using just a name
    public CategoryResponseDto addCategory(String name) {
        return orderServiceClient.addCategory(name);
    }

    // ✅ Get all categories
    public List<CategoryResponseDto> getCategories() {
        return orderServiceClient.getCategories();
    }

    // ✅ Get category details
    public CategoryResponseDto getCategoryDetails(String categoryId) {
        return orderServiceClient.getCategoryDetails(categoryId);
    }

    // ✅ Update category using just a name
    public CategoryResponseDto updateCategory(String categoryId, String name) {
        return orderServiceClient.updateCategory(categoryId, name);
    }

    // ✅ Delete category
    public void deleteCategory(String categoryId) {
        orderServiceClient.deleteCategory(categoryId);
    }
}
