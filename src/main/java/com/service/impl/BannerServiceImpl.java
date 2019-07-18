package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BannerDAO;
import com.entity.Banner;
import com.service.BannerService;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {
	@Autowired
	@Resource
	private BannerDAO bannerDAO;

	@Override
	public int insertBanner(Banner banner) {
		return this.bannerDAO.insertBanner(banner);
	}

	@Override
	public int updateBanner(Banner banner) {
		return this.bannerDAO.updateBanner(banner);
	}

	@Override
	public int deleteBanner(String bannerid) {
		return this.bannerDAO.deleteBanner(bannerid);
	}

	@Override
	public List<Banner> getAllBanner() {
		return this.bannerDAO.getAllBanner();
	}

	@Override
	public List<Banner> getBannerByCond(Banner banner) {
		return this.bannerDAO.getBannerByCond(banner);
	}

	@Override
	public List<Banner> getBannerByLike(Banner banner) {
		return this.bannerDAO.getBannerByLike(banner);
	}

	@Override
	public Banner getBannerById(String bannerid) {
		return this.bannerDAO.getBannerById(bannerid);
	}

}
