package com.shop.dao.impl;

import java.util.List;

import com.shop.dao.IGoodsDAO;
import com.shop.po.Goods;
import com.shop.po.User;
import com.shop.util.BaseDAO;

public class GoodsDAOImpl implements IGoodsDAO {
	BaseDAO<Goods> bd = new BaseDAO<Goods>();

	@Override
	public void save(Goods g) {
		// TODO Auto-generated method stub
		String sql = "insert into `goods` values(null,?,?,?,?,?,?)";
		Object objs[] = {g.getGname(),g.getGprice(),g.getQuantity(),g.getGphoto(),g.getGdesc(),g.getGtype()};
		bd.update(sql, objs);

	}

	@Override
	public void delete(int gid) {
		// TODO Auto-generated method stub
		String sql = "delete from `goods` where gid=?";
		Object objs[] = {gid};
		bd.update(sql, objs);

	}

	@Override
	public void update(Goods g) {
		// TODO Auto-generated method stub
		String sql = "update `goods` set `gname`=?,`gprice`=?,`quantity`=?,`gphoto`=?,`gdesc`=?,`gtype`=? where `gid`=?";
		Object objs[] = {g.getGname(),g.getGprice(),g.getQuantity(),g.getGphoto(),g.getGdesc(),g.getGtype(),g.getGid()};
		bd.update(sql, objs);

	}

	@Override
	public Goods findOne(int gid) {
		// TODO Auto-generated method stub
		String sql = "select * from `goods` where gid=?";
		Object objs[] = {gid};
		List<Goods> gs = bd.select(sql, objs, Goods.class);
		return gs.size()==0?null:gs.get(0);
	}

	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from `goods`";
		Object objs[] = {};
		List<Goods> gs = bd.select(sql, objs, Goods.class);
		return gs;
	}

}
