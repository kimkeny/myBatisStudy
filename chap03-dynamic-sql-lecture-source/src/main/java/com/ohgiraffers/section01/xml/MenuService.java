package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicMenuMapper mapper;

    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicMenuMapper.class);

        /*설명. 기본 자료형으로는 조건문의 값을 비교할 수 없으며,
         * hashmap의 key값 또는 DTO의 getter 메소드를 이용해 값을 확인 할 수 있다.
         *  */

        Map<String,Integer> param = new HashMap<>();
        param.put("price",price);

        List<MenuDTO> menuList = mapper.selectMenuByPrice(param);

        if(menuList != null && menuList.size() > 0 ){
            for(MenuDTO m : menuList) {
                System.out.println(m);
            }
        }else {
            System.out.println("[warn] 검색 결과가 존재 하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicMenuMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size() > 0 ){
            for(MenuDTO m : menuList) {
                System.out.println(m);
            }
        }else {
            System.out.println("[warn] 검색 결과가 존재 하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicMenuMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null && menuList.size() > 0 ){
            for(MenuDTO m : menuList) {
                System.out.println(m);
            }
        }else {
            System.out.println("[warn] 검색 결과가 존재 하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicMenuMapper.class);

        Map<String, List<Integer>> params = new HashMap<>();
        params.put("randomMenuCodeList",randomMenuCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(params);

        if(menuList != null && menuList.size() > 0 ){
            for(MenuDTO m : menuList) {
                System.out.println(m);
            }
        }else {
            System.out.println("[warn] 검색 결과가 존재 하지 않습니다.");
        }

        sqlSession.close();

    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicMenuMapper.class);


        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null && menuList.size() > 0 ){
            for(MenuDTO m : menuList) {
                System.out.println(m);
            }
        }else {
            System.out.println("[warn] 검색 결과가 존재 하지 않습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByOrCategory(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicMenuMapper.class);


        List<MenuDTO> menuList = mapper.searchMenuByOrCategory(criteria);

        if(menuList != null && menuList.size() > 0 ){
            for(MenuDTO m : menuList) {
                System.out.println(m);
            }
        }else {
            System.out.println("[warn] 검색 결과가 존재 하지 않습니다.");
        }

        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicMenuMapper.class);


        int dmlResult = mapper.modifyMenu(criteria);

        if(dmlResult >0 ){
            sqlSession.commit();
            System.out.println("[info] 메뉴 정보 변경을 성공 했습니다.");
        }else {
            sqlSession.rollback();
            System.out.println("[error] 메뉴 정보 변경을 실패 했습니다.");
        }

        sqlSession.close();

    }
}
