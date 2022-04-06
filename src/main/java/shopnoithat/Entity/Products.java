 package shopnoithat.Entity;

import java.sql.Date;

public class Products {
	private long maSP;
	private int maLoai;
	private String tenSP;
	private String image;
	private Date ngayTao;
	private String dvt;
	private Date ngayCapNhat;
	private double giaBan;
	private int giamGia;
	private String gioiThieu;
	private boolean noiBat;
	private boolean sanPhamMoi;

	public String getDvt() {
		return dvt;
	}

	public void setDvt(String dvt) {
		this.dvt = dvt;
	}

	public Products() {
		super();
	}

	public long getMaSP() {
		return maSP;
	}

	public void setMaSP(long maSP) {
		this.maSP = maSP;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public boolean isNoiBat() {
		return noiBat;
	}

	public void setNoiBat(boolean noiBat) {
		this.noiBat = noiBat;
	}

	public boolean isSanPhamMoi() {
		return sanPhamMoi;
	}

	public void setSanPhamMoi(boolean sanPhamMoi) {
		this.sanPhamMoi = sanPhamMoi;
	}

}
