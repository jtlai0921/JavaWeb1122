package com.study.web.mytag;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Stock2Tag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = this.getJspContext().getOut();
        
        // ?? tag body ??
        StringWriter stringWriter = new StringWriter();
        getJspBody().invoke(stringWriter);
        
        String symbols = stringWriter.toString().trim();
        
        Arrays.asList(symbols.split(",")).stream()
                .forEach(symbol -> {
                    try {
                        Stock stock = YahooFinance.get(symbol);
                        BigDecimal price = stock.getQuote().getPrice();
                        out.println(symbol + ": $" + price + "<p/>");
                    } catch (Exception e) {
                        try {
                            out.println(symbol + ": " + e + "<p/>");
                        } catch (Exception e2) {
                        }
                    }
                });
    }
    
}