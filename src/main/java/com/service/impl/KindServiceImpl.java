package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.KindDAO;
import com.entity.Kind;
import com.service.KindService;

@Service("kindService")
public class KindServiceImpl implements KindService {
	@Autowired
	@Resource
	private KindDAO kindDAO;

	@Override
	public int insertKind(Kind kind) {
		return this.kindDAO.insertKind(kind);
	}

	@Override
	public int updateKind(Kind kind) {
		return this.kindDAO.updateKind(kind);
	}

	@Override
	public int deleteKind(String kindid) {
		return this.kindDAO.deleteKind(kindid);
	}

	@Override
	public List<Kind> getAllKind() {
		return this.kindDAO.getAllKind();
	}

	@Override
	public List<Kind> getKindByCond(Kind kind) {
		return this.kindDAO.getKindByCond(kind);
	}

	@Override
	public List<Kind> getKindByLike(Kind kind) {
		return this.kindDAO.getKindByLike(kind);
	}

	@Override
	public Kind getKindById(String kindid) {
		return this.kindDAO.getKindById(kindid);
	}

}
