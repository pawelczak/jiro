package pl.jiro.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Łukasz Pawełczak
 */
@Entity
@Table(name = "photo_preview")
public class PreviewPhoto extends BasicDataSource {
	
	
	@Id
	@GeneratedValue
	private long id;

	@Size(min=0, max=128, message="Tytu� zdj�cia musi sk�ada� si� z maksymalnie 128 znak�w.")
	private String title;
	
	private String src;
	
	private boolean visible = true;
	
	private int position;
	
	@Size(min=0, max=256, message="Opis fotografii mo�e sk�ada� si� maksymalnie z 256 znak�w.")
	private String description;

	
	//------------------------ CONSTRUCTORS --------------------------
	
	public PreviewPhoto() {}
	
	public PreviewPhoto(String title) {
		this.title = title;
	}
	
	
	//------------------------ GETTERS --------------------------
	
	public long getId() {
		return id;
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
	
	public boolean getVisible() {
		return visible;
	}
	
	public int getPosition() {
		return position;
	}
	
	
	//------------------------ PRIVATE --------------------------
	
	private void init() {
	    addConnectionProperty("useUnicode", "true");
	    addConnectionProperty("characterEncoding", "UTF-8");
	}
	
	//------------------------ SETTERS --------------------------
	
	public void setId(long id) {
		this.id = id;
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
	
	public void setVisible(boolean vis) {
		this.visible = vis;
	}
	
	public void setPosition(int pos) {
		this.position = pos;
	}
	
}