package lt.seb.interview.task.service;

import lt.seb.interview.task.model.ExchangeRate;
import lt.seb.interview.task.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ExchangeRate> getExchangeRatesByDate(Date date) {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host("old.lb.lt")
                .path("/webservices/ExchangeRates/ExchangeRates.asmx/getExchangeRatesByDate")
                .queryParam("date", DATE_FORMATTER.format(date)).build().toUri();
        return restTemplate.getForObject(uri, ExchangeRates.class).getExchangeRates();
    }
}
