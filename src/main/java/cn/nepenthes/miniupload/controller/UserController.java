package cn.nepenthes.miniupload.controller;


import cn.nepenthes.miniupload.annotation.PassToken;
import cn.nepenthes.miniupload.entity.UserEntity;
import cn.nepenthes.miniupload.service.UserService;
import cn.nepenthes.miniupload.utils.JwtUtil;
import cn.nepenthes.miniupload.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author  superl
 * @email   superl@nepenthes.cn
 * @blog    http://www.superl.org
 */

@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PassToken
    @RequestMapping(value="auth", method = RequestMethod.POST)
    public R uploadImage(@RequestParam("api_key") String apiKey, @RequestParam("api_secret") String apiSecret){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("api_key",apiKey);
        queryWrapper.eq("api_secret",apiSecret);

        UserEntity userEntity = userService.getOne(queryWrapper);
        if (userEntity.getId() == 0){
            return R.error(1000,"api_key或api_secret信息错误!");
        }
        String token = JwtUtil.sign(userEntity.getId(),userEntity.getUsername());
        return R.ok().put("data",token);
    }

}
