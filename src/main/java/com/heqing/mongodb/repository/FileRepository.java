package com.heqing.mongodb.repository;

import com.heqing.mongodb.model.MongoFile;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * 文件处理接口
 * @author heqing
 * @date 2021/10/28
 */
public interface FileRepository {

    /**
     * 上传文件到mongodb
     *
     * @param localFilePath 本地文件的绝对路径
     * @param originFileName 远程文件名
     * @return String 远程objectId
     */
    String uploadFile(String localFilePath, String originFileName);

    /**
     * 上传文件到mongodb
     *
     * @param id 远程objectId
     * @param localFilePath 本地文件的绝对路径
     */
    void downLoadByFileId(String id, String localFilePath);

    /**
     * 根据id查找文件
     * @param id
     * @return 文件信息
     */
    MongoFile searchFileById(String id);

    /**
     * 查找文件
     * @param query 查询条件
     * @return 文件信息
     */
    List<MongoFile> searchFile(Query query);

    /**
     * 根据id查找文件
     * @param id
     * @return 文件信息
     */
    void deletFileById(String id);

    /**
     * 查找文件
     * @param query 查询条件
     * @return 文件信息
     */
    void deleteFile(Query query);
}
