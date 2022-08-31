package rikkei.academy.service.news;

import rikkei.academy.model.news.News;
import rikkei.academy.service.IGenericService;

public interface INewsService extends IGenericService<News> {
    News findById(int id);

    void deleteById(int id);
}
