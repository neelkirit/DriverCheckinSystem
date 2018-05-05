package com.fsg.it.drivercheckinsystem.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class DateUtil {

    private final static Logger LOG = Logger.getLogger(DateUtil.class.getName());

    public String getCurrentDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        LOG.info("Current German Time "+df.format(dateobj));
        return df.format(dateobj);
    }

}
