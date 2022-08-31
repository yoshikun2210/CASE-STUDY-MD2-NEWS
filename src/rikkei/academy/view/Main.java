package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.view.category.ViewCategory;
import rikkei.academy.view.news.ViewNews;
import rikkei.academy.view.user.ViewUser;


public class Main {
    public Main(){
        System.out.println("|______< TIN TỨC 24H >______|");
        System.out.println("1.Category ");
        System.out.println("2.News");
        System.out.println("3.Register");
        System.out.println("4.Login");
        int chooseHome = Config.scanner().nextInt();
        switch (chooseHome){
            case 1:
                new ViewCategory();
                break;
            case 2:
                new ViewNews();
                break;
            case 3:
                new ViewUser();
                break;

        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
