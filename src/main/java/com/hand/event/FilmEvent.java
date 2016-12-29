package com.hand.event;

import com.hand.bean.Film;
import org.springframework.context.ApplicationEvent;

/**
 * Created by 陈伟 on 2016/12/29.
 */
public class FilmEvent extends ApplicationEvent {
    private Film film;
    public FilmEvent(Film film) {
        super(film);
        this.film=film;
    }
}
