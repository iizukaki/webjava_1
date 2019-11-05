package jp.co.systena.tigerscave.shoppingcart.application.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.shoppingcart.application.model.ListService;
import jp.co.systena.tigerscave.shoppingcart.application.service.Item;


@Controller//Viewに返却するアノテーション
public class shoppingcontroller {

    @RequestMapping(value="/ListView", method = RequestMethod.GET)// URLとのマッピング
    public ModelAndView display() {
      // Viewに渡すデータを設定
      ModelAndView mav = new ModelAndView();

          mav.addObject("data", list ());  // 新規クラスを設定

          //使用するビューを設定
          mav.setViewName("ListView");

          return mav;
          
          
          }

    private Object list() {
      // TODO 自動生成されたメソッド・スタブ
      ListService obj = new ListService();
      List<Map<String, Item>> list = new ArrayList<>();
      System.out.println(list.get(0));
      return null;
    }
}
