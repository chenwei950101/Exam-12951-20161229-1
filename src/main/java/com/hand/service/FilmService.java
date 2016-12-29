package com.hand.service;

import com.hand.bean.Film;
import com.hand.event.FilmEvent;
import com.hand.mapper.FilmMapper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by 陈伟 on 2016/12/29.
 */
@Service
public class FilmService implements ApplicationContextAware {
    @Autowired
    private FilmMapper filmMapper;
    private ApplicationContext applicationContext;
    public void setFilmMapper(FilmMapper filmMapper) {
        this.filmMapper = filmMapper;
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    public int addFilm(Film film){
        
        int rowNumber=filmMapper.addFilm(film);
        if(rowNumber==1){
           // user=userMapper.selectOneByName(user);
            FilmEvent filmEvent=new FilmEvent(film);
            applicationContext.publishEvent(filmEvent);
        }
        return rowNumber;
    }
}
