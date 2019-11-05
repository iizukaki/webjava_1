package jp.co.systena.tigerscave.shoppingcart.application.service;

public class Item {
  //キーにあいてむID バリューにname　を入れる
    String name;  //名前
    int price;    //値段
    int itemId;   //商品番号

    //コンストラクタ
    public Item( String name,int price, int itemId) {
      // TODO 自動生成されたコンストラクター・スタブ
      this.name = name;
      this.price = price;
      this.itemId = itemId;

    }


    //このメソッドを呼ぶとリターンする
    //Listserviceクラスで読んで、hashmapで

    public Item(int i, String string) {
      // TODO 自動生成されたコンストラクター・スタブ
    }


    //名前の取得
    public String getItemname() {
          return this.name;
    }
    public String setItemname(String name){
          return this.name = name;
    }

    //値段の取得
    public int getItemprice() {
          return this.price;
    }
    public int setItemprice(int price) {
          return this.price;
    }


    //商品番号の取得
    public int getItemitemId() {
          return this.itemId;
    }
    public int setItemId(int itemId) {
          return this.itemId;
    }
}
