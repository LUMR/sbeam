package com.lumr.sbeam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lumr.sbeam.entity.Game;

/**
 * @author lumr frlumr777@sina.com
 * @since 2019-03-20
 **/
@JsonIgnoreProperties(value = {"current","size"})
public class GameDto extends Game {

    private long current;
    private long size;

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @return the current
     */
    public long getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(long current) {
        this.current = current;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }
}
