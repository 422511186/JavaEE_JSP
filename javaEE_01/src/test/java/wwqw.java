import com.example.javaEE.pojo.Item_chat;

/**
 * @Auther: hzy
 * @Date: 2021/11/18 19:34
 * @Description:
 */
public class wwqw {
    public static void main(String[] args) {
        Item_chat item_chat = new Item_chat(){{
            setUsername("dsadsa");
            setMsg("sdsadas");
        }};


        System.out.println("item_chat = " + item_chat);
    }

}
