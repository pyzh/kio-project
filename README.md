# kio-project

自用的kotlin工具库

基础工具使用hutool  
http/socket服务器修改自nanohttpd  
mc wsserver事件来自PEWS-API  

欢迎指正错误 我什么都<del>不</del>会做的

~~~gradle
rootProject build.gradle :

allprojects {
    repositories {
        ...
        maven {
            url 'https://maven.kurumi.io'
        }
    }
}
~~~
~~~gradle

def kio_version = "1.0.0"

dependencies {
    compile "io.kurumi.kio-core:${kio_version}"
    // compile "io.kurumi.kio-desktop:${kio_version}"
    // api "io.kurumi.kio-android:${kio_version}"
}
~~~

### Js项目支持
如果使用Kio的内置浏览器无须任何操作,而一般浏览器需要引用Kio支持库
(Kio浏览器会增加 Kio-Interface 的 Http头以判断版本