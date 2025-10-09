
// ================== Lớp Sach ==================
public class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach() {}

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }
    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }
    public int getNamXuatBan() { return namXuatBan; }
    public void setNamXuatBan(int namXuatBan) { this.namXuatBan = namXuatBan; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tiêu đề: " + tieuDe);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("---------------------------");
    }
}

// ================== Lớp SachGiaoTrinh ==================
class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;

    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,
                         String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    @Override
    public String toString() {
        return "📘 Sách giáo trình {" +
                "\n  Mã sách: " + getMaSach() +
                "\n  Tiêu đề: " + getTieuDe() +
                "\n  Tác giả: " + getTacGia() +
                "\n  Năm XB: " + getNamXuatBan() +
                "\n  Số lượng: " + getSoLuong() +
                "\n  Môn học: " + monHoc +
                "\n  Cấp độ: " + capDo +
                "\n}";
    }
}

// ================== Lớp SachTieuThuyet ==================
class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;

    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,
                          String theLoai, boolean laSachSeries) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    @Override
    public String toString() {
        return "📖 Sách tiểu thuyết {" +
                "\n  Mã sách: " + getMaSach() +
                "\n  Tiêu đề: " + getTieuDe() +
                "\n  Tác giả: " + getTacGia() +
                "\n  Năm XB: " + getNamXuatBan() +
                "\n  Số lượng: " + getSoLuong() +
                "\n  Thể loại: " + theLoai +
                "\n  Series: " + (laSachSeries ? "Có" : "Không") +
                "\n}";
    }
}

// ================== Lớp QuanLySach ==================
import java.util.ArrayList;

class QuanLySach {
    private ArrayList<Sach> danhSachSach = new ArrayList<>();

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    public boolean xoaSach(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                danhSachSach.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean capNhatSach(String maSach, Sach sachMoi) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
                danhSachSach.set(i, sachMoi);
                return true;
            }
        }
        return false;
    }

    public Sach timKiemTheoMa(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("📭 Danh sách trống!");
        } else {
            System.out.println("===== DANH SÁCH SÁCH =====");
            for (Sach s : danhSachSach) {
                System.out.println(s.toString());
                System.out.println("-------------------------");
            }
        }
    }
}

// ================== Lớp Test ==================
public class Test {
    public static void main(String[] args) {
        QuanLySach ql = new QuanLySach();

        SachGiaoTrinh sgk1 = new SachGiaoTrinh("GT01", "Cấu trúc dữ liệu", "Nguyễn Văn A", 2021, 10, "CNTT", "Đại học");
        SachGiaoTrinh sgk2 = new SachGiaoTrinh("GT02", "Giải tích 1", "Trần Thị B", 2020, 8, "Toán học", "Đại học");
        SachTieuThuyet tt1 = new SachTieuThuyet("TT01", "Doraemon", "Fujiko Fujio", 1995, 20, "Phiêu lưu", true);
        SachTieuThuyet tt2 = new SachTieuThuyet("TT02", "Nhà Giả Kim", "Paulo Coelho", 1988, 15, "Triết lý", false);

        ql.themSach(sgk1);
        ql.themSach(sgk2);
        ql.themSach(tt1);
        ql.themSach(tt2);

        ql.hienThiDanhSach();

        System.out.println("\n🔍 Tìm kiếm mã 'TT01':");
        Sach ketQua = ql.timKiemTheoMa("TT01");
        if (ketQua != null) System.out.println(ketQua);
        else System.out.println("Không tìm thấy!");

        SachTieuThuyet ttMoi = new SachTieuThuyet("TT01", "Doraemon (Tập đặc biệt)", "Fujiko Fujio", 2000, 25, "Phiêu lưu", true);
        ql.capNhatSach("TT01", ttMoi);

        System.out.println("\n📘 Sau khi cập nhật:");
        ql.hienThiDanhSach();

        ql.xoaSach("GT02");
        System.out.println("\n❌ Sau khi xóa GT02:");
        ql.hienThiDanhSach();
    }
}
