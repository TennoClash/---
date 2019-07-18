package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Kind;

@Service("kindService")
public interface KindService {
	public int insertKind(Kind kind);

	public int updateKind(Kind kind);

	public int deleteKind(String kindid);

	public List<Kind> getAllKind();
	
	public List<Kind> getKindByCond(Kind kind);

	public List<Kind> getKindByLike(Kind kind);

	public Kind getKindById(String kindid);
}
