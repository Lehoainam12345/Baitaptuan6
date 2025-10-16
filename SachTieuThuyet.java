package Baitaptuan6;

public class SachTieuThuyet extends Sach {
    private String theLoai;
    private Boolean laSachSeries;
    public SachTieuThuyet(){
        super();
    }
    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,String theLoai, Boolean laSachSeries){
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong);
        this.theLoai=theLoai;
        this.laSachSeries=laSachSeries;
    }
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhap theLoai: ");
        this.theLoai=super.sc.nextLine();
        System.out.println("Nhap laSachSeries");
        this.laSachSeries = Boolean.parseBoolean(sc.nextLine());
    }
    public String toString(){
        return super.toString()+" /theLoai="+this.theLoai+" / laSachSeries="+this.laSachSeries;
    }
}

