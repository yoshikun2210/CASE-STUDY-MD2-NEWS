package rikkei.academy.view.news;

import rikkei.academy.config.Config;
import rikkei.academy.controller.NewsController;
import rikkei.academy.model.news.News;
import rikkei.academy.view.Main;

import java.util.List;

public class ViewNews {
    public NewsController newsController = new NewsController();
    public List<News> newsList = newsController.showListNews();

    public ViewNews() {
        System.out.println("|     * * NEWS MANAGER * *    |");
        System.out.println("1.Create News");
        System.out.println("2.Show List News");
        System.out.println("3.Detail News");
        System.out.println("4.Edit News");
        System.out.println("5.Delete News");
        System.out.println("6.Back Menu");
        int chooseNews = Config.scanner().nextInt();
        switch (chooseNews) {
            case 1:
                newsCreateNews();
                break;
            case 2:
                newsShowListNews();
                break;
            case 3:
                newsDetailNews();
                break;
            case 4:
                newsEditNews();
                break;
            case 5:
                newsDeleteNews();
                break;
            case 6:
                new Main();
                break;
        }


    }


    private void newsCreateNews() {
        System.out.println("|________ CREATE NEWS ________|");
        while (true) {
            int idNews;
            if (newsList.size() == 0) {
                idNews = 1;
            } else {
                idNews = newsList.get(newsList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập vào tên chủ đề :");
            String newsName = Config.scanner().nextLine();
            System.out.println("Nhập vào nội dung :");
            String newContent = Config.scanner().nextLine();
            News news = new News(idNews,newsName,newContent);
            newsController.createNews(news);
            System.out.println("Thêm thành công!!!");
            newsController.showListNews();
            System.out.println("Nhập phím bất kỳ đề tiếp tục - out để thoát");
            String outHome = Config.scanner().nextLine();
            if (outHome.equalsIgnoreCase("out")) {
                new ViewNews();
                break;

            }
        }

    }

    private void newsShowListNews() {
        System.out.println("|     STT     TIN TỨC     NỘI DUNG     |");
        for (int i = 0; i < newsList.size(); i++) {
            int j=i+1;
            System.out.println("|======"+j+"====="+newsList.get(i).getNameNews()+"======" + newsList.get(i).getContent()+"========|");
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewNews();
        }
    }

    private void newsDetailNews() {
        System.out.println("Nhập id:");
        int idNews = Config.scanner().nextInt();
        if (newsController.detailNews(idNews) == null) {
            System.out.println("Không có id này");
        } else {
            News news = newsController.detailNews(idNews);
            System.out.println(news);
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewNews();
        }
    }
    private void newsDeleteNews() {
        System.out.println("Nhập id và để xóa: ");
        int idNews = Config.scanner().nextInt();
        if(newsController.detailNews(idNews)==null){
            System.out.println("Không tồn tại");
        } else {
            System.out.println("Nhập 1 để xóa - Nhập 2 Không Xóa");
            int chooseDelete = Config.scanner().nextInt();
            switch (chooseDelete){
                case 1:
                    newsController.deleteNews(idNews);
                    newsShowListNews();
                    newsController.showListNews();
                    break;
                case 2:
                    new ViewNews();
                    break;
            }
        }


    }

    private void newsEditNews() {
        System.out.println("Nhập id để sửa");
        int idNews = Config.scanner().nextInt();
        if (newsController.detailNews(idNews) == null) {
            System.out.println("Không có id này");
        } else {
            News news = newsController.detailNews(idNews);
            System.out.println("OLD NEWS :" + news.getNameNews());
            System.out.println("OLD CONTENT :" + news.getContent());
            System.out.println("Enter new name :");
            String newName = Config.scanner().nextLine();
            if (newName.trim().equals("")){
                newName = news.getNameNews();
            }
            System.out.println("Enter new content :");
            String newContent = Config.scanner().nextLine();
            if (newContent.trim().equals("")){
                newContent = news.getContent();
            }
            News newNameNews = new News(newName,newContent);
            newsController.updateNews(idNews, newNameNews,newContent);
            System.out.println("Sửa thành công !!!!!!");
            newsShowListNews();
        }
        System.out.println("Nhập out để thoát");
        String outHome = Config.scanner().nextLine();
        if (outHome.equalsIgnoreCase("out")) {
            new ViewNews();
        }

    }


}
