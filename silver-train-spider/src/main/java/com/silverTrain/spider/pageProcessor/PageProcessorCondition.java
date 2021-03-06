package com.silverTrain.spider.pageProcessor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.silverTrain.common.entity.PageProcessorTable;
import com.silverTrain.schedule.mapper.PageProcessorTableMapper;

public class PageProcessorCondition implements Condition {
	@Autowired
	private PageProcessorTableMapper pageProcessorConfigMapper;
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(PageProcessorOnProperty.class.getName());
        String className = (String) annotationAttributes.get("className");
        QueryWrapper<PageProcessorTable> wap = new QueryWrapper<PageProcessorTable>();
        wap.eq("className", className);
        wap.eq("status", 1);
        if(pageProcessorConfigMapper.selectOne(wap)!=null){
        	return true;
        }else{
        	return false;
        }
	}

}
