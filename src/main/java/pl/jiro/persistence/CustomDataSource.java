package pl.jiro.persistence;

import org.apache.commons.dbcp.BasicDataSource;



public class CustomDataSource extends BasicDataSource {
	
	private void init() {
	    addConnectionProperty("useUnicode", "true");
	    addConnectionProperty("characterEncoding", "UTF-8");
	}
	
}