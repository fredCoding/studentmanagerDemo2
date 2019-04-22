# studentmanagerDemo2
According to a requirement that we need a same sysytem for different system

使用maven、spring boot2.1.4、jdk1.8,lombok插件 启动Demo,
根据需求，做了思路图，见同目录结构分析图。

对数据库的数据做初始化，见同目录 初始化Mongo语句.txt 文件

需求如下:
在用mongodb实现一个成绩管理系统，实现对学生成绩的增删改查功能的系统的基础上实现如下需求：


假定现在需要实现一学生管理系统，需要实现如下功能。
1. 对学生信息进行管理。包括如姓名、学号、宿舍号、手机号等信息进行增删改查。
2. 对学生的课程信息进行管理。比如课程名称、上课时间、课程地点等信息进行增删改查。
3. 对学生成绩信息进行管理。比如课程成绩，单科名次等信息进行增删改查。

但是现在该系统使用的学校有很多，他们各自需要管理的信息构成不一样，比如学生信息
对于中学B只管理姓名、学号、家庭地址、监护人姓名、监护人联系方式、当前学生的一门课成绩等。
对于大学A则需要管理姓名、学号、家庭地址、邮箱、电话、宿舍号、当前学生的一门课成绩等。

但是总体上他们都是需要对学生信息、课程、成绩信息进行管理。

请实现用mongodb+java实现该需求。





