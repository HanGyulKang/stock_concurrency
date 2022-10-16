package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        /**
         * [ synchronized : 한 개의 스레드만 접근 가능하도록 함 ]
         *
         * [ Transactional : 우리가 만든 클래스를 Wrapping 한 클래스를 새로 만듦 ]
         * Transactional은 정상적으로 종료될 때 데이터베이스에 저장함.
         * 실제 데이터베이스에 데이터를 저장하기 전에 다른 Thread가 decrease 메서드에 접근이 가능함.
         * 데이터를 저장하기 전의 데이터를 가진 Thread가 접근 가능해지기 때문에 여전히 레이스 컨디션 문제가 발생함.
         */

        // get stock
        // decrease stock
        // save
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }
}
