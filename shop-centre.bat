@echo off

:begin

:rem 菜单定义
echo ------------------------shop-centre 服务启动控制器------------------------
echo -- 服务状态:
echo -- (1 )  启动 [shop-eureka-server]           服务治理
echo -- (2 )  启动 [shop-admin-console]           监控平台
echo -- (3 )  启动 [shop-config-centre-default]   Config Default 平台
echo -- (4 )  启动 [shop-config-centre-service]   Config Service 平台
echo -- (5 )  启动 [shop-web-wap]                 Wap 前端平台
echo -- (6 )  启动 [shop]           监控平台
echo -- (7 )  启动 [shop]           监控平台
echo -- (8 )  启动 [shop]           监控平台
echo -- (9 )  启动 [shop]           监控平台
echo -- (Q )  退出控制台
echo -------------------------------------------------------------------------

:rem java 路径 直接使用命令无效
:rem -Dfile.encoding=utf-8
set java="%JAVA_HOME%\bin\java.exe" -Xms50m -Xmx150m -jar
:rem 项目根目录
set path="C:\\Users\\Administrator\\SpringCloudWork\\shop-centre\\"
:rem 菜单选择
set/p inType=请输入参数:

if %inType% == 1 (
    start http://shop-centre.com:11000/
    set project_name=shop-eureka-server
    cd %path%%project_name%\\target\\
   	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 2 (
    start http://shop-centre.com:11020/
    set project_name=shop-admin-console
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 3 (
    start http://shop-centre.com:11030/
    set project_name=shop-config-centre-default
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 4 (
    start http://shop-centre.com:11031/
    set project_name=shop-config-centre-service
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 5 (
    start http://shop-centre.com:12000/
    set project_name=shop-web-wap
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 6 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 7 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 8 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
) else if %inType% == 9 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo 启动%project_name%服务完成
)
















:rem 退出
if %inType%==q (
	 exit
)

goto begin
pause