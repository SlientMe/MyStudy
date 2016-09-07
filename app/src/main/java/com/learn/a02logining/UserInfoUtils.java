package com.learn.a02logining;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Romantic on 2016/8/31.
 */

public class UserInfoUtils {


    public static boolean saveInfo(Context context,String username, String pwd) throws IOException {
        String resault = username+"##"+pwd;
        String path = context.getFilesDir().getPath();
//        File file = new File("/data/data/com.learn.a02logining/my.txt");
        File file = new File(path,"my.txt");
        FileOutputStream fos = context.openFileOutput("hha.txt",Context.MODE_PRIVATE);
        //外部存储空间获取方法
        Environment.getExternalStorageDirectory().getPath();

        FileOutputStream fo = new FileOutputStream(file);
        Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

        fo.write(resault.getBytes());
        fo.close();
        return true;

    }

    @Nullable
    public static Map<String,String> readInfo(){
        Map<String,String> maps = new HashMap<String, String>();
        File file = new File("/data/data/com.learn.a02logining/my.txt");

        try {
            FileInputStream fileInputStream = fileInputStream = new FileInputStream(file);
            BufferedReader br = new  BufferedReader(new InputStreamReader(fileInputStream));
            String content = br.readLine();
            String[] split = content.split("##");
            String name = split[0];
            String pwd = split[1];


            maps.put("name",name);
            maps.put("pwd",pwd);

            br.close();
            fileInputStream.close();
            return maps;


        } catch (Exception e) {
            return null;
        }


    }

}
