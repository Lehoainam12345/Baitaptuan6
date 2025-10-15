import java.util.ArrayList;

// ======= Lớp cha =======
class Sach {
    protected String maSach;
    protected String tenSach;
    protected String tacGia;
    protected double gia;

    public Sach(String maSach, String tenSach, String tacGia, double gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.gia = gia;
    }

    public String getMaSach() {
        return maSach;
    }

    @Override
    public String toString() {
        return "Mã: " + maSach + ", Tên: " + tenSach + ", Tác giả: " + tacGia + ", Giá: " + gia;
    }
}

// ======= Lớp con 1 =======
class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;

    public SachGiaoTrinh(String maSach, String tenSach, String tacGia, double gia,
                         String monHoc, String capDo) {
        super(maSach, tenSach, tacGia, gia);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Môn học: " + monHoc + ", Cấp độ: " + capDo;
    }
}

// ======= Lớp con 2 =======
class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;

    public SachTieuThuyet(String maSach, String tenSach, String tacGia, double gia,
                          String theLoai, boolean laSachSeries) {
        super(maSach, tenSach, tacGia, gia);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thể loại: " + theLoai +
               ", Series: " + (laSachSeries ? "Có" : "Không");
    }
}

// ======= Quản lý sách =======
class QuanLySach {
    private ArrayList<Sach> danhSach = new ArrayList<>();

    public void themSach(Sach sach) {
        danhSach.add(sach);
    }

    public boolean xoaSach(String maSach) {
        return danhSach.removeIf(s -> s.getMaSach().equals(maSach));
    }

    public Sach timKiem(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equals(maSach)) {
                return s;
            }
        }
        return null;
    }

    public void hienThi() {
        for (Sach s : danhSach) {
            System.out.println(s);
        }
    }
}

// ======= Lớp main =======
public class Test {
    public static void main(String[] args) {
        QuanLySach ql = new QuanLySach();

        Sach sgk = new SachGiaoTrinh("GT01", "Giải tích 1", "Nguyễn Văn A", 50000, "Toán", "Đại học");
        Sach ttn = new SachTieuThuyet("TT01", "Harry Potter", "J.K Rowling", 120000, "Phiêu lưu", true);

        ql.themSach(sgk);
        ql.themSach(ttn);

        System.out.println("Danh sách sách:");
        ql.hienThi();

        System.out.println("\nTìm sách có mã TT01:");
        System.out.println(ql.timKiem("TT01"));

        System.out.println("\nXóa sách mã GT01...");
        ql.xoaSach("GT01");

        System.out.println("\nDanh sách sau khi xóa:");
        ql.hienThi();
    }
}
}
