# itProjectHomework
## vue是前端文件夹，启动方式npm install, npm run serve启动
## back是后端文件夹
### 本地启动8081
clone后，cd到back文件夹，键入mvn install,后可在idea里面启动
### 后端部署上云步骤8081
1. 将项目打成jar包
2. 将项目jar包上传服务器，打开cmd输入：scp E:\java文件\0908createProject\itProjectHomework\back\target\demo-0.0.1-SNAPSHOT.jar root@106.52.23.196:/usr/java
3. 在服务器该jar包路径下启动: nohup ./start.sh &
4. 如果需要关闭该服务，“#netstat -tunlp | grep  8081”或“#ps -ef | grep java”   查出java进程编号
5. "#kill -9 xxxx" xxxx是java的进程编号
#### ftp控制相关
1. 查看FTP服务是否运行中：service vsftpd status
2. 启动FTP服务：service vsftpd start
3. 停止FTP服务：service vsftpd stop
4. 重启FTP服务：service vsftpd restart
