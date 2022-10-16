package com.example.stock.transaction;

import com.example.stock.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class TransactionStockService {

    private StockService stockService;

    public TransactionStockService(StockService stockService) {
        startTransaction();
        this.stockService = stockService;
        endTransaction();
    }

    public void startTransaction() {

    }

    public void endTransaction() {

    }
}
