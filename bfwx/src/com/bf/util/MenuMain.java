package com.bf.util;
import com.bf.entity.Button;
import com.bf.entity.CommonButton;
import com.bf.entity.ComplexButton;
import com.bf.entity.Menu;
import com.bf.entity.Token;
import com.bf.entity.ViewButton;
import com.jfinal.kit.PropKit;

public class MenuMain {
	public static void main(String[] args) {	
        // 第三方用户唯一凭证
		// 调用接口获取access_token
		PropKit.use("a_little_config.txt");
		Token at = abc.getToken(PropKit.get("appid"),PropKit.get("appsecret"));
		if (null != at) {
			boolean result = MenuUtil.createMenu(getMenu(), at.getAccessToken());
			 //判断菜单创建结果
			if (result)
				System.out.println("菜单创建成功！");
			else
				System.out.println("菜单创建失败，错误码：" + result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		
		PropKit.use("a_little_config.txt");
		
		String str="http://zhuli.wanxidi.com/zhuli/weix/course?type=1";
		ViewButton btn11 = new ViewButton();
		btn11.setName("团操课程");
		btn11.setType("view");
		btn11.setUrl(str); 
		
		str="http://zhuli.wanxidi.com/zhuli/weix/course?type=2";
		ViewButton btn12 = new ViewButton();
		btn12.setName("动感单车");
		btn12.setType("view");
		btn12.setUrl(str);
		
		str="http://zhuli.wanxidi.com/zhuli/weix/course?type=3";
		ViewButton btn13 = new ViewButton();
		btn13.setName("器械跑步");
		btn13.setType("view");
		btn13.setUrl(str);

		str="http://zhuli.wanxidi.com/zhuli/api/getTrainer?type=5";
		ViewButton btn14 = new ViewButton();
		btn14.setName("私人教练");
		btn14.setType("view");
		btn14.setUrl(str);
		
		str="http://zhuli.wanxidi.com/zhuli/api/getTrainer?type=4";
		ViewButton btn15 = new ViewButton();
		btn15.setName("运动康复");
		btn15.setType("view");
		btn15.setUrl(str);

        str="http://zhuli.wanxidi.com/zhuli/weix/center";
		ViewButton btn21 = new ViewButton();
		btn21.setName("个人中心");
		btn21.setType("view");
		btn21.setUrl(str);
	
		CommonButton btn22 = new CommonButton();
		btn22.setName("扫一扫");
		btn22.setType("scancode_waitmsg");
		btn22.setKey("rselfmenu_0_0");
		
		str="http://zhuli.wanxidi.com/zhuli/weix/about";
		ViewButton btn23 = new ViewButton();
		btn23.setName("关于筑力");
		btn23.setType("view");
		btn23.setUrl(str);
		
		str="http://zhuli.wanxidi.com/zhuli/api/getCarOrder";
		ViewButton btn24 = new ViewButton();
		btn24.setName("购卡续费");
		btn24.setType("view");
		btn24.setUrl(str);

		str="http://buluo.qq.com/mobile/barindex.html?_bid=128&_wv=1027&bid=339484";
		ViewButton btn31 = new ViewButton();
		btn31.setName("筑力社区");
		btn31.setType("view");
		btn31.setUrl(str);

		ViewButton btn32 = new ViewButton();
		btn32.setName("我要推广");
		btn32.setType("view");
		btn32.setUrl(str);
		
		ViewButton btn33 = new ViewButton();
		btn33.setName("个人中心");
		btn33.setType("view");
		btn33.setUrl(str);

		ViewButton btn34= new ViewButton();
		btn34.setName("操作指导");
		btn34.setType("view");
		btn34.setUrl(str);
		
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("课程预约");
		mainBtn1.setSub_button(new Button[] { btn11,btn12,btn13,btn14,btn15});

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("会员中心");
		mainBtn2.setSub_button(new Button[] {btn21,btn22,btn23,btn24});

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("筑力社区");
		mainBtn3.setSub_button(new  Button[] {btn31,btn32,btn33});

		Menu menu = new Menu();
		//menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3});
		menu.setButton(new Button[]{mainBtn1, mainBtn2,btn31} );
		System.out.println(menu);
		return menu;
	}
}
