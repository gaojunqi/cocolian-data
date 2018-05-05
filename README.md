# cocolian-data 基础数据（码表）服务

## 接口说明

提供最新的常用数据， 可以通过http://{域名}/cardbin 来读取。 默认可以通过http://api.cocolian.org/data/cardbin.csv 来获取。 
接口使用示例如下

```bash
GET /cardbin  HTTP/1.1
Host: api.cocolian.org
Content-Type: text/xml; charset=utf-8
Authorization: Bearer <Access-Token>
```

返回值示例：

```json
Date: {卡bin最后更新时间}
Status: 200
Content-Type: text/csv; charset=utf-8
Content-Encoding: gzip


"发卡行名称及机构代码", "卡名", "ATM适用","POS适用", "磁道","磁道起始字节","磁道长度","主账号起始字节","主账号长度"，"主账号"，"主账号读取磁道",
"发卡行标识起始字节","发卡行标识长度"，"发卡行标识"，"发卡行标识读取磁道"，	"卡种", "入库时间"
00010030   ,中国银联支付标记              ,中国银联移动支付标记,2  ,2 ,16,625153      ,2  ,2 ,06,2  ,2 ,37    ,1,2, ,11000000, 20160209                      
00010030   ,中国银联支付标记              ,中国银联移动支付标记,2  ,2 ,19,623529      ,2  ,2 ,06,2  ,2 ,37    ,1,1, ,11000000, 20160209                      
01000000   ,邮储银行                      ,绿卡(银联卡)        ,2  ,2 ,19,955100      ,2  ,2 ,06,2 3,22,37 104,1,1, ,11000000, 20170312                      
01000000   ,邮储银行                      ,绿卡(银联卡)        ,2  ,2 ,19,95510031    ,2  ,2 ,08,2 3,22,37 104,1,1, ,11000000, 20170312                      

```

## 接口使用

卡bin是支付系统的基本数据，在多个场景中都会使用。 比如绑卡时，根据用户输入的卡号来自动识别发卡行，就需要卡bin数据。 
使用时，调用方需要先加载所有的卡bin数据到缓存中，然后再做处理。 所以卡bin服务也只需要提供一个全量接口即可。 


## 开发指南

### 模块设计

包含如下模块：
1. cocolian-cardbin-server : 基于spring boot实现的web server，提供上述接口。 数据保存在MySQL中， 访问时从缓存或者数据库中加载卡bin数据
2. cocolian-cardbin-importer: 支持导入各机构发布的卡bin文件，目前是银联发布的excel格式的文件。 
3. cocolian-carbin-docker-server: 用于构建cardbin server的镜像
4. cocolian-carbin-docker-mysql: 用来支持本项目的mysql语句和mysql镜像的builder

### 技术栈

本项目中使用到的技术栈包括但不限于：
- Spring Boot: 对外提供HTTP服务；
- Google Protobuf：卡bin数据建模

### 银联卡bin数据
参考示例： http://doc.cocolian.org/essay/2017/10/09/bin/ 