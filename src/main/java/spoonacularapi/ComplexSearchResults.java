package spoonacularapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComplexSearchResults {

	@JsonProperty("image")
	private String image;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("imageType")
	private String imageType;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setImageType(String imageType){
		this.imageType = imageType;
	}

	public String getImageType(){
		return imageType;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"image = '" + image + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",imageType = '" + imageType + '\'' + 
			"}";
		}
}