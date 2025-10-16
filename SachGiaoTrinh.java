package Baitaptuan6;

public class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;
    public SachGiaoTrinh(){
        super();
    }
    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,String capDo,String monHoc){
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong);
        this.capDo=capDo;
        this.monHoc=monHoc;
    }
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhap monHoc: ");
        this.monHoc=super.sc.nextLine();
        System.out.println("Nhap capDo: ");
        this.capDo=super.sc.nextLine();
    }
    public String toString(){
        return super.toString()+" /monHoc="+this.monHoc+" /capDo="+this.capDo;
    }
}
