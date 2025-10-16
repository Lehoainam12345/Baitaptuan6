import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    public void themSach(Sach s) {
        danhSachSach.add(s);
    }

    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println(" Danh sách rỗng!");
            return;
        }
        for (Sach s : danhSachSach) {
            System.out.println(s.toString());
        }
    }

    public Sach timKiemTheoMa(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    public void capNhatSach(String maSach, Sach sachMoi) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
                danhSachSach.set(i, sachMoi);
                System.out.println(" Cập nhật thành công!");
                return;
            }
        }
        System.out.println(" Không tìm thấy sách có mã: " + maSach);
    }

    public void xoaSach(String maSach) {
        Sach s = timKiemTheoMa(maSach);
        if (s != null) {
            danhSachSach.remove(s);
            System.out.println(" Đã xóa sách có mã: " + maSach);
        } else {
            System.out.println(" Không tìm thấy sách có mã: " + maSach);
        }
    }
}