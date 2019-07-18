package com.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Article;
import com.entity.Banner;
import com.entity.Goods;
import com.entity.Items;
import com.entity.Orders;
import com.entity.Users;
import com.service.ArticleService;
import com.service.BannerService;
import com.service.BookService;
import com.service.CateService;
import com.service.GoodsService;
import com.service.ItemsService;
import com.service.KindService;
import com.service.OrdersService;
import com.service.UsersService;
import com.util.MD5;
import com.util.RSACrypt;
import com.util.VeDate;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	@Resource
	private UsersService usersService;
	@Autowired
	@Resource
	private BannerService bannerService;
	@Autowired
	@Resource
	private ArticleService articleService;
	@Autowired
	@Resource
	private KindService kindService;
	@Autowired
	@Resource
	private GoodsService goodsService;
	@Autowired
	@Resource
	private OrdersService ordersService;
	@Autowired
	@Resource
	private ItemsService itemsService;
	@Autowired
	@Resource
	private CateService cateService;
	@Autowired
	@Resource
	private BookService bookService;

	private void front() {
		this.getRequest().setAttribute("title", "建材租赁财务管理系统");
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
	}

	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Banner> bannerList = this.bannerService.getAllBanner();
		List<Banner> frontList = new ArrayList<Banner>();
		for (Banner banner : bannerList) {
			List<Article> articleList = this.articleService.getArticleByBanner(banner.getBannerid());
			banner.setArticleList(articleList);
			frontList.add(banner);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Article> topList = this.articleService.getTopArticle();
		List<Article> favList = this.articleService.getFlvArticle();
		this.getRequest().setAttribute("topList", topList);
		this.getRequest().setAttribute("favList", favList);
		return "users/index";
	}

	@RequestMapping("article.action")
	public String article(String id) {
		this.front();
		Article article = new Article();
		article.setBannerid(id);
		List<Article> articleList = this.articleService.getArticleByCond(article);
		this.getRequest().setAttribute("articleList", articleList);
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "users/article";
	}

	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	@RequestMapping("goods.action")
	public String goods() {
		this.front();
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "users/goods";
	}

	@RequestMapping("kind.action")
	public String kind(String id) {
		this.front();
		Goods goods = new Goods();
		goods.setKindid(id);
		List<Goods> goodsList = this.goodsService.getGoodsByCond(goods);
		this.getRequest().setAttribute("goodsList", goodsList);
		return "users/goods";
	}

	@RequestMapping("goodsDetail.action")
	public String goodsDetail(String id) {
		this.front();
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		return "users/goodsDetail";
	}

	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}
	
	@RequestMapping(value = "getkey.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getKey(HttpSession session) throws NoSuchAlgorithmException {
		HashMap<String, String> map2 = RSACrypt.getKeys();
		String privateKeyStr = map2.get("privateKey");
		String publicKeyStr = map2.get("publicKey");
		session.setAttribute("privateKeyStr", privateKeyStr);
		return publicKeyStr;
	}

	@RequestMapping(value = "login.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(String username,String password,HttpSession session) throws Exception {
		this.front();
		String privateKey = (String) session.getAttribute("privateKeyStr");
		System.out.println(privateKey);
		password = RSACrypt.decrypt(RSACrypt.loadPrivateKey(privateKey), RSACrypt.strToBase64(password));
		password = MD5.md5(password);
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			return "用户名不存在";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "1";
			} else {
				return "密码错误";
			}
		}
	}

	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			String password = MD5.md5(users.getPassword());
			users.setPassword(password);
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "index";
	}

	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		password = MD5.md5(password);
		String repassword = this.getRequest().getParameter("repassword");
		repassword = MD5.md5(repassword);
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		return "redirect:/index/userinfo.action";
	}

	@RequestMapping("preOrders.action")
	public String preOrders() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("ordercode", "OD" + VeDate.getStringDatex());
		return "users/addorders";
	}

	@RequestMapping("addOrders.action")
	public String addOrders(Orders orders) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preOrders.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		orders.setAddtime(VeDate.getStringDateShort());
		orders.setStatus("未完成");
		orders.setUsersid(userid);
		this.ordersService.insertOrders(orders);
		return "redirect:/index/preOrders.action";
	}

	@RequestMapping("myOrders.action")
	public String myOrders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = new Orders();
		String userid = (String) this.getSession().getAttribute("userid");
		orders.setUsersid(userid);
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
		int pageNumber = tempList.size();
		int maxPage = pageNumber;
		if (maxPage % 10 == 0) {
			maxPage = maxPage / 10;
		} else {
			maxPage = maxPage / 10 + 1;
		}
		if (number == null) {
			number = "0";
		}
		int start = Integer.parseInt(number) * 10;
		int over = (Integer.parseInt(number) + 1) * 10;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Orders obj = tempList.get(i);
			ordersList.add(obj);
		}
		String html = "";
		StringBuffer buffer = new StringBuffer();
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"index/myOrders.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"index/myOrders.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"index/myOrders.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"index/myOrders.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		this.getRequest().setAttribute("ordersList", ordersList);
		this.getRequest().setAttribute("html", html);
		return "users/myorders";
	}

	@RequestMapping("orderDetail.action")
	public String orderDetail(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		Items items = new Items();
		items.setOrdercode(orders.getOrdercode());
		List<Items> itemsList = this.itemsService.getItemsByCond(items);
		this.getRequest().setAttribute("orders", orders);
		this.getRequest().setAttribute("itemsList", itemsList);
		long days = VeDate.getDays(VeDate.getStringDateShort(), orders.getAddtime()) + 1;
		double total = 0;
		int sum = 0;
		for (Items x : itemsList) {
			total += Double.parseDouble(x.getPrice()) * Double.parseDouble(x.getNum());
			sum += Integer.parseInt(x.getNum());
		}
		total = total * days;
		if ("月租".equals(orders.getWay())) {
			total = total * 0.8 * Math.ceil(Double.parseDouble("" + (days / 30)));
		}
		this.getRequest().setAttribute("days", days);
		this.getRequest().setAttribute("total", total);
		this.getRequest().setAttribute("sum", sum);
		return "users/orderDetail";
	}

	@RequestMapping("preItems.action")
	public String preItems() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preOrders.action";
		}
		String ordercode = this.getRequest().getParameter("id");
		this.getRequest().setAttribute("ordercode", ordercode);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "users/addItems";
	}

	@RequestMapping("print.action")
	public String print(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		Items items = new Items();
		items.setOrdercode(orders.getOrdercode());
		List<Items> itemsList = this.itemsService.getItemsByCond(items);
		this.getRequest().setAttribute("orders", orders);
		this.getRequest().setAttribute("itemsList", itemsList);
		long days = VeDate.getDays(VeDate.getStringDateShort(), orders.getAddtime()) + 1;
		double total = 0;
		int sum = 0;
		for (Items x : itemsList) {
			total += Double.parseDouble(x.getPrice()) * Double.parseDouble(x.getNum());
			sum += Integer.parseInt(x.getNum());
		}
		total = total * days;
		if ("月租".equals(orders.getWay())) {
			total = total * 0.8 * Math.ceil(Double.parseDouble("" + (days / 30)));
		}
		this.getRequest().setAttribute("days", days);
		this.getRequest().setAttribute("total", total);
		this.getRequest().setAttribute("sum", sum);
		return "users/print";
	}

}
