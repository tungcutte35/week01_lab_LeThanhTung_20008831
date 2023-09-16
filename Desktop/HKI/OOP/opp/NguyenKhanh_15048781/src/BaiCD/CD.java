package BaiCD;

import java.text.DecimalFormat;

public class CD {
	private int maCD,soBaiHat;
	private String tuaCD, caSi;
	private float giaThanh;
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) {
		this.soBaiHat = soBaiHat;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	public String getCaSi() {
		return caSi;
	}
	public void setCaSi(String caSi) {
		this.caSi = caSi;
	}
	public float getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(float giaThanh) {
		this.giaThanh = giaThanh;
	}
	/**
	 * @param maCD
	 * @param soBaiHat
	 * @param tuaCD
	 * @param caSi
	 * @param giaThanh
	 */
	public CD(int maCD, int soBaiHat, String tuaCD, String caSi, float giaThanh) {
		super();
		this.maCD = maCD;
		this.soBaiHat = soBaiHat;
		this.tuaCD = tuaCD;
		this.caSi = caSi;
		this.giaThanh = giaThanh;
	}
	/**
	 * 
	 */
	public CD() {
		super();
		// TODO Auto-generated constructor stub
	}
//	private int maCD,soBaiHat;
//	private String tuaCD, caSi;
//	private float giaThanh;
	@Override
	public String toString() {
		DecimalFormat fm = new DecimalFormat("###,000");
		return String.format("%15d | %-20s | %-20s | %10d | %25s", this.getMaCD(), this.getTuaCD(), this.getCaSi(), this.getSoBaiHat(), fm.format(this.getGiaThanh()));
	}
	
	
}
