package pl.jiro.webapp.admin.category;

import javax.validation.constraints.Size;

/**
 * Simple DTO for category.
 * 
 * @author Łukasz Pawełczak
 *
 */
public class CategoryForm {

	
	private Integer id;	
	
	@Size(min=3, max=128, message="Nazwa kategorii musi składać się z 3 do 128 znaków.")
	private String name;
	
	@Size(min=1, max=256, message="Opis kategorii może składać się maksymalnie z 256 znaków.")
	private String description;
	
	private boolean visible = false;
	
	
	//------------------------ GETTERS --------------------------
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	
	//------------------------ SETTERS --------------------------
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
