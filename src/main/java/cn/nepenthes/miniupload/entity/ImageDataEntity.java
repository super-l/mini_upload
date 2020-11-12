package cn.nepenthes.miniupload.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 图片数据
 * 
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
@Data
@TableName("image_data")
public class ImageDataEntity implements Serializable {
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
	private String imagePath;
	/**
	 * 图片文件名
	 */
	private String imageName;
	/**
	 * 图片大小
	 */
	private long imageSize;
	/**
	 * 原图片访问地址
	 */
	private String imageUrl;
	/**
	 * 缩略图URL
	 */
	private String imageThumUrl;
	/**
	 * 创建时间
	 */
	private Date createdAt;

}
