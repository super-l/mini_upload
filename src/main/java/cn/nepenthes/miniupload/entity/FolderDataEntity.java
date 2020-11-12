package cn.nepenthes.miniupload.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文件夹数据
 * 
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
@Data
@TableName("folder_data")
public class FolderDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private String folderPath;
	/**
	 * 
	 */
	private String folderName;
	/**
	 * 
	 */
	private long folderSize;
	/**
	 * 
	 */
	private String folderUrl;
	/**
	 * 创建时间
	 */
	private Date createdAt;
}
