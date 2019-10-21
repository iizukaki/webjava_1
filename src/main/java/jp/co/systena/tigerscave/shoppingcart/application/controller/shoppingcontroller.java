package jp.co.systena.tigerscave.shoppingcart.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class shoppingcontroller {

    /**
     * Thymeleaf 基本編
     * 
     * @param mav
     * ModelAndViewクラステンプレートで利用するデータ類とビューに関する情報をまとめて管理するクラス
     * @return
     */
  
    @RequestMapping("/Shopping")
    public ModelAndView index(ModelAndView mav) {
      
          //変数式
          //・コントローラーからテンプレートに値を渡す
          //・変数「msg」に値を設定
          mav.addObject("msg", "コントローラーからテンプレートに値を渡す");
          
          //使用するビューを設定
          mav.setViewName("Shopping");
      
          return mav;
    }
}
