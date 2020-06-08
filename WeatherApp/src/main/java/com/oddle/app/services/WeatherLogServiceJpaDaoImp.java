package com.oddle.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.oddle.app.model.WeatherLog;

@Service
@Transactional
public class WeatherLogServiceJpaDaoImp implements WeatherLogService{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<WeatherLog> listAll(String city) {
		List<WeatherLog> log = (List<WeatherLog>) this.hibernateTemplate.find("from WeatherLog w where w.city=? order by w.id desc", city);
		return log;
	}

	@Override
	public WeatherLog getById(Integer id) {
		try {
			return this.hibernateTemplate.get(WeatherLog.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public WeatherLog saveOrUpdate(WeatherLog entity) {
		this.hibernateTemplate.save(entity);
		return entity;
	}

	@Override
	public void delete(Integer id) {
		WeatherLog log = this.getById(id);
		if( log != null ) {
			this.hibernateTemplate.delete(log);
		}
		
	}

}
