package jp.co.systena.tigerscave.shoppingcart.application.model;

public class Item {
    private String name;  //名前
    private int price;    //値段
    private int itemId;   //商品番号

    //コンストラクタ
    public Item( String name,int price, int itemId) {
      // TODO 自動生成されたコンストラクター・スタブ
      this.name = name;
      this.price = price;
      this.itemId = itemId;

    }


    //このメソッドを呼ぶとリターンする
    //Listserviceクラスで読んで、hashmapで

    //名前の取得
    public String getName() {
          return name;
    }
    public void setnName(String name){
          this.name = name;
    }

    //値段の取得
    public int getPrice() {
          return price;
    }
    public void setPrice(int price) {
          this.price = price;
    }


    //商品番号の取得
    public int getItemId() {
          return itemId;
    }
    public void setItemId(int itemId) {
          this.itemId = itemId;
    }
}
