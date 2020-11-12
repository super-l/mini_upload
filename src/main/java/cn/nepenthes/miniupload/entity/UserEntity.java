package cn.nepenthes.miniupload.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Superl
 * @email superl@nepenthes.cn
 * @date 2020-11-12 12:57:21
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String uuid;
	/**
	 * 用户状态
	 */
	private Integer status;
	/**
	 * 用户组
	 */
	private Integer groupId;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String salt;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String apiKey;
	/**
	 * 
	 */
	private String apiSecret;
	/**
	 * 创建时间
	 */
	private Date createdAt;

}
