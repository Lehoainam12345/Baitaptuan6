package Baitaptuan6;

import java.util.Scanner;

public class QuanLySach {
    private Sach[] LISTSACH;
    private int N;
    private Scanner sc;
    public QuanLySach(){
        sc =new Scanner (System.in);
    }
    public QuanLySach(int N){
        this.N=N;
        LISTSACH = new Sach[N];
        sc =new Scanner (System.in);
    }
    public void Nhap(){
        char chon;
        Sach listsach=null;
        for(int i=0;i<N;i++){
            System.out.println("Loai can nhap (T=Sachtieuthuyet/G=Sachgiaotrinh)");
            chon =sc.nextLine().toUpperCase().charAt(0);
            switch(chon){
                case 'T':
                    listsach = new SachTieuThuyet();
                    listsach.Nhap();
                    break;
                case 'G':
                    listsach =new SachGiaoTrinh();
                    listsach.Nhap();
                    break; 
                default: 
                    System.out.println("Lựa chọn không hợp lệ!");      
                    break;
            }
            if(listsach!=null)
                LISTSACH[i]=listsach;
        }
    }
     public void Xuat(){
        for(int i=0;i<N;i++) 
            System.out.println(LISTSACH[i]);
    }
    public void Them(){
        char chon;
        Sach listsach=null;
        int n;
        System.out.println("Can nhap them bao nhieu: ");
        n =Integer.parseInt(sc.nextLine());
        Sach[] tam = new Sach[N + n];
        for (int i = 0; i < N; i++) {
        tam[i] = LISTSACH[i];
    }
    LISTSACH = tam;
        for(int i=N;i<N+n;i++){
        System.out.println("Loai can nhap (T=Sachtieuthuyet/G=Sachgiaotrinh)");
            chon =sc.nextLine().toUpperCase().charAt(0);
            switch(chon){
                case 'T':
                    listsach = new SachTieuThuyet();
                    listsach.Nhap();
                    break;
                case 'G':
                    listsach =new SachGiaoTrinh();
                    listsach.Nhap();
                    break; 
                default: 
                    System.out.println("Lựa chọn không hợp lệ!");      
                    break;
            }
            if(listsach!=null){
                LISTSACH[i]=listsach;
            }
        }
    N=N+n;
    }
    public void Xoa(){
        String ma;
        System.out.println("Nhap ma sach can xoa: ");
        ma=sc.nextLine();
        for(int i=0;i<N;i++) 
           if(this.LISTSACH[i].getmasach().equals(ma)) 
           { 
              for(int j=i;j<N-1;j++) 
                  this.LISTSACH[j]=this.LISTSACH[j+1]; 
           } 
        
      this.LISTSACH[this.LISTSACH.length-1]=null; 
      this.N--; 
     }  
     public Sach tim (){
        String ma;
        System.out.println("Nhap ma sach can xoa: ");
        ma=sc.nextLine();
        for(int i=0;i<N;i++){
           if(this.LISTSACH[i].getmasach().equals(ma))
                 return LISTSACH[i];
        }
        return null;
     }
     public void capnhat (){
        String ma;
        System.out.println("Nhap ma sach can xoa: ");
        ma=sc.nextLine();
        for(int i=0;i<N;i++){
           if(this.LISTSACH[i].getmasach().equals(ma)){
                LISTSACH[i].Nhap();
           }
        }
    }
}

