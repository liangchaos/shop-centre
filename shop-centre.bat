@echo off

:begin

:rem �˵�����
echo ------------------------shop-centre ��������������------------------------
echo -- ����״̬:
echo -- (1 )  ���� [shop-eureka-server]           ��������
echo -- (2 )  ���� [shop-admin-console]           ���ƽ̨
echo -- (3 )  ���� [shop-config-centre-default]   Config Default ƽ̨
echo -- (4 )  ���� [shop-config-centre-service]   Config Service ƽ̨
echo -- (5 )  ���� [shop-web-wap]                 Wap ǰ��ƽ̨
echo -- (6 )  ���� [shop]           ���ƽ̨
echo -- (7 )  ���� [shop]           ���ƽ̨
echo -- (8 )  ���� [shop]           ���ƽ̨
echo -- (9 )  ���� [shop]           ���ƽ̨
echo -- (Q )  �˳�����̨
echo -------------------------------------------------------------------------

:rem java ·�� ֱ��ʹ��������Ч
:rem -Dfile.encoding=utf-8
set java="%JAVA_HOME%\bin\java.exe" -Xms50m -Xmx150m -jar
:rem ��Ŀ��Ŀ¼
set path="C:\\Users\\Administrator\\SpringCloudWork\\shop-centre\\"
:rem �˵�ѡ��
set/p inType=���������:

if %inType% == 1 (
    start http://shop-centre.com:11000/
    set project_name=shop-eureka-server
    cd %path%%project_name%\\target\\
   	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 2 (
    start http://shop-centre.com:11020/
    set project_name=shop-admin-console
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 3 (
    start http://shop-centre.com:11030/
    set project_name=shop-config-centre-default
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 4 (
    start http://shop-centre.com:11031/
    set project_name=shop-config-centre-service
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 5 (
    start http://shop-centre.com:12000/
    set project_name=shop-web-wap
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 6 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 7 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 8 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
) else if %inType% == 9 (
 set project_name=shop-eureka-server
	cd %path%%project_name%\\target\\
	%java% %project_name%-0.0.1-SNAPSHOT.jar
	echo ����%project_name%�������
)
















:rem �˳�
if %inType%==q (
	 exit
)

goto begin
pause