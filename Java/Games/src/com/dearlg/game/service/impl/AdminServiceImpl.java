package com.dearlg.game.service.impl;

import java.sql.SQLException;
import java.util.Scanner;

import com.dearlg.game.dao.AdminDao;
import com.dearlg.game.dao.GameDao;
import com.dearlg.game.dao.impl.GameTypeDao;
import com.dearlg.game.entity.Admin;
import com.dearlg.game.entity.Game;
import com.dearlg.game.exception.ErrorCode;
import com.dearlg.game.exception.GameException;
import com.dearlg.game.factory.ObjectFactory;
import com.dearlg.game.service.AdminService;
import com.dearlg.game.transaction.Transaction;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao = (AdminDao) ObjectFactory.getBean("adminDao");
	private GameDao gameDao = (GameDao) ObjectFactory.getBean("gameDao");
	private GameTypeDao gameTypeDao = (GameTypeDao) ObjectFactory.getBean("gameTypeDao");
	private Transaction tx = (Transaction) ObjectFactory.getBean("tx");

	@Override
	public Admin log(String id, String pwd) throws GameException {
		Admin admin = null;
		try {
			admin = adminDao.logByIdPwd(id, pwd);
			if (null == admin) {
				throw new GameException(ErrorCode.LOG_IS_ERROR, ErrorCode.LOG_IS_ERROR_MSG);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public void add(Game game) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入游戏编号：");
		game.setId(input.next());
		System.out.print("请输入游戏名称：");
		game.setName(input.next());
		System.out.print("请输入游戏类型：");
		String typename = input.next();
		try {
			while(!gameTypeDao.queryByName(typename)) {
				System.out.println("游戏类型不合法！");
				System.out.print("请重新输入:");
				typename = input.next();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		game.setCategory(typename);
		System.out.print("请输入话费下载定价：");
		game.setRmbPrice(input.nextDouble());
		System.out.print("请输入乐豆下载定价：");
		game.setVirtualPrice(input.nextDouble());
		try {
			tx.begin();
			gameDao.add(game);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		try {
			if (null == gameDao.select(id)) {
				System.out.println("删除失败,该编号的游戏不存在！");
			} else {
				tx.begin();
				gameDao.delete(id);
				tx.commit();
				System.out.println("删除成功！");
			}
		} catch (SQLException e) {
			System.out.println("删除失败");
			tx.rollback();
			e.printStackTrace();
		}
	}
}
