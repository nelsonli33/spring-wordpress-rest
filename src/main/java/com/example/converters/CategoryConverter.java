/*
 * 
 */
 package com.example.converters;

import org.springframework.stereotype.Component;

import com.example.data.CategoryData;
import com.example.wordpress.resource.Category;

@Component(value = "categoryConverter")
public class CategoryConverter implements Converter<Category, CategoryData> {

	@Override
	public CategoryData convert(final Category source) {
		final CategoryData categoryData = new CategoryData();
		categoryData.setId(source.getId());
		categoryData.setName(source.getName());
		categoryData.setDescription(source.getDescription());
		return categoryData;
	}

}
