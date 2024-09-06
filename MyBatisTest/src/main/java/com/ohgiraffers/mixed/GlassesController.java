package com.ohgiraffers.mixed;

import com.ohgiraffers.dto.GlassesDTO;
import com.ohgiraffers.dto.LensDTO;

import java.util.List;
import java.util.Map;

public class GlassesController {

    private final GlassesService glassesService;
    private final ResultView resultView;

    public GlassesController() {
        glassesService = new GlassesService();
        resultView = new ResultView();
    }

    public void getAllGlasses() {

        List<GlassesDTO> glassesDTOList = glassesService.getAllGlasses();

        if(glassesDTOList != null) {
            resultView.printGlassesList(glassesDTOList);
        }else {
            resultView.printErrorMessage("selectList");
        }

    }

    public void getGlassesBy(Map<String, String > param) {

        int glassesCode = Integer.parseInt(param.get("glassesCode"));

        GlassesDTO glasses = glassesService.getGlassesBy(glassesCode);

        if(glasses != null) {
            resultView.printGlasses(glasses);
        }else {
            resultView.printErrorMessage("selectOne");
        }
    }

    public void getAllLens() {

        List<LensDTO> lensDTOList = glassesService.getAllLens();

        if(lensDTOList != null) {
            resultView.printLensList(lensDTOList);
        }else {
            resultView.printErrorMessage("selectList");
        }
    }

    public void getLensBy(Map<String, String> param) {

        int lensCode = Integer.parseInt(param.get("lensCode"));

        LensDTO lens = glassesService.getLensBy(lensCode);

        if(lens != null) {
            resultView.printLens(lens);
        }else {
            resultView.printErrorMessage("selectOne");
        }
    }

    public void addGlasses(Map<String, String> param) {

        String glassesName = param.get("glassesName");
        int glassesPrice = Integer.parseInt(param.get("glassesPrice"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        GlassesDTO glasses = new GlassesDTO();

        glasses.setGlassesName(glassesName);
        glasses.setGlassesPrice(glassesPrice);
        glasses.setCategoryCode(categoryCode);

        if(glassesService.addGlasses(glasses)) {
            resultView.printSuccessMessage("insert");
        }else {
            resultView.printErrorMessage("insert");
        }
    }

    public void addLens(Map<String, String> param) {

        String lensName = param.get("lensName");
        int lensPrice = Integer.parseInt(param.get("lensPrice"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        LensDTO lens = new LensDTO();

        lens.setLensName(lensName);
        lens.setLensPrice(lensPrice);
        lens.setCategoryCode(categoryCode);

        if(glassesService.addLens(lens)) {
            resultView.printSuccessMessage("insert");
        }else {
            resultView.printErrorMessage("insert");
        }
    }

    public void modifyGlasses(Map<String, String> param) {

        int glassesCode = Integer.parseInt(param.get("glassesCode"));
        String glassesName = param.get("glassesName");
        int glassesPrice = Integer.parseInt(param.get("glassesPrice"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        GlassesDTO glasses = new GlassesDTO();

        glasses.setGlassesCode(glassesCode);
        glasses.setGlassesName(glassesName);
        glasses.setGlassesPrice(glassesPrice);
        glasses.setCategoryCode(categoryCode);

        if(glassesService.modifyGlasses(glasses)) {
            resultView.printSuccessMessage("update");
        }else {
            resultView.printErrorMessage("update");
        }
    }

    public void modifyLens(Map<String,String> param) {

        int lensCode = Integer.parseInt(param.get("lensCode"));
        String lensName = param.get("lensName");
        int lensPrice = Integer.parseInt(param.get("lensPrice"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        LensDTO lens = new LensDTO();

        lens.setLensCode(lensCode);
        lens.setLensName(lensName);
        lens.setLensPrice(lensPrice);
        lens.setCategoryCode(categoryCode);

        if(glassesService.modifyLens(lens)) {
            resultView.printSuccessMessage("update");
        }else {
            resultView.printErrorMessage("update");
        }
    }

    public void deleteGlasses(Map<String, String> param) {

        int glassesCode = Integer.parseInt(param.get("glassesCode"));


        if(glassesService.deleteGlasses(glassesCode)) {
            resultView.printSuccessMessage("delete");
        }else {
            resultView.printErrorMessage("delete");
        }
    }

    public void deleteLens(Map<String, String> param) {

        int lensCode = Integer.parseInt(param.get("lensCode"));


        if(glassesService.deleteLens(lensCode)) {
            resultView.printSuccessMessage("delete");
        }else {
            resultView.printErrorMessage("delete");
        }
    }
}
