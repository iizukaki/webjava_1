package jp.co.systena.tigerscave.shoppingcart.application.controller;


import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.shoppingcart.application.model.Item;
import jp.co.systena.tigerscave.shoppingcart.application.service.ListService;
import jp.co.systena.tigerscave.shoppingcart.model.Cart;
import jp.co.systena.tigerscave.shoppingcart.model.DeleteForm;
import jp.co.systena.tigerscave.shoppingcart.model.ListForm;
import jp.co.systena.tigerscave.shoppingcart.model.Order;


@Controller//Viewに返却するアノテーション
public class shoppingcontroller {


  @Autowired
  HttpSession session; // セッション管理

  @Autowired
  ListService listService; // サービスクラス

  /**
   * 商品一覧画面表示
   *
   * @param mav the mav
   * @return the model and view
   */

    @RequestMapping(value="/list", method = RequestMethod.GET)// URLとのマッピング
    public ModelAndView list(ModelAndView mav ) {
      // Viewに渡すデータを設定

      Map<Integer, Item>itemList = listService.getItemList();
          mav.addObject("itemList", itemList);

          //使用するビューを設定
          mav.setViewName("ListView");

          return mav;
      }
    /**
     * 注文内容をカートに追加する
     *
     * @param mav the mav
     * @param listForm the list form
     * @param bindingResult the binding result
     * @return the model and view
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST) // URLとのマッピング
    public ModelAndView order(ModelAndView mav, @Validated jp.co.systena.tigerscave.shoppingcart.application.model.ListForm listForm,
        BindingResult bindingResult) {

      if (bindingResult.getAllErrors().size() > 0) {
        // リクエストパラメータにエラーがある場合は商品一覧画面を表示

        Map<Integer, Item> itemListMap = listService.getItemList();
        mav.addObject("itemList", itemListMap);

        // Viewのテンプレート名を設定
        mav.setViewName("ListView");

        return mav;

      }

      // 注文内容をカートに追加
      Cart cart = getCart();
      cart.addOrder(listForm.getItemId(), listForm.getNum());

      // データをセッションへ保存
      session.setAttribute("cart", cart);

      return new ModelAndView("redirect:/cart"); // リダイレクト
    }

    /**
     * カートの内容を表示する
     *
     * @param mav the mav
     * @return the model and view
     */
    @RequestMapping(value = "/cart", method = RequestMethod.GET) // URLとのマッピング
    public ModelAndView cart(ModelAndView mav) {

      // セッションからカートを取得し、テンプレートに渡す
      Cart cart = getCart();
      mav.addObject("orderList", cart.getOrderList());

      // 商品一覧をテンプレートに渡す。※商品名、価格を表示するため
      Map<Integer, Item> itemListMap = listService.getItemList();
      mav.addObject("itemList", itemListMap);

      // 合計金額計算
      int totalPrice = 0;
      for (Order order : cart.getOrderList()) {
        if (itemListMap.containsKey(order.getItemId())) {
          totalPrice += order.getNum() * itemListMap.get(order.getItemId()).getPrice();
        }
      }
      mav.addObject("totalPrice", totalPrice);

      // Viewのテンプレート名設定
      mav.setViewName("CartView");

      return mav;
    }

    /**
     * 注文内容削除する
     *
     * @param mav the mav
     * @param deleteForm the delete form
     * @param bindingResult the binding result
     * @return the model and view
     */
    @RequestMapping(value = "/cart", method = RequestMethod.POST) // URLとのマッピング
    public ModelAndView deleteOrder(ModelAndView mav, @Validated DeleteForm deleteForm,
        BindingResult bindingResult) {

      if (bindingResult.getAllErrors().size() == 0) {
        //リクエストパラメータにエラーがなければ、削除処理行う

        // カートから商品を削除
        Cart cart = getCart();
        cart.deleteOrder(deleteForm.getItemId());

        // データをセッションへ保存
        session.setAttribute("cart", cart);
      }

      return new ModelAndView("redirect:/cart"); // リダイレクト
    }

    /**
     * セッションからカートを取得する
     *
     * @return the cart
     */
    private Cart getCart() {
      Cart cart = (Cart) session.getAttribute("cart");
      if (cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
      }

      return cart;
    }

  }

}

