package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 通用的dao层操作,构造器需要传入主键字段;局限性:目前只适用于String 的属性
 * @author: Arnold
 * @since: 2018/12/30 22:08
 * @version: v1.0.0
 */
public class CrudUtil<T> {

    private static final String url = "jdbc:mysql://132.232.37.42:3306/friends?characterEncoding=utf8";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root";


    private String id;

    public CrudUtil(String id) {
        this.id = id;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        String str="123";
        Class clazz=str.getClass();
        System.out.println(clazz.getAnnotations().length);
        Arrays.stream(clazz.getAnnotations()).forEach(e->
        {
            System.out.println(e);
        });
        //----------------
        System.out.println(clazz.getClassLoader());

        //------------
        System.out.println(clazz.getConstructors());
        Arrays.stream(clazz.getConstructors()).forEach(e->
        {
            System.out.println(e.getName());
        });





        System.out.println("============================");
        Class stringClass=String.class;
        for (Constructor constructor :stringClass.getConstructors()) {
            Class[] paramters=constructor.getParameterTypes();
            System.out.println("构造器......");
            for (int i = 0; i <paramters.length ; i++) {

                System.out.println(paramters[i]);

            }

        }
        System.out.println("+++++++++++++");
        System.out.println(str.getClass().getSimpleName());

        Integer a=110;

        if(a instanceof  Integer){
            System.out.println("instanceof" );
        }

        System.out.println("===================");
        User user =new User();
        Class userClass=user.getClass();
        Field userName = userClass.getDeclaredField("userName");
        userName.setAccessible(true);
        userName.set(user,"11111");
        System.out.println(user.getUserName());

        System.out.println(userClass.getInterfaces().length);







      /*  User user = new User();
        user.setUserName("congcong");
        user.setPassWord("dshfasfhdsk");
        CrudUtil<User> crudUtil = new CrudUtil<>("userId");
        try {
            crudUtil.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    public T findOne(String id) {
        return null;
    }

    public List<T> findAll() {
        return null;
    }

    public void insert(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {

        //insert into '表明' ( ) values ( ) ;
        Class clazz = t.getClass();
        //拼接SQL
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(clazz.getSimpleName().substring(0, 1).toLowerCase()).append(clazz.getSimpleName()
                .substring(1).toLowerCase()).append(" (");
        //给主键赋值
        Method setId = clazz.getDeclaredMethod("set".concat(this.id.substring(0, 1).toUpperCase()).concat(this.id.substring(1)), String.class);
        setId.invoke(t, getUUID(20));
        Method[] methods = clazz.getDeclaredMethods();
        //存放所有get方法
        List<Method> getMethods = new ArrayList();
        for (Method m : methods) {
            String methodName = m.getName();
            if (methodName != null && methodName.startsWith("get") && !methodName.equals("get")) {
                getMethods.add(m);
            }
        }
        //存放所有参数 ? 占位符部分
        List<String> parameters = new ArrayList();
        for (Method m : getMethods) {
            sql.append(m.getName().substring(3, 4).toLowerCase()).append(m.getName().substring(4));
            sql.append(" ,");
            parameters.add((String) m.invoke(t));
        }
        sql.replace(sql.lastIndexOf(","), sql.length(), " ) values ( ");
        for (int i = 0; i < parameters.size(); i++) {
            if (i != parameters.size() - 1)
                sql.append(" ? ,");
            else
                sql.append("? );");
        }

        //数据库操作
        Connection connection = openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        //给占位符赋值
        for (int i = 1; i <= parameters.size(); i++) {
            preparedStatement.setString(i, parameters.get(i - 1));
        }
        preparedStatement.execute();
        CloseConPstmtResult(connection, preparedStatement);
    }



    public void update(T t) {

    }


    /************************/
    /******  辅助部分 ********/
    /************************/

    private String getUUID(int size) {
        return UUID.randomUUID().toString().substring(0, size);
    }

    public static Connection openConnection() {
        Connection conn = null;

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void CloseConPstmtResult(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null && conn != null) {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void CloseConPstmtResult(Connection conn, PreparedStatement pstmt,
                                           ResultSet result) {
        if (pstmt != null && conn != null && result != null) {
            try {
                result.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
