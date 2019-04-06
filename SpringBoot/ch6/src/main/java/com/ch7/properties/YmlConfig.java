package com.ch7.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @program: swagger
 * @description: 读取yml文件实例
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-01 16:49
 **/

@Component
@ConfigurationProperties(prefix = "testyml")
public class YmlConfig {

    /*
testyml:
  simpleProp: simplePropValue
  arrayProps: 1,2,3,4,5
  listProp1:
    - name: abc
      value: abcValue
    - name: efg
      value: efgValue
  listProp2:
    - config2Value1
    - config2Vavlue2
  mapProps:
    key1: value1
     */
    private  String simpleProp;
    private  String[] arrayProps;
    private  List<Map<String,String>> listProp1 = new ArrayList< >();
    private  List<String> listProp2 = new ArrayList<String>();
    private  Map<String,String> mapProps = new HashMap<String, String>();

    public void setSimpleProp(String simpleProp) {
        this.simpleProp = simpleProp;
    }

    public void setArrayProps(String[] arrayProps) {
        this.arrayProps = arrayProps;
    }

    public void setListProp1(List<Map<String, String>> listProp1) {
        this.listProp1 = listProp1;
    }

    public void setListProp2(List<String> listProp2) {
        this.listProp2 = listProp2;
    }

    public void setMapProps(Map<String, String> mapProps) {
        this.mapProps = mapProps;
    }

    @Override
    public String toString() {
        return "YmlConfig{" +
                "simpleProp='" + simpleProp + '\'' +
                ", arrayProps=" + Arrays.toString(arrayProps) +
                ", listProp1=" + listProp1 +
                ", listProp2=" + listProp2 +
                ", mapProps=" + mapProps +
                '}';
    }
}
