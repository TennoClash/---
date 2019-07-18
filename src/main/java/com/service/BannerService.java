package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Banner;

@Service("bannerService")
public interface BannerService {
	public int insertBanner(Banner banner);

	public int updateBanner(Banner banner);

	public int deleteBanner(String bannerid);

	public List<Banner> getAllBanner();

	public List<Banner> getBannerByCond(Banner banner);

	public List<Banner> getBannerByLike(Banner banner);
	
	public Banner getBannerById(String bannerid);
}
