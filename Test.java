package Baitaptuan6;

import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        QuanLySach sach1= new QuanLySach(1);
        sach1.Nhap();
        sach1.Xuat();
        sach1.Them();
        sach1.Xuat();
        System.out.println("Nhap ma sach can xoa: ");
        sach1.Xoa();
        sach1.Xuat();
        sach1.capnhat();
        sach1.Xuat();
    }
}
