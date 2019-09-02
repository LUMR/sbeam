package com.lumr.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lumr.sbeam.entity.Game;
import com.lumr.sbeam.mapper.GameMapper;
import com.lumr.sbeam.utils.Executor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-03-29
 **/
public class GameGenerator implements Executor {

    @Autowired
    private GameMapper mapper;

    @Override
    public String executor() {
        IPage<Game> gameIPage = mapper.selectPage(new Page<>(1,20),null);

        StringBuilder builder = new StringBuilder(100);
        gameIPage.getRecords().forEach(a->{
            builder.append(String.format("%n %s %n",a.getName()));
        });
        return builder.toString();
    }
}
