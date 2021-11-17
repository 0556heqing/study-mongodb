package com.heqing.mongodb;

import com.alibaba.fastjson.JSONObject;
import com.heqing.mongodb.config.SpringMongoDBConfig;
import com.heqing.mongodb.model.MongoFile;
import com.heqing.mongodb.repository.FileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = SpringMongoDBConfig.class
)
public class FileTest {

    @Autowired
    FileRepository fileRepository;

    @Test
    public void writeFile() throws FileNotFoundException {
        String orderid = fileRepository.uploadFile("D:\\test\\welcome.png","test2.png");
        System.out.println("-->"+ orderid);
    }

    @Test
    public void downLoadByFileId() {
         fileRepository.downLoadByFileId("619472613eb96846c41a4df9","D:\\test\\11.jpg");
    }

    @Test
    public void searchFileById() {
        MongoFile result = fileRepository.searchFileById("619472613eb96846c41a4df9");
        System.out.println("-->"+ JSONObject.toJSONString(result));
    }

    @Test
    public void searchFile() {
        Query query = new Query(Criteria.where("filename").is("test1.png"));
        List<MongoFile> result = fileRepository.searchFile(query);
        System.out.println("-->"+ JSONObject.toJSONString(result));
    }

    @Test
    public void deleteFileById() {
        fileRepository.deletFileById("619472213eb96845002c3362");
    }

    @Test
    public void deleteFile() {
        Query query = new Query(Criteria.where("filename").is("test2.png"));
        fileRepository.deleteFile(query);
    }

}
