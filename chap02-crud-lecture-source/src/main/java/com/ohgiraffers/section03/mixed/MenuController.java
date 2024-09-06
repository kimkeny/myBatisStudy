package com.ohgiraffers.section03.mixed;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;      //일을 시킬 서비스 클래스
    private final PrintResult printResult;      //서비스의 성공여부에 따라 결과를 보여주는 뷰 클래스

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void getAllMenus() {

        List<MenuDTO> menuList = menuService.getAllMenus();

        if(menuList != null){
           printResult.printMenuList(menuList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void getMenuBy(Map<String, String> param) {

        int code = Integer.parseInt(param.get("code"));

        MenuDTO menu = menuService.getMenuBy(code);

        if(menu != null) {
            printResult.printMenu(menu);
        }else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void registMenu(Map<String, String> param) {

        String name = param.get("name");
        int price = Integer.parseInt(param.get("price"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        MenuDTO menu = new MenuDTO();

        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)) {
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }

    }

    public void modifyMenu(Map<String, String> param) {


        int code = Integer.parseInt(param.get("code"));
        String name = param.get("name");
        int price = Integer.parseInt(param.get("price"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        MenuDTO menu = new MenuDTO();

        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if(menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }

    }

    public void deleteMenu(Map<String, String> param) {

        int code = Integer.parseInt(param.get("code"));


        if(menuService.deleteMenu(code)) {
            printResult.printSuccessMessage("delete");
        }else {
            printResult.printErrorMessage("delete");
        }

    }
}
