package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        MenuController menuController =  new MenuController();
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("=================메뉴 관리 프로그램================");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 검색");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");

            System.out.print("[info] 원하시는 메뉴 관리 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: menuController.getAllMenus(); break;
                case 2: menuController.getMenuBy(inputMenuCode());break;
                case 3: menuController.registMenu(inputMenu()); break;
                case 4: menuController.modifyMenu(inputModifyMenu()); break;
                case 5: menuController.deleteMenu(inputMenuCode()); break;
            }

        }while (true);
    }



    private static Map<String, String> inputMenuCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 코드를 입력해주세요 : ");
        String code = sc.nextLine();

        Map<String ,String > param = new HashMap<>();
        param.put("code",code);



        return param;
    }

    private static Map<String,String > inputMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("신규메뉴를 등록하려면 아래 정보를 입력해주세요");

        System.out.print("메뉴 이름 : ");
        String name  = sc.nextLine();

        System.out.print("메뉴 가격 : ");
        String price = sc.nextLine();

        System.out.print("카테고리 코드 : ");
        String  categoryCode = sc.nextLine();

        Map<String,String> param = new HashMap<>();

        param.put("name",name);
        param.put("price",price);
        param.put("categoryCode",categoryCode);

     return param;
    }

    private static Map<String,String> inputModifyMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정하고자 하는 메뉴의 코드를 입력해주세요 : ");
        String code = sc.nextLine();

        System.out.println("입력하신 메뉴의 신규 정보를 입력해주세요");
        System.out.print("수정할 메뉴의 이름 : ");
        String name = sc.nextLine();

        System.out.print("수정할 메뉴의 가격 : ");
        String price = sc.nextLine();

        System.out.print("수정할 카테고리 코드 : ");
        String categoryCode = sc.nextLine();

        Map<String ,String> param = new HashMap<>();
        param.put("code",code);
        param.put("name",name);
        param.put("price",price);
        param.put("categoryCode",categoryCode);


        return param;
    }
}
