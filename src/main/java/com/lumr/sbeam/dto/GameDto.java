package com.lumr.sbeam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lumr.sbeam.entity.Game;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lumr frlumr777@sina.com
 * @since 2019-03-20
 **/
@JsonIgnoreProperties(value = {"current","size"})
@Getter
@Setter
public class GameDto extends Game {

    private long current;
    private long size;
    
}
