package com.ohgiraffers.mixed;

import java.util.*;

public class OrderGlassesView {

    private GlassesController glassesController = new GlassesController();

    public void displayMain() {

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("===========안경 관리 프로그램===========");
            System.out.println("1. 안경테 상품 조회");
            System.out.println("2. 안경렌즈 상품 조회");
            System.out.println("3. 신규 상품 추가");
            System.out.println("4. 기존 상품 수정");
            System.out.println("5. 기존 상품 삭제");
            System.out.println("9. 프로그램 종료");

            System.out.print("[안내] 원하시는 관리 번호를 입력하세요 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: getGlasses();break;
                case 2: getLens();break;
                case 3: inputProduct();break;
                case 4: modifyProduct();break;
                case 5: deleteProduct();break;
                case 9:
                    System.out.println("[안내] 프로그램을 종료합니다.");break;
            }

        }while(true);
    }

    private void deleteProduct() {

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1. 안경테 상품 삭제");
            System.out.println("2. 안경렌즈 상품 삭제");
            System.out.println("9. 이전 메뉴로 이동");

            System.out.print("[안내] 원하시는 관리 번호를 입력하세요 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: glassesController.deleteGlasses(inputGlassesCode());break;
                case 2: glassesController.deleteLens(inputLensCode());break;
                case 9: return;
            }

        }while (true);
    }

    private void modifyProduct() {

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1. 안경테 상품 수정");
            System.out.println("2. 안경렌즈 상품 수정");
            System.out.println("9. 이전 메뉴로 이동");

            System.out.print("[안내] 원하시는 관리 번호를 입력하세요 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: glassesController.modifyGlasses(inputModifyGlasses());break;
                case 2: glassesController.modifyLens(inputModifyLens());break;
                case 9: return;
            }

        }while (true);

    }

    private Map<String, String> inputModifyLens() {

        Scanner sc = new Scanner(System.in);
        System.out.println("기존 안경렌즈 정보를 수정하려면 아래 정보를 입력 하세요");

        System.out.print("수정할 안경렌즈 코드를 입력해주세요 : ");
        String lensCode = sc.nextLine();

        System.out.print("수정할 안경렌즈 이름 : ");
        String lensName = sc.nextLine();

        System.out.print("수정할 안경렌즈 가격 : ");
        String lensPrice = sc.nextLine();

        System.out.print("수정할 카테고리 코드 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> param = new HashMap<>();

        param.put("lensCode",lensCode);
        param.put("lensName",lensName);
        param.put("lensPrice",lensPrice);
        param.put("categoryCode",categoryCode);

        return param;
    }

    private Map<String, String> inputModifyGlasses() {

        Scanner sc = new Scanner(System.in);
        System.out.println("기존 안경테 정보를 수정하려면 아래 정보를 입력 하세요");

        System.out.print("수정할 안경테 코드를 입력해주세요 : ");
        String glassesCode = sc.nextLine();

        System.out.print("수정할 안경테 이름 : ");
        String glassesName = sc.nextLine();

        System.out.print("수정할 안경테 가격 : ");
        String glassesPrice = sc.nextLine();

        System.out.print("수정할 카테고리 코드 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> param = new HashMap<>();

        param.put("glassesCode",glassesCode);
        param.put("glassesName",glassesName);
        param.put("glassesPrice",glassesPrice);
        param.put("categoryCode",categoryCode);

        return param;
    }

    private void inputProduct() {

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1. 안경테 상품 추가");
            System.out.println("2. 안경렌즈 상품 추가");
            System.out.println("9. 이전 메뉴로 이동");

            System.out.print("[안내] 원하시는 관리 번호를 입력하세요 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: glassesController.addGlasses(inputGlasses());break;
                case 2: glassesController.addLens(inputLens());break;
                case 9: return;
            }

        }while (true);
    }

    private Map<String, String> inputLens() {

        Scanner sc = new Scanner(System.in);
        System.out.println("신규 안경렌즈 정보를 등록하려면 아래 정보를 입력 하세요");

        System.out.print("안경렌즈 이름 : ");
        String lensName = sc.nextLine();

        System.out.print("안경렌즈 가격 : ");
        String lensPrice = sc.nextLine();

        System.out.print("카테고리 코드 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> param = new HashMap<>();

        param.put("lensName",lensName);
        param.put("lensPrice",lensPrice);
        param.put("categoryCode",categoryCode);

        return param;
    }

    private Map<String, String> inputGlasses() {

        Scanner sc = new Scanner(System.in);
        System.out.println("신규 안경테 정보를 등록하려면 아래 정보를 입력 하세요");

        System.out.print("안경테 이름 : ");
        String glassesName = sc.nextLine();

        System.out.print("안경테 가격 : ");
        String glassesPrice = sc.nextLine();

        System.out.print("카테고리 코드 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> param = new HashMap<>();

        param.put("glassesName",glassesName);
        param.put("glassesPrice",glassesPrice);
        param.put("categoryCode",categoryCode);

        return param;
    }

    private void getLens() {

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1. 안경렌즈 전체 조회");
            System.out.println("2. 안경렌즈 코드로 상품 조회");
            System.out.println("9. 이전 메뉴로 이동");

            System.out.print("[안내] 원하시는 관리 번호를 입력하세요 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: glassesController.getAllLens();break;
                case 2: glassesController.getLensBy(inputLensCode());break;
                case 9: return;
            }

        }while (true);
    }

    private Map<String, String> inputLensCode() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("안경렌즈의 코드를 입력해주세요 : ");
        String lensCode = scanner.nextLine();

        Map<String, String> params = new HashMap<>();
        params.put("lensCode", lensCode);

        return params;
    }

    private void getGlasses() {

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1. 안경테 전체 조회");
            System.out.println("2. 안경테 코드로 상품 조회");
            System.out.println("9. 이전 메뉴로 이동");

            System.out.print("[안내] 원하시는 관리 번호를 입력하세요 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: glassesController.getAllGlasses();break;
                case 2: glassesController.getGlassesBy(inputGlassesCode());break;
                case 9: return;
            }

        }while (true);
    }

    private Map<String, String> inputGlassesCode() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("안경테의 코드를 입력해주세요 : ");
        String glassesCode = scanner.nextLine();

        Map<String, String> params = new HashMap<>();
        params.put("glassesCode", glassesCode);

        return params;
    }
}
