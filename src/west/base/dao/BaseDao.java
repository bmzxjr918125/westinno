package west.base.dao;

import java.util.List;


import org.hibernate.Session;

import west.base.action.datatables.DataTables;



/**
 * 锟斤拷锟斤拷锟�
 * 
 * @author
 * @param <T>
 *            实锟斤拷锟斤拷锟斤拷锟�
 */
public interface BaseDao<T> {
	/**
	 * 锟斤拷锟斤拷一锟斤拷实锟斤拷姆锟斤拷锟�
	 * 
	 * @param t
	 *            要锟斤拷锟斤拷锟绞碉拷锟�
	 * @throws RuntimeException
	 *             锟斤拷锟芥不锟缴癸拷锟斤拷时锟斤拷锟阶筹拷锟届常
	 */
	void save(T t);

	/**
	 * 删锟斤拷一锟斤拷实锟斤拷姆锟斤拷锟�
	 * 
	 * @param t
	 *            要删锟斤拷实锟斤拷
	 * @throws RuntimeException
	 *             删锟斤拷晒锟斤拷锟绞憋拷锟斤拷壮锟斤拷斐�
	 */
	void delete(T t);

	/**
	 * 通锟斤拷id删锟斤拷一锟斤拷实锟斤拷
	 * 
	 */
	void deleteById(int id);

	/**
	 * 锟斤拷锟斤拷一锟斤拷实锟斤拷
	 * 
	 * @param t
	 *            要锟斤拷锟铰碉拷实锟斤拷
	 * @throws RuntimeException
	 *             锟斤拷锟铰诧拷锟缴癸拷锟斤拷时锟斤拷锟阶筹拷锟届常
	 */
	void update(T t);
	void merge(T t);

	/**
	 * 锟斤拷锟絠d锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷询锟斤拷锟斤拷氐锟绞碉拷锟�
	 * 
	 * @param idList
	 *            id锟侥硷拷锟斤拷
	 * @return 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷id锟斤拷实锟斤拷
	 */
	List<T> getByIdList(List<Integer> idList);

	/**
	 * 通锟斤拷id锟斤拷取一锟斤拷实锟斤拷
	 * 
	 * @param id
	 *            要锟斤拷取实锟斤拷锟絠d
	 * @return 锟斤拷取锟斤拷锟斤拷实锟斤拷
	 */
	T load(int id);

	/**
	 * 锟斤拷询锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷锟叫碉拷锟斤拷锟�
	 * 
	 * @return 锟斤拷装锟剿憋拷锟斤拷锟斤拷锟斤拷实锟斤拷锟揭伙拷锟绞碉拷锟�
	 */
	List<T> findAll();


	/**
	 * 锟矫碉拷一锟脚憋拷母锟斤拷锟�
	 * 
	 * @return
	 */
	public int count();

	/**
	 * 锟斤拷锟铰伙拷锟竭憋拷锟斤拷一锟斤拷锟斤拷锟斤拷
	 * 
	 * @param object
	 */
	void saveOrUpdate(T t);

	/**
	 * 锟斤拷锟斤拷删锟斤拷
	 * 
	 * @param ids
	 *            要删锟斤拷亩锟斤拷锟斤拷Id锟叫憋拷
	 */
	void delete(List<Integer> ids);

	/**
	 * 通锟斤拷Id锟斤拷锟斤拷锟斤拷一锟斤拷实锟斤拷
	 * 
	 * @param id
	 * @return
	 */
	T get(int id);

	/**
	 * 锟斤拷取锟斤拷前Session
	 * 
	 * @return
	 */
	Session getCurrentSession();

	

	/**
	 * 锟斤拷锟斤拷锟接︼拷侄锟斤拷锟斤拷锟斤拷锟街段讹拷应值锟斤拷锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷
	 * 
	 * @param str
	 * @param i
	 * @return
	 */
	public List<T> getListByNameAndId(String str, int i);

	/**
	 * 通锟斤拷一锟斤拷锟街段伙拷取实锟藉集锟斤拷
	 * 
	 * @return
	 */
	public List<T> findByName(String name, String str);

	/**
	 * 通锟斤拷一锟斤拷锟斤拷锟斤拷为int锟斤拷锟街段伙拷取锟斤拷锟斤拷侄味锟接︼拷锟斤拷锟斤拷
	 */
	public List<T> findByInt(String name, int i);
	/**
	 * 通锟斤拷一锟斤拷锟斤拷锟斤拷为int锟斤拷锟街段猴拷String锟街段伙拷取锟斤拷锟斤拷侄味锟接︼拷锟斤拷锟斤拷
	 */
	public List<T> findByIntAndStr(String name1,int i,String name2,String value);
	/**
	 * 通锟斤拷一锟斤拷锟斤拷锟斤拷为int锟斤拷锟街段猴拷String锟街段伙拷取锟斤拷锟斤拷侄味锟接︼拷锟斤拷锟斤拷
	 */
	public List<T> findByIntAndInt(String name1,int i,String name2,int j);
	/**
	 * dataTable锟侥凤拷页
	 * @param displayStart 锟斤拷始位锟斤拷
	 * @param displayLength 锟斤拷示锟斤拷锟斤拷
	 * @param hql hql锟斤拷锟�
	 */
	public List<T> getPage(int displayStart,int displayLength,String hql);
	/**
	 * dataTable锟侥凤拷页
	 * @param hql hql锟斤拷锟�
	 */
	public int getPageCount(String hql);
	
	public void findByPage(String hql, DataTables dt,Object... params);

	public List<T> findByHql(String hql, Object...params);
	
	public boolean runByHql(String hql, Object...params);

}
