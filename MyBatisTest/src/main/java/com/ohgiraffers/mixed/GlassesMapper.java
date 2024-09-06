package com.ohgiraffers.mixed;

import com.ohgiraffers.dto.GlassesDTO;
import com.ohgiraffers.dto.LensDTO;

import java.util.List;

public interface GlassesMapper {


    List<GlassesDTO> getAllGlasses();

    GlassesDTO getGlassesBy(int glassesCode);

    List<LensDTO> getAllLens();

    LensDTO getLensBy(int lensCode);

    int addGlasses(GlassesDTO glasses);

    int addLens(LensDTO lens);

    int modifyGlasses(GlassesDTO glasses);

    int modifyLens(LensDTO lens);

    int deleteGlasses(int glassesCode);

    int deleteLens(int lensCode);
}
