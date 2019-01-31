package lt.seb.interview.task.model;

import lt.seb.interview.task.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

import static lt.seb.interview.task.service.ExchangeRateService.DATE_FORMATTER;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRate {
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    private String currency;
    private BigDecimal quantity;
    private BigDecimal rate;
    private String unit;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormattedDate() {
        return DATE_FORMATTER.format(date);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "date=" + date +
                ", currency='" + currency + '\'' +
                ", quantity=" + quantity +
                ", rate=" + rate +
                ", unit='" + unit + '\'' +
                '}';
    }
}
