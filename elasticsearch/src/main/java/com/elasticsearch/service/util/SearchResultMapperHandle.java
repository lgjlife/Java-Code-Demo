package com.elasticsearch.service.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *功能描述
 * @author lgj
 * @Description  处理查询结果,高亮字段，由于高亮字段需要添加html字符串，因此只适用于字符串类型的字段。
 * @date 5/19/19
*/
@Component
@Slf4j
public class SearchResultMapperHandle implements SearchResultMapper {

    @Override
    public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
        SearchHits searchHits = searchResponse.getHits();

        List<T> results=null;
        if(searchHits.getHits().length <= 0){
            return  null;
        }
        results = new ArrayList<>();
        for (SearchHit searchHit:searchHits){

            try{

                String searchStr = searchHit.getSourceAsString();
                log.info("searchStr="+searchStr);

                ObjectMapper objectMapper = new ObjectMapper();
                T resultPojo = objectMapper.readValue(searchStr,aClass);
                Map<String, Object> resultMap = searchHit.getSourceAsMap();
                T instance =  aClass.newInstance();

                Field[] fields =   aClass.getDeclaredFields();
                Map<String, HighlightField> highlightFieldMap =  searchHit.getHighlightFields();

                for(Field field:fields){
                    if(highlightFieldMap.containsKey(field.getName())){
                        if(field.getType() != String.class){
                            break;
                        }
                        field.setAccessible(true);
                        String highlightFieldValue =  Arrays.toString(highlightFieldMap.get(field.getName()).getFragments());
                        field.set(resultPojo,highlightFieldValue);
                    }

                }
                results.add(resultPojo);
            }
            catch(Exception ex){
                log.error(ex.getMessage());
                ex.printStackTrace();
            }


        }
        //log.info("size = " + results.size() + "results:"+results);
        AggregatedPage page = new AggregatedPageImpl<T>(results);
        return page;
    }

    /**
     *功能描述 
     * @author lgj
     * @Description  elasticsearch 返回来的是String或者Integer类型，需要转换为pojo对应的类型
     * @date 5/20/19
    */
    private Object valueTypeExchang(Field field,Object value) throws ParseException {

        /*System.out.println("原来的类型：" + field.getName() + "- " + field.getType()
                + " 当前类型:" + value.getClass()
                + "  值:" + value );*/

        //Integer--> Long
        if((field.getType() == Long.class) && (value.getClass() ==  Integer.class)){
            value = ((Integer)value).longValue();
        }
        //Integer-->byte
        else if((field.getType() == byte.class) && (value.getClass() ==  Integer.class)){
            value = ((Integer)value).byteValue();
        }
        //String--> Ｄate
        else if((field.getType() == Date.class) && (value.getClass() ==  String.class)){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            value = (Date)format.parse((String) value);

        }
        //String--> Ｄate
        else if((field.getType() == Date.class) && (value.getClass() ==  Long.class)){
            value = new Date((Long)value);

        }

        return value;
    }

    public static void main(String args[]){
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Date date = format.parse("2019-02-20T13:56:06.000Z");
        }
        catch(Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }



    }
}
