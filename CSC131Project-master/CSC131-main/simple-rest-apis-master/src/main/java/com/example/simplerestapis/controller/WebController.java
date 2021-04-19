package com.example.simplerestapis.controller;
import com.example.simplerestapis.Award;
import com.example.simplerestapis.Movies;
//import com.google.gson.annotations.SerializedName;
//import jdk.jfr.Category;
import com.example.simplerestapis.readCSV;
import org.springframework.web.bind.annotation.*;

import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;
import com.example.simplerestapis.models.SampleResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

	private static final List<Movies> ALL_MOVIES = readCSV.all();
	private static final ArrayList<String> ALL_CATEGORIES = readCSV.get_Category();

	@GetMapping("/movies")
	public SampleResponse Sample(@RequestParam(value = "name",
	defaultValue = "null") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1927);
		response.setMessage("Your movie is "+name);
		return response;
	}


//	@GetMapping("/movies/{category}")
//	public ArrayList<Movies> movie(@PathVariable(required = false) String category,
//								   @RequestParam(value = "type") String type){
//		ArrayList<Movies> matchCategory = new ArrayList<>();
//		for (Movies movie : ALL_MOVIES) {
//			for (Award award : movie.getAwards()) {
//				if (award.getCategory().toUpperCase().contains(category.toUpperCase())) {
//					if ("true".equalsIgnoreCase(type) && award.isWinner()){
//						matchCategory.add(movie);
//					break;
//				}
//				}
//			}
//		}
//		return matchCategory;
//	}


	@GetMapping("/movies/categories")
	public ArrayList<String> cat() {

		ArrayList<String> list = new ArrayList<String>();
		return list;

	}

	//@GetMapping("/categories/{category})

	/*
	@GetMapping("/movies/{category})
	public ArrayList<Movies> movie(@PathVariable("category") String category){
		ArrayList<Movies> matchList = new ArrayList<>();
		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards()) {
				if (award.getCategory().toUpperCase().contains(category.toUpperCase())) {
					matchList.add(movie);
				}
			}
		}
		return matchList;
	}

	 */

	@GetMapping("/winner")
	public List<Movies> winner()
	{
		ArrayList<Movies> won = new ArrayList<>();

		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards())
			{
				if (award.isWinner())
				{
					won.add(movie);
					break;
				}
			}
		}
		return won;
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
