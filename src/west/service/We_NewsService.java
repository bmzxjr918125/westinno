package west.service;

import java.util.List;

import net.sf.json.JSONObject;

import west.base.action.datatables.DataTables;
import west.entity.We_News;


public interface We_NewsService {

	void getByPage(DataTables dtJson);

	We_News getById(int id);

	void saveOrUpdate(We_News we_News);

	void deleteById(int id);
    /**
     * 获取最多9条推荐资讯
     * @Title: getRecommend
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-24 下午2:17:37
     * @param @return 
     * @return List<We_News> 
     * @throws
     */
	List<We_News> getRecommend();
    /**
     * 计算条数
     * @Title: countAll
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-24 下午3:21:29
     * @param type  类型 0为全部
     * @return int 
     * @throws
     */
	int countAllByType(int type);
    /**
     * 获取html页面分页新闻
     * @Title: getHtmlPage
     * @Description: TODO
     * @author BianMingZhou
     * @date 2016-3-24 下午3:31:22
     * @param @param jsonData  
     *  jsonData.put("pageNumber", pageNumber);
		jsonData.put("currentPage", currentPage);
		jsonData.put("type",type);
     * 
     * @param @return 
     * @return List<We_News> 
     * @throws
     */
	List<We_News> getHtmlPage(JSONObject jsonData);

}
