package com.company;

import java.util.Random;
import java.util.Scanner;
import java.lang.Exception;

public class Main {

    //Bilge Can Fırat Üniversitesi Teknoloji Fakültesi Yazılım Mühendisliği
    //1.sınıf 2.dönem Algoritma ve Programlama 2 Mayın Tarlası Ödevi

    static int[][] boardStatic;
    public static void main(String[] args) {
        try{
            start();
        }catch(Exception e) {
            System.err.println("Lutfen Tam Sayi Giriniz");
            start();
        }
    }

    public static void start(){
        int ROW; //integer for rows
        int COL; //integer for columns
        int mine; //integer for mines
        Scanner scan = new Scanner(System.in); //creating scan for user input
        Random rand = new Random(); //creating random number generator
        //getting user input for rows and columns

        try {
            System.out.println("Satir sayisini giriniz ");
            ROW = scan.nextInt();
            System.out.println("Sutun sayisini giriniz ");
            COL = scan.nextInt();
            mine = (ROW*COL)/3; //mayın sayısının satır sutun sayısına oranlayarak ayarlama
            int[][] board = new int[ROW][COL];//satır ve sutun değerlerine göre çok boıyutlu dizi oluşturuyoruz
            int count=0; //sayaç
            int a; //satır için rastgele bir sayı
            int b; //sutun için rastgele bir sayı
            //while döngüsü ile mayınları oluşturuyoruz
            while(count<mine)
            {
                a = rand.nextInt(ROW);
                b = rand.nextInt(COL);
                if(board[a][b]!= 1)
                {
                    board[a][b] = 1;
                    System.err.println("--"+a+" "+b);

                    count++;
                }
            }

            //döngü oluşturuyoruz
            for (int r=0; r< board.length; r++)
            {
                for(int c = 0; c< board[r].length; c++)
                {

                    int rMax = r + 1; //maxium amount of r at each point
                    int cMax = c + 1; //maksiumum sutun sayısı
                    int rMin = r - 1;//minimum satır sayısı
                    int cMin = c - 1;//minimum satır sayısı
                    int count1 = 0;//another count varible

                    if(r == 0)
                    {
                        rMin = 0; //r 0 ise minimum satır sayısını 0 olarak ayarlama
                    }
                    if(c == 0)
                    {
                        cMin =0; //c 0 ise minimum sütun sayısını 0 olarak ayarlama
                    }
                    if(r == ROW - 1)
                    {
                        rMax = ROW - 1;//kullanıcı giriş satırlarına maksimum satır sayısını ayarlama - 1 (böylece sayaç bu noktayı geçmeyecektir)
                    }
                    if(c == COL - 1)
                    {
                        cMax = COL - 1;//kullanıcı giriş sütunlarına maksimum sütun sayısını ayarlama - 1 (böylece sayaç bu noktayı geçmeyecektir)
                    }
                    //to find the positions where not equal to 9 (mine)
                    if(board[r][c] != 1)
                    {
                        count1 = 0;//ayar sayacı 0'a eşit
                        //dizi taramak için döngü
                        for(int i = rMin; i <= rMax; i++)
                        {
                            for(int j = cMin; j <= cMax; j++)
                            {
                                if(board[i][j] == 1)
                                {
                                    count1++; //konum 9'a eşitse, sayaca 1 ekle
                                }
                                if(count > 0)
                                {
                                    board[r][c] = 0; //sayım 0'dan büyükse, konumu sayacın miktarına ayarlayın
                                }
                            }
                        }
                    }
                    //oyun çok boyutlu dizisini yazdır
                    System.out.print(board[r][c] + " ");
                }
                boardStatic = board;
                System.out.println("");
            }
            getRowColum();
        }catch (Exception e){
            System.err.println("Lutfen Tam Sayi Giriniz");
            start();
        }
    }

    public static void getRowColum(){
        int ROW = 0;
        int COL = 0;
        int close = 0;
        Scanner scan = new Scanner(System.in); //creating scan for user input
        System.out.println("------ çıkış yapmak için 000 giriniz");
        System.out.println("Satir sayisini giriniz ");
        ROW = scan.nextInt();
        System.out.println("Sutun sayisini giriniz ");
        COL = scan.nextInt();
        if (boardStatic[ROW][COL] == 1){
            System.out.println("mayina denk geldi :(");
        }else{
            System.out.println("mayina denk gelmeddi devam et :)");
        }
        System.out.println("cikmak istiyorsanız 1 giriniz, aksi durumda herhangi bir sey");
        close = scan.nextInt();

        while (close != 1){
            System.out.println("------ çıkış yapmak için 1 giriniz");
            System.out.println("Satir sayisini giriniz ");
            ROW = scan.nextInt();
            System.out.println("Sutun sayisini giriniz ");
            COL = scan.nextInt();

            if (boardStatic[ROW][COL] == 1){
                System.out.println("mayin");
            }else{
                System.out.println("mayina denk gelmeddi devam et :)");
            }
            System.out.println("cikmak istiyorsanız 1 giriniz, aksi durumda herhangi bir sey");
            close = scan.nextInt();
        }
    }

}
