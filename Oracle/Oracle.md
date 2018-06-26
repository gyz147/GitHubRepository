## Oracle个人使用手册 ##

该手册针对已有一点数据库基础的童鞋。

### 一、前期工作 ###

#### 1.安装和配置 ####

网上教程一抓一大把，细心一点，一般不会出错，不再赘述。

#### 2.创建数据库 ####

Oracle建库非常复杂，需要设置很多的参数，意味着create命令语句会很长，所以推荐使用可视化工具（Oracle自带）建库。

##### Oracle安装成功呢后，开始菜单中会有一些工具 #####

 - **Oracle卸载工具**：该工具不能将oracle卸载完全，需要自行删除好多注册表的信息，如需卸载推荐网上查看攻略。
 
 - **配置管理工具**（database configuration assistant):
     - **DBCA**:数据库配置管理助手，是一个创建和删除数据库的可视化界面
     - **net configuration assistant**:网络配置助手，配置客户端的连接。
     
##### 使用DBCA创建数据库： #####

- 先检查现已存在的数据库：计算机-----》管理----》服务和应用程序----》输入o

 - **OracleOraDb10g_home1**	数据库监听程序
 - **OracleServiceORCL** 数据库名：ORCL
<br><br>
- 现在创建一个数据库。。。。。。步骤省略。注意：数据库名称唯一，数据库将来被Oracle实例引用，SID要唯一，默认和数据库名称一致(在客户端连接服务器时有用)。


- 数据库创建好后，其中有三类文件：
 - 控制文件(* .ctl)，存储数据库的配置信息
 - 数据库文件(*.dbf)，存储数据库的用户数据(表、视图、索引。。。)
 - 重做日志文件(*.log)，记录用户的操作轨迹。
 
### 二、Sql语句类型 ###

#### 1.DDL 数据定义语言 ####

数据库中的对象，创建数据库中的对象，删除对象，修改对象<br>
`create database`、`drop database`、`create table`、`drop table`、`alter table`、`create view`、`drop view`.......

#### 2.DML 数据库操作语言 ####

CRUD,操作对象中的数据<br>
`Insert`、`update`、`delete`、`truncate`、`select`

#### 3.DCL 数据库控制语言 ####

`commit`、`rollback`　　　　`grant`、`revoke`--------用户权限关联

### 三、数据类型 ###

#### 1.number：数字类型 ####

number(10)：10位的整数　　　number(10,2)：8位的整数和两位的小数

#### 2.decimal：其底层类型也是number ####

用于表示钱的类型，不容易丢失精度　　decimal(10,2)：8位的整数和两位的小数

#### 3.char：定长的字符串 ####

#### 4.varchar2：可变长的字符串 ####

- char(10)和varchar(10)的异同：

 - 共同点:都是表示字符串

 - 不同点：char(10),定长10位，如果不足10位，用空格代替(占空间)；varchar(10),不定长，如果不足10位，则不占用空间

- 从空间上来说：varchar更省空间

- 从时间上来说：char 插入的效率更高；varchar在插入的时候需要计算真实字符有几个，然后再动态的分配空间(时间上的消耗)

- 使用场景：如果定长使用char，否则一律是varchar

#### 5.date：日期类型 ####

#### 注：mysql中有int  double  float  varchar  char…。oracle中都有，但是不是必须要使用，全凭经验 ####

### 四、Oracle系统架构 ###


### 五、Oracle用户、权限、角色 ###

#### 1.创建表空间 ####

使用system用户：create tablespace gyz datafile "d:/tablespace/gyz.dbf" size 2M

#### 2.创建用户 ####

使用system用户：create user gyz identified by gyz(密码) default tablespace gyz（表空间）

#### 3.赋予权限 ####

- 新创建的用户连登陆权限都没有，使用system用户赋予登陆权限：grant create session to gyz
- 登陆权限赋完后，还有创建表权限、修改表权限、删除表权限、insert权限...太多，下面解决。

#### 4.收回权限 ####

- 一个权限一个权限赋予太繁琐，现在使用system用户收回权限，引入下面角色的概念：
	- revork create session from gyz

#### 5.赋予角色 ####

- 观察scott用户中“Role grants”下有两个角色connect和resource
- 什么是角色：角色是对oracle中权限的一个打包，使用角色的好处，方便权限管理
- 用system用户赋予gyz用户两个角色：grant connect,resource to gyz

### 六、Sql语句（CRUD） ###

基本通用的sql语句不赘述，下面只罗列特殊的。

#### 1.select语句 ####

- **dual表**：是一个单位表，是一个虚表，当查询的字段不属于任何表时使用<br>

	`select 1+2 from dual`-----3	　　`select sysdate from dual`-----当前系统时间

- **nvl(列1,列2)**：如果列1为null取列2值，否则取列1值<br>

	`select nvl(null,1) from dual`-----1	　　`select nvl('aaaa',2) from dual`----aaaa

- **nvl2(列1,列2,列3)**：如果列1为null ，取列3值，否则取列2值<br>

	`select nvl2(null,1,2) from dual`----2　　`select nvl2('aa',1,2) from dual`----1

- **查询当前系统时间，按照指定格式输出**<br>

	`select to_char(sysdate,'yyyy-MM-dd  hh24:mi:ss') from dual`---格式表示有点特殊

- **将字符串变成日期**<br>

	`select to_date('2016-11-11','yyyy-MM-dd') from dual`

- **将钱按照千位分隔**<br>

	to_char(数字,转换的规则)<br>
	规则使用通配符：**9**：代表任意一位数字<br>
　　　　　　　	　**,** **:**　千分隔符<br>
　　　　　　　　**L**：本地货币符号<br>

    `select ename,to_char(12*sal + nvl(comm,0),'L999,999') as perfect_money from emp`<br>
	`select ename, to_char(12*sal + nvl(comm,0),'$999,999') as perfect_money from emp`

- **时间区间的查询**<br>

	**查询在1987-01-01后入职的员工信息** <br>
	mysql 中可以，oracle不行，报**`文字和字符串格式不匹配`**错误
  	`select * from emp  where hiredate >= '1987-01-01'`<br>
	其实就是类型不一致  日期不能和字符串直接相比较<br>

	**除了一个特例**<br>
	`select * from emp  where hiredate >= '01-1月-1987'`
  
	**要么全部使用日期  要么全部使用字符串**
    `select * from emp  where hiredate >= to_date('1987-01-01','yyyy-MM-dd')`<br>
    `select * from emp  where to_char(hiredate,'yyyy-MM-dd') >= '1987-01-01'`

- **字符串拼接问题**<br>
	
	**查询员工信息   员工号_员工名**<br>
  	`select empno,ename,empno || '_' || ename from emp`
  
	**查询员工信息   员工号''员工名**<br>
	使用两个单引号代替一个单引号  '' ---在后面的存储过程中使用
	`select empno,ename,empno || '''' || ename from emp`

- **模糊查询**<br>

 - **查询ename中含有%**<br>
	`select * from emp where ename like '%&%%'  escape '&'`<br>

		**使用转义字符**<br>
		java中`\t`　`\n`<br> 
		oracle中`a%`　`x%`不好使,而是用`&%`，告诉Oracle &是一个转义字符   escape '&'

 - **查询员工名称的第二个字母含有’a’或’A’**<br>
	`select * from emp where ename like '_a%' or ename like '_A%'`<br>
	`select * from emp where lower(ename) like '_a%'`<br>
	`select * from emp where upper(ename) like '_A%'`<br>

 - **查询员工名，从第二个字符开始截取，截取3位**<br>
 	`select ename,substr(ename,2,3) from emp`<br>

- **查询平均数、最大值，以及分组(group by)和分组后色筛选(having)**<br>

 - **查询平均工资，采用四舍五入 ，保留4位有效数字**<br>
 	`select avg(sal),round(avg(sal),4) from emp`<br>

 - **计算每个部门的平均薪水**<br>
 	`select round(avg(sal),0) as avg_sal,deptno from emp group by deptno`<br>

 - **求出每个部门中工资最高的员工信息**<br>
 	`select e.empno,e.name,e.sal,e.deptno from emp e` <br>
	　`inner join` <br>
 	　　`(select max(sal) as max_sal,deptno from emp group by deptno)t` <br>
	　　　`on e.sal = t.max_sal and e.deptno = t.deptno` <br>

 - **求出平均工资大于2000的部门信息**<br>
 	`select d.deptno,d.deptname,t.avg_sal from dept d`<br>
	　`inner join`<br>
	　　`(select round(avg(sal),0) as avg_sal,deptno from emp group by deptno`<br>
	　　　`having round(avg(sal),0)>2000 )t`<br>
	　　　　`on d.deptno = t.deptno`<br>

- **左连接**<br>

 - **求出员工及其经理**<br>
 	`select e1.empno,e1.empname,e2.empname as mar_name from emp e1`<br>
	　`left join emp e2`<br>
	　　`on e1.mgr = e2.empno`<br><br>

- **查询结果去重(distinct)**<br>

 - **求哪些人是经理**<br>
	`select distinct mgr from emp where mgr is not null`<br><br>

- **连接查询的区别**

 - **inner join:**多表连接是，同事满足条件的才显示
 - **left join:**A left join B，以A表为主，inner join的结果`+`A表剩余的数据，但B表的相关内容以空值代替。理解为“有效连接”，两张表中都有的数据才会显示，left join理解为“有左显示”，比如on a.field=b.field，则显示a表中存在的全部数据及a\\b中都有的数据，A中有、B没有的数据以null显示
 - **right join:**和 left join的用法正好相反
 - **full join：**理解为“全连接”，两张表中所有数据都显示，实际就是inner +(left-inner)+(right-inner)
<br><br>

- **分页查询**

 - Oralce中的分页不能使用limit，通常使用伪列。啥叫伪列，不存在的列。
 - select rownum from emp,发现Oracle的伪列是一个从1开始的自增长的列
 - `select * from emp where rownum <=3`<br>
	`select * from emp where rownum >3`<br>
	`select * from emp where rownum =3`<br>
	通过上述发现Oracle中的伪列相当诡异，只能使用<=或者<,其它都不行
 - 不能直接使用rownum，要间接的使用rownum，使用子查询：
		- 1. 第一次查询，带出伪列：select *，rownum as rn from emp
		- 2. 第二次子查询，使用rn：<br>
		select t.empno,t.name,t.job from <br>
		(select *,rownum as rn from emp)t <br>
		where t.rn>3 and t.rn<6;
 - Oracle中规范的分页，通常有三次查询：排序，带出伪列，使用伪列分页。
		- 1.select empno,empname,hiredate from emp order by hiredate desc
		- 2.select empno,empname,hiredate,rownum as rn from <br>
			(select empno,empname,hiredate from emp order by hiredate desc)
		- 3.select empno,empname,hiredate from <br>
			　(<br>
			　　select empno,empname,hiredate,rownum as rn from <br>
			　　　(select empno,empname,hiredate from emp order by hiredate desc)<br>
			　)<br>
			where rn > 0 and rn < 3
<br><br>

- **一般要使得数据库查询语句性能好点遵循一下原则：**
 - 在做表与表的连接查询时，大表在前，小表在后
 - 不使用表别名，通过字段前缀区分不同表中的字段
 - 查询条件中的限制条件要写在表连接条件前
 - 尽量使用索引的字段做为查询条件

#### 2.insert、delete、update语句 ####

- **Oracle中的事务默认手动提交，使用这些语句后需要commit**


### 七、主键和序列 ###

#### 1.为什么使用主键 ####

- 能够唯一确定一条数据

- 能够提高查询速度

#### 2.表中的主键通常使用的两种方式 ####

- 有意义的列，如：手机号、身份证号
- 无意义的列，通常使用自增长：在 mysql中使用auto_increment，但是在oracle中没有，使用序列代替—sequence

#### 3.序列及其使用 ####

- **序列的创建：**create sequence seq_表名（序列名称随便起，但为了命名规范，最好定义有意义的名称）
 
- **序列的使用：**Oracle中的对象都有其自己的属性和方法，使用序列主要使用其两个属性nextval(获取序列的下一个值)、currval(获取序列的当前值)

- **删除序列：**drop sequence seq\_operator_log

- **误删序列：**误删序列后，新建的序列想从表中最大值加1开始
	- 获取表中最大值 select max(t\_id) from t_log
	- 新建序列 create sequence SEQ\_OPERATOR_LOG <br>
　　　　　minvalue 28<br>
　　　　　maxvalue 999999999999999999999999999<br>
　　　　　start with 28<br>
　　　　　increment by 1<br>
　　　　　cache 20<br>

### 八、视图 ###

#### 1.首先给用户赋予创建视图的权限 ####

使用system用户给gyz用户赋予权限：`grant create view to gyz`

#### 2.使用gyz用户创建视图 ####

- create view 视图名称 as 子查询语句<br>
 - create view v$empinfo as <br>
 select e.empno from emp e inner join dept d <br>
 on e.deptno = d.deptno <br>
 inner join salary s on e.sal between s.losal and s.hisal
 - select * from v$empinfo 即可查到上面那一串sql的结果
 - 在mysql中视图不能有嵌套查询，oracle中可以嵌套查询

#### 3.使用视图的好处 ####

- 简化查询（上述案例）
- 保护数据（下面案例）
	- 假设有一个新用户xyq，xyq想访问gyz中的emp表数据，gyz可以赋予其权限：<br>
		gyz用户下，grant select on emp to xyq
	- 现在在xyq用户下，执行 select * from gyz.emp 成功
	- 但现在这种情况gyz就把自己emp的所有信息都暴露给了xyq，不想这样，使用视图：<br>
		1.回到gyz用户，收回权限：revoke select on emp from xyq<br>
		2.赋予其使用视图的权限：grant select on v$empinfo to xyq
	- 回到xyq用户，执行 select * from gyz.v$empinfo 成功

### 九、数据字典、索引 ###

#### 1.数据字典 ####

- 有多少表？多少视图？约束？。。。。。。都是数据库的对象。oracle将用户的相关对象都记录在一个叫数据字典的系统表中。数据字典本身也是一张表。

 - 表名的规律：user_对象名的复数形式
 - 查询的列名：对象名_name

- 查询系统中有多少索引：select index_name,table_name from user_indexes <br>

- 查询系统中有多少约束：select constraint_name,table_name from user_constraints

#### 2.索引 ####

- 按照一定的规则，形成关键字和地址之间的一一映射
- 索引的优缺点
 - 优点：提高查询速度
 - 缺点：
		- 空间(存储)：索引需要额外的存储空间的开销
     索引占存储空间，数据库需要分配一定的空间用于存储索引(映射关系)，随着数据量越大，索引占用的空间越大  
		- 时间上(性能)：对于插入和删除数据，需要对索引进行维护(插入和删除  key –value映射)，降低了插入和删除的性能，需要时间上的开销
- 主键分为单列主键和组合列主键：
 - 主键默认生成索引
 - 查询条件包含单列主键，走索引
 - 组合列主键的情况下，查询语句中只要包含组合列主键中第一个列，才走索引 
- 唯一键
 - 唯一键也默认生成索引
 - 组合列做唯一键，查询中只要包含组合列唯一键中的第一个列，才走索引
- 外键不走索引
- 如果一个表没有主键唯一键，可自己手动创建索引，创建索引的语法，create index 索引的名称 on 表名(列名)，有以下三种情况：
 - 单列索引：
 		- 假设根据手机号码查询个人的消费记录(大数据且需要快速响应)
		- 得给手机号列建立一个单列索引
 		- 建索引之前 select * from t\_user_fee where msisdn = '134518000';--全表扫描
 		- 建索引 create index idx\_msisdn on t\_user_fee(msisdn);<br>
   				select index\_name,table\_name from user\_indexes; 
 		- 建索引之后 select * from t\_user_fee where msisdn = '134518000';--走索引
 - 组合列索引：
 		- 根据手机号码和游戏id 查询具体的消费清单
  		- 建索引之前 select * from t\_user_fee where msisdn = '134518000' and  gameid='123';--全表扫描
   		- 建组合列索引 create index idx\_msisdn\_gameid on t\_user\_fee(msisdn,gameid);
  		- 建索引之后 select * from t\_user_fee where msisdn = '134518000' and gameid='123';--走组合列索引<br>
  		select * from t\_user\_fee where msisdn = '134518000';----走组合列索引<br>
  		select * from t\_user\_fee where gameid='123';--全表扫描
		- 对应组合列索引，和组合列主键组合列唯一键，执行规律一样
 - 函数索引：
		- 查询feetime 在 2015-09-20 到 2015-09-21之间的消费情况
 		- 没有建索引前 select * from t\_user\_fee where to_char(feetime,'yyyy-MM-dd') between '2015-09-20' and '2015-09-21';--全表扫描
 		- 建索引，给feetime建立一个索引 create index idx\_feetime on t\_user_fee(feetime);<br> 
		select * from t\_user\_fee where 
               to\_char(feetime,'yyyy-MM-dd') between '2015-09-20' and '2015-09-21';---全表扫描,并没有走idx\_feetime索引，原因：如果一个索引列上使用函数，则索引失效<br>
		select * from t\_user\_fee where feetime between to\_date('2015-09-20','yyyy-MM-dd') 
                            and  to\_date('2015-09-21','yyyy-MM-dd');---走idx\_feetime索引          
		- 使用函数索引 create index idx\_to\_char\_feetime on t\_user\_fee(to\_char(feetime,'yyyy-MM-dd'));<br>
		select * from t\_user\_fee where to_char(feetime,'yyyy-MM-dd') between '2015-09-20' and '2015-09-21';--走函数索引

#### 3.如何提高sql查询效率 ####

- 善于使用主键查询或者唯一键查询
- 给大数据表中建立索引 
- 避免出现查询语句中 *
- oracle查询语句，where条件执行顺序是自右向左，select from 条件1 条件2 条件3。。。。将一次性能过滤出大量数据的条件，写在最右边


### 十、Oracle高级部分 ###

#### 1.PL/SQL编程 ####

- **PL:procedural language** 过程式语言。过程式语言对sql语言的一种扩展，提供了分支、循环等语法，也就形成了一门语言---数据库编程。
- 任何一门数据库都有自己的数据库内部编程语言，Oracle中pl/sql ,SQL Server中叫T-SQL, mysql中也有，不同的数据库编程语言只是语法不一样，本质一样。

