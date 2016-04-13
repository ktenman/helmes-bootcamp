package ee.helmes.bootcamp.model;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UtilsTest {

    @Test
    public void addHoursToDate() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2016-02-02 12:17");
        Date outputDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2016-02-02 15:29");
        BigDecimal hours = new BigDecimal("3.2");
        Date newDate = DateUtils.addMinutes(date, hours.multiply(new BigDecimal(60)).intValue());
        assertNotEquals(date, newDate);
        assertEquals(outputDate, newDate);
    }
}
