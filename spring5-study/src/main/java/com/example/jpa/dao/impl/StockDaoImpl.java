package com.example.jpa.dao.impl;

import com.example.jpa.dao.StockDao;
import com.example.jpa.entity.StockDo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @Author: linKe
 * @Date: 2022/7/1 23:52
 * @FileName: StockDaoImpl
 * @version: 1.0
 * @Description: 描述
 */
public class StockDaoImpl implements StockDao {
    @Override
    public StockDo findBySymbol(String symbol) {
        return null;
    }

    @Override
    public List<StockDo> findAll() {
        return null;
    }

    @Override
    public List<StockDo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<StockDo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<StockDo> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(StockDo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends StockDo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends StockDo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends StockDo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<StockDo> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends StockDo> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends StockDo> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<StockDo> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public StockDo getOne(String s) {
        return null;
    }

    @Override
    public StockDo getById(String s) {
        return null;
    }

    @Override
    public <S extends StockDo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends StockDo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends StockDo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends StockDo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends StockDo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends StockDo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends StockDo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
