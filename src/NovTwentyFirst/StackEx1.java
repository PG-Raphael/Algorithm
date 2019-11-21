package NovTwentyFirst;

import java.util.Stack;

/**
 * Created by seungmin.yun on 11/21/2019
 */

public class StackEx1 {
    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void main(String[] args) {
        goURL("Google");
        goURL("Amazon");
        goURL("Indeed");
        goURL("Linkedin");
        goURL("GlassDoor");

        print();

        goBack();
        System.out.println("=====after going back ======");
        print();

        goBack();
        System.out.println("=====after going back ======");
        print();

        goForward();
        System.out.println("======after going forward=====");
        print();

        goURL("youtube");
        System.out.println("======go to new URL======");
        print();
    }

    public static void goURL(String url) {
        back.push(url);
        if(!forward.empty())
            forward.clear();
    }

    public static void goForward() {
        if(!forward.empty())
            back.push(forward.pop());
    }

    public static void goBack() {
        if(!back.empty())
            forward.push(back.pop());
    }

    public static void print() {
        System.out.println("back: " + back);
        System.out.println("forward: " + forward);
        System.out.println("Current page is " + back.peek());
        System.out.println();
    }
}
