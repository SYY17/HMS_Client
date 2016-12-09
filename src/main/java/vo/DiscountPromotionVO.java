package vo;

import java.sql.Date;

public class DiscountPromotionVO extends PromotionVO {

	double discount;

	public DiscountPromotionVO(String pn, String ctt, Date s, Date sp, PromotionType pt, int i, double discount) {
		super(pn, ctt, s, sp, pt, i);
		// TODO Auto-generated constructor stub
		this.discount = discount;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @return 获得营销策略discount
	 */
	public double getDiscount() {
		return discount;
	}

	@Override
	public double calculatePayment(double sum) {
		// TODO Auto-generated method stub
		double payment;
		payment = sum * discount;

		if (payment > 0) {
			return payment;
		}

		return -1;
	}

}
