package lt.seb.interview.task.service;

import lt.seb.interview.task.model.ExchangeRate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface ExchangeRateService {
    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    List<ExchangeRate> getExchangeRatesByDate(Date date);
}
