# senrui-api-boot-starter
旨在提供统一访问的api，和一些公共的请求或响应类

## 使用方式
在maven中导入如下依赖（别忘记在setting.xml添加相关的token）

    <repositories>
        <repository>
            <id>senrui-api-boot-starter</id>
            <url>https://github.com/201892036ljl/senrui-api-boot-starter/release-1.0.1/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.senrui</groupId>
            <artifactId>senrui-api-boot-starter</artifactId>
            <version>1.0.1</version>
        </dependency>
    </dependencies>

