package com.ohgiraffers.section02.javaconfig;


import org.apache.ibatis.annotations.*;


import java.util.List;

public interface MenuMapper {

    @Results(id = "menuResultMap",
            value = {
                @Result(id = true, property = "code", column = "menu_code"),
                @Result(property = "name", column = "menu_name"),
                @Result(property = "price", column = "menu_price"),
                @Result(property = "categoryCode", column = "category_code"),
                @Result(property = "orderableStatus", column = "orderable_status"),

            }

    )
    @Select("""
            SELECT
                a.menu_code ,
                a.menu_name ,
                a.menu_price ,
                a.category_code ,
                a.orderable_status
            From
                tbl_menu a
            where
                a.orderable_status = 'Y'
            ORDER BY
                a.menu_code""")
    List<MenuDTO> getAllmenus();

    @ResultMap("menuResultMap")
    @Select("""
             select
                        a.menu_code ,
                        a.menu_name ,
                        a.menu_price ,
                        a.category_code ,
                        a.orderable_status
                    From
                        tbl_menu a
                    where
                        a.orderable_status = 'Y' AND
                        a.menu_code = #{ code }
                    ORDER BY
                        a.menu_code\
            """)
    MenuDTO getMenuBy(int code);

    @Insert("""
                    INSERT INTO tbl_menu
                        (
                            menu_name,
                            menu_price,
                            category_code,
                            orderable_status
                        )
                    VALUES
                        (
                            #{ name },
                            #{ price },
                            #{ categoryCode },
                            'Y'
                        )\
            """)
    int resgistMenu(MenuDTO menu);

    @Update("""
               UPDATE
                        tbl_menu
                    SET
                        menu_name = #{ name },
                        menu_price = #{ price },
                        category_code = #{ categoryCode }
                    where
                        menu_code = #{ code }\
            """)
    int modifyMenu(MenuDTO menu);

    @Delete("""
                 DELETE
                    FROM
                        tbl_menu
                    WHERE
                        menu_code = #{ code }\
            """)
    int deleteMenu(int code);
}
