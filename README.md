# spring cloud oauth demo

- 生成 jks 文件

```
 keytool -genkeypair -alias walker-jwt -validity 3650 -keyalg RSA -dname "CN=jwt,OU=jtw,O=jtw,L=zurich,S=zurich,C=CH" -keypass walker -keystore walker-jwt.jks -storepaass walker
```