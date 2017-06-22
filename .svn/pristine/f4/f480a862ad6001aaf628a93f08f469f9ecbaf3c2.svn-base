package west.admin.action;


import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import west.base.action.BaseAction;
import west.entity.We_Product;
import west.service.We_ProductService;
import west.service.We_Product_Type_OneService;
import west.service.We_Product_Type_TwoService;
import west.util.Config;
import west.util.ImageUtils;
import west.util.Notify;
import west.util.RequestUtils;
/**
 * 商品管理
 * @ClassName: AdminProductAction
 * @Description: TODO
 * @author BianMingZhou
 * @date 2016-3-23 下午4:26:37
 */
@Controller("adminProductAction")
@Scope("prototype")
public class AdminProductAction extends BaseAction {
	private static final long serialVersionUID = 890499133824024701L;
	private Notify notify=new Notify();
	private We_ProductService we_ProductService;
	private We_Product_Type_OneService we_Product_Type_OneService;
	private We_Product_Type_TwoService we_Product_Type_TwoService;
	private We_Product product;
	private File file1;
	private String file1ContentType;
	private String file1FileName;
	public String Show(){
		
		return "Show";
	}
	public String GetData(){
		we_ProductService.getByPage(super.getDtJson());
		return "ajaxShow";
	}
	
	public String Update(){
		int id=	RequestUtils.getIntParamter("product_id");
		product=we_ProductService.getById(id);
		return "Update";
	}
	
	
	public String UpdateSave(){
		int product_type_one_id = RequestUtils.getIntParamter("product_type_one_id");
		int product_type_two_1 = RequestUtils.getIntParamter("product_type_two_1");
		int product_type_two_2 = RequestUtils.getIntParamter("product_type_two_2");
		int product_type_two_3 = RequestUtils.getIntParamter("product_type_two_3");
		double price = RequestUtils.getDoubleParamter("product_price");
		product.setPrice(price);
		if(product.getLogo()==null||"".equals(product.getLogo().trim())){
			if (file1==null) {
				//操作消息提示
				notify.setCode(2);
				notify.setMsg("请选择商品图");
				//操作提示放入session
				request.getSession().setAttribute("notify", notify);
				return "UpdateSaveError";
			}
		}
			
			String imagepath = "";
			String ext1 = "";
			if (file1!=null) {
				if (!ImageUtils.isVisibleImage(file1FileName)) {
					// json.put("msg","手持照图片格式有误。");
					return "UpdateSaveError";
				}
				String imagePath1 = "";
				ext1 = this.file1FileName.substring(
						this.file1FileName.lastIndexOf("."),
						this.file1FileName.length());
				try {
					String imageName1 = ImageUtils.createUploadFileName(ext1);
					FileUtils.copyFile(file1, new File(ImageUtils.uploadProductPath
							+ Config.DIR_LOC + imageName1));
					imagePath1 = ImageUtils.saveProductPath + imageName1;
				} catch (Exception e) {
				}
			    imagepath = imagePath1;
			    product.setLogo(imagepath);
			}
			
		
			product.setType_one_id(we_Product_Type_OneService.getById(product_type_one_id));
			product.setType_two_1(we_Product_Type_TwoService.getById(product_type_two_1));
			product.setType_two_2(we_Product_Type_TwoService.getById(product_type_two_2));
			product.setType_two_3(we_Product_Type_TwoService.getById(product_type_two_3));
			//product.setPrice(price);
			//操作消息提示
			notify.setCode(1);
			notify.setMsg("操作成功！");
			//操作提示放入session
			request.getSession().setAttribute("notify", notify);
			
	        we_ProductService.saveOrUpdate(product);
			return "UpdateSave";
	}
	
	public We_ProductService getWe_ProductService() {
		return we_ProductService;
	}
	@Resource(name="we_ProductService")
	public void setWe_ProductService(We_ProductService we_ProductService) {
		this.we_ProductService = we_ProductService;
	}
	public We_Product getProduct() {
		return product;
	}
	public void setProduct(We_Product product) {
		this.product = product;
	}
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public String getFile1ContentType() {
		return file1ContentType;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	public String getFile1FileName() {
		return file1FileName;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public We_Product_Type_OneService getWe_Product_Type_OneService() {
		return we_Product_Type_OneService;
	}
	@Resource(name="we_Product_Type_OneService")
	public void setWe_Product_Type_OneService(
			We_Product_Type_OneService we_Product_Type_OneService) {
		this.we_Product_Type_OneService = we_Product_Type_OneService;
	}
	public We_Product_Type_TwoService getWe_Product_Type_TwoService() {
		return we_Product_Type_TwoService;
	}
	@Resource(name="we_Product_Type_TwoService")
	public void setWe_Product_Type_TwoService(
			We_Product_Type_TwoService we_Product_Type_TwoService) {
		this.we_Product_Type_TwoService = we_Product_Type_TwoService;
	}
}
