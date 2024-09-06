package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> getAllMenus() {

        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.getAllmenus(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO getMenuBy(int code) {

        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.getMenuBy(sqlSession,code);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int dmlResult = menuDAO.resgistMenu(sqlSession,menu);

        if(dmlResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int dmlResult = menuDAO.modifyMenu(sqlSession,menu);

        if(dmlResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }


    public boolean deleteMenu(int code) {

        SqlSession sqlSession = getSqlSession();

        int dmlResult = menuDAO.deleteMenu(sqlSession,code);

        if(dmlResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;

    }
}
