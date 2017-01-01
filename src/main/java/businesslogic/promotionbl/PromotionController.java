package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import businesslogic.customerbl.CustomerController;
import businesslogic.userbl.UserController;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import businesslogicservice.ResultMessage;
import businesslogicservice.customerBLService.CustomerBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.userblservice.UserBLService;
import po.DiscountPromotionPO;
import po.FullCutPromotionPO;
import po.PromotionPO;
import po.PromotionType;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.CustomerVO;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionVO;

public class PromotionController implements PromotionBLService {

	private RemoteController remoteController;

	public PromotionController() {
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
	}

	/**
	 * 
	 * @param pvo
	 * @return 制定营销策略
	 */
	@Override
	public ResultMessage addPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService()
					.findsPromotion(pvo.getID(), pvo.getContent(), pvo.getStartTime());

			if (listPromotion != null && listPromotion.size() != 0) {
				return ResultMessage.FALSE;
			}

			PromotionPO ppo = new PromotionPO(pvo.getPromotionName(), pvo.getContent(), pvo.getStartTime(),
					pvo.getStopTime(), converse(pvo.getPromotionType()), pvo.getID());
			remoteController.getPromotionDataService().insertPromotion(ppo);
			remoteController.getPromotionDataService().finishPromotionDataService();

			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 获取所有营销策略的信息列表
	 */
	@Override
	public ArrayList<PromotionVO> getAllPromotion(int id) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		try {
			PromotionVO tmp;
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(id);

			if (listPromotion == null) {
				list = null;
			} else {
				for (int i = 0; i < listPromotion.size(); i++) {
					tmp = new PromotionVO(listPromotion.get(i).getPromotionName(), listPromotion.get(i).getContent(),
							listPromotion.get(i).getStartTime(), listPromotion.get(i).getStopTime(),
							converse(listPromotion.get(i).getPromotionType()), listPromotion.get(i).getID());
					list.add(tmp);
				}
			}

			remoteController.getPromotionDataService().finishPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param pvo
	 * @return 删除营销策略
	 */
	@Override
	public ResultMessage deletePromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getPromotionDataService().initPromotionDataService();
			// 待修改
			PromotionPO ppo = new PromotionPO(pvo.getPromotionName(), pvo.getContent(), pvo.getStartTime(),
					pvo.getStopTime(), converse(pvo.getPromotionType()), pvo.getID());
			remoteController.getPromotionDataService().deletePromotion(ppo);
			remoteController.getPromotionDataService().finishPromotionDataService();

			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param pvo
	 * @return 精确查找营销策略
	 */
	@Override
	public ResultMessage searchPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService()
					.findsPromotion(pvo.getID(), pvo.getContent(), pvo.getStartTime());

			if (listPromotion == null) {
				return ResultMessage.FALSE;
			}
			remoteController.getPromotionDataService().finishPromotionDataService();

			PromotionPO ppo;
			for (int i = 0; i < listPromotion.size(); i++) {
				ppo = listPromotion.get(i);
				if (ppo.getContent().equals(pvo.getContent())) {
					return ResultMessage.TRUE;
				}
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @param content
	 * @return 按照内容查找营销策略
	 */
	@Override
	public ArrayList<PromotionVO> searchByContent(int id, String content) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		try {
			PromotionVO pvo;
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(id,
					content);

			if (listPromotion == null) {
				list = null;
			} else {
				for (int i = 0; i < listPromotion.size(); i++) {
					pvo = new PromotionVO(listPromotion.get(i).getPromotionName(), listPromotion.get(i).getContent(),
							listPromotion.get(i).getStartTime(), listPromotion.get(i).getStopTime(),
							converse(listPromotion.get(i).getPromotionType()), listPromotion.get(i).getID());
					list.add(pvo);
				}
			}
			remoteController.getPromotionDataService().finishPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param id
	 * @param start
	 * @return 按照起始时间查找营销策略
	 */
	@Override
	public ArrayList<PromotionVO> searchByStartTime(int id, Date start) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		try {
			PromotionVO tmp;
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(id, start);
			remoteController.getPromotionDataService().finishPromotionDataService();

			if (listPromotion == null) {
				list = null;
			} else {
				for (int i = 0; i < listPromotion.size(); i++) {
					tmp = new PromotionVO(listPromotion.get(i).getPromotionName(), listPromotion.get(i).getContent(),
							listPromotion.get(i).getStartTime(), listPromotion.get(i).getStopTime(),
							converse(listPromotion.get(i).getPromotionType()), listPromotion.get(i).getID());
					list.add(tmp);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMessage addFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();

			FullCutPromotionPO fpo = new FullCutPromotionPO(fvo.getPromotionName(), fvo.getContent(),
					fvo.getStartTime(), fvo.getStopTime(), converse(fvo.getPromotionType()), fvo.getID(),
					fvo.getEvery(), fvo.getCut());// ....

			remoteController.getFullCutPromotionDataService().insertFullCutPromotion(fpo);
			remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ResultMessage.TRUE;
	}

	@Override
	public ResultMessage addDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();

			DiscountPromotionPO dpo = new DiscountPromotionPO(dvo.getPromotionName(), dvo.getContent(),
					dvo.getStartTime(), dvo.getStopTime(), converse(dvo.getPromotionType()), dvo.getID(),
					dvo.getDiscount());// ....

			remoteController.getDiscountPromotionDataService().insertDiscountPromotion(dpo);
			remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ResultMessage.TRUE;
	}

	@Override
	public ResultMessage deleteFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();

			FullCutPromotionPO fpo = new FullCutPromotionPO(fvo.getPromotionName(), fvo.getContent(),
					fvo.getStartTime(), fvo.getStopTime(), converse(fvo.getPromotionType()), fvo.getID(),
					fvo.getEvery(), fvo.getCut());// ....

			remoteController.getFullCutPromotionDataService().deleteFullCutPromotion(fpo);
			remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ResultMessage.TRUE;
	}

	@Override
	public ResultMessage deleteDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();

			DiscountPromotionPO dpo = new DiscountPromotionPO(dvo.getPromotionName(), dvo.getContent(),
					dvo.getStartTime(), dvo.getStopTime(), converse(dvo.getPromotionType()), dvo.getID(),
					dvo.getDiscount());// ....

			remoteController.getDiscountPromotionDataService().deleteDiscountPromotion(dpo);
			remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ResultMessage.TRUE;
	}

	@Override
	public double searchPromotionPresent(int userId, int roomNum, int id, Timestamp presentTime, int initialPrice) {
		try {
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> allPromotion = remoteController.getPromotionDataService().getAllPromotion();// 所有promotion
																												// 没有筛选
			ArrayList<PromotionPO> hotelPromotion = remoteController.getPromotionDataService().findsPromotion(id);// 所有酒店的promotion
																													// 没有筛选

			ArrayList<PromotionPO> available = new ArrayList<PromotionPO>();// 所有时间可有的promotion

			for (int i = 0; i < hotelPromotion.size(); i++) {
				Date startTemp = hotelPromotion.get(i).getStartTime();
				Date stopTemp = hotelPromotion.get(i).getStopTime();

				Date present = parse(parse(presentTime));

				if (!afterDate(startTemp, present) && !beforeDate(stopTemp, present)) {
					available.add(hotelPromotion.get(i));
				}
			} // 把酒店promotion中时间可用的筛选

			for (int i = 0; i < allPromotion.size(); i++) {
				if (String.valueOf(allPromotion.get(i).getID()).substring(0, 1) == "3") {// 如果是网站营销人员的策略
					Date startTemp = allPromotion.get(i).getStartTime();
					Date stopTemp = allPromotion.get(i).getStopTime();

					Date present = parse(parse(presentTime));

					if (!afterDate(startTemp, present) && !beforeDate(stopTemp, present)) {
						available.add(hotelPromotion.get(i));
					}
				}
			} // 把网站营销promotion可用的加入

			if (available.size() == 0) {
				return initialPrice;
			}

			/*
			 * for(int i=0;i<available.size();i++){
			 * System.out.println(available.get(i).getPromotionName()); //pvo =
			 * new
			 * PromotionVO(available.get(i).getPromotionName(),available.get(i).
			 * getContent(),available.get(i).getStartTime(), //
			 * available.get(i).getStopTime(),converse(available.get(i).
			 * getPromotionType()),available.get(i).getID());
			 * //PromotionInfoForOrder.addList(pvo); }
			 */

			if (roomNum >= 3) {
				double result = 0;
				PromotionPO ins = remoteController.getPromotionDataService().findsPromotion(id, "三间及以上预定优惠").get(0);
				if (ins.getPromotionType() == PromotionType.DISCOUNT) {
					remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
					DiscountPromotionPO ds = remoteController.getDiscountPromotionDataService()
							.findsDiscountPromotion(ins.getID(), ins.getContent()).get(0);

					result = ds.calculatePayment(initialPrice);
					PromotionInfoForOrder.addString(String.valueOf(result) + "+" + ds.getPromotionName());
					remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
				} else {
					remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
					FullCutPromotionPO fs = remoteController.getFullCutPromotionDataService()
							.findsFullPromotion(ins.getID(), ins.getContent()).get(0);

					result = fs.calculatePayment(initialPrice);
					PromotionInfoForOrder.addString(String.valueOf(result) + "+" + fs.getPromotionName());
					remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
				}
				return result;
			} // 三间客房优惠

			// 生日优惠
			Date preTime = parse(parse(presentTime));
			UserBLService userBlService = new UserController();
			CustomerBLService customerBLService = new CustomerController();
			CustomerVO cvo = customerBLService.getCustomerInfo(userBlService.searchByUserID(userId));

			Date birth = cvo.getBirthday();
			Date first = getTimeSpan(preTime, -10);
			Date second = getTimeSpan(preTime, 10);

			double bir = 0;
			if (!afterDate(first, birth) && !beforeDate(second, birth)) {
				PromotionPO ins = remoteController.getPromotionDataService().findsPromotion(id, "生日").get(0);

				if (ins.getPromotionType() == PromotionType.DISCOUNT) {
					remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
					DiscountPromotionPO ds = remoteController.getDiscountPromotionDataService()
							.findsDiscountPromotion(ins.getID(), ins.getContent()).get(0);

					bir = ds.calculatePayment(initialPrice);
					PromotionInfoForOrder.addString(String.valueOf(bir) + "+" + ds.getPromotionName());
					remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
				} else {
					remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
					FullCutPromotionPO fs = remoteController.getFullCutPromotionDataService()
							.findsFullPromotion(ins.getID(), ins.getContent()).get(0);

					bir = fs.calculatePayment(initialPrice);
					PromotionInfoForOrder.addString(String.valueOf(bir) + "+" + fs.getPromotionName());
					remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
				}
				return bir;
			} //

			// 合作企业客户优惠
			double diss = 0;
			String enterprise = cvo.getEnterprise();
			if (enterprise != null && enterprise.equals("")) {
				PromotionPO ins = remoteController.getPromotionDataService().findsPromotion(id, "合作企业客户折扣").get(0);

				if (ins.getPromotionType() == PromotionType.DISCOUNT) {
					remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
					DiscountPromotionPO ds = remoteController.getDiscountPromotionDataService()
							.findsDiscountPromotion(ins.getID(), ins.getContent()).get(0);

					diss = ds.calculatePayment(initialPrice);
					PromotionInfoForOrder.addString(String.valueOf(bir) + "+" + ds.getPromotionName());
					remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
				} else {
					remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
					FullCutPromotionPO fs = remoteController.getFullCutPromotionDataService()
							.findsFullPromotion(ins.getID(), ins.getContent()).get(0);

					diss = fs.calculatePayment(initialPrice);
					PromotionInfoForOrder.addString(String.valueOf(bir) + "+" + fs.getPromotionName());
					remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
				}
				return diss;
			}

			//
			ArrayList<Double> list = new ArrayList<Double>();
			for (int i = 0; i < available.size(); i++) {
				if (available.get(i).getPromotionName().equals("生日")
						|| available.get(i).getPromotionName().equals("三间及以上预定优惠")
						|| available.get(i).getPromotionName().equals("合作企业客户折扣")) {
					list.add(new Double(9999999));
					PromotionInfoForOrder
							.addString(String.valueOf(9999999) + "+" + available.get(i).getPromotionName());
				} else {
					if (available.get(i).getPromotionType() == PromotionType.DISCOUNT) {
						remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
						DiscountPromotionPO ds = remoteController.getDiscountPromotionDataService()
								.findsDiscountPromotion(available.get(i).getID(), available.get(i).getContent()).get(0);
						list.add(new Double(ds.calculatePayment(initialPrice)));
						//
						PromotionInfoForOrder.addString(
								String.valueOf(ds.calculatePayment(initialPrice)) + "+" + ds.getPromotionName());
						remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
					} else {
						remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
						FullCutPromotionPO fs = remoteController.getFullCutPromotionDataService()
								.findsFullPromotion(available.get(i).getID(), available.get(i).getContent()).get(0);
						list.add(new Double(fs.calculatePayment(initialPrice)));
						//
						PromotionInfoForOrder.addString(
								String.valueOf(fs.calculatePayment(initialPrice)) + "+" + fs.getPromotionName());
						remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
					}
				}
			} // 找出最低返回

			/*
			 * for(int i=0;i<list.size();i++){ System.out.println(list.get(i));
			 * //PromotionInfoForOrder.addPrice(list.get(i)); }
			 */

			int small = 0;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) < list.get(small)) {
					small = i;
				}
			}
			remoteController.getPromotionDataService().finishPromotionDataService();

			return list.get(small);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return initialPrice;
	}

	//
	public static void main(String[] args) {
		PromotionController a = new PromotionController();
		double pc = a.searchPromotionPresent(10916231, 2, 20902341, Timestamp.valueOf("2016-12-02 00:00:00"), 1000);
		System.out.println(pc);
	}
	//

	public Date getTimeSpan(Date holdDate, int span) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(holdDate);

		java.util.Date utilDate = (java.util.Date) calendar.getTime();
		calendar.add(Calendar.DATE, span);
		utilDate = (java.util.Date) calendar.getTime();
		Date newDate = new Date(utilDate.getTime());

		return newDate;
	}

	public boolean beforeDate(Date first, Date second) {
		Date d1_temp = Date.valueOf(first.toString());
		Date d2_temp = Date.valueOf(second.toString());

		return d1_temp.before(d2_temp);
	}

	public boolean equalsDate(Date first, Date second) {
		Date d1_temp = Date.valueOf(first.toString());
		Date d2_temp = Date.valueOf(second.toString());

		return d1_temp.equals(d2_temp);
	}

	public boolean afterDate(Date first, Date second) {
		Date d1_temp = Date.valueOf(first.toString());
		Date d2_temp = Date.valueOf(second.toString());

		return d1_temp.after(d2_temp);
	}

	public String parse(Timestamp ts) {
		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			tsStr = sdf.format(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tsStr;
	}

	public Date parse(String s) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date time = format.parse(s);
		return new Date(time.getTime());
	}

	public vo.PromotionType converse(po.PromotionType pt) {
		vo.PromotionType pp = vo.PromotionType.FULL_CUT;

		if (pt == po.PromotionType.FULL_CUT) {
			pp = vo.PromotionType.FULL_CUT;
		} else if (pt == po.PromotionType.DISCOUNT) {
			pp = vo.PromotionType.DISCOUNT;
		}

		return pp;
	}

	public po.PromotionType converse(vo.PromotionType pt) {
		po.PromotionType pp = po.PromotionType.FULL_CUT;

		if (pt == vo.PromotionType.FULL_CUT) {
			pp = po.PromotionType.FULL_CUT;
		} else if (pt == vo.PromotionType.DISCOUNT) {
			pp = po.PromotionType.DISCOUNT;
		}

		return pp;
	}

	@Override
	public ArrayList<FullCutPromotionVO> searchFullCutByContent(int id, String content) {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionVO> list = new ArrayList<FullCutPromotionVO>();
		try {
			FullCutPromotionVO pvo;
			remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
			ArrayList<FullCutPromotionPO> listPromotion = remoteController.getFullCutPromotionDataService()
					.findsFullPromotion(id, content);

			if (listPromotion == null) {
				list = null;
			} else {
				for (int i = 0; i < listPromotion.size(); i++) {
					pvo = new FullCutPromotionVO(listPromotion.get(i).getPromotionName(),
							listPromotion.get(i).getContent(), listPromotion.get(i).getStartTime(),
							listPromotion.get(i).getStopTime(), converse(listPromotion.get(i).getPromotionType()),
							listPromotion.get(i).getID(), listPromotion.get(i).getEvery(),
							listPromotion.get(i).getCut());
					list.add(pvo);
				}
			}
			remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<FullCutPromotionVO> searchFullCutByStartTime(int id, Date start) {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionVO> list = new ArrayList<FullCutPromotionVO>();
		try {
			FullCutPromotionVO pvo;
			remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
			ArrayList<FullCutPromotionPO> listPromotion = remoteController.getFullCutPromotionDataService()
					.findsFullPromotion(id, start);

			if (listPromotion == null) {
				list = null;
			} else {
				for (int i = 0; i < listPromotion.size(); i++) {
					pvo = new FullCutPromotionVO(listPromotion.get(i).getPromotionName(),
							listPromotion.get(i).getContent(), listPromotion.get(i).getStartTime(),
							listPromotion.get(i).getStopTime(), converse(listPromotion.get(i).getPromotionType()),
							listPromotion.get(i).getID(), listPromotion.get(i).getEvery(),
							listPromotion.get(i).getCut());
					list.add(pvo);
				}
			}
			remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<DiscountPromotionVO> searchDiscountByContent(int id, String content) {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionVO> list = new ArrayList<DiscountPromotionVO>();
		try {
			DiscountPromotionVO pvo;
			remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
			ArrayList<DiscountPromotionPO> listPromotion = remoteController.getDiscountPromotionDataService()
					.findsDiscountPromotion(id, content);

			if (listPromotion == null) {
				list = null;
			} else {
				for (int i = 0; i < listPromotion.size(); i++) {
					pvo = new DiscountPromotionVO(listPromotion.get(i).getPromotionName(),
							listPromotion.get(i).getContent(), listPromotion.get(i).getStartTime(),
							listPromotion.get(i).getStopTime(), converse(listPromotion.get(i).getPromotionType()),
							listPromotion.get(i).getID(), listPromotion.get(i).getDiscount());
					list.add(pvo);
				}
			}
			remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<DiscountPromotionVO> searchDiscountByStartTime(int id, Date start) {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionVO> list = new ArrayList<DiscountPromotionVO>();
		try {
			DiscountPromotionVO pvo;
			remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
			ArrayList<DiscountPromotionPO> listPromotion = remoteController.getDiscountPromotionDataService()
					.findsDiscountPromotion(id, start);

			if (listPromotion == null) {
				list = null;
			} else {
				for (int i = 0; i < listPromotion.size(); i++) {
					pvo = new DiscountPromotionVO(listPromotion.get(i).getPromotionName(),
							listPromotion.get(i).getContent(), listPromotion.get(i).getStartTime(),
							listPromotion.get(i).getStopTime(), converse(listPromotion.get(i).getPromotionType()),
							listPromotion.get(i).getID(), listPromotion.get(i).getDiscount());
					list.add(pvo);
				}
			}
			remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}
}
