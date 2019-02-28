package com.massky.connsqlserver;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private View btnTest;
    private View btnClean;
    private TextView tvTestResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest = findViewById(R.id.btnTestSql);
        btnClean = findViewById(R.id.btnClean);
        tvTestResult = (TextView) findViewById(R.id.tvTestResult);

        btnTest.setOnClickListener(getClickEvent());
        btnClean.setOnClickListener(getClickEvent());
    }

    private View.OnClickListener getClickEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTestResult.setText("...");
                if (v == btnTest) {
                    test();

                }
            }
        };
    }

    private void test() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
//                String ret = DBUtil.QuerySQL();
//                Message msg = new Message();
//                msg.what=1001;
//                Bundle data = new Bundle();
//                data.putString("result", ret);
//                msg.setData(data);
//                mHandler.sendMessage(msg);
                user user = new user();//直接new为查询全部user表中的数据
//                user.setName("郑波");//插入数据为条件查询全部为郑波的user表数据
//                user.setUsertype(3);
                List<user> list = user.queryList(user);
//                user.deleteList(user);

                //where  and
                Map map = new HashMap();
                map.put("usertype", 1);//where usertype = 1

                //设置成为的类型
                user.setUsertype(3);
                user.setName("众天力55");//set name  = 众天力55 where usertype = 1

//                user.insertList(user);
//
                user.updateList(user, map);
            }
        };
        new Thread(run).start();
    }

    Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1001:
                    String str = msg.getData().getString("result");
                    tvTestResult.setText(str);
                    break;

                default:
                    break;
            }
        }
    };
}
