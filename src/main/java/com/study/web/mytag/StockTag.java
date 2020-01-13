package com.study.web.mytag;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockTag extends SimpleTagSupport {
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        Stock stock = YahooFinance.get(symbol);
        BigDecimal price = stock.getQuote().getPrice();
        JspWriter out = this.getJspContext().getOut();
        out.println(symbol + ": $" + price);
    }
    
}