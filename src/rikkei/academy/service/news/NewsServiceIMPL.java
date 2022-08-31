package rikkei.academy.service.news;

import rikkei.academy.config.Config;
import rikkei.academy.model.news.News;


import java.util.List;

public class NewsServiceIMPL implements INewsService {
    public static final String PATH_NEWS = "D:\\New folder\\untitled8\\src\\rikkei\\academy\\database\\news.txt";
    public static List<News> newsList = new Config<News>().readFile(PATH_NEWS);

    @Override
    public List<News> findALl() {
        new Config<News>().writeFile(PATH_NEWS,newsList);
        return newsList;
    }

    @Override
    public void save(News news) {
        newsList.add(news);

    }

    @Override
    public News findById(int id) {
        for (int i = 0; i < newsList.size(); i++) {
            if (id == newsList.get(i).getId()) {
                return newsList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < newsList.size(); i++) {
            if (id == newsList.get(i).getId()) {
                newsList.remove(i);
                break;
            }
        }
    }
}
