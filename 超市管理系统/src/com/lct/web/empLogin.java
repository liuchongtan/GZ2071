package com.lct.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.lct.dao.IEmployeeDao;
import com.lct.dao.impl.EmployeeDaoImpl;
import com.lct.domain.Clock;
import com.lct.domain.Employee;
import com.lct.domain.Good;
import com.lct.domain.Receipt;
import com.lct.domain.Sell;
import com.lct.domain.VIP;
import com.lct.test.ClockOp;
import com.lct.test.SellOp;
import com.lct.test.VipOp;
import com.lct.test.empOp;
import com.lct.test.goodOp;

public class empLogin {

	public static void main(String[] args) throws Exception {
		login();

	}

	public static void login() throws Exception {
		List<Receipt> receipts = new ArrayList<>();
		SellOp sp = new SellOp();
		goodOp gp = new goodOp();
		VipOp vp = new VipOp();
		ClockOp cp = new ClockOp();
		empOp ep = new empOp();
		LoginSelect lsc = new LoginSelect();
		IEmployeeDao iemp = new EmployeeDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("*******欢迎管理员进入管理系统********");
		System.out.println("用户名:");
		String username = sc.nextLine();
		System.out.println("密码:");
		String password = sc.nextLine();
		Employee emp = iemp.login(username, password);
		if (emp != null) {
			System.out.println("欢迎管理员**" + emp.getUsername() + "**进入管理系统");
			if (emp.getRole() == 1) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
				while (true) {
					System.out.println("*********管理员管理页面*************");
					System.out.print("1.收银员账户管理" + "\t");
					System.out.print("2.采购员账户管理" + "\t");
					System.out.print("3.员工出勤管理" + "\t");
					System.out.print("4.查询超市营业额" + "\t");
					System.out.println();
					System.out.print("5.会员管理" + "\t");
					System.out.print("6.查询所有人员信息" + "\t");
					System.out.print(" 7.上班打卡" + "\t");
					System.out.print("8.下班打卡" + "\t");
					System.out.println();
					System.out.print("9.返回登录界面");
					System.out.println();
					System.out.println("请输入您要进行的操作:");
					int i = sc.nextInt();
					if (i == 1) {
						adminFunction1.function1(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);
					} else if (i == 2) {
						adminFunction1.function2(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);

					} else if (i == 3) {
						adminFunction1.function3(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);
					} else if (i == 4) {
						adminFunction1.function4(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);
					} else if (i == 5) {
						adminFunction1.function5(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);

					} else if (i == 6) {
						ep.listallemp();
						continue;
					} else if (i == 7) {
						Date date1 = new Date();
						String enumber = emp.getNumber();
						java.sql.Date date2 = new java.sql.Date(date1.getTime());
						Clock clock = new Clock(enumber, date1, null, date2);
						cp.saveClock(clock);
						continue;
					} else if (i == 8) {
						/**
						 * String empnum=emp.getNumber(); Clock clock = cp.getbyempnum(empnum); Date
						 * date=new Date(); clock.setDateoff(date); System.out.println(clock);
						 * cp.updateClock(clock); System.out.println("下班打卡成功！"); continue;
						 */
						String empnum = emp.getNumber();
						Clock clock = cp.getbyempnum(empnum);
						if (clock.getDatein() == null) {
							System.out.println("下班打卡失败，请先上班打卡！");
						} else {
							Date date = new Date();
							clock.setDateoff(date);
							cp.updateClock(clock);
							System.out.println("下班打卡成功！");
						}
					} else if (i == 9) {
						lsc.loginxuanze();
					}
				}

			} else if (emp.getRole() == 2) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
				while (true) {
					System.out.println("***********************************");
					System.out.println("请选择您要进行的操作：");
					System.out.print("1.收银结算" + "\t");
					System.out.print("2.会员积分查询" + "\t");
					System.out.print("3.开通会员" + "\t");
					System.out.println();
					System.out.print("4.上班打卡" + "\t");
					System.out.print("5.下班打卡" + "\t");
					System.out.print("6.返回登录界面");
					System.out.println();
					System.out.println("请输入操作");
					String flag;
					int i2 = sc.nextInt();
					String text = sc.nextLine();
					String vipnum = null;
					if (i2 == 1) {
						System.out.println("是否使用会员卡(y/n)");
						flag = sc.nextLine();
						if (flag.equals("y")) {
							System.out.println("请输入vip卡号");
							vipnum = sc.nextLine();
						}
						while (true) {
//							System.out.println("是否使用会员卡(y/n)");
//							flag = sc.nextLine();
							Receipt receipt = new Receipt();
							System.out.println("请输入商品编号(输入-1结束添加订单):");
							int goodnum = sc.nextInt();
							String test12 = sc.nextLine();
							if (goodnum == -1) {
								break;
							} else {
								if (flag.equals("y")) {
									System.out.println("请输入商品数量");
									int quantity = sc.nextInt();
									String str = Integer.toString(goodnum);
									Good good = gp.getby(str);
									Integer compare = good.getInventory();
									if (quantity > compare) {
										System.out.println("所购买的量超出库存量,无法成功下单");
									} else {
										String test13 = sc.nextLine();
										String empnum = emp.getNumber();
//									System.out.println("是否使用会员卡(y/n)");
//									String flag = sc.nextLine();
//									if (flag.equals("y")) {
//										System.out.println("请输入vip卡号");
//										String vipnum = sc.nextLine();
										Date date = new Date();
										Sell sell = new Sell(goodnum, quantity, date, empnum, vipnum);
										sp.savesell(sell);
										good.setInventory(good.getInventory() - quantity);
										receipt.setGoodnum(goodnum);
										receipt.setQuantity(quantity);
										receipt.setFlag(true);
										receipts.add(receipt);
									}
								} else {
									System.out.println("请输入商品数量");
									int quantity = sc.nextInt();
									String str = Integer.toString(goodnum);
									Good good = gp.getby(str);
									Integer compare = good.getInventory();
									if (quantity > compare) {
										System.out.println("所购买的量超出库存量,无法成功下单");
									} else {
										vipnum = null;
										Date date = new Date();
										String empnum = emp.getNumber();
										Sell sell = new Sell(goodnum, quantity, date, empnum, vipnum);
										sp.savesell(sell);
										receipt.setGoodnum(goodnum);
										receipt.setQuantity(quantity);
										receipt.setFlag(false);
										receipts.add(receipt);
									}
								}
							}
						}
//						}
						double total = 0.0;
						;
						double vipprice = 0.0d;
						double novipprice = 0.0d;
						System.out.println("-----------------☆☆☆☆购物小票☆☆☆☆-----------------------");
						System.out.println("收银员:" + emp.getUsername() + "为您服务");
						if (flag.equals("y")) {
							System.out.println(
									"商品名字" + "\t" + "   商品编号" + "\t" + "  " + "商品数量" + "\t" + "单价" + "\t" + "总价");
							for (int i = 0; i < receipts.size(); i++) {
								Good good = gp.getby(Integer.toString(receipts.get(i).getGoodnum()));
//						if (receipts.get(i).getFlag() == true) {
								total += good.getVipprice() * receipts.get(i).getQuantity();
								System.out.println(good.getName() + "\t" + "     " + receipts.get(i).getGoodnum() + "\t"
										+ "            " + receipts.get(i).getQuantity() + "\t" + "\t"
										+ good.getVipprice() + "\t"
										+ (good.getVipprice() * receipts.get(i).getQuantity()));

							}
							System.out.println();
							System.out.println(
									"                                                                                                  总价:"
											+ total);
							System.out.println("-----------------☆☆☆☆购物小票☆☆☆☆-----------------------");
							receipts.clear();
							total = 0;
						} else {
							System.out.println(
									"商品名字" + "\t" + "   商品编号" + "\t" + "  " + "商品数量" + "\t" + "单价" + "\t" + "总价");
							for (int i = 0; i < receipts.size(); i++) {
								Good good = gp.getby(Integer.toString(receipts.get(i).getGoodnum()));
								total += (good.getPrice() * receipts.get(i).getQuantity());
								System.out.println(good.getName() + "\t" + "     " + receipts.get(i).getGoodnum() + "\t"
										+ "            " + receipts.get(i).getQuantity() + "\t" + "\t" + good.getPrice()
										+ "\t" + (good.getPrice() * receipts.get(i).getQuantity()));
							}
							System.out.println();
							System.out.println(
									"                                                                                                  总价:"
											+ total);
							System.out.println("-----------------☆☆☆☆购物小票☆☆☆☆-----------------------");
							receipts.clear();
							total = 0;
						}

					} else if (i2 == 2) {
						shouyuanyinFunction.function2(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);
					} else if (i2 == 3) {
						shouyuanyinFunction.function3(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);
					} else if (i2 == 4) {
						Date date1 = new Date();
						String enumber = emp.getNumber();
						java.sql.Date date2 = new java.sql.Date(date1.getTime());
						Clock clock = new Clock(enumber, date1, null, date2);
						cp.saveClock(clock);
						continue;
					} else if (i2 == 5) {
						String empnum = emp.getNumber();
						Clock clock = cp.getbyempnum(empnum);
						if (clock.getDatein() == null) {
							System.out.println("下班打卡失败，请先上班打卡！");
						} else {
							Date date = new Date();
							clock.setDateoff(date);
							System.out.println(clock);
							cp.updateClock(clock);
							System.out.println("下班打卡成功！");
						}
					} else if (i2 == 6) {
						lsc.loginxuanze();
					}
				}
			} else if (emp.getRole() == 3) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
				while (true) {
					System.out.println("***********************************");
					System.out.println("请选择您要进行的操作：");
					System.out.print("1.商品补货" + "\t");
					System.out.print("2.查询进货单" + "\t");
					System.out.print("3.上班打卡" + "\t");
					System.out.print("4.下班打卡" + "\t");
					System.out.println();
					System.out.println("5.返回登录界面");
					System.out.println("请输入操作");
					int i2 = sc.nextInt();
					String text = sc.nextLine();
					if (i2 == 1) {
						TransferFunction.function1(receipts, sp, gp, vp, cp, ep, lsc, iemp, sc);
					} else if (i2 == 2) {
						System.out.println("库存少于100的商品有：");
						gp.selectlessgood();
					} else if (i2 == 3) {
						Date date1 = new Date();
						String enumber = emp.getNumber();
						java.sql.Date date2 = new java.sql.Date(date1.getTime());
						Clock clock = new Clock(enumber, date1, null, date2);
						cp.saveClock(clock);
						continue;
					} else if (i2 == 4) {
						String empnum = emp.getNumber();
						Clock clock = cp.getbyempnum(empnum);
						if (clock.getDatein() == null) {
							System.out.println("下班打卡失败，请先上班打卡！");
						} else {
							Date date = new Date();
							clock.setDateoff(date);
							System.out.println(clock);
							cp.updateClock(clock);
							System.out.println("下班打卡成功！");
						}
					} else if (i2 == 5) {
						lsc.loginxuanze();
					}
				}
			}
		} else {
			System.out.println("您的账号密码有误，请重新输入");
			login();
		}
	}

}
