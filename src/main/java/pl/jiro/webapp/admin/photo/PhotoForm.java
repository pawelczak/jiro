package pl.jiro.webapp.admin.photo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
public class PhotoForm {

		
	private long id;
	
	@NotNull
	private long cid;
	
	@Size(min=0, max=128, message="Tytuł zdjęcia musi składać się z maksymalnie 128 znaków.")
	private String title;
	
	private String src;
	
	@Size(min=0, max=256, message="Opis fotografii może składać się maksymalnie z 256 znaków.")
	private String description;
	
	
	//------------------------ GETTERS --------------------------
	
	public long getId() {
		return id;
	}
	
	public long getCid() {
		return cid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSrc() {
		return src;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	//------------------------ SETTERS --------------------------
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}	
	
	public void setDescription(String desc) {
		this.description = desc;
	}
}
