package test;

public class Demo {
	
	public static void main(String[] args) {
		double longitude = 103.88415;
		double latitude = 30.67439;
		//先计算查询点的经纬度范围
		double r = 6371;//地球半径千米
		double dis = 3;//3千米距离
		double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));//角度
		dlng = dlng*180/Math.PI;//角度转为弧度
		double dlat = dis/r;
		dlat = dlat*180/Math.PI;		
		double minlat =latitude-dlat;
		double maxlat = latitude+dlat;
		double minlng = longitude -dlng;
		double maxlng = longitude + dlng;
		System.out.println(longitude);
		System.out.println(latitude);
		System.out.println(minlat);
		System.out.println(maxlat);
		System.out.println(minlng);
		System.out.println(maxlng);
		
		
	}
}
