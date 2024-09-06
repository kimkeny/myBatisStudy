package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

public class Applicaton {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("============MyBaits Dynamic SQL (Conditional)===============");
            System.out.println("============마이바티스 동적 SQL(조건문)===============");

            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where,set) 확인하기");
            System.out.println("9. 종료하기");

            System.out.print("[info] 공부하고자 하는 섹션을 선택하시오 : ");
            int num = sc.nextInt();

            switch (num){
                case 1: ifSubMenu();break;
                case 2: chooseSubMenu();break;
                case 3: foreachSubMenu();break;
                case 4: tirmSubMenu();break;
                case 9:
                    System.out.println("[info]학습을 종료합니다.");break;
            }
        }while (true);
    }

    /**
     * trim 동적쿼리 공뷰용 메소드
     * */
    private static void tirmSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("========================4. trim Dynamic SQL 서브 메뉴===============");
            System.out.println("1. 검색 조건이 있는 경우 메뉴 코드로 조회, 없으면 전체조회");
            System.out.println("2. 메뉴 혹은 카테고리 코드로 검색, 단 메뉴와 카테고리 둘다 일치하는 경우도 검색하며," +
                    "건색조건이 없는 경우 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("9. 이전메뉴로");

            System.out.print("[info] 공부하고자 하는 서브 섹션을 선택하시오 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1: menuService.searchMenuByCodeOrSearchAll(inputAllOrOnd());break;
                case 2: menuService.searchMenuByOrCategory(inputSearchCriteriaMap());break;
                case 3: menuService.modifyMenu(inputChangeInfo());break;
                case 9: return;
            }
        }while (true);

    }

    private static Map<String ,Object> inputChangeInfo() {

        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴 코드를 입력해주세요 : ");
        int code = sc.nextInt();

        System.out.print("변경할 메뉴 이름을 입력해주세요 : ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("변경할 메뉴의 카테고리코드를 입력해주세요 : ");
        int categoryCode = sc.nextInt();

        System.out.print("판매 여부를 결정하세요(Y/N) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();

        criteria.put("code",code);
        criteria.put("name",name);
        criteria.put("categoryCode",categoryCode);
        criteria.put("orderableStatus",orderableStatus);

        return criteria;
    }

    private static Map<String, Object> inputSearchCriteriaMap() {

        Scanner sc =new Scanner(System.in);

        System.out.print("검색 조건을 입력해주세요(category/name/both/none) : ");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();

        if("category".equals(condition)){

            System.out.print("검색할 카테고리 코드를 입력해주세요(1 ~ 12) : ");
            int categoryValue = sc.nextInt();

            criteria.put("categoryValue",categoryValue);

        } else if ("name".equals(condition)) {

            System.out.print("검색할 메뉴의 이름을 입력해주세요 : ");
            String nameValue = sc.nextLine();

            criteria.put("nameValue",nameValue);

        } else if ("both".equals(condition)) {

            System.out.print("검색할 카테고리 코드를 입력해주세요(1~12) : ");
            int categoryValue = sc.nextInt();
            sc.nextLine();

            System.out.print("검색할 메뉴의 이름을 입력해주세요 : ");
            String nameValue = sc.nextLine();

            criteria.put("categoryValue",categoryValue);
            criteria.put("nameValue",nameValue);

        }


        return criteria;
    }

    private static SearchCriteria inputAllOrOnd() {

        Scanner sc = new Scanner(System.in);

        System.out.print("검색 조건을 입력 하시겠습니까? (예 or 아니오) : ");
        boolean hasSearchValue = "예".equals(sc.nextLine()) ? true : false;

        SearchCriteria searchCriteria = new SearchCriteria();

        if(hasSearchValue) {
            System.out.print("검색할 메뉴 코드를 입력해주세요 : ");
            String code = sc.nextLine();

            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }


        return searchCriteria;
    }

    /**
     * foreach 동적 쿼리 공부용 메소드*/
    private static void foreachSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("========================3. foreach Dynamic SQL 서브 메뉴===============");
            System.out.println("1. 랜덤한 메뉴 5개 추천해주기");
            System.out.println("9. 이전메뉴로");

            System.out.print("[info] 공부하고자 하는 서브 섹션을 선택하시오 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1: menuService.searchMenuByRandomMenuCode(creatRandomMenuCodeList());break;
                case 9: return;
            }
        }while (true);
    }

    private static List<Integer> creatRandomMenuCodeList() {

        Set<Integer> set = new HashSet<>();

        /*설명. 현재 메뉴 번호는 1~36번 까지다.*/
        while (set.size() < 5) {
            int randomCode = ((int)(Math.random()*36)) + 1;
            set.add(randomCode);
        }
        List<Integer> randomCodeList = new ArrayList<>(set);
        Collections.sort(randomCodeList);   //순서없는 집합인 Set을 정

        return randomCodeList;
    }

    /**
     * choose 동적 쿼리 공부용 메소드
     * */
    private static void chooseSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("========================2. choose Dynamic SQL 서브 메뉴===============");
            System.out.println("1. 카테고리의 상위 분류 별 메뉴 보여주기(식사,음료,디저트)");
            System.out.println("9. 이전메뉴로");

            System.out.print("[info] 공부하고자 하는 서브 섹션을 선택하시오 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1: menuService.searchMenuBySupCategory(inputSupCategory());break;
                case 9: return;
            }
        }while (true);
    }

    private static SearchCriteria inputSupCategory() {

        Scanner sc = new Scanner(System.in);

        System.out.print("원하시는 상위 카테고리 분류를 입력해주세요(식사,음료,디저트) : ");
        String value = sc.nextLine();

        return new SearchCriteria("category",value);
    }

    /**
     * if 동적 쿼리 공뷰용 메소드
     * */
    private static void ifSubMenu() {

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("========================1. if Dynamic SQL 서브 메뉴===============");
            System.out.println("1. 원하는 금액대에 적합한 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 또는 카테고리 명으로 메뉴를 검색해 메뉴 목록 보여주기");
            System.out.println("9. 이전메뉴로");

            System.out.print("[info] 공부하고자 하는 서브 섹션을 선택하시오 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1: menuService.selectMenuByPrice(inputPrice());break;
                case 2: menuService.searchMenu(inputSearchCriteria()); break;
                case 9: return;
            }
        }while (true);
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);

        System.out.print("검색 기준을 입력해주세요('name' or 'category') : ");
        String condition = sc.nextLine();

        System.out.print("검색어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static int inputPrice() {

        Scanner sc = new Scanner(System.in);

        System.out.print("검색하고자 하는 메뉴의 최대 금액을 입력해주세요 : ");
        int price = sc.nextInt();

        return price;
    }
}
