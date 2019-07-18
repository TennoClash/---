package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Banner;

@Repository("bannerDAO")
public interface BannerDAO {

	public int insertBanner(Banner banner);

	public int updateBanner(Banner banner);

	public int deleteBanner(String bannerid);

	public List<Banner> getAllBanner();

	public List<Banner> getBannerByCond(Banner banner);

	public List<Banner> getBannerByLike(Banner banner);

	public Banner getBannerById(String bannerid);

}
