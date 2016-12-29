package com.hand.mapper;

import com.hand.bean.Film;
import org.springframework.stereotype.Component;

/**
 * Created by 陈伟 on 2016/12/29.
 */
@Component
public interface FilmMapper {
    public int addFilm(Film film);
}
