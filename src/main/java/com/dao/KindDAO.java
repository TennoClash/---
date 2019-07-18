package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Kind;

@Repository("kindDAO")
public interface KindDAO {

	public int insertKind(Kind kind);

	public int updateKind(Kind kind);

	public int deleteKind(String kindid);

	public List<Kind> getAllKind();

	public List<Kind> getKindByCond(Kind kind);

	public List<Kind> getKindByLike(Kind kind);

	public Kind getKindById(String kindid);

}
