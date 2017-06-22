package west.service;

import java.util.List;
import west.entity.We_Order_Team;
public interface We_Order_TeamService {
	List<We_Order_Team> getByInt(String string, int id);
	public abstract We_Order_Team getOnly(int order_id);

}
