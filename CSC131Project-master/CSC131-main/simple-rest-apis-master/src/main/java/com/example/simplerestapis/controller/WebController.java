package com.example.simplerestapis.controller;
import com.example.simplerestapis.Categories;
import com.example.simplerestapis.models.CategoryResponse;
//import com.google.gson.annotations.SerializedName;
//import jdk.jfr.Category;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;
import com.example.simplerestapis.models.SampleResponse;

import java.util.ArrayList;

@RestController
public class WebController {

	//@SerializedName("category")
	//private String mCategory;

	@RequestMapping("/movies")
	public SampleResponse Sample(@RequestParam(value = "name",
	defaultValue = "null") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1927);
		response.setMessage("Your movie is "+name);
		return response;
	}


	@RequestMapping("/movies/categories")
	public CategoryResponse Category(@RequestParam(value = "name",
			defaultValue = "null") String category) {
		CategoryResponse response = new CategoryResponse();
		response.setId(1927);
		response.setMessage("Your category is " + category);
		return response;

		//ArrayList CategoryList;
		ArrayList<Categories> CategoryList = new ArrayList<>();
		CategoryList.add("Horror");
		//System.out.println(CategoryList);
		CategoryList.add(new Categories( "Horror"));
		//CategoryList.add(new Categories("Drama"));
		// ArrayList of Strings
		// a class categoryList for category to store values


	}
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		response.setId(inputPayload.getId()*100);
		response.setMessage("Hello " + inputPayload.getName());
		response.setExtra("Some text");
		return response;
	}
}
