package com.ohgiraffers.section03.mixed;


import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.mixed.Template.getSqlSession;


public class MenuService {

    private MenuMapper menuMapper;



    public List<MenuDTO> getAllMenus() {

        SqlSession sqlSession = getSqlSession();

//        List<MenuDTO> menuList = menuDAO.getAllmenus(sqlSession);
        /*설명. sqlSession은 요청(Req) 단위로 생성해야 하기 때문에 getMapper() 메소드를 사용해
         * 로컬 스코프(메소드 스코프)로 매번 가져와야 한다.a
         *  */
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.getAllMenus();


        sqlSession.close();

        return menuList;
    }

    public MenuDTO getMenuBy(int code) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.getMenuBy(code);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int dmlResult = menuMapper.resgistMenu(menu);

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

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int dmlResult = menuMapper.modifyMenu(menu);

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

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int dmlResult = menuMapper.deleteMenu(code);

        if(dmlResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;

    }
}
