package pl.jiro.photo;

import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;


@Controller
@SessionAttributes("sessionCid")
public class PhotoController {
	
	@Value("${jiro.photo.path}")
	private String webContext;
	
	@Autowired private CategoryDAO categoryDAO;
	
	@Autowired private PhotoDAO photoDAO;
	
	@RequestMapping("/admin/photo")
	public String photoListAll(@RequestParam(value="actionResponse", required=false) String res, Model model) {
		
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("sessionCid", categories.get(0).getId());
		
		//int cid = (int) request.getAttribute("sessionCid", WebRequest.SCOPE_SESSION);
		
		if (categories.size() > 0) {
			List<Photo> photos;
			
			//if (cid > 0) {
			//	photos = photoDAO.findByCategoryId(Long.toString(cid));
			//} else {
				photos = photoDAO.findByCategoryId(Long.toString(categories.get(0).getId()));
			//}
			
			model.addAttribute("photos", photos);
		} else {
			List<Photo> photos = photoDAO.findAll();
			model.addAttribute("photos", photos);
		}
		
		model.addAttribute("message", res);
		
		return "photoList";
	}
	
	@RequestMapping("/admin/photoList/{cid}")
	public String photoList(@RequestParam(value="actionResponse", required=false) String res, @PathVariable String cid, Model model) {
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("categoryId", Integer.parseInt(cid));
		model.addAttribute("sessionCid", Integer.parseInt(cid));
		
		if (Integer.parseInt(cid) > 0) {
			List<Photo> photos = photoDAO.findByCategoryId(cid);
			//List<Photo> photos = photoDAO.findAll();
			model.addAttribute("photos", photos);
		} else {
			List<Photo> photos = photoDAO.findAll();
			model.addAttribute("photos", photos);
		}
		
		model.addAttribute("message", res);
		
		return "photoList";
	}
	
	@RequestMapping(value="/admin/addPhoto", method=RequestMethod.GET)
	public String addPhoto(@RequestParam(value="actionResponse", required=false) String res,
						Model model) {
		
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("sessionCid", 0);
		model.addAttribute("photo", new Photo());
		model.addAttribute("formHeader", "add");
		model.addAttribute("message", res);
		
		return "photoAdd";
	}
	
	@RequestMapping(value="/admin/addPhoto", method=RequestMethod.POST)
	public String addPhotoSubmit(@ModelAttribute @Valid Photo photo, BindingResult bindingResult,
			@RequestParam(value="image", required=false) MultipartFile image, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "add");
            return "photoAdd";
        }
		
		//model.addAttribute("sessionCid", photo.getCid());
		
		photo.setSrc(" ");
		photoDAO.addPhoto(photo);
		
		try {
			if (!image.isEmpty()) {
				validateImage(image);
				saveImage(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
			}
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			//return "redirect:/admin/addPhoto?action=addFailure";
			model.addAttribute("formHeader", "add");
			return "photoAdd";
		}
		
		
		photoDAO.editPhoto(photo);
		
		model.addAttribute("actionResponse", "addSuccess");
		
		return "redirect:/admin/addPhoto";
	}
	
	@RequestMapping(value="/admin/deletePhoto", method=RequestMethod.POST)
	public String deletePhoto(@RequestParam long id, Model model) {
		
		Photo photo = photoDAO.getPhotoById(id);
		long categoryId = photo.getCid();
		photoDAO.deletePhoto(photo);
		
		deleteImage(getImagePath(photo.getId()));
		
		model.addAttribute("actionResponse", "deleteSuccess");
		
		return "redirect:/admin/photoList/" + String.valueOf(categoryId);
	}
	
	@RequestMapping(value="/admin/editPhoto", method=RequestMethod.GET)
	public String editPhoto(@RequestParam long id, Model model) {
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("categories", categories);
		
		model.addAttribute("formHeader", "edit");
		Photo photo = photoDAO.getPhotoById(id);
		model.addAttribute("photo", photo);
		model.addAttribute("photoSrc", photo.getSrc());
		
		return "photoAdd";
	}
	
	@RequestMapping(value="/admin/editPhoto", method=RequestMethod.POST)
	public String editPhotoPost(@ModelAttribute @Valid Photo photo, 
			@RequestParam(value="image", required=false) MultipartFile image,
			@RequestParam(value="image_uploaded", required=false) String imageUploaded,
			BindingResult bindingResult, Model model) {
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("formHeader", "edit");
            return "photoAdd";
        }		
		
		photo.setSrc(imageUploaded);
		
		if (image != null) {
			if (!image.isEmpty()) {
				deleteImage(getImagePath(photo.getId()));
				
				validateImage(image);
				saveImage(webContext + photo.getId() + ".jpg", image);
				photo.setSrc(photo.getId() + ".jpg");
			}
		}
		
		photoDAO.editPhoto(photo);
		model.addAttribute("actionResponse", "editSuccess");
		
		return "redirect:/admin/photoList/" + photo.getCid();
	}
	
	@RequestMapping("/admin/featurePhoto")
	public String featurePhoto(@RequestParam long id, @RequestParam boolean status, Model model) {
		Photo photo = photoDAO.getPhotoById(id);
		long categoryId = photo.getCid();
		photo.setFeatured(status);
		
		if (status) {
			photo.setVisible(true);
		}
		
		photoDAO.editPhoto(photo);
		
		return "redirect:/admin/photoList/" + String.valueOf(categoryId);
	}
	
	@RequestMapping("/admin/visiblePhoto")
	public String visilePhoto(@RequestParam long id, @RequestParam boolean status, Model model) {
		Photo photo = photoDAO.getPhotoById(id);
		long categoryId = photo.getCid();
		photo.setVisible(status);
		photoDAO.editPhoto(photo);

		return "redirect:/admin/photoList/" + String.valueOf(categoryId);
	}
	
	private String getImagePath(long id) {
		return webContext + id + ".jpg";
	}
	
	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Nieakceptowane pliki jpeg");
		}
		
	}
	
	private void saveImage(String filename, MultipartFile image) throws ImageUploadException {
		try {
			File file = new File (filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch(IOException e) {
			throw new ImageUploadException("photo.upload.fail");
		}
		
	}
	
	private void deleteImage(String filename) {
		try {
			 
    		File file = new File(filename);
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		} else {
    			System.out.println("Delete operation is failed.");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	
}