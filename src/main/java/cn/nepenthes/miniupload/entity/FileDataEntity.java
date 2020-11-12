package cn.nepenthes.miniupload.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文件数据
 * 
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
@Data
@TableName("file_data")
public class FileDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 方式【1=本地】
	 */
	private Integer method;
	/**
	 * 保存路径
	 */
	private String filePath;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 访问地址
	 */
	private String fileUrl;
	/**
	 * 文件大小
	 */
	private long fileSize;
	/**
	 * 创建时间
	 */
	private Date createdAt;

}
