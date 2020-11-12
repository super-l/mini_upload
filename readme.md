## 忘忧草文件上传系统

### 系统说明

一款精简的文件上传服务器系统，使用springboot+mybitis进行开发。

数据库采用了mysql，具有简单的会员账户、会员用户组机制，提供API接口；

系统采用JWT认证机制。上传文件前，需要先使用授权API接口，获取access_token授权码。

本地上传接口，会根据会员的用户名，为每个会员都生成一个单独的根目录；


### 环境说明

1. JDK1.8

2. Mysql

3. nginx


### 配置说明
配置文件：application.properties

配置信息例子：
```

# 服务器端口，如果不配置默认是8080端口
server.port=52700

# 数据库设置
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://192.168.0.100:3306/uploads?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8
spring.datasource.username=root
spring.datasource.password=root

# 上传文件总的最大值
spring.servlet.multipart.max-request-size=100MB

# 单个文件的最大值
spring.servlet.multipart.max-file-size=10MB

# 本地文件保存路径前缀(绝对路径)
local.savepath.prefix=/Users/superl/data/uploads

# 本地文件访问URL前缀
local.url.prefix=http://file.nepenthes.cn
```

启动nginx服务，创建一个新的静态虚拟站点！

站点的根目录为配置文件中的"local.savepath.prefix"的值；

站点绑定的域名为配置文件中的"local.url.prefix"的值；


### 使用说明

授权码获取接口：
```
请求地址：http://127.0.0.1:52700/user/auth
请求类型：POST
请求格式：application/x-www-form-urlencoded 或者 application/form-data
请求参数：
    api_key： 
        类型：字符串
        描述：接口key(测试值：up1d2a4c0a41bf0981)

    api_secret：
        类型：字符串
        描述：接口secret(测试值：2bd51edc96e2d800bf0eaf5dc7d775ab)


返回参数例子：

{
    "msg": "success",
    "code": 200,
    "data": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1N2VlZmJlNjM5Yjc0YjA1YjQ3NmJmZDQ2MTc1Y2U2MyIsImV4cCI6MTYwNTA4Njk3MH0.7IOYg9mpiGzkKtzHo48JWxXcjmvSOEOedNIxs-KWVnQ"
}

返回说明：

如果code等于200，则表示成功。会有data内容,data中的内容就是授权码。
如果code不等于200，则会在msg中输出错误提示信息。

```


单个图片文件上传接口(本地)：
```
请求地址：http://127.0.0.1:52700/local/image/upload
请求类型：POST
请求格式：form-data
请求头：
    Authorization：授权码

请求参数：
    is_original： 
        类型：布尔型 
        描述：是否重命名文件，如果为false,则保持文件名不变；

    path：
        类型：字符串型  
        描述：保存的目录名称。如果为空，则为用户的根目录保存

    file：文件

返回参数例子：

{
    "msg": "success",
    "code": 200,
    "data": {
        "imageName": "1304e0b0da3f428a93c9be9e4bef6dd0.png",
        "imagePath": "1",
        "imageSize": 194551,
        "imageUrl": "http://file.nepenthes.cn/superl/1/1304e0b0da3f428a93c9be9e4bef6dd0.png",
        "imageThumUrl": ""
    }
}

返回说明：

如果code等于200，则表示成功。会有data内容；
如果code不等于200，则会在msg中输出错误提示信息。

```


文件夹上传接口(本地)：

>原理:上传ZIP压缩文件，并自动解压生成文件夹! 支持设置压缩密码
>备注：仅支持管理员账户调用(用户的group_id为1)!

```
请求地址：http://127.0.0.1:52700/local/folder/upload
请求类型：POST
请求格式：form-data
请求头：
    Authorization：授权码

请求参数：
    is_original： 
        类型：布尔型 
        描述：是否重命名文件，如果为false,则保持文件名不变；

    path：
        类型：字符串型  
        描述：保存的目录名称。如果为空，则为用户的根目录保存

    file：文件

    password：
        类型：字符串型  
        描述：解压密码

返回参数例子：
{
    "msg": "success",
    "code": 200,
    "data": {
        "folderName": "b43c2d14488541a4a50dfa894cb9df91",
        "folderPath": "1",
        "foldereSize": 387776,
        "folderUrl": "http://file.nepenthes.cn/superl/1/b43c2d14488541a4a50dfa894cb9df91"
    }
}

返回说明：

如果code等于200，则表示成功。会有data内容；
如果code不等于200，则会在msg中输出错误提示信息。

```

### 安全说明

特别注意: 上传目录必须要禁止执行权限！


### 使用帮助

#### 本地curl客户端
```
curl --location --request POST 'http://127.0.0.1:52700/local/upload_image' \
--form 'is_original=false' \
--form 'path=' \
--form 'file=@/Users/superl/Desktop/图片素材/alogo1882/1.png'
```

#### JAVA OKHTTP
```
OkHttpClient client = new OkHttpClient().newBuilder()
  .build();
MediaType mediaType = MediaType.parse("text/plain");
RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
  .addFormDataPart("is_original", "false")
  .addFormDataPart("path", "")
  .addFormDataPart("file","1.png",
    RequestBody.create(MediaType.parse("application/octet-stream"),
    new File("/Users/superl/Desktop/图片素材/alogo1882/1.png")))
  .build();
Request request = new Request.Builder()
  .url("http://127.0.0.1:52700/local/upload_image")
  .method("POST", body)
  .build();
Response response = client.newCall(request).execute();
```

#### JavaScript - XHR

```
var data = new FormData();
data.append("is_original", "false");
data.append("path", "");
data.append("file", fileInput.files[0], "1.png");
 
var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function() {
  if(this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("POST", "http://127.0.0.1:52700/local/upload_image");

xhr.send(data);
```

####  JavaScript - jQuery
```
var form = new FormData();
form.append("is_original", "false");
form.append("path", "");
form.append("file", fileInput.files[0], "1.png");

var settings = {
  "url": "http://127.0.0.1:52700/local/upload_image",
  "method": "POST",
  "timeout": 0,
  "processData": false,
  "mimeType": "multipart/form-data",
  "contentType": false,
  "data": form
};

$.ajax(settings).done(function (response) {
  console.log(response);
});
```


#### Nodejs Axios
```
var axios = require('axios');
var FormData = require('form-data');
var fs = require('fs');
var data = new FormData();
data.append('is_original', 'false');
data.append('path', '');
data.append('file', fs.createReadStream('/Users/superl/Desktop/图片素材/alogo1882/1.png'));

var config = {
  method: 'post',
  url: 'http://127.0.0.1:52700/local/upload_image',
  headers: { 
    ...data.getHeaders()
  },
  data : data
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
})
.catch(function (error) {
  console.log(error);
});

```


#### PHP CURL调用测试
```
<?php

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "http://127.0.0.1:52700/local/upload_image",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 0,
  CURLOPT_FOLLOWLOCATION => true,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => array('is_original' => 'false','path' => '','file'=> new CURLFILE('/Users/superl/Desktop/图片素材/alogo1882/1.png')),
));

$response = curl_exec($curl);

curl_close($curl);
echo $response;

```

#### GO 语言调用

```
package main

import (
  "fmt"
  "bytes"
  "mime/multipart"
  "os"
  "path/filepath"
  "io"
  "net/http"
  "io/ioutil"
)

func main() {

  url := "http://127.0.0.1:52700/local/upload_image"
  method := "POST"

  payload := &bytes.Buffer{}
  writer := multipart.NewWriter(payload)
  _ = writer.WriteField("is_original", "false")
  _ = writer.WriteField("path", "")
  file, errFile3 := os.Open("/Users/superl/Desktop/图片素材/alogo1882/1.png")
  defer file.Close()
  part3,
         errFile3 := writer.CreateFormFile("file",filepath.Base("/Users/superl/Desktop/图片素材/alogo1882/1.png"))
  _, errFile3 = io.Copy(part3, file)
  if errFile3 != nil {
    fmt.Println(errFile3)
    return
  }
  err := writer.Close()
  if err != nil {
    fmt.Println(err)
    return
  }


  client := &http.Client {
  }
  req, err := http.NewRequest(method, url, payload)

  if err != nil {
    fmt.Println(err)
    return
  }
  req.Header.Set("Content-Type", writer.FormDataContentType())
  res, err := client.Do(req)
  if err != nil {
    fmt.Println(err)
    return
  }
  defer res.Body.Close()

  body, err := ioutil.ReadAll(res.Body)
  if err != nil {
    fmt.Println(err)
    return
  }
  fmt.Println(string(body))
}
```
