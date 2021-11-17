package com.heqing.mongodb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件实体类
 * @author heqing
 * @date 2021/10/28
 */
@NoArgsConstructor
@Data
public class MongoFile implements Serializable {

    private String fileId;
    private String fileName;
    private long fileSize;
    private Date uploadTime;

}
