package jp.co.systena.tigerscave.shoppingcart.application.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.systena.tigerscave.shoppingcart.application.service.Item;

public class ListService {

  public static void getItemlist() {
    // TODO 自動生成されたメソッド・スタブ

  //マップクラスにアイテムクラスのインスタンスを3つ入れてメソッドの返り値として返す

    List<Map<String, Item>> maplist = new ArrayList<>();
    
    Map<String, Item> map = new HashMap<>();
    map.put("001", new Item("リンゴ", 200, 001));
    maplist.add(map);
    map.put("002", new Item("ミカン", 300, 002));
    maplist.add(map);
    map.put("003", new Item("ブドウ", 500, 003));
    maplist.add(map);
    
   

    for (String key : map.keySet()) {
      System.out.println("val : " + map.get(key));
    }
  }
}

