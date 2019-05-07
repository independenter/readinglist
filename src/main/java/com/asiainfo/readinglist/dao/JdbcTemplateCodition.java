/**
 * Copyright (C),2018-2018,亚信科技
 * FilaName: JdbcTemplateCodition
 * Author: Dob
 * Date:  2018/11/19 0019 15:59
 * Description:
 * History:
 * <author>         <time>          <version>           <desc>
 * 作者姓名          修改时间           版本号               描述
 */
package com.asiainfo.readinglist.dao;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * <功能简述><br>
 * <>
 *
 * @author Dob
 * @create 2018/11/19 0019 15:59
 * @since 1.0.0
 */
public class JdbcTemplateCodition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        try {
            conditionContext.getClassLoader().loadClass(
                    "org.springframework.jdbc.core.JdbcTemplate"
            );
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
