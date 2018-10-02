# kio-project

多平台Kotlin界面/工具库

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

项目格式 : 按照Kotlin多平台项目的 core/android/jvm/js格式  
开发中 目前仅android部分可用  jvm , js 将会支持  
