package rikkei.academy.controller;

import rikkei.academy.model.news.News;
import rikkei.academy.service.news.INewsService;
import rikkei.academy.service.news.NewsServiceIMPL;

import java.util.List;

public class NewsController {
    INewsService newsService = new NewsServiceIMPL();

    public List<News> showListNews() {
        return newsService.findALl();
    }

    public void createNews(News news) {

        newsService.save(news);
    }

    public News detailNews(int id) {
        return newsService.findById(id);
    }

    public void updateNews(int id, News newNews, String newContent) {
        News news1 = newsService.findById(id);
        news1.setContent(newContent);
        news1.setNameNews(newNews.getNameNews());


    }

    public void deleteNews(int id) {
        newsService.deleteById(id);
    }
}
