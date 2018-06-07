------------------------------------1.管理后台的用户表-----------------------------------------
create table t_sys_user(
    id varchar(30) primary key,
    user_name varchar2(30),
    user_account varchar2(30) ,
    user_pwd varchar2(30),
    user_phone varchar2(30),
    create_time date
);

comment on table t_sys_user is '管理员表';
comment on column t_sys_user.id is '管理员ID';
comment on column t_sys_user.user_name is '管理员用户名';
comment on column t_sys_user.user_account is '管理员帐号';
comment on column t_sys_user.user_pwd is '管理员帐号密码';
comment on column t_sys_user.user_phone is '手机号';
comment on column t_sys_user.create_time is '创建时间';

create sequence seq_sys_user;
insert into t_sys_user(id,user_name,user_account,user_pwd,user_phone,create_time)
values(seq_sys_user.nextval,'弓永壮','admin','admin','18360922022',sysdate);
commit;

--查询所有管理员
select  
        id,
        user_name,
        user_account,
        user_pwd,
        user_phone,
        create_time 
        from t_sys_user;
--根据帐号查询管理员用户
select  
        id,
        user_name,
        user_account,
        user_pwd,
        user_phone,
        create_time 
        from t_sys_user where user_account = 'admin';


------------------------------------2.乐豆系统用户表------------------------------------
create table t_joy_beans_user(
    id varchar2(30) primary key,
    user_account varchar2(30),
    user_name varchar2(30),
    user_pwd varchar2(30),
    user_phone varchar2(30),
    fee_balance number(10),
    beans_balance number(10),
    secret_balance number(10),
    secret_code varchar2(30),
    user_status varchar2(30),
    modify_time date,
    create_time date
);
comment on table t_joy_beans_user
is '乐豆用户表';
comment on column t_joy_beans_user.id
is '乐豆用户ID';
comment on column t_joy_beans_user.user_account
is '乐豆帐号';
comment on column t_joy_beans_user.user_name
is '乐豆用户名';
comment on column t_joy_beans_user.user_pwd
is '帐号密码';
comment on column t_joy_beans_user.user_phone
is '手机号';
comment on column t_joy_beans_user.fee_balance
is '话费余额';
comment on column t_joy_beans_user.beans_balance
is '乐豆余额';
comment on column t_joy_beans_user.secret_balance
is '密保余额';
comment on column t_joy_beans_user.secret_code
is '密保卡号';
comment on column t_joy_beans_user.user_status
is '用户状态(1:正常 2.暂停使用)';
comment on column t_joy_beans_user.modify_time
is '上次修改时间';
comment on column t_joy_beans_user.create_time
is '创建时间';

create sequence seq_joy_beans_user;
--插入乐豆用户
insert into t_joy_beans_user(id, user_name,user_account ,user_pwd,user_phone,fee_balance,beans_balance,secret_balance,secret_code,user_status,modify_time,create_time)
values(seq_joy_beans_user.nextval,'弓永壮','gyz','gyz','18360922022',100,0,0,'844030425','1',sysdate,sysdate);
insert into t_joy_beans_user(id, user_name,user_account ,user_pwd,user_phone,fee_balance,beans_balance,secret_balance,secret_code,user_status,modify_time,create_time)
values(seq_joy_beans_user.nextval,'吕伟','lw','lw','18360922023',100,0,0,'lw74110','1',sysdate,sysdate);
commit;

--查询所有乐豆用户
select 
      id,
      user_name,
      user_account,
      user_pwd,
      user_phone,
      fee_balance,
      beans_balance,
      secret_balance,
      secret_code,
      user_status,
      modify_time,
      create_time 
      from t_joy_beans_user
--分页查询所有用户
--1，按照id升序排列
select 
        id,
        user_name,
        user_account,
        user_pwd,
        user_phone,
        fee_balance,
        beans_balance,
        secret_balance,
        secret_code,
        user_status,
        modify_time,
        create_time 
        from t_joy_beans_user
        order by id asc
--2，查询出rownum
select 
        id,
        user_name,
        user_account,
        user_pwd,
        user_phone,
        fee_balance,
        beans_balance,
        secret_balance,
        secret_code,
        user_status,
        modify_time,
        create_time ,
        rownum rn
        from(
                    select 
                            id,
                            user_name,
                            user_account,
                            user_pwd,
                            user_phone,
                            fee_balance,
                            beans_balance,
                            secret_balance,
                            secret_code,
                            user_status,
                            modify_time,
                            create_time 
                            from t_joy_beans_user
                            order by id asc
                  )
--3，结合分页
select 
        id,
        user_name,
        user_account,
        user_pwd,
        user_phone,
        fee_balance,
        beans_balance,
        secret_balance,
        secret_code,
        user_status,
        modify_time,
        create_time 
        from(
                  select 
                          id,
                          user_name,
                          user_account,
                          user_pwd,
                          user_phone,
                          fee_balance,
                          beans_balance,
                          secret_balance,
                          secret_code,
                          user_status,
                          modify_time,
                          create_time ,
                          rownum as rn
                          from(
                                      select 
                                              id,
                                              user_name,
                                              user_account,
                                              user_pwd,
                                              user_phone,
                                              fee_balance,
                                              beans_balance,
                                              secret_balance,
                                              secret_code,
                                              user_status,
                                              modify_time,
                                              create_time 
                                              from t_joy_beans_user
                                              order by id asc
                                    )
                  )
                  where rn between 1 and 6
--返回总用户数量
select count(0) from t_joy_beans_user

--分页多条件模糊查询userAccount，userName，userPhone
	<select id="queryByCondition" parameterType="JoyBeansUserWrapper" resultMap="joyBeanUserMapper">
		select 
		        id,
		        user_name,
		        user_account,
		        user_pwd,
		        user_phone,
		        fee_balance,
		        beans_balance,
		        secret_balance,
		        secret_code,
		        user_status,
		        modify_time,
		        create_time 
		        from(
		                  select 
		                          id,
		                          user_name,
		                          user_account,
		                          user_pwd,
		                          user_phone,
		                          fee_balance,
		                          beans_balance,
		                          secret_balance,
		                          secret_code,
		                          user_status,
		                          modify_time,
		                          create_time ,
		                          rownum as rn
		                          from(
		                                      select 
		                                              id,
		                                              user_name,
		                                              user_account,
		                                              user_pwd,
		                                              user_phone,
		                                              fee_balance,
		                                              beans_balance,
		                                              secret_balance,
		                                              secret_code,
		                                              user_status,
		                                              modify_time,
		                                              create_time 
		                                              from t_joy_beans_user
		                                              order by id asc
		                                    )
		                  )
		                  where rn > #{pageNoForDB} 
		                  <![CDATA[and rn <= #{pageSizeForDB}]]> and user_account like #{userAccount} 
		                  and user_name like #{userName} 
		                  and user_phone like #{userPhone}
--分页多条件模糊查询后的用户数量
		select 
			count(0) 
			from t_joy_beans_user 
			where user_account like #{userAccount} 
		          and user_name like #{userName} 
		          and user_phone like #{userPhone}


select * from T_Joy_Beans_User;
--根据id修改用户状态
update t_joy_beans_user
set user_status = '1' ,modify_time  = sysdate where id = '21';
--根据帐号查询用户      
select 
      id,
      user_name,
      user_account,
      user_pwd,
      user_phone,
      fee_balance,
      beans_balance,
      secret_balance,
      secret_code,
      user_status,
      modify_time,
      create_time 
      from t_joy_beans_user
      where user_account = 'hexu'

--根据帐号和密码查询乐豆用户
select 
      id,
      user_name,
      user_account,
      user_pwd,
      user_phone,
      fee_balance,
      beans_balance,
      secret_balance,
      secret_code,
      user_status,
      modify_time,
      create_time 
      from t_joy_beans_user
      where user_account = 'hexu'and  user_pwd = 'hexu';


------------------------------------3.游戏类型表------------------------------------
create table t_game_type(
    id varchar2(30) primary key,
    type_name varchar2(30),
    type_status varchar2(30),
    modify_time date,
    create_time date
);
comment on table t_game_type
is '游戏类型表';
comment on column t_game_type.id
is '游戏类型ID';
comment on column t_game_type.type_name
is '游戏类型名';
comment on column t_game_type.type_status
is '游戏类型状态';
comment on column t_game_type.modify_time
is '上次修改时间';
comment on column t_game_type.create_time
is '创建时间';
create Sequence seq_game_type;
--插入一个游戏类型
insert into t_game_type(id,type_name,type_status,modify_time,create_time)
values(seq_game_type.nextval,'射击类','1',sysdate,sysdate);
insert into t_game_type(id,type_name,type_status,modify_time,create_time)
values(seq_game_type.nextval,'益智类','1',sysdate,sysdate);
insert into t_game_type(id,type_name,type_status,modify_time,create_time)
values(seq_game_type.nextval,'竞技类','1',sysdate,sysdate);
insert into t_game_type(id,type_name,type_status,modify_time,create_time)
values(seq_game_type.nextval,'休闲类','1',sysdate,sysdate);
insert into t_game_type(id,type_name,type_status,modify_time,create_time)
values(seq_game_type.nextval,'旗牌类','1',sysdate,sysdate);
insert into t_game_type(id,type_name,type_status,modify_time,create_time)
values(seq_game_type.nextval,'赛车类','1',sysdate,sysdate);
commit;

select * from t_game_type;
--根据ID查询乐豆游戏类型
select 
      id,
      type_name,
      type_status,
      modify_time,
      create_time 
      from t_game_type 
      where id = '6';


--分页所有游戏类型
--1，按id降序排列
select 
      id,
      type_name,
      type_status,
      modify_time,
      create_time 
      from t_game_type 
      order by id asc
--2，查询出rownum
select 
      id,
      type_name,
      type_status,
      modify_time,
      create_time ,
      rownum as rn
      from(
                select 
                      id,
                      type_name,
                      type_status,
                      modify_time,
                      create_time 
                      from t_game_type 
                      order by id asc
                )
--3,结合pageNoForDB
select 
      id,
      type_name,
      type_status,
      modify_time,
      create_time 
      from(
                select 
                      id,
                      type_name,
                      type_status,
                      modify_time,
                      create_time ,
                      rownum as rn
                      from(
                                select 
                                      id,
                                      type_name,
                                      type_status,
                                      modify_time,
                                      create_time 
                                      from t_game_type 
                                      order by id asc
                                )
                )
                where rn>0 and rn<=5
--分页多条件模糊查询（typeName，typeStatus）
		select 
		      id,
		      type_name,
		      type_status,
		      modify_time,
		      create_time 
		      from(
		                select 
		                      id,
		                      type_name,
		                      type_status,
		                      modify_time,
		                      create_time ,
		                      rownum as rn
		                      from(
		                                select 
		                                      id,
		                                      type_name,
		                                      type_status,
		                                      modify_time,
		                                      create_time 
		                                      from t_game_type 
		                                      order by id asc
		                                )
		                )
		                where rn > #{pageNoForDB} 
		                <![CDATA[and rn <= #{pageSizeForDB}]]>
		                and type_name like #{typeName}
		                and type_status = #{typeStatus}
                    
--分页多条件模糊查询后的游戏类型数量（typeName，typeStatus）
		select 
			count(0) 
			from t_game_type
			where type_name like #{typeName}
		          and type_status = #{typeStatus}

--新增游戏类型
insert into t_game_type(
                                          id,
                                          type_name,
                                          type_status,
                                          modify_time,
                                          create_time)
values(seq_game_type.nextval,
                                          '军事类',
                                          '1',
                                          sysdate,
                                          sysdate)

select * from t_game_type;
-- 修改游戏类型状态根据ID
		update t_game_type
			set  type_name = 'xx',
              type_status = '2',
              modify_time = sysdate
			where id = 1;

-- 根据游戏类型名查询游戏
select 
      id,
      type_name,
      type_status,
      modify_time,
      create_time 
      from t_game_type 
      where type_name = '军事类';

------------------------------------4.游戏列表------------------------------------
create table t_game(
    id varchar2(30) primary key,
    game_name varchar2(30),
    game_type varchar2(30),
    game_picture varchar2(100),
    game_detail varchar2(1000),
    game_status varchar2(30),
    game_fee number(10),
    game_beans number(10),
    modify_time date,
    create_time date
);

comment on table t_game
is '游戏列表';
comment on column t_game.id
is '游戏ID';
comment on column t_game.game_name
is '游戏名';
comment on column t_game.game_type
is '游戏类型ID';
comment on column t_game.game_picture
is '游戏图片';
comment on column t_game.game_detail
is '游戏详情';
comment on column t_game.game_status
is '游戏状态';
comment on column t_game.game_fee
is '话费价格';
comment on column t_game.game_beans
is '乐豆价格';
comment on column t_game.modify_time
is '上次修改时间';
comment on column t_game.create_time
is '创建时间';
create sequence seq_game;

--插入游戏
insert into t_game(id,game_name,game_type,game_picture,game_detail,game_status,game_fee,game_beans,modify_time,create_time)
values(seq_game.nextval,'愤怒的小鸟','1','','非常有趣','1',10,30,sysdate,sysdate);
insert into t_game(id,game_name,game_type,game_picture,game_detail,game_status,game_fee,game_beans,modify_time,create_time)
values(seq_game.nextval,'英雄联盟','2','','非常有趣','1',10,30,sysdate,sysdate);
insert into t_game(id,game_name,game_type,game_picture,game_detail,game_status,game_fee,game_beans,modify_time,create_time)
values(seq_game.nextval,'阴阳师','3','','非常有趣','1',10,30,sysdate,sysdate);
insert into t_game(id,game_name,game_type,game_picture,game_detail,game_status,game_fee,game_beans,modify_time,create_time)
values(seq_game.nextval,'皮城女警','4','','非常有趣','1',10,30,sysdate,sysdate);
commit;

--分页查询所有游戏
--1，按照id升序排列
select
        id,
        game_name,
        game_type,
        game_picture,
        game_detail,
        game_status,
        game_fee,
        game_beans,
        modify_time,
        create_time 
        from t_game
        order by id asc
--查询出rownum
select
        id,
        game_name,
        game_type,
        game_picture,
        game_detail,
        game_status,
        game_fee,
        game_beans,
        modify_time,
        create_time ,
        rownum as rn
        from(
                  select
                          id,
                          game_name,
                          game_type,
                          game_picture,
                          game_detail,
                          game_status,
                          game_fee,
                          game_beans,
                          modify_time,
                          create_time 
                          from t_game
                          order by id asc
                  )
--3,结合pageNoForDB
select
        id,
        game_name,
        game_type,
        game_picture,
        game_detail,
        game_status,
        game_fee,
        game_beans,
        modify_time,
        create_time
        from(
                  select
                          id,
                          game_name,
                          game_type,
                          game_picture,
                          game_detail,
                          game_status,
                          game_fee,
                          game_beans,
                          modify_time,
                          create_time ,
                          rownum as rn
                          from(
                                    select
                                            id,
                                            game_name,
                                            game_type,
                                            game_picture,
                                            game_detail,
                                            game_status,
                                            game_fee,
                                            game_beans,
                                            modify_time,
                                            create_time 
                                            from t_game
                                            order by id asc
                                    )
                  )
                  where rn  > 0 and rn <= 3
                  
--	查询游戏总数 
		select
			count(0)
			from t_game
--分页多条件模糊查询（gameName，gameType）
		select
		        id,
		        game_name,
		        game_type,
		        game_picture,
		        game_detail,
		        game_status,
		        game_fee,
		        game_beans,
		        modify_time,
		        create_time
		        from(
		                  select
		                          id,
		                          game_name,
		                          game_type,
		                          game_picture,
		                          game_detail,
		                          game_status,
		                          game_fee,
		                          game_beans,
		                          modify_time,
		                          create_time ,
		                          rownum as rn
		                          from(
		                                    select
		                                            id,
		                                            game_name,
		                                            game_type,
		                                            game_picture,
		                                            game_detail,
		                                            game_status,
		                                            game_fee,
		                                            game_beans,
		                                            modify_time,
		                                            create_time 
		                                            from t_game
		                                            order by id asc
		                                    )
		                  )
		                where rn > #{pageNoForDB} 
		                <![CDATA[and rn <= #{pageSizeForDB}]]> and 1=1
		                <if test="gameName != null">
		                	and game_name like #{gameName}
		                </if>
		                <if test="gameType != null">
		                	and game_type = #{gameType}
		                </if>
--新增游戏
insert into t_game
                            (id,
                              game_name,
                              game_type,
                              game_picture,
                              game_detail,
                              game_status,
                              game_fee,
                              game_beans,
                              modify_time,
                              create_time)
values(
                              seq_game.nextval,
                              '英雄联盟',
                              '4',
                              '',
                              '非常有趣',
                              '1',
                              0,
                              30,
                              sysdate,
                              sysdate
            )
-- 根据ID查询游戏
select
        id,
        game_name,
        game_type,
        game_picture,
        game_detail,
        game_status,
        game_fee,
        game_beans,
        modify_time,
        create_time 
        from t_game
        where id = '5';
-- 修改游戏根据ID
update t_game
            set 
            game_name ='xx',
            game_type ='1',
            game_picture ='xxxx',
            game_detail ='xxxx',
            game_status ='2',
            game_fee =10,
            game_beans =5,
            modify_time =sysdate
            where id = '1';
commit;

select * from t_game;
-- 根据游戏名查询游戏
		select
	        id,
	        game_name,
	        game_type,
	        game_picture,
	        game_detail,
	        game_status,
	        game_fee,
	        game_beans,
	        modify_time,
	        create_time 
	        from t_game
	        where game_name = #{gameName}


------------------------------------5.省份表------------------------------------
create table t_province(
    prov_code varchar2(30),
    prov_name varchar2(30)
); 
comment on table t_province
is '省份表';
comment on column t_province.prov_code
is '省份编号';
comment on column t_province.prov_name
is '省份名';
create sequence seq_province;

insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'北京市(京)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'天津市(津)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'上海市(沪)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'重庆市(渝)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'河北省(冀)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'河南省(豫)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'云南省(云)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'辽宁省(辽)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'黑龙江省(黑)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'湖南省(湘)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'安徽省(皖)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'山东省(鲁)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'江苏省(苏)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'浙江省(浙)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'江西省(赣)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'湖北省(鄂)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'广西壮族省(桂)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'甘肃省(甘)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'山西省(晋)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'内蒙古(蒙)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'陕西省(陕)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'吉林省(吉)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'福建省(福)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'贵州省(贵)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'广东省(粤)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'青海省(青)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'西藏(藏)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'四川省(川)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'宁夏回族(宁)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'海南省(琼)');
insert into t_province(prov_code,prov_name)
values(seq_province.nextval,'新疆维吾尔(新)');
commit;

select * from t_province;
------------------------------------6.乐豆换算比例表------------------------------------
create table t_beans_exchange(
    id varchar2(30),
    prov_code varchar2(30),
    price number,
    modify_time date,
    create_time date
);
comment on table t_beans_exchange
is '乐豆换算比例表';
comment on column t_beans_exchange.id
is '换算比例ID';
comment on column t_beans_exchange.prov_code
is '省份编码';
comment on column t_beans_exchange.price
is '消费金额';
comment on column t_beans_exchange.modify_time
is '更新时间';
comment on column t_beans_exchange.create_time
is '创建时间';
create sequence seq_beans_exchange;

insert into t_beans_exchange(id, prov_code,price ,modify_time,create_time)
values(seq_beans_exchange.nextval,'1',10,sysdate,sysdate);
commit;
select * from t_beans_exchange;
------------------------------------7.密保卡表------------------------------------
create table t_secret_card(
    id varchar2(30),
    card_no varchar2(32),
    card_pwd varchar2(30),
    beans_numbers number,
    card_prov varchar2(30),
    start_time date,
    end_time date,
    card_status varchar2(3),
    create_time date
);
comment on table t_secret_card
is '密保卡表';
comment on column t_secret_card.id
is '密保卡ID';
comment on column t_secret_card.card_no
is '卡号';
comment on column t_secret_card.card_pwd
is '密码';
comment on column t_secret_card.beans_numbers
is '金额（乐豆数量）';
comment on column t_secret_card.card_prov
is '省份';
comment on column t_secret_card.start_time
is '开始时间';
comment on column t_secret_card.end_time
is '结束时间';
comment on column t_secret_card.card_status
is '状态1：正常，2：已使用，3：过期';
comment on column t_secret_card.create_time
is '创建时间';
create sequence seq_secret_card;

insert into t_secret_card(id, card_no,card_pwd,beans_numbers,card_prov,start_time,end_time,card_status,create_time)
values(seq_secret_card.nextval,'D03FF716D8','211304',100,'1','2016-11-18','2016-12-18','1',sysdate);

------------------------------------8.手机号段归属表------------------------------------
create table t_phone_address(
    phone_no varchar2(30),
    phone_address_code varchar2(30)
);
comment on table t_phone_address
is '手机号段归属表';
comment on column t_phone_address.phone_no
is '号段';
comment on column t_phone_address.phone_address_code
is '省份ID';




------------------------------------5.配置表------------------------------------
create table t_joy_beans_config(
    t_type varchar2(20) not null,
    t_keyId varchar2(20) not null,
    t_pageValue varchar2(20) not null
);
--乐豆用户状态
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('1_user_status','1','正常');
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('1_user_status','2','暂停使用');
--游戏类型状态
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('2_type_status','1','商用');
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('2_type_status','2','下线');
--游戏状态
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('3_game_status','1','商用');
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('3_game_status','2','下线');
--密保卡状态
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('4_card_status','1','正常');
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('4_card_status','2','已使用');
insert into t_joy_beans_config(t_type,t_keyId,t_pageValue)
values('4_card_status','1','过期');


select * from t_joy_beans_config;
