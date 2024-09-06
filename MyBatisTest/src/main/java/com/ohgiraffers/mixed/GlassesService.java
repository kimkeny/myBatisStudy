package com.ohgiraffers.mixed;

import com.ohgiraffers.dto.GlassesDTO;
import com.ohgiraffers.dto.LensDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.mixed.Template.getSqlSession;

public class GlassesService {

    private GlassesMapper glassesMapper;

    public List<GlassesDTO> getAllGlasses() {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        List<GlassesDTO> glassesDTOList = glassesMapper.getAllGlasses();

        sqlSession.close();

        return glassesDTOList;
    }

    public GlassesDTO getGlassesBy(int glassesCode) {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        GlassesDTO glasses = glassesMapper.getGlassesBy(glassesCode);

        sqlSession.close();

        return glasses;
    }

    public List<LensDTO> getAllLens() {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        List<LensDTO> lensDTOList = glassesMapper.getAllLens();

        sqlSession.close();

        return lensDTOList;
    }

    public LensDTO getLensBy(int lensCode) {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        LensDTO lens = glassesMapper.getLensBy(lensCode);

        sqlSession.close();

        return lens;
    }

    public boolean addGlasses(GlassesDTO glasses) {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        int dmlResult = glassesMapper.addGlasses(glasses);

        if(dmlResult > 0) {
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }

    public boolean addLens(LensDTO lens) {
        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        int dmlResult = glassesMapper.addLens(lens);

        if(dmlResult > 0) {
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }

    public boolean modifyGlasses(GlassesDTO glasses) {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        int dmlResult = glassesMapper.modifyGlasses(glasses);

        if(dmlResult > 0) {
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }

    public boolean modifyLens(LensDTO lens) {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        int dmlResult = glassesMapper.modifyLens(lens);

        if(dmlResult > 0) {
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }

    public boolean deleteGlasses(int glassesCode) {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        int dmlResult = glassesMapper.deleteGlasses(glassesCode);

        if(dmlResult > 0) {
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }

    public boolean deleteLens(int lensCode) {

        SqlSession sqlSession = getSqlSession();

        glassesMapper = sqlSession.getMapper(GlassesMapper.class);
        int dmlResult = glassesMapper.deleteLens(lensCode);

        if(dmlResult > 0) {
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return dmlResult > 0 ? true : false;
    }
}
