package west.service;

import java.util.List;

import west.entity.We_Product_Type_Two;


public interface We_Product_Type_TwoService {

	We_Product_Type_Two getById(int product_typetwo);

	List<We_Product_Type_Two> getByName(String string, int type_one);

}
