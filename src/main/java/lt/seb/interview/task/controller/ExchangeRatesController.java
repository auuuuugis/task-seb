package lt.seb.interview.task.controller;

import lt.seb.interview.task.model.ExchangeRate;
import lt.seb.interview.task.service.ExchangeRateService;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static lt.seb.interview.task.service.ExchangeRateService.DATE_FORMATTER;

@Component(value = "listRates")
@ELBeanName(value = "listRates")
@Join(path = "/", to = "/rates-list.jsf")
public class ExchangeRatesController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    public List<ExchangeRate> fetchRates(String date) {
        deleteMessages();
        if (!StringUtils.isEmpty(date)) {
            try {
                Date formattedDate = DATE_FORMATTER.parse(date);
                return exchangeRateService.getExchangeRatesByDate(formattedDate);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
            }
        }
        return Collections.EMPTY_LIST;
    }

    private void deleteMessages() {
        Iterator<FacesMessage> messageIterator = FacesContext.getCurrentInstance().getMessages();
        while (messageIterator.hasNext()) {
            messageIterator.next();
            messageIterator.remove();
        }
    }
}
