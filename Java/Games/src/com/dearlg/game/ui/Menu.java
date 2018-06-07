package com.dearlg.game.ui;

import java.io.File;
import java.util.Scanner;

import com.dearlg.game.entity.Admin;
import com.dearlg.game.entity.DownloadRecord;
import com.dearlg.game.entity.Game;
import com.dearlg.game.entity.User;
import com.dearlg.game.exception.GameException;
import com.dearlg.game.factory.ObjectFactory;
import com.dearlg.game.service.AdminService;
import com.dearlg.game.service.DownRecordService;
import com.dearlg.game.service.GameService;
import com.dearlg.game.service.UserService;

public class Menu {
	private UserService userService = (UserService) ObjectFactory.getBean("userService");
	private GameService gameService = (GameService) ObjectFactory.getBean("gameService");
	private DownRecordService downRecordService = (DownRecordService) ObjectFactory.getBean("downRecordService");
	private AdminService adminService = (AdminService) ObjectFactory.getBean("adminService");

	public void init() {
		try {
			userService.userimprt(new File("src/mobileuser.txt"));
		} catch (GameException e) {
			e.printStackTrace();
		}
		System.out.println("欢迎进入游戏大厅");
		System.out.println("1.用户注册");
		System.out.println("2.用户登录");
		System.out.println("3.管理员登录");
		System.out.print("请选择：");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			regist();
			break;
		case 2:
			log();
			break;
		case 3:
			adminlog();
			break;

		default:
			break;
		}
	}

	/**
	 * 注册页面
	 */
	public void regist() {
		System.out.println("注册页面");
		System.out.print("请输入移动手机号：");
		Scanner input = new Scanner(System.in);
		String number = input.next();
		System.out.print("请输入密码：");
		String password = input.next();
		System.out.print("请输入确认密码：");
		String confirmpwd = input.next();
		if (!password.equals(confirmpwd)) {
			System.out.println("两次密码输入不一致");
			regist();
		} else {
			try {
				userService.regist(number, password);
				System.out.println("注册成功！");
				System.out.print("1.登录系统\t2.退出");
				int choice = input.nextInt();
				if (1 == choice) {
					User user = userService.log(number, password);
					ShowUserCenter(user);
				}
			} catch (GameException e) {
				System.err.println(e.getMsg());
				regist();
			}
		}
	}

	/**
	 * 登录页面
	 */
	public void log() {
		System.out.println("登录页面");
		System.out.print("请输入移动手机号：");
		Scanner input = new Scanner(System.in);
		String number = input.next();
		System.out.print("请输入密码：");
		String password = input.next();
		try {
			User user = userService.log(number, password);
			if (null == user) {
				System.out.println("用户名或密码不正确！");
				log();
			} else {
				System.out.println("登录成功！");
				ShowUserCenter(user);
			}
		} catch (GameException e) {
			System.err.println(e.getMsg());
			log();
		}
	}

	/**
	 * 登录进去的用户中心
	 * 
	 * @param user
	 */
	public void ShowUserCenter(User user) {
		System.out.println("用户中心");
		System.out.println("1.查询余额");
		System.out.println("2.查询消费记录");
		System.out.println("3.下载游戏");
		System.out.print("请选择:");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("当前话费余额为：" + user.getAccount() + "元");
			System.out.println("当前乐豆余额为：" + user.getVirtualAccount() + "豆");
			System.out.print("请选择：1.返回\t2.退出");
			choice = input.nextInt();
			if (1 == choice) {
				ShowUserCenter(user);
			} else if (2 == choice) {
				break;
			}
			break;
		case 2:
			downRecordService.queryBynumber(user.getNumber());
			System.out.print("请选择：1.返回\t2.退出");
			choice = input.nextInt();
			if (1 == choice) {
				ShowUserCenter(user);
			} else if (2 == choice) {
				break;
			}
			break;
		case 3:
			gameService.show();
			System.out.print("请选择要下载的游戏编号:"); // 下载成功意味着有一条下载信息存到下载记录里
			String id = input.next();
			download(user, id);
			System.out.print("请选择：1.返回\t2.退出");
			choice = input.nextInt();
			if (1 == choice) {
				ShowUserCenter(user);
			} else if (2 == choice) {
				break;
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 管理员登录
	 */
	public void adminlog() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入管理员帐号：");
		String id = input.next();
		System.out.print("请输入管理员密码：");
		String pwd = input.next();
		try {
			Admin admin = adminService.log(id, pwd);
			if (null != admin) {
				admincenter();
			}
		} catch (GameException e) {
			System.err.println(e.getMsg());
			adminlog();
		}
	}

	/**
	 * 管理员操作中心
	 */
	public void admincenter() {
		System.out.println("管理员中心");
		System.out.println("1.查找游戏");
		System.out.println("2.增加游戏");
		System.out.println("3.删除游戏");
		System.out.println("4.修改游戏");
		System.out.print("请选择：");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("1.查找所有游戏");
			System.out.println("2.根据游戏编号查找");
			System.out.print("请选择：");
			choice = input.nextInt();
			if (1 == choice) {
				gameService.show();
			} else if (2 == choice) {
				System.out.print("请输入游戏编号：");
				String id = input.next();
				if (null == gameService.select(id)) {
					System.out.println("该编号的游戏不存在！");
				}
			}
			System.out.print("请选择：1.返回\t2.退出");
			int cin = input.nextInt();
			if (1 == cin) {
				admincenter();
			} else if (2 == cin) {
				break;
			}
			break;
		case 2:
			adminService.add(new Game());
			System.out.println("添加成功！");
			System.out.print("请选择：1.返回\t2.退出");
			cin = input.nextInt();
			if (1 == cin) {
				admincenter();
			} else if (2 == cin) {
				break;
			}
			break;
		case 3:
			System.out.print("请输入游戏编号：");
			String id = input.next();
			adminService.delete(id);
			System.out.print("请选择：1.返回\t2.退出");
			cin = input.nextInt();
			if (1 == cin) {
				admincenter();
			} else if (2 == cin) {
				break;
			}
			break;

		case 4:
			System.out.print("请输入游戏编号：");
			id = input.next();
			gameService.select(id);
			adminService.delete(id);
			System.out.println("重新加载游戏！");
			adminService.add(new Game());
			System.out.println("修改成功！");
			System.out.print("请选择：1.返回\t2.退出");
			cin = input.nextInt();
			if (1 == cin) {
				admincenter();
			} else if (2 == cin) {
				break;
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 下载游戏，生成一条下载记录
	 * 
	 * @param user
	 */
	public void download(User user, String id) {
		Scanner input = new Scanner(System.in);
		Game game = gameService.select(id);
		if (null != game) {
			System.out.println("当前话费余额:" + user.getAccount() + ",乐豆余额:" + user.getVirtualAccount());
			System.out.print("请选择下载方式(1)话费下载 (2)乐豆下载：");
			int down = input.nextInt();
			if (1 == down) {
				if (user.getAccount() < game.getRmbPrice()) {
					System.out.println("话费余额不足!");
				} else {
					DownloadRecord downloadRecord = new DownloadRecord();
					downloadRecord.setUser(user);
					downloadRecord.setGame(game);
					downloadRecord.setBuyType("话费");
					downloadRecord.setBuyPrice(game.getRmbPrice());
					downRecordService.add(downloadRecord);
					try {
						userService.modifyAccount(user, game.getRmbPrice());
						System.out.println("下载成功！");
					} catch (GameException e) {
						System.err.println(e.getMsg());
					}
				}
			} else if (2 == down) {
				if (user.getVirtualAccount() < game.getVirtualPrice()) {
					System.out.println("乐豆余额不足！");
				} else {
					DownloadRecord downloadRecord = new DownloadRecord();
					downloadRecord.setUser(user);
					downloadRecord.setGame(game);
					downloadRecord.setBuyType("乐豆");
					downloadRecord.setBuyPrice(game.getVirtualPrice());
					downRecordService.add(downloadRecord);
					try {
						userService.modifVirtualAccount(user, game.getVirtualPrice());
						System.out.println("下载成功！");
					} catch (GameException e) {
						System.err.println(e.getMsg());
					}
				}
			}
		} else {
			System.out.println("该编号的游戏不存在！");
		}
	}
}
