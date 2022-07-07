package com.example.mvc.service.impl;

import com.example.mvc.model.Stock;
import com.example.mvc.service.SubscriptionService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @Author: linKe
 * @Date: 2022/7/2 0:08
 * @FileName: SubscriptionServiceImpl
 * @version: 1.0
 * @Description: 描述
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {


    @Override
    public List<Stock> findAll() {
        return null;
    }

    @Override
    public List<Stock> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Stock> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Stock> findAllById(Iterable<String> strings) {
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
    public void delete(Stock entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Stock> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Stock> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Stock> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Stock> findById(String s) {
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
    public <S extends Stock> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Stock> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Stock> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Stock getOne(String s) {
        return null;
    }

    @Override
    public Stock getById(String s) {
        return null;
    }

    @Override
    public <S extends Stock> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Stock> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Stock> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Stock> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Stock> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Stock> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Stock, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
