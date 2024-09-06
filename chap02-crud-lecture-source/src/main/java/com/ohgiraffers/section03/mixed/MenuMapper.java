package com.ohgiraffers.section03.mixed;


import java.util.List;

public interface MenuMapper {


    List<MenuDTO> getAllMenus();


    MenuDTO getMenuBy(int code);


    int resgistMenu(MenuDTO menu);


    int modifyMenu(MenuDTO menu);


    int deleteMenu(int code);
}
