package com.ohgiraffers.mixed;

import com.ohgiraffers.dto.GlassesDTO;
import com.ohgiraffers.dto.LensDTO;

import java.util.List;

public class ResultView {

    public void printGlassesList(List<GlassesDTO> glassesDTOList) {

        System.out.println("요청하신 상품 목록입니다");

        for(GlassesDTO g : glassesDTOList) {
            System.out.println("상픔 코드 : " + g.getGlassesCode() + " " + g.getGlassesName() + "(" + g.getGlassesPrice() + "원)");
        }
    }

    public void printErrorMessage(String errorType) {

        String errorMessage = "";

        switch (errorType) {
            case "selectList" : errorMessage = "[에러] 상품 목록 조회에 실패했습니다.";break;
            case "selectOne" : errorMessage = "[에러] 상품 조회에 실패했습니다.";break;
        }
    }

    public void printGlasses(GlassesDTO glasses) {

        System.out.println("요청하신 상품입니다 : ");
        System.out.println(glasses);
    }

    public void printLensList(List<LensDTO> lensDTOList) {

        System.out.println("요청하신 상품 목록입니다");

        for(LensDTO l : lensDTOList) {
            System.out.println("상픔 코드 : " + l.getLensCode() + " " +l.getLensName() + "(" + l.getLensPrice() + "원)");
        }
    }

    public void printLens(LensDTO lens) {

        System.out.println("요청하신 상품입니다 : ");
        System.out.println(lens);
    }

    public void printSuccessMessage(String dmlType) {

        String successMessage = "";

        switch (dmlType) {
            case "insert" :  successMessage = "[안내] 신규 메뉴 등록 작업이 성공적으로 완료됐습니다."; break;
            case  "update" :  successMessage = "[안내] 기존 메뉴의 정보를 수정하는 작업이 성공적으로 완료됐습니다."; break;
            case  "delete" :  successMessage = "[안내] 기존 메뉴 삭제 작업이 성공적으로 완료됐습니다."; break;
        }
        System.out.println(successMessage);
    }
}
