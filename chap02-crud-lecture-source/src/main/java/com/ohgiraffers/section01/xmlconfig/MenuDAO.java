package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*설명.
 * 해당 DAO에서 호출하는 이름(MenuMapper)와 menu-mapper.xml의 namespace값이 반드시 일치해야한다.
 * section02,section03까지 구현할 경우 MenuMapper 링크가 section02로 연결되지만,
 * 실제 사용하게 될 패머틑 menu-mapper.xml이다.
 *  */
public class MenuDAO {
    public List<MenuDTO> getAllmenus(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.getAllMenus");
    }

    public MenuDTO getMenuBy(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.getMenuByCode",code);
    }

    public int resgistMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.resgistMenu",menu);
    }

    public int modifyMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.modifyMenu",menu);
    }

    public int deleteMenu(SqlSession sqlSession, int code) {

        return sqlSession.delete("MenuMapper.deleteMenu",code);
    }
}
