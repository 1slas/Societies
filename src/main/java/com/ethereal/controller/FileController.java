package com.ethereal.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.server.HttpServerResponse;
import com.ethereal.common.Result;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.controller
 * @Author: Echo
 * @CreateTime: 2024-03-29  08:38
 * @Description: 文件上传
 * @Version: 1.0
 */
@RestController
@RequestMapping("/files")
public class FileController {

    /**
     * @description 文件上传路径
     * @date 2024/3/29 14:05
     */
    private static final String FILE_PATH = System.getProperty("user+dir")+"/files/";

    @Value("{server.port:9090}")
    private String port;

    @Value("{ip:localhost}")
    private String ip;

    /**
     * @param file:
      * @return Result
     * @author 53609
     * @description 文件上传
     * @date 2024/3/29 14:15
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        String flag;
        synchronized (FileController.class) {
            flag = System.currentTimeMillis() + "";
            ThreadUtil.sleep(1L);
        }
        String fileName = file.getOriginalFilename();
        try {
            if (!FileUtil.isDirectory(FILE_PATH)) {
                FileUtil.mkdir(FILE_PATH);
            }
            // 文件存储形式：时间戳-文件名
            FileUtil.writeBytes(file.getBytes(), FILE_PATH + flag + "-" + fileName);
            // ***/manager/files/1697438073596-avatar.png
            System.out.println(fileName + "--上传成功");

        } catch (Exception e) {
            System.err.println(fileName + "--文件上传失败");
        }
        String http = "https://" + ip + ":" + port + "/files/";
        return Result.success(http + flag + "-" + fileName);
        //  http://localhost:9090/files/1697438073596-avatar.png
    }
    /**
     * @param flag:
    	 * @param response:
      * @return void
     * @author 53609
     * @description 获取文件
     * @date 2024/3/29 15:41
     */
    @GetMapping("/{flag}")
    public void avatarPath(@PathVariable String flag , HttpServerResponse response){
        OutputStream os ;
        if (StrUtil.isNotEmpty(flag)){
            response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(flag, StandardCharsets.UTF_8));
            response.setContentType("application/octet-stream");
            byte[] bytes = FileUtil.readBytes(FILE_PATH + flag);
            os = response.getOut();
            try {
                os.write(bytes);
                os.flush();
                os.close();
            } catch (IOException e) {
                System.out.println("文件下载失败");
            }
        }
    }
    /**
     * @param flag:
      * @return void
     * @author 53609
     * @description 删除文件
     * @date 2024/3/29 15:45
     */
    @DeleteMapping("/{flag}")
    public void delFile(@PathVariable String flag){
        FileUtil.del(FILE_PATH + flag);
        System.out.println("删除文件"+ flag + "成功");
    }

    @PostMapping("/wang/upload")
    public Map<String, Object> wangEditorUpload(MultipartFile file){
        String flag = System.currentTimeMillis()+"";
        String fileName = file.getOriginalFilename();
        try {
            //文件储存形式： 时间戳-文件名
            FileUtil.writeBytes(file.getBytes(), FILE_PATH +flag + "-" +fileName);
            System.out.println(fileName + "--上传成功");
            Thread.sleep(1L);
        }catch (Exception e){
            System.out.println(fileName + "--文件上传失败");
        }
        String http = "https://" + ip + ":" +"/files/";
        Map<String,Object> resMap = new HashMap<>();
        //wangEditor 上传图片成功后 需要返回的参数
        resMap.put("error",0);
        resMap.put("data", CollUtil.newArrayList(Dict.create().set("url",http + "-" + fileName)));
        return resMap;
    }
}
