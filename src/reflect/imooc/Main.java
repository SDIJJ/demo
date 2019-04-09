package reflect.imooc;

public class Main
{
	public static void main(String args[]){
		try{
		   Class clazz=Class.forName("com.jia.utils.reflect.imooc.Dog");
		   Animal a=(Animal)clazz.newInstance();

		   a.call();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}