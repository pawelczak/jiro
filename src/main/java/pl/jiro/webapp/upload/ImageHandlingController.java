package pl.jiro.webapp.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@Controller
public class ImageHandlingController {
 
 
	@Value("${upload.img}")
	private String uploadImg;
	
	
	//------------------------ LOGIC --------------------------

	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public void testImage1(HttpServletResponse response, @RequestParam(value="fileName", required=false) String fileName) throws IOException {
		InputStream in = getImageFileStream(fileName);
		
		try {
			response.setContentType("image/jpeg");
			IOUtils.copy(in, response.getOutputStream());
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	@RequestMapping(value = "/image2/{fileName}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> testImage2(@PathVariable(value="fileName") String fileName) throws IOException {
		InputStream in = getImageFileStream(fileName);

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);

			return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,
					HttpStatus.OK);
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	@RequestMapping(value = "/image3/{fileName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] testImage3(@PathVariable(value="fileName") String fileName) throws IOException {
		InputStream in = getImageFileStream(fileName);

		try {
			return IOUtils.toByteArray(in);
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
	
	
	//------------------------ PRIVATE --------------------------
	
	private InputStream getImageFileStream(String fileName)  throws IOException {
		File file = new File(uploadImg + fileName);
		return new FileInputStream(file);
	}
}

