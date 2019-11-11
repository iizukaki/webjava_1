package jp.co.systena.tigerscave.shoppingcart.application.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscave.shoppingcart.application.model.Item;


@Service
public class ListService {

  public Map<Integer, Item> getItemList(){

    Item item1 =new Item("リンゴ", 200, 001);
    Item item2 =new Item("ミカン", 300, 002);
    Item item3 =new Item("ブドウ", 500, 003);

  //マップクラスにアイテムクラスのインスタンスを3つ入れてメソッドの返り値として返す

    Map<Integer, Item> itemListMap = new LinkedHashMap<Integer, Item>();
    itemListMap.put(item1.getItemId(), item1);
    itemListMap.put(item2.getItemId(), item2);
    itemListMap.put(item3.getItemId(), item3);

   return itemListMap;
  }
}

