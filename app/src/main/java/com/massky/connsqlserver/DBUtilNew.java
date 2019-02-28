package com.massky.connsqlserver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtilNew {
    private static String db = "ackpass";
    private static String ip = "192.168.169.210";
    private static String user = "sa";
    private static String pwd = "";

//    static {
//        try {
//            InputStream is = DBUtilNew.class.getResourceAsStream("/db.properties");
//            Properties ps = new Properties();
//            ps.load(is);
//            mysqlDriver = ps.getProperty("mysqlDriver");
//            url = ps.getProperty("url");
//            user = ps.getProperty("user");
//            password = ps.getProperty("password");
//            Class.forName(mysqlDriver);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //获取数据库连接
    public static Connection getConn() {
        Connection con = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            try {
//                con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + ip + ":1433/" + db + ";charset=utf8", user, pwd);
                con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + ip + ":1433/" + db , user, pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return con;
    }

    //关闭资源
    public static void close(Object... objs) {
        if (objs != null && objs.length > 0) {
            for (int i = 0; i < objs.length; i++) {
                try {
                    if (objs[i] instanceof Connection) {
                        ((Connection) objs[i]).close();
                    } else if (objs[i] instanceof PreparedStatement) {
                        ((PreparedStatement) objs[i]).close();
                    } else if (objs[i] instanceof ResultSet) {
                        ((ResultSet) objs[i]).close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("关闭资源 异常");
                }
            }
        }
    }

}
