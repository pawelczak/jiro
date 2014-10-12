package pl.jiro.photo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import pl.jiro.persistence.FormatConst;


@Entity
@Table(name = "category")
public class Category {
	@Id @GeneratedValue private long id;	
	
	@Size(min=3, max=128, message="Nazwa kategorii musi sk³adaæ siê z 3 do 128 znaków.")
	private String name;
	
	@Size(min=0, max=256, message="Opis kategorii mo¿e sk³adaæ siê maksymalnie z 256 znaków.")
	private String description;
	
	/*
	@DateTimeFormat(pattern=FormatConst.DATE_FORMAT_PATTERN)
	private Date addDate;
	
	@DateTimeFormat(pattern=FormatConst.DATE_FORMAT_PATTERN)
	private Date modDate;*/
	
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	public Date getAddDate() {
		return addDate;
	}
	
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public Date getModDate() {
		return modDate;
	}
	
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	*/
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public String getDescription() {
		return description;
	}
	
}

