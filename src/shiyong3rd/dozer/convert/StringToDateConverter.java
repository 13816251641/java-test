package shiyong3rd.dozer.convert;

import org.dozer.DozerConverter;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter extends DozerConverter<String, Date> {
    public StringToDateConverter() {
        super(String.class, Date.class);
    }

    @Override
    public String convertFrom(Date source, String destination) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(source);
    }

    @Override
    public Date convertTo(String source, Date destination) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(source, pos);
    }

}
