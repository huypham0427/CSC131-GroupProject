package com.example.simplerestapis.controller;
import com.example.simplerestapis.Award;
import com.example.simplerestapis.Movies;
import com.example.simplerestapis.readCSV;
import org.springframework.web.bind.annotation.*;

import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

	private static final List<Movies> ALL_MOVIES = readCSV.all();
	private static final ArrayList<String> ALL_CATEGORIES = readCSV.get_Category();
	private static final ArrayList<String> ALL_TITLES = readCSV.get_Titles();


	/*
	 * http://localhost:8080/movies
	 * @return
	 */
	@GetMapping("/movies")
	public ArrayList<String> titles()
	{
		int j = 0;
		ArrayList<String> list = new ArrayList<String>();
		list.add(ALL_TITLES.get(0));

		for(int i = 1; i <= ALL_TITLES.size() - 2; i++)
		{
			int key = ALL_TITLES.get(i).compareTo(list.get(j));
			if(key != 0)
			{
				j++;
				list.add(ALL_TITLES.get(i));
			}
		}
		return list;
	}


	/*
	 * http://localhost:8080/movies/actor
	 * @param category
	 * @return
	 */
	@GetMapping("/movies/{category}")
	public ArrayList<Movies> movie(@PathVariable("category") String category)
	{
		ArrayList<Movies> matchList = new ArrayList<>();
		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards())
			{
				// Get the matching Category
				if (award.getCategory().equalsIgnoreCase(category))
				{
					matchList.add(movie);
					break;
				}
			}
		}
		return matchList;
	}


	/*
	 * http://localhost:8080/movies/categories/directing_(dramatic_picture)/1927
	 * @param category
	 * @param year
	 * @return
	 */
	@GetMapping("/movies/categories/{category}/{year}")
	public ArrayList<Movies> Movie (@PathVariable("category") String category,
									@PathVariable("year") String year)
	{
		ArrayList<Movies> matchList = new ArrayList<>();

		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards()) {
				// Get the match Categories
				if (award.getCategory().equalsIgnoreCase(category)
						&& movie.getYear().equals(year))
				{
					matchList.add(movie);
					break;
				}
			}
		}
		return matchList;
	}


	/*
	 * http://localhost:8080/categories/best_picture/year/1979
	 * @param category
	 * @param year
	 * @return
	 */
	@GetMapping("/categories/{category}/year/{year}")
	public ArrayList<Movies> movies(@PathVariable("category") String category,
								    @PathVariable("year") String year)
	{
		ArrayList<Movies> matchList = new ArrayList<>();
		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards()) {
				// Get the match Categories
				if (award.getCategory().equalsIgnoreCase(category)
					&& movie.getYear().equals(year))
				{
					matchList.add(movie);
					break;
				}
			}
		}
		return matchList;
	}


	/*
	 * http://localhost:8080/best_picture/year/2000/winner
	 * @param category
	 * @param year
	 * @return
	 */
	@GetMapping("/{category}/year/{year}/winner")
	public ArrayList<Movies> movie(@PathVariable("category") String category,
	                               @PathVariable("year") String year)
	{
		ArrayList<Movies> matchList = new ArrayList<>();

		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards()) {
				// Get the match Categories
				if (award.getCategory().equalsIgnoreCase(category)
						&& movie.getYear().equals(year)
						&& award.isWinner())
				{
					matchList.add(movie);
					break;
				}
			}
		}
		return matchList;
	}


	/*
	 * http://localhost:8080/movies/categories/actor/1947/type/true
	 * @param category
	 * @param year
	 * @param winner
	 * @return
	 */
	@GetMapping("/movies/categories/{category}/{year}/type/{winner}")
	public ArrayList<Movies> film(@PathVariable("category") String category,
								  @PathVariable("year") String year,
								  @PathVariable("winner")Boolean winner)
	{
		ArrayList<Movies> matchList = new ArrayList<>();

		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards()) {
				// Get the match Categories
				if (award.getCategory().equalsIgnoreCase(category)
					&& movie.getYear().equals(year)
					&& award.isWinner() == winner)
				{
					matchList.add(movie);
					break;
				}
			}
		}
		return matchList;
	}


	/*
	 * http://localhost:8080/movies/search?year=1997&category=best_picture
	 * @param year
	 * @param category
	 * @return
	 */

	@GetMapping("/movies/search")
	public ArrayList<Movies> search(@RequestParam(value = "year", defaultValue = "null") String year
			,@RequestParam(value = "category", defaultValue = "null") String category)
	{
		ArrayList<Movies> matchSearch = new ArrayList<>();

		for (Movies movie : ALL_MOVIES)
		{
			for (Award award : movie.getAwards())
			{
				// Get the match Categories
				if (movie.getYear().equals(year) && award.getCategory().equalsIgnoreCase(category))
				{
					matchSearch.add(movie);
					break;
				}
			}
		}
		return matchSearch;
	}


	/*
	 * http://localhost:8080/search?type=actor&year=1936&category=in_a_supporting_role
	 * @param type
	 * @param year
	 * @param category
	 * @return
	 */
	@GetMapping("/search")
	public ArrayList<Movies> search(@RequestParam(value = "type", defaultValue = "null") String type,
									@RequestParam(value = "year", defaultValue = "null") String year,
									@RequestParam(value = "category", defaultValue = "null") String category)
	{
		ArrayList<Movies> matchSearch = new ArrayList<>();

		for(Movies movie : ALL_MOVIES)
		{
			for(Award award : movie.getAwards())
			{
				if (award.getCategory().toUpperCase().contains(type.toUpperCase())
						&& movie.getYear().equals(year)
						&& award.getCategory().toUpperCase().contains(category.toUpperCase()))
				{
					matchSearch.add(movie);
					break;
				}
			}
		}
		return matchSearch;
	}


	/*
	 * http://localhost:8080/searchRange?type=actor&year=1900&range=2000&category=in_a_leading_role
	 * @param type
	 * @param year
	 * @param range
	 * @param category
	 * @return
	 */
	@GetMapping("/searchRange")
	public ArrayList<Movies> searchRange(@RequestParam(value = "type", defaultValue = "null") String type,
										 @RequestParam(value = "year", defaultValue = "null") String year,
										 @RequestParam(value = "range", defaultValue = "null") String range,
										 @RequestParam(value = "category", defaultValue = "null") String category)
	{
		ArrayList<Movies> matchSearch = new ArrayList<>();

		for(Movies movie : ALL_MOVIES)
		{
			for(Award award : movie.getAwards())
			{
				if (award.getCategory().toUpperCase().contains(type.toUpperCase())
					&& Integer.parseInt(movie.getYear()) >= Integer.parseInt(year)
					&& Integer.parseInt(movie.getYear())<= Integer.parseInt(range)
					&& award.getCategory().toUpperCase().contains(category.toUpperCase()))
				{
					matchSearch.add(movie);
					break;
				}
			}
		}
		return matchSearch;
	}


	/*
	 * http://localhost:8080/search2Cat?category=actor&category2=actress&year=1900&range=2000
	 * @param year
	 * @param range
	 * @param category
	 * @param category2
	 * @return
	 */
	@GetMapping("/search2Cat")
	public ArrayList<Movies> search(@RequestParam(value = "category", defaultValue = "null") String category,
									@RequestParam(value = "category2", defaultValue = "null") String category2,
									@RequestParam(value = "year", defaultValue = "null") String year,
									@RequestParam(value = "range", defaultValue = "null") String range)
	{
		ArrayList<Movies> matchSearch = new ArrayList<>();

		for(Movies movie : ALL_MOVIES)
		{
			for(Award award : movie.getAwards())
			{
				if ((award.getCategory().equalsIgnoreCase(category)
					|| award.getCategory().equalsIgnoreCase(category2))
					&& Integer.parseInt(movie.getYear()) >= Integer.parseInt(year)
					&& Integer.parseInt(movie.getYear()) <= Integer.parseInt(range))
				{
					matchSearch.add(movie);
					break;
				}
			}
		}
		return matchSearch;
	}


	/*
	 * http://localhost:8080/movies/categories
	 * @return
	 */
	@GetMapping("/movies/categories")
	public ArrayList<String> cat()
	{
		int j = 0;
		ArrayList<String> matchList = new ArrayList<String>();
		matchList.add(ALL_CATEGORIES.get(0));

		for(int i = 1; i <= ALL_CATEGORIES.size() - 2; i++)
		{
			int key = ALL_CATEGORIES.get(i).compareTo(matchList.get(j));
			if(key != 0)
			{
				j++;
				matchList.add(ALL_CATEGORIES.get(i));
			}
		}

		return matchList;
	}


	/*
	 * http://localhost:8080/winner
	 * @return
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
