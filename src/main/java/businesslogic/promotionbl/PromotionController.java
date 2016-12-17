package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import po.DiscountPromotionPO;
import po.FullCutPromotionPO;
import po.PromotionPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
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
			
			if (listPromotion != null && listPromotion.size()!=0) {
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
	public PromotionVO searchPromotionPresent(int id, Timestamp presentTime) {
		// TODO Auto-generated method stub
		PromotionVO pvo;
		try {
			remoteController.getPromotionDataService().initPromotionDataService();

			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(id);
			ArrayList<PromotionPO> available = new ArrayList<PromotionPO>();

			for (int i = 0; i < listPromotion.size(); i++) {
				Date startTemp = listPromotion.get(i).getStartTime();
				Date stopTemp = listPromotion.get(i).getStopTime();

				Date present = parse(parse(presentTime));

				if (!afterDate(startTemp, present) && !beforeDate(stopTemp, present)) {
					available.add(listPromotion.get(i));
				}
			}

			if (available.size() == 1) {
				pvo = new PromotionVO(available.get(0).getPromotionName(), available.get(0).getContent(),
						available.get(0).getStartTime(), available.get(0).getStopTime(),
						converse(available.get(0).getPromotionType()), available.get(0).getID());
				return pvo;
			} else if (available.size() == 2) {
				String one = String.valueOf(available.get(0).getID()).substring(0, 1);
				String two = String.valueOf(available.get(1).getID()).substring(0, 1);

				if (one == "2" && two != "2") {
					pvo = new PromotionVO(available.get(0).getPromotionName(), available.get(0).getContent(),
							available.get(0).getStartTime(), available.get(0).getStopTime(),
							converse(available.get(0).getPromotionType()), available.get(0).getID());
					return pvo;
				} else if (two == "2" && one != "2") {
					pvo = new PromotionVO(available.get(1).getPromotionName(), available.get(1).getContent(),
							available.get(1).getStartTime(), available.get(1).getStopTime(),
							converse(available.get(1).getPromotionType()), available.get(1).getID());
					return pvo;
				} else {
					return null;
				}
			}

			remoteController.getPromotionDataService().finishPromotionDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		return null;
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
}
