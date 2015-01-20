package pl.jiro.webapp.admin.photo;

import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
public class PhotoManyFilesForm {

		
	private long id;
	
	@NotNull
	private long cid;
	
	private String src;
	
	private List<MultipartFile> files;
	
	private boolean featured = false;
	
	private boolean visible = true;
	
	private int position = 0;
	
	
	//------------------------ GETTERS --------------------------
	
	public long getId() {
		return id;
	}
	
	public long getCid() {
		return cid;
	}
	
	public String getSrc() {
		return src;
	}
	
	public boolean getVisible() {
		return visible;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	
	public boolean getFeatured() {
		return featured;
	}
	
	public int getPosition() {
		return position;
	}
	
	
	//------------------------ SETTERS --------------------------
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}	
	
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	public void setVisible(boolean vis) {
		this.visible = vis;
	}
	
	public void setFeatured(boolean feat) {
		featured = feat;
	}
	
	public void setPosition(int pos) {
		position = pos;
	}
}
